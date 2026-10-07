public class Primes {
  public static int[] generate(int maxValue) {
        if (maxValue < 2)
          return new int[0];
        
        int size = maxValue + 1;
        boolean[] flags = initializeArray(maxValue);
        markNonPrime(size, flags);

        // count the number of primes
        int count = getCount(size, flags);
        int[] primes = new int[count];
        // move the primes into the result
        initializePrimeArray(size, flags, primes);
        return primes;
    }

  private static void initializePrimeArray(int size, boolean[] flags, int[] primes) {
    int i;
    int j;
    for (i = 0, j = 0; i < size; i++) {
        if (flags[i])
            primes[j++] = i;
    }
  }

  private static int getCount(int size, boolean[] flags) {
    int i;
    int count = 0;
    for (i = 0; i < size; i++) {
        if (flags[i])
            count++; // increase count
    }
    return count;
  }

  private static void markNonPrime(int size, boolean[] flags) {
    int i, j;
    for (i = 2; i < Math.sqrt(size) + 1; i++) {
        if (flags[i]) {
            for (j = 2 * i; j < size; j += i)
                flags[j] = false; // not prime
        }
    }
  }

    public static boolean[] initializeArray(int maxValue) {
        int size = maxValue + 1;
        boolean[] flags = new boolean[size];
        int i;
        for (i = 0; i < size; i++)
            flags[i] = true;
        flags[0] = flags[1] = false;
        return flags;
    }
}