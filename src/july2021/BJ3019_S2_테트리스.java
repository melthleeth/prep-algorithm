package july2021;

import java.io.*;
import java.util.*;

public class BJ3019_S2_테트리스 {
    static int C, P, ans;
    static int[] tetris;
    static ArrayList<Block> block;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        tetris = new int[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++)
            tetris[i] = Integer.parseInt(st.nextToken());

        getBlockShape();

        for (int s = 0; s < block.size(); s++) {
            Block b = block.get(s);
//            System.out.println("block shape: " + Arrays.toString(b.shape));
            for (int i = 0; i < C - b.size + 1; i++) {
                boolean isDropped = true;
                int firstNum = getMin(i, b.size);
                for (int j = i; j < i + b.size; j++) {
                    int idx = j - i;
                    int floorNum = tetris[j] - firstNum;
//                    System.out.println("block: " + b.shape[idx] + ", tetris: " + floorNum);
                    if (b.shape[idx] != floorNum) {
                        isDropped = false;
                        break;
                    }
                }
//                System.out.println("isDropped: " + isDropped);
                if (isDropped) ans++;
            }
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
    public static int getMin(int start, int size) {
        int min = tetris[start];

        for (int i = start; i < start + size; i++)
            min = Math.min(min, tetris[i]);


        return min;
    }

    public static void getBlockShape() {
        block = new ArrayList<>();

        switch (P) {
            case 1:
                block.add(new Block(1, new int[]{0}));
                block.add(new Block(4, new int[]{0, 0, 0, 0}));
                break;
            case 2:
                block.add(new Block(2, new int[]{0, 0}));
                break;
            case 3:
                block.add(new Block(3, new int[]{0, 0, 1}));
                block.add(new Block(2, new int[]{1, 0}));
                break;
            case 4:
                block.add(new Block(3, new int[]{1, 0, 0}));
                block.add(new Block(2, new int[]{0, 1}));
                break;
            case 5:
                block.add(new Block(3, new int[]{0, 0, 0}));
                block.add(new Block(3, new int[]{1, 0, 1}));
                block.add(new Block(2, new int[]{0, 1}));
                block.add(new Block(2, new int[]{1, 0}));
                break;
            case 6:
                block.add(new Block(3, new int[]{0, 0, 0}));
                block.add(new Block(3, new int[]{0, 1, 1}));
                block.add(new Block(2, new int[]{0, 0}));
                block.add(new Block(2, new int[]{2, 0}));
                break;
            case 7:
                block.add(new Block(3, new int[]{0, 0, 0}));
                block.add(new Block(3, new int[]{1, 1, 0}));
                block.add(new Block(2, new int[]{0, 2}));
                block.add(new Block(2, new int[]{0, 0}));
                break;
        }
    }

    static class Block {
        int size;
        int[] shape;

        public Block(int size, int[] shape) {
            this.size = size;
            this.shape = shape;
        }
    }
}
