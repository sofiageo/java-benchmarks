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
HashBenchmark.CRC32CBench|3687611.726|ops/s
HashBenchmark.xxHashZeroBench|1394913.160|ops/s
HashBenchmark.xxHash64Bench|935442.969|ops/s
HashBenchmark.murmur3Bench|511385.676|ops/s
HashBenchmark.CRC32Bench|501530.592|ops/s
HashBenchmark.xxHash32Bench|299190.778|ops/s
HashBenchmark.highwayhash|91777.851|ops/s
HashBenchmark.highwayhash256|90482.692|ops/s
HashBenchmark.sha1Bench|33703.050|ops/s
