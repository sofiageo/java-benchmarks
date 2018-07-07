package gr.sofiageo.benchmarks.crypto;

import net.jpountz.xxhash.XXHash64;
import net.jpountz.xxhash.XXHashFactory;
import net.openhft.hashing.LongHashFunction;
import org.apache.commons.codec.digest.XXHash32;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;
import java.util.zip.CRC32;

import static org.junit.Assert.*;

public class HashBenchmarkTest {

    public static byte[] bytes;

    @BeforeClass
    public static void setup() {
        bytes = new byte[8196];
        Random random = new Random();
        random.nextBytes(bytes);
    }

    @Test
    public void CRC32CBench() {
    }

    @Test
    public void CRC32Bench() {
        CRC32 obj = new CRC32();
        obj.update(bytes);
        System.out.println(obj.toString());
    }


    @Test
    public void xxHashBench() {

        // Apache commons
        XXHash32 hash1 = new XXHash32();
        hash1.update(bytes);
        System.out.println(hash1.getValue());

        // LZ4
        XXHashFactory factory = XXHashFactory.fastestInstance();
        long seed = 0L;
        XXHash64 hash = factory.hash64();
        long result = hash.hash(bytes, 0, 8192, seed);
        System.out.println(result);

        // Zero allocation
        LongHashFunction hassh = LongHashFunction.xx(seed);
        System.out.println(hassh.hashBytes(bytes));
    }
}