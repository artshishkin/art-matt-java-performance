# how-lists-work
[Tutorial - Java Application Performance and Memory Management - from Matt Greencroft (Udemy)](../README.md)

###  Section 20: Chapter 20 - How Lists Work

####  99. The 8 different list implementations

- ArrayList
- CopyOnWriteArrayList
- LinkedList
- AttributeList
- RoleList
- RoleUnresolvedList
- Stack
- Vector

#### 100. The CopyOnWriteArrayList

Consider using it when:
- Multi-threaded application
- Multiple threads accessing the same list
- Lots of iterations / reads
- Few writes / additions / deletions

#### 102. Specifying the initial size of an ArrayList
```
Benchmark                              Mode  Cnt  Score   Error  Units
ListBenchmark.arrayListDefault         avgt   25  1,506 ? 0,128   s/op
ListBenchmark.arrayListSettingSize     avgt   25  1,265 ? 0,035   s/op
ListBenchmark.arrayListStream          avgt   25  1,503 ? 0,062   s/op
ListBenchmark.arrayListStreamWithCopy  avgt   25  1,414 ? 0,036   s/op
ListBenchmark.arrayListStreamWithSize  avgt   25  1,138 ? 0,011   s/op

ListBenchmark.linkedListStream         avgt   25  4,314 ? 0,085   s/op
```

#### 106. Choosing the optimal list type

```
Benchmark                                            Mode  Cnt          Score         Error  Units
ArrayListVsLinkedListBenchmark.arrayListGetByIndex   avgt   25          1,257 ?       0,035  ns/op
ArrayListVsLinkedListBenchmark.linkedListGetByIndex  avgt   25  267266424,288 ? 4519729,374  ns/op
```
