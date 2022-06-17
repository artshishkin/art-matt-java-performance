# performance-example-01
Tutorial - Java Application Performance and Memory Management - from Matt Greencroft (Udemy)

###  Section 2: Chapter 2 - Just In Time Compilation and the Code Cache

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

###  Section 3: Chapter 3 - Selecting the JVM

#### 14. Specifying which compiler to use at runtime

1. Compilers
   - c1 - client
   - c2 - server
2. According to JVM
   - 32 bit - c1 only
   - 64 bit - both c1 and c2 present
3. Specify client compiler only
   - add flag `-client`
   - `java -XX:+PrintCompilation  net.shyshkin.study.performance.perf01.Main 15000`
   - took 7372 ms (Matt had ~3500)
   - `java -XX:+PrintCompilation -client net.shyshkin.study.performance.perf01.Main 15000`
   - took 7355 ms (Matt had ~2300)
   - no benefit for me

#### 15. Turning off tiered compilation

1. May be useful
   - when using only interpretation is acceptable
   - for *Serverless* Applications
   - for *one-line-of-code* applications
2. Turning off tiered compilation
   - `-XX:-TieredCompilation`

####  16. Tuning native compilation within the Virtual Machine

1. View All the flags
   - `java -XX:+PrintFlagsFinal`
2. Find threads count for compiler
   - `CICompilerCount` - 4 for my machine
3. View certain flag
   - `jps` - view any java running application - get process id - 724
   - `jinfo -flag CICompilerCount 724` - 2 (for IntelliJ - it starts with this flag set)
4. Set CICompilerCount
   - `java -XX:+PrintCompilation -XX:CICompilerCount=8 net.shyshkin.study.performance.perf01.Main 15000`
5. Flag `CompileThreshold`
   - number of times method has to be run before compile happened
   - `java -XX:+PrintFlagsFinal` - CompileThreshold = 10000
   - `jinfo -flag CompileThreshold 724` - -XX:CompileThreshold=10000
6. Set CompileThreshold
   - `java -XX:+PrintCompilation -XX:CompileThreshold=1000 net.shyshkin.study.performance.perf01.Main 15000`


