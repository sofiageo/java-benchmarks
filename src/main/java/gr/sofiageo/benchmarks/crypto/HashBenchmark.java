package gr.sofiageo.benchmarks.crypto;

import net.openhft.hashing.LongHashFunction;
import org.openjdk.jmh.annotations.*;

import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import java.util.zip.CRC32C;

@Warmup(iterations = 0)
@Measurement(iterations = 2)
@Fork(1)
@BenchmarkMode(Mode.Throughput)
public class HashBenchmark {

    @Benchmark
    public void CRC32CBench() {
        CRC32C obj = new CRC32C();
        obj.update("dsadasdsadas".getBytes(StandardCharsets.UTF_8));
    }

    @Benchmark
    public void CRC32Bench() {
        CRC32 obj = new CRC32();
        obj.update("dsadasdsadas".getBytes(StandardCharsets.UTF_8));
    }

    @Benchmark
    public void xxHashBench() {
        LongHashFunction hash = LongHashFunction.xx();
        hash.hashBytes("dsadasdsadas".getBytes(StandardCharsets.UTF_8));
    }
}
