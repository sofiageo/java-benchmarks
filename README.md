# java-benchmarks
Java benchmarks for fun

#### How to run

    mvn clean install
    java -jar target/benchmark.jar
    
### Benchmark results
These benchmarks are just for fun and should not be considered accurate.
The result data have been populated after 2 successful runs without any warmup phases.
Last update: **2018-07-07**

|Benchmark|Score|Units|
|---------|-----|-----|
|HashBenchmark.CRC32Bench|45614305.785|ops/s
|HashBenchmark.CRC32CBench|68176659.415|ops/s
|HashBenchmark.xxHashBench|67721462.200|ops/s