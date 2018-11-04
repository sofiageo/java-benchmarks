# java-benchmarks
Java benchmarks for fun

#### How to run

    mvn clean install
    java -jar target/benchmark.jar
    
### Benchmark results
These benchmarks are just for fun and should not be considered accurate.
The result data have been populated after 2 successful runs without any warmup phases.
Last update: **2018-11-04**

|Benchmark|2500k@4.5Ghz|2700x PBO|Units|
|---------|-----|-----|-----|
CRC32CBench|3687611.726|1193949.807|ops/s
xxHashZeroBench|1394913.160|1820926.840|ops/s
xxHash64Bench|935442.969|780115.163|ops/s
murmur3Bench|511385.676|546458.544|ops/s
CRC32Bench|501530.592|1951136.717|ops/s
xxHash32Bench|299190.778|347809.125|ops/s
highwayhash|91777.851|119499.909|ops/s
highwayhash256|90482.692|116613.848|ops/s
sha1Bench|33703.050|246865.688|ops/s