package March2021;
import java.util.*;

public class Programmers_L3_네트워크 {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int start = 0; start < n; start++) {
            if (!visited[start]) {
                BFS(computers, n, start);
                answer++;
            }
        }

        return answer;
    }

    static public void BFS(int[][] arr, int n, int start){
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int from = q.poll();

            for (int to = 0; to < n; to++){
                if (arr[from][to] == 1 && !visited[to]) {
                    // System.out.println(from + " -> " + to);
                    q.offer(to);
                    visited[to] = true;
                }
            }
        }
    }
}
