package gr.sofiageo.benchmarks.crypto;

import org.openjdk.jmh.annotations.Benchmark;

import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import java.util.zip.CRC32C;

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
}
