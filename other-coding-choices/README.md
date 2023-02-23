# other-coding-choices
[Tutorial - Java Application Performance and Memory Management - from Matt Greencroft (Udemy)](../README.md)

### Section 22: Chapter 22 - Other Coding Choices

#### 119. Comparing primitives with objects
```
Benchmark                                                 Mode  Cnt        Score         Error  Units
PrimitivesPerformance.addNumbersObjectBenchmark           avgt    5   155212,957 ±    2417,452  ns/op
PrimitivesPerformance.addNumbersPrimitiveBenchmark        avgt    5   156572,175 ±    5216,528  ns/op
PrimitivesPerformance.addNumbersObjectDoubleBenchmark     avgt    5  7625926,476 ±  660850,104  ns/op
PrimitivesPerformance.addNumbersPrimitiveDoubleBenchmark  avgt    5  7339158,725 ± 3025501,172  ns/op
```
