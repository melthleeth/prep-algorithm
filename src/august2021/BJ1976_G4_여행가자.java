package august2021;

import java.io.*;
import java.util.*;

// 다익스트라를 노드 갯수만큼 돌림 -> 경로 판단
public class BJ1976_G4_여행가자 {
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
