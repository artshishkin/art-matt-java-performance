# other-jvm-languages

[Tutorial - Java Application Performance and Memory Management - from Matt Greencroft (Udemy)](../README.md)

### Section 24: Chapter 24 - Using Other JVM Languages

#### 130. The principles of using other JVM Languages

- `java -jar JavaMain.jar`
    - `20070 primes found.`
    - `The largest prime was 999941849`
    - `time taken : 7273 ms.`
- `java -jar KotlinMain.jar`
    - `19595 primes found.`
    - `The largest prime was 999962641`
    - `time taken : 6955  ms.`

#### 131. Looking at bytecode with javap

- `javap -v Simple.class`
  - `v` - verbose
- `javap -v Mathematics.class`

#### 132. Disassembling bytecode back to Java

- `java -jar data/cfr-0.152.jar target/classes/net/shyshkin/study/performance/languages/Simple.class`
- `java -jar data/cfr-0.152.jar target/classes/net/shyshkin/study/performance/languages/Mathematics.class`
- `java -jar data/cfr-0.152.jar data/JavaMain.class`
- `java -jar data/cfr-0.152.jar data/KotlinMain.class`

