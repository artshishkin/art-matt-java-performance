# exploring-strings
[Tutorial - Java Application Performance and Memory Management - from Matt Greencroft (Udemy)](../README.md)

###  Section 9: Chapter 9 - The Metaspace and internal JVM memory optimisations

#### 41. Interning Strings

Interning - putting String into the String Pool in Heap

### Section 10: Chapter 10 - Tuning the JVM's Memory Settings

#### 43. Understanding the size and density of the string pool

1. Run from `exploring-strings\target\classes`:
   - `java -XX:+PrintStringTableStatistics net.shyshkin.study.performance.exploringstrings.EmptyMain`
2. Result 
   - `Variance of bucket size :     0.834`
   - `Std. dev. of bucket size:     0.913`
   - `Maximum bucket size     :         9`
   - `StringTable statistics:`
   - `Number of buckets       :     65536 =    524288 bytes, each 8`
   - `Number of entries       :      1731 =     27696 bytes, each 16`
   - `Number of literals      :      1731 =    112320 bytes, avg  64.887`
   - `Total footprsize_t         :           =    664304 bytes`
   - `Average bucket size     :     0.026`
   - `Variance of bucket size :     0.026`
   - `Std. dev. of bucket size:     0.163`
   - `Maximum bucket size     :         2`
3. Explanation
   - number of buckets : 65536 - much more then default for HashMap (16)
   - Number of entries : 1731 - already many strings stored in hashMap 
