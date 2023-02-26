public class Util {

  private static boolean isPrime(int x) {
    if (x < 2) {
      return false;
    }
    if (x == 2)
      return true;
    if (x % 2 == 0) {
      return false;
    }
    for (int i = 3; i <= Math.sqrt(x); i += 2) {
      if (x % i == 0)
        return false;
    }

    return true;
  }

  private static int[] prepareKmp(String pattern) {
    int[] kmp = new int[pattern.length()];
    kmp[0] = 0;
    int i = 0, j = 0;
    while (++i < pattern.length()) {
      if (pattern.charAt(i) == pattern.charAt(j)) {
        j++;
        kmp[i] = j;
      } else {
        while (j != 0) {
          if (pattern.charAt(i) == pattern.charAt(j)) {
            j++;
            break;
          } else {
            j = kmp[j - 1];
          }
        }
        kmp[i] = j;
      }
    }
    return kmp;
  }

}
