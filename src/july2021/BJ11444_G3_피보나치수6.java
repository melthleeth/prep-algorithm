package july2021;

import java.io.*;

// 행렬을 이용한 곱셈이라니...
// 결국 곱셈을 이용하는건 똑같은데 이걸 어떻게 하느냐구나
// N == 1 일때 바로 1 출력하는 코드를 하니 99%에서 틀렸다; 왜지?

public class BJ11444_G3_피보나치수6 {
    static long N;
    static long[][] A = new long[][]{{1, 1}, {1, 0}};
    static long[][] ans = new long[][]{{1, 0}, {0, 1}};
    final static int C = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Long.parseLong(br.readLine());

        while (N > 0) {
            if ((N & 1) == 1) ans = multiplyMatrix(ans, A);
            A = multiplyMatrix(A, A);

            N >>= 1;
        }
        bw.write(String.valueOf(ans[1][0]));
        br.close();
        bw.close();
    }

    public static long[][] multiplyMatrix(long[][] m1, long[][] m2) {
        long[][] result = new long[2][2];

        result[0][0] = (m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0]) % C;
        result[0][1] = (m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1]) % C;
        result[1][0] = (m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0]) % C;
        result[1][1] = (m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1]) % C;

        return result;
    }
}
