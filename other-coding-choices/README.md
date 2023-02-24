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

#### 120. Comparing BigDecimals with Doubles
```
Benchmark                                            Mode  Cnt         Score         Error  Units
BigDecimalPerformance.addNumbersBigDecimalBenchmark  avgt    5  21199383,498 ± 1912439,495  ns/op
BigDecimalPerformance.addNumbersDoubleBenchmark      avgt    5    818097,284 ±   87883,840  ns/op
```

#### 121. Using the StringBuilder
```
Benchmark                                              Mode  Cnt    Score   Error  Units
StringBuilderPerformance.generateNamesConcat           avgt    5  157,525 ± 0,589  ns/op
StringBuilderPerformance.generateNamesConcatOptimized  avgt    5   80,548 ± 0,419  ns/op
StringBuilderPerformance.generateNamesStringBuilder    avgt    5  129,135 ± 0,368  ns/op
StringBuilderPerformance.generateNamesStringJoiner     avgt    5  103,091 ± 0,493  ns/op
```

#### 122. Comparing loops and streams

```
Benchmark                                               Mode  Cnt         Score         Error  Units
LoopPerformance.calculateLengthLoopBenchmark            avgt    5  27076425,009 ± 5430873,452  ns/op
LoopPerformance.calculateLengthParallelStreamBenchmark  avgt    5  13507189,140 ± 2324580,298  ns/op
LoopPerformance.calculateLengthStreamBenchmark          avgt    5  24736181,255 ± 4797374,660  ns/op
LoopPerformance.calculateLengthStreamFlatMapBenchmark   avgt    5  21200496,122 ±  669926,495  ns/op
```

#### 123. A note on logging

```
Benchmark                         Mode  Cnt         Score        Error  Units
LoggingExample.logInfo            avgt    5  15908517,025 ± 519927,680  ns/op
LoggingExample.logFine            avgt    5  15688670,979 ± 344322,847  ns/op
LoggingExample.logFineParameters  avgt    5  15936486,680 ± 565550,551  ns/op
LoggingExample.logFineIsLoggable  avgt    5         1,252 ±      0,292  ns/op
LoggingExample.logFineLazy        avgt    5         1,132 ±      0,128  ns/op
```
