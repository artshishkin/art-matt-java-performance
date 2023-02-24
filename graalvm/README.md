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