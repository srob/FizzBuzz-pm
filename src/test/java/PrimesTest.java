import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class PrimesTest {
  @Test
    public void primesUpTo1 () {
        assertArrayEquals(new int[0], Primes.generate(1));
    }

    @Test
    public void primesUpto3 () {
        assertArrayEquals(new int[]{2, 3}, Primes.generate(3));
    }

    @Test
    public void primesUpto10 () {
        assertArrayEquals(new int[]{2, 3, 5, 7}, Primes.generate(10));
    }

    @Test
    public void  primesUpto100() {
        assertArrayEquals(new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97}, Primes.generate(100));
    }
}
