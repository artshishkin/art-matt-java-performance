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




