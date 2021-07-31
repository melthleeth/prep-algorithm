package july2021;

import java.io.*;
import java.util.*;

/*
생각하지 못했던 반례: 순서가 뒤에 있는 파티가 이미 지나간 파티에 영향을 미칠 수 있다
--> 큐로 체크해야할 리스트를 관리!!
처음에 파티정보: 이차원 배열 -> ArrayList -> HashSet
visited: HashSet -> Queue

6 5
1 6
2 4 5
2 1 2
2 2 3
2 3 4
2 5 6
답: 0
*/

public class BJ1043_G4_거짓말 {
    static int N, M, ans;
    static Set<Integer> party[];
    static Queue<Integer> checkList = new LinkedList<>();
    static boolean[] knowTruth, truthParty;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        party = new HashSet[M];
        for (int i = 0; i < M; i++)
            party[i] = new HashSet<>();
        knowTruth = new boolean[N + 1];
        truthParty = new boolean[M + 1];
        ans = M;

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            int idx = Integer.parseInt(st.nextToken());
            knowTruth[idx] = true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            boolean shouldTellTruth = false;
            for (int j = 0; j < k; j++) {
                int person = Integer.parseInt(st.nextToken());
                party[i].add(person);
                if (knowTruth[person]) shouldTellTruth = true;
            }

            if (shouldTellTruth) {
                ans--;
                truthParty[i] = true;
                for (Integer p : party[i])
                    if (!knowTruth[p]) checkList.offer(p);
            }
        }

        while(!checkList.isEmpty()) {
            int p = checkList.poll();
            knowTruth[p] = true;

            for (int i = 0; i < M; i++) {
                if (truthParty[i]) continue;
                if (party[i].contains(p)) {
                    truthParty[i] = true;
                    ans--;
                    for (Integer person : party[i])
                        if (!knowTruth[person]) checkList.offer(person);
                }
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}