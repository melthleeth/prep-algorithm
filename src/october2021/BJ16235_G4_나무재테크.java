package october2021;

import java.io.*;
import java.util.*;

/*
처음에 PriorityQueue로 살아있는 모든 나무를 관리했다.
 - 그렇게 되면 시간초과가 나게 되는데
 - offer(), poll()의 time complexity가 O(logn)이라 그런것 같다.
따라서 deque[][]로 age값만 넣어서 관리했다.
 - 모든 operation의 time complexity가 O(1)이다. (random access by index 제외)
 - 처음 큐 사이즈만큼만 돌리기 때문에 정렬은 따로 필요 없다.
 - breeding할때만 나이가 1인 나무를 deque 맨앞에 넣어주면 된다.
*/

public class BJ16235_G4_나무재테크 {
    static int N, M, K;
    static int[] dx = new int[]{1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] land, nutrients;
    static Deque<Integer>[][] alive;
    static Queue<Tree> dead = new LinkedList<>();
    static Queue<Tree> breed = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        land = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            Arrays.fill(land[i], 5);

        nutrients = new int[N + 1][N + 1];
        alive = new Deque[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                nutrients[i][j] = Integer.parseInt(st.nextToken());
                alive[i][j] = new LinkedList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            alive[x][y].offer(age);
        }

        for (int i = 0; i < K; i++) {
            spring();
            summer();
            autumn();
            winter();
        }
        bw.write(String.valueOf(calcuateLiveTree()));
        br.close();
        bw.close();
    }

    public static int calcuateLiveTree() {
        int cnt = 0;

        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                cnt += alive[i][j].size();

        return cnt;
    }

    public static void spring() {
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                if (!alive[i][j].isEmpty()) growing(i, j);
    }

    public static void summer() {
        while (!dead.isEmpty()) {
            Tree tree = dead.poll();
            land[tree.x][tree.y] += tree.age / 2;
        }
    }

    public static void autumn() {
        planting();
    }

    public static void winter() {
        supplyNutrients();
    }

    public static void growing(int x, int y) {


        int size = alive[x][y].size();
        while (size-- > 0) {
            int age = alive[x][y].poll();
            if (land[x][y] < age) dead.offer(new Tree(x, y, age));
            else {
                land[x][y] -= age;
                alive[x][y].offer(age + 1);
                if ((age + 1) % 5 == 0) breed.offer(new Tree(x, y));
            }


        }
    }

    public static void planting() {
        while (!breed.isEmpty()) {
            Tree tree = breed.poll();

            for (int d = 0; d < 8; d++) {
                int x = tree.x + dx[d];
                int y = tree.y + dy[d];

                if (isIn(x, y)) alive[x][y].offerFirst(1);
            }
        }
    }

    public static boolean isIn(int x, int y) {
        if (x < 1 || x > N || y < 1 || y > N) return false;
        return true;
    }

    public static void supplyNutrients() {
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                land[i][j] += nutrients[i][j];
    }

    static class Tree {
        int x;
        int y;
        int age;

        public Tree(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Tree(int x, int y, int age) {
            this(x, y);
            this.age = age;
        }
    }
}
