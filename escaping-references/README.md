# escaping-references
[Tutorial - Java Application Performance and Memory Management - from Matt Greencroft (Udemy)](../README.md)

###  Section 7: Chapter 7 - Escaping References

#### 29. Strategy 1 - using an iterator

1. No impact on the performance 
2. Can still provide unexpected behaviour (we can delete item)

#### 30. Strategy 2 - duplicating collections

1. Has **small** impact on the performance
2. We can still modify objects

#### 31. Strategy 3 - using immutable collections

1. Has **small** impact on the performance
2. Produce UnsupportedOperationException when trying to modify collection
3. We can still modify objects






