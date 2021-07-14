package july2021;

import java.io.*;
import java.util.*;

public class BJ3019_S2_테트리스 {
    static int C, P;
    static int[] tetris;
    static ArrayList<Block> block;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        tetris = new int[C + 1];

        st = new StringTokenizer(br.readLine());
        for (int t : tetris)
            t = Integer.parseInt(st.nextToken());

        getBlockShape();

        for (int s = 0; s < block.size(); s++) {
            Block b = block.get(s);
            for (int i = 0; i < C - b.size; i++) {

            }
        }

        br.close();
        bw.close();
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
