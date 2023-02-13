# gc-tuning
[Tutorial - Java Application Performance and Memory Management - from Matt Greencroft (Udemy)](../README.md)

###  Section 15: Chapter 15 - Garbage Collector tuning & selection

#### 65. Monitoring garbage collections

VM Argument to monitor garbage collectors
- `-verbose:gc`

#### 66. Turning off automated heap allocation sizing

View flag `UseAdaptiveSizePolicy`
- `jps` &rarr; view process Id
- `jinfo -flag UseAdaptiveSizePolicy` &rarr; the default is `ON`
Switch off adaptive size selection
- `-XX:-UseAdaptiveSizePolicy`

   