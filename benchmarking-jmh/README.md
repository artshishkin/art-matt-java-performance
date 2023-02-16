# benchmarking-jmh

[Tutorial - Java Application Performance and Memory Management - from Matt Greencroft (Udemy)](../README.md)

### Section 18: Chapter 18 - Benchmarking with JMH

#### 90. Installing the JMH benchmarking tool

Use instructions from [Java Microbenchmark Harness (JMH)](https://github.com/openjdk/jmh)

##### Step 1. Setting up the benchmarking project. 

The following command will generate the new JMH-driven project:
```shell
mvn archetype:generate \
  -DinteractiveMode=false \
  -DarchetypeGroupId=org.openjdk.jmh \
  -DarchetypeArtifactId=jmh-java-benchmark-archetype \
  -DgroupId=net.shyshkin.study.performance \
  -DartifactId=jmh \
  -Dversion=1.0
```
##### Step 2. Building the benchmarks. 

After the project is generated, you can build it with the following Maven command:

```shell
$ cd jmh/
$ mvn clean verify
```
##### Step 3. Running the benchmarks. 

After the build is done, you will get the self-contained executable JAR, which holds your benchmark, and all essential JMH infrastructure code:
```shell
$ java -jar target/benchmarks.jar
```
