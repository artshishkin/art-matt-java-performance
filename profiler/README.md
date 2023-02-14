# profiler

[Tutorial - Java Application Performance and Memory Management - from Matt Greencroft (Udemy)](../README.md)

### Section 16: Chapter 16 - Using a profiler to analyse application performance

#### 74. Introducing Java Mission Control (JMC)

Download [Java Mission Control](https://www.oracle.com/java/technologies/jdk-mission-control.html)

#### 80. Introducing our problem project

1. Run application
    - `java  net.shyshkin.study.performance.profiler.Main` from `profiler/fibonacci-primes/target/classes`
2. Open JMC
    - View Threads
    - `combinedNumbersThread	BLOCKED	10028` - a lot of blocked

#### 81. Using the flight recorder

1. Enable Flight Recorder
    - `-XX:+FlightRecorder`
2. Start Flight Recorder in JMC
    - Continuous
    - Max Age: `5 min`
    - Event setting: `Profiling - on server` (for finding bugs)
    - Next
    - Thread Dump: `Every 10 s` (more aggressive)
    - Finish
3. Start Flight Recording through Command Line
    - `-XX:StartFlightRecording=delay=2min,duration=60s,name=Test,filename=recording.jfr,settings=profile`

