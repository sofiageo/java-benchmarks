package gr.sofiageo.benchmarks.crypto;

import net.jpountz.xxhash.*;
import net.openhft.hashing.LongHashFunction;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.XXHash32;
import org.openjdk.jmh.annotations.*;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.zip.CRC32;
import java.util.zip.CRC32C;

@Warmup(iterations = 0)
@Measurement(iterations = 2)
@Fork(1)
@BenchmarkMode(Mode.Throughput)
public class HashBenchmark {

    @State(Scope.Benchmark)
    public static class LocalState {

        public byte[] bytes;

        @Setup(Level.Trial)
        public void setup() {
            bytes = new byte[8196];
            Random random = new Random();
            random.nextBytes(bytes);
        }
    }

    @Benchmark
    public void CRC32CBench(LocalState state) {
        CRC32C obj = new CRC32C();
        obj.update(state.bytes);
        obj.getValue();
    }

    @Benchmark
    public void CRC32Bench(LocalState state) {
        CRC32 obj = new CRC32();
        obj.update(state.bytes);
        obj.getValue();
    }

    @Benchmark
    public void sha1Bench(LocalState state) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(state.bytes);
        new String(DigestUtils.sha1Hex(md.digest()));
    }

    @Benchmark
    public void xxHash32Bench(LocalState state) {
        XXHash32 hash1 = new XXHash32();
        hash1.update(state.bytes);
        hash1.getValue();
    }

    @Benchmark
    public void xxHash64Bench(LocalState state) {
        XXHashFactory factory = XXHashFactory.fastestInstance();
        int seed = 0x32132167;

        StreamingXXHash64 hash = factory.newStreamingHash64(seed);
        hash.update(state.bytes, 0, 8192);
        hash.getValue();
    }

    @Benchmark
    public void xxHashZeroBench(LocalState state) {
        LongHashFunction hash = LongHashFunction.xx();
        hash.hashBytes(state.bytes);
    }

    @Benchmark
    public void murmur3Bench(LocalState state) {
        LongHashFunction hash = LongHashFunction.murmur_3();
        hash.hashBytes(state.bytes);
    }

    @Benchmark
    public void highwayhash64(LocalState state) {
        long[] key = {0x0706050403020100L, 0x0F0E0D0C0B0A0908L,
                0x1716151413121110L, 0x1F1E1D1C1B1A1918L};
        HighwayHash.hash64(state.bytes, 0, state.bytes.length, key);
    }

    @Benchmark
    public void highwayhash256(LocalState state) {
        long[] key = {0x0706050403020100L, 0x0F0E0D0C0B0A0908L,
                0x1716151413121110L, 0x1F1E1D1C1B1A1918L};
        HighwayHash.hash256(state.bytes, 0, state.bytes.length, key);
    }

}
