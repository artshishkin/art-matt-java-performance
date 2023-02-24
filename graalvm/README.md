# graalvm

[Tutorial - Java Application Performance and Memory Management - from Matt Greencroft (Udemy)](../README.md)

### Section 23: Chapter 23 - GraalVM

#### 128. Native image building with Graal

1. Compile java
    - `javac Main.java`
    - **or**
    - build project `mvn clean compile`
2. Install Native Image on Windows 10
    - `cd $Env:JAVA_HOME` PowerShell
    - `cd bin`
    - `gu install native-image`
3. Run `x64 Native Tools Command Prompt`
    - Start &rarr; Visual Studio 2022 &rarr; `x64 Native Tools Command Prompt`
4. Run build command
    - `cd C:\Users\Admin\IdeaProjects\Study\MattGreencroft\art-matt-java-performance\graalvm\`
    - `native-image -H:+ReportExceptionStackTraces -cp target/classes net.shyshkin.study.performance.graalvm.Main`

#### 129. Using the Graal experimental features within OpenJDK

- `javac src/main/java/net/shyshkin/study/performance/graalvm/Main.java`
- `java -cp src/main/java net.shyshkin.study.performance.graalvm.Main`
    - `19919 primes found.`
    - `The largest prime was 999965413`
    - `time taken : 6805 ms.`
- `java -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCI -XX:+UseJVMCICompiler -cp src/main/java net.shyshkin.study.performance.graalvm.Main`
    - `19845 primes found.`
    - `The largest prime was 999985379`
    - `time taken : 6857 ms.`
