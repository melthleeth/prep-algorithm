package september2021;

import java.io.*;
import java.util.*;

// 그냥 for문으로 해도 될것을 왜 복잡하게 했을까?
// Integer.toString(int i, int radix) 대체 왜 이건 검색해도 안나와? 짜증나네 진짜로
// 다음부턴 "제일 쉬운 방법"을 시도해보고나서 안되면 더 어려운 방법을 시도하자.

public class kakao_Q2 {

    public static void main(String[] args) throws IOException {
        int n = 999992;
        int k = 3;
        // --------------------
        int answer = 0;

        System.out.println(nToKNumber(n, k));
        System.out.println(Integer.toString(n, k));
        String[] result = nToKNumber(n, k).split("0");
        for (String item : result) {
            if (item.equals("1") || item.isEmpty()) continue;
            long num = Long.parseLong(item);
            if (num == 2 || isPrimeNumber(num)) answer++;
        }

        System.out.println(answer);
    }

    public static boolean isPrimeNumber(long num) {
        for (long i = 2; i * i <= num; i++)
            if (num % i == 0) return false;
        return true;
    }

    public static String nToKNumber(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n >= 1) {
            sb.insert(0, n % k);
            n /= k;
        }
        return sb.toString();
    }
}
