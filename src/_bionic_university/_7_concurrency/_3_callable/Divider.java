package _bionic_university._7_concurrency._3_callable;

public class Divider {

    public int getCountOfDividers(long n) {
        int ret = 0;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) ret++;
                else ret += 2;
            }
        }
        return ret;
    }

}
