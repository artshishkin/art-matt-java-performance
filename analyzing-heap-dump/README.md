# analyzing-heap-dump
[Tutorial - Java Application Performance and Memory Management - from Matt Greencroft (Udemy)](../README.md)

###  Section 13: Chapter 13 - Analysing a heap dump

#### 58. Generating a heap dump

Ways to generate Heap Dump
1. VisualVM &rarr; Monitor &rarr; press button `Heap Dump`
2. Through Command Line Arguments
   - will create Heap Dump when program crashes
   - `-XX:+HeapDumpOnOutOfMemoryError`
   - `-XX:HeapDumpPath=someFilePath`

#### 59. Viewing a heap dump

Tools to analyze memory
- [Memory Analyzer (MAT)](https://www.eclipse.org/mat/)
  - Open Heap Dump
- IntelliJ Profiler
  - Double-click on *.hprof file (Heap Dump file)  
   