# how-maps-work
[Tutorial - Java Application Performance and Memory Management - from Matt Greencroft (Udemy)](../README.md)

###  Section 21: Chapter 21 - How Maps Work

#### 111. Specifying the initial size and factor of a HashMap

```
Benchmark                                                       Mode  Cnt     Score     Error  Units
MapBenchmark.collectHashMapFromStream                           avgt    5  2890,204 ± 189,361  ms/op
MapBenchmark.collectHashMapFromStreamInitialCapacity            avgt    5  2686,094 ± 182,116  ms/op
MapBenchmark.collectHashMapFromStreamInitialCapacityLoadFactor  avgt    5  2673,722 ± 253,929  ms/op
MapBenchmark.putToHashMap                                       avgt    5  3267,411 ± 970,502  ms/op
MapBenchmark.putToHashMapInitialCapacity                        avgt    5  3056,169 ± 328,960  ms/op
MapBenchmark.putToHashMapInitialCapacityLoadFactor              avgt    5  2856,929 ± 180,946  ms/op
```

#### 112. HashMap Performance and 113. The rules for Hashcodes

```
Benchmark                                       Mode  Cnt       Score       Error  Units
HashCodeBenchmark.getLastFromAllInOneBucketMap  avgt    5  598155,646 ± 65873,250  ns/op
HashCodeBenchmark.getLastFromUsualHashMap       avgt    5     104,699 ±     2,341  ns/op
```

