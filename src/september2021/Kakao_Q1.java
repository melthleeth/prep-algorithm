package september2021;

import java.io.*;
import java.util.*;


public class Kakao_Q1 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;

        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        // -----------------------
        int N = id_list.length;

        Map<Integer, Boolean>[] status = new HashMap[N];
        int[] banned = new int[N];
        int[] answer = new int[N];
        Map<String, Integer> id_mapping = new HashMap<>();
        Set<Integer> emailed_id = new HashSet<>();
        int idx = 0;
        for (String id : id_list)
            id_mapping.put(id, idx++);

        for (int i = 0; i < N; i++)
            status[i] = new HashMap<>();

        for (String str : report) {
            String[] info = str.split(" ");
            int user_id = id_mapping.get(info[0]);
            int reported_id = id_mapping.get(info[1]);

            if (status[user_id].get(reported_id) == null) {
                status[user_id].put(reported_id, true);
                if (++banned[reported_id] >= k) emailed_id.add(reported_id);
            }
        }

        for (int i = 0; i < N; i++) {
            for (Integer key : status[i].keySet()) {
                if (emailed_id.contains(key)) answer[i]++;
            }
        }


        bw.write(String.valueOf(Arrays.toString(answer)));
//        br.close();
        bw.close();
    }
}
