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

