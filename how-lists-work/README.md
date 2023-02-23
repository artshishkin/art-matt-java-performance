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
Benchmark                                                    Mode  Cnt          Score         Error  Units
ArrayListVsLinkedListBenchmark.arrayListAddAt0RemoveLast     avgt    5   10783993,707 ±  221833,119  ns/op
ArrayListVsLinkedListBenchmark.arrayListGetByIndex           avgt    5          1,304 ±       0,074  ns/op
ArrayListVsLinkedListBenchmark.linkedListAddAt0RemoveLast    avgt    5       1658,440 ±     590,546  ns/op
ArrayListVsLinkedListBenchmark.linkedListAddFirstRemoveLast  avgt    5       1669,036 ±     413,820  ns/op
ArrayListVsLinkedListBenchmark.linkedListGetByIndex          avgt    5  258875113,846 ± 1439989,735  ns/op
```

#### 107. Sorting lists

```
Benchmark                             Mode  Cnt      Score      Error  Units
SortingListBenchmark.cloneArrayList   avgt    5     51,750 ±   17,359  ms/op
SortingListBenchmark.cloneLinkedList  avgt    5   2310,875 ± 1435,638  ms/op
SortingListBenchmark.copyArrayList    avgt    5     41,019 ±    7,486  ms/op
SortingListBenchmark.copyLinkedList   avgt    5   2083,803 ±  927,795  ms/op
SortingListBenchmark.sortArrayList    avgt    5  11633,503 ± 1582,596  ms/op
SortingListBenchmark.sortLinkedList   avgt    5  13570,911 ± 4381,387  ms/op
```
