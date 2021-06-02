package juniorSheet.cfB.uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwinPrimes {

  private static final int MAX = 2_00_000_00;
  private static boolean[] prime;
  private static int[] tPrime;

  private static void sieve() {
    Arrays.fill(prime, true);
    prime[0] = prime[1] = false;
    for (int i = 4; i <= MAX; i += 2)
      prime[i] = false;
    for (int i = 3; i * i <= MAX; i += 2) {
      if (prime[i]) {
        for (int j = i * i; j <= MAX; j += (i + i)) {
          prime[j] = false;
        }
      }
    }
  }

  private static void twinPrime() {
    int j = 1;
    for (int i = 3; i <= MAX; i++) {
      if (prime[i] && prime[i + 2]) {
        tPrime[j++] = i;
      }
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (br.ready()) {
      int s = Integer.parseInt(br.readLine());
      prime = new boolean[MAX + 10];
      tPrime = new int[MAX + 10];
      sieve();
      twinPrime();
      System.out.println("(" + tPrime[s] + ", " + (tPrime[s] + 2) + ")");
    }
  }
}
