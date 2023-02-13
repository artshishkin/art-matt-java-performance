# gc-tuning

[Tutorial - Java Application Performance and Memory Management - from Matt Greencroft (Udemy)](../README.md)

### Section 15: Chapter 15 - Garbage Collector tuning & selection

#### 65. Monitoring garbage collections

VM Argument to monitor garbage collectors

- `-verbose:gc`

#### 66. Turning off automated heap allocation sizing

View flag `UseAdaptiveSizePolicy`

- `jps` &rarr; view process Id
- `jinfo -flag UseAdaptiveSizePolicy 17216` &rarr; the default is `ON`
  Switch off adaptive size selection
- `-XX:-UseAdaptiveSizePolicy`

#### 67. Tuning garbage collection - old and young allocation

Flags

- `-XX:NewRatio=n` (n=4 OldGeneration will be 4 times larger then the young generation)
    - check default
      - `jps` &rarr; view process Id
      - `jinfo -flag NewRatio 21292` &rarr;
      - the default is `-XX:NewRatio=2`
- Set `-XX:NewRatio=1`
    