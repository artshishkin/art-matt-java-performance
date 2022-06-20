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
4. Run:
   - `java -XX:+PrintStringTableStatistics net.shyshkin.study.performance.exploringstrings.ManyStrings`
5. Result
   - `StringTable statistics:`
   - `Number of buckets       :   1048576 =   8388608 bytes, each 8`
   - `Number of entries       :  10002372 = 160037952 bytes, each 16`
   - `Number of literals      :  10002372 = 480149840 bytes, avg  48.004`
   - `Total footprsize_t         :           = 648576400 bytes`
   - `Average bucket size     :     9.539`
   - `Variance of bucket size :    42.171`
   - `Std. dev. of bucket size:     6.494`
   - `Maximum bucket size     :        35`

#### 44. Tuning the size of the string pool

1. Use flag `StringTableSize`
   - must be the Prime number
   - `java -XX:StringTableSize=120121 -XX:+PrintStringTableStatistics net.shyshkin.study.performance.exploringstrings.ManyStrings`
2. Result
   - `StringTable statistics:`
   - `Number of buckets       :   1048576 =   8388608 bytes, each 8`
   - `Number of entries       :  10002368 = 160037888 bytes, each 16`
   - `Number of literals      :  10002368 = 480149592 bytes, avg  48.004`
   - `Total footprsize_t         :           = 648576088 bytes`
   - `Average bucket size     :     9.539`
   - `Variance of bucket size :    42.171`
   - `Std. dev. of bucket size:     6.494`
   - `Maximum bucket size     :        35`
3. Bucket size enlarged automatically ???

#### 45. Tuning the size of the heap

1. Flags
   - run `java -XX:+PrintFlagsFinal`
   - MaxHeapFreeRatio = 70
   - MaxHeapSize = 4127195136
   - InitialHeapSize = 257949696
2. Reduce heap size
   - `java -XX:MaxHeapSize=400m -XX:+PrintStringTableStatistics net.shyshkin.study.performance.exploringstrings.ManyStrings`
3. Result
  - `Exception in thread "main" java.lang.OutOfMemoryError: Java heap space`
  - `  at java.base/java.lang.Integer.toString(Integer.java:440)`
  - `  at java.base/java.lang.String.valueOf(String.java:3058)`
  - `  at net.shyshkin.study.performance.exploringstrings.ManyStrings.main(ManyStrings.java:14)`
  - `  SymbolTable statistics:`
  - `...`
  - `  statistics unavailable at this moment`
4. Enlarge initial heap size
  - for possible performance
  - `java -XX:InitialHeapSize=1g -XX:+PrintStringTableStatistics net.shyshkin.study.performance.exploringstrings.ManyStrings`
  - `Elapsed time was :PT52.1821638S` (but was PT48.7560031S ???)

#### 46. Shortcut syntax for heap tuning flags

1. Xmx
  - `-Xmx1g` - `-XX:MaxHeapSize=1g`
2. Xms
  - `-Xms128m` - `-XX:InitialHeapSize=128m`


   