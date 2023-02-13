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

#### 68. Tuning garbage collection - survivor space allocation

- `jinfo -flag SurvivorRatio 13008`
    - default `-XX:SurvivorRatio=8` (S0 and S1 should be 1/8 of young generation)
    - so Eden Space should be 8 - 1 - 1 = 6/8 ???(as Matt says)
- Set `-XX:SurvivorRatio=5`     

#### 69. Tuning garbage collection - generations needed to become old

- `jinfo -flag MaxTenuringThreshold 20032`
    - default `-XX:MaxTenuringThreshold=15`
- Set `-XX:MaxTenuringThreshold=15` [1...16]  

