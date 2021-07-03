package july2021;
import java.util.*;
import java.io.*;

public class BJ18352_S2_특정거리의도시찾기 {
    // 단방향 그래프
    // 오름차순으로 출력, 하나도 없으면 -1
    static int N, M, K, X; // 도시(vertex) 개수, 도로(edge) 개수, 거리정보, 출발점
    static ArrayList<Integer>[] city;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        city = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            city[i] = new ArrayList<>();


    }
}
