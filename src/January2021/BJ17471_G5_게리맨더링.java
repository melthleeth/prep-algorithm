package January2021;
import java.io.*;
import java.util.*;

public class BJ17471_G5_게리맨더링 {
	static int N;
	static Area[] area;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		area = new Area[N + 2];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int population = Integer.parseInt(st.nextToken());
			area[i].population = population;
			area[i].node = new ArrayList<>();
		}
		
		for (int i = 1; i<= N; i++) {
			
		}
	}
	
	static class Area {
		int population;
		ArrayList<Integer> node;
		
		public Area(int population, ArrayList<Integer> node) {
			super();
			this.population = population;
			this.node = node;
		}
	}

}
