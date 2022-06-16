# performance-example-01
Tutorial - Java Application Performance and Memory Management - from Matt Greencroft (Udemy)

####  Run App

1. from target/classes run:
   - `java net.shyshkin.study.performance.perf01.Main 10`

####  PrintCompilation

1. from target/classes run:
   -  `java -XX:+PrintCompilation net.shyshkin.study.performance.perf01.Main 10`
2. from IntelliJ Run Configuration:
   - add `-XX:+PrintCompilation` to VM options
3. Explanation
   - `n` - native method
   - `s` - synchronized method
   - `!` - exception handling
4. Enlarge numbers to 5000
   - `java -XX:+PrintCompilation net.shyshkin.study.performance.perf01.Main 5000`
   - got
   - `123  206 %     4       net.shyshkin.study.performance.perf01.PrimeNumbers::isPrime @ 2 (35 bytes)`
   - this means this method is put into the code cache
   - `0` - no compilation
   - `1...4` - deeper level of compilation

####  10. Logging Diagnostic

1. Unlock diagnostic and logging to file
   - `java -XX:+UnlockDiagnosticVMOptions -XX:+LogCompilation net.shyshkin.study.performance.perf01.Main 5000`
   - view `hotspot_pid9860.log`

####  11. Tuning the code cache size

1. View CodeCache
   - `java -XX:+PrintCodeCache net.shyshkin.study.performance.perf01.Main 5000`
   - but I did not see `CodeCache` 
   - `CodeHeap 'non-profiled nmethods': size=120000Kb used=26Kb max_used=26Kb free=119973Kb`
   - `CodeHeap 'profiled nmethods': size=120000Kb used=135Kb max_used=135Kb free=119864Kb`
   - `CodeHeap 'non-nmethods': size=5760Kb used=996Kb max_used=1009Kb free=4764Kb`
   - `total_blobs=335 nmethods=96 adapters=151`
2. Change CodeCache size
   - `InitialCodeCacheSize` - min
   - `ReservedCodeCacheSize` - max
   - `CodeCacheExpansionSize` - step of changing size
   - `java -XX:ReservedCodeCacheSize=28m -XX:+PrintCodeCache net.shyshkin.study.performance.perf01.Main 5000`
   - I saw
   - `CodeCache: size=28672Kb used=1163Kb max_used=1176Kb free=27509Kb`
   - `total_blobs=339 nmethods=100 adapters=151`
     
####  12. Remotely monitoring the code cache with JConsole

1. Start JConsole
   - `jconsole`
   - Local Process
   - ensure enough permissions for folder
     - `c:\Users\Admin\AppData\Local\Temp\hsperfdata_Admin\` for everyone to write
2. Connect to process
   - IntelliJ for example
3. Run our modified code and connect to it through JConsole
   - `java -XX:+PrintCompilation net.shyshkin.study.performance.perf01.Main 5000`
   - view that our process uses additional memory for connection with JConsole 

