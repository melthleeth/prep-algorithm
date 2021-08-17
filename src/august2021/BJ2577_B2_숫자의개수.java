package august2021;

import java.io.*;

public class BJ2577_B2_숫자의개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int num = A * B * C;
        int[] arr = new int[10];

        while (num > 0) {
            arr[num % 10]++;
            num /= 10;
        }

        for (int n : arr)
            bw.write(n + "\n");
        br.close();
        bw.close();
    }
}
