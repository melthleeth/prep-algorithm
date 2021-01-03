package January2021;
import java.util.*;
import java.io.*;

// 2021.01.03

public class BJ17413_S3_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		int mark = -1;
		for (int i = 0; i < str.length(); i++) {
			condition:
			if (str.charAt(i) == '<') {
				//System.out.println("mark + 1, i: " + (mark + 1) + ", " + i);
				temp.append(str.substring(mark + 1, i));
				//System.out.println("< temp: " + temp.toString());
				sb.append(temp.reverse());
				temp.setLength(0);
				while (str.charAt(i) != '>')
					sb.append(str.charAt(i++));
				
				mark = i;
				sb.append(str.charAt(i));
				//System.out.println("sb, mark: " + sb.toString() + ", " + mark);
			}
			if (str.charAt(i) == ' ') {
				temp.append(str.substring(mark + 1, i));
				//System.out.println("\' \' temp: " + temp.toString());
				sb.append(temp.reverse());
				temp.setLength(0);
				sb.append(str.charAt(i));
				mark = i;
				
				//System.out.println("sb, mark: " + sb.toString() + ", " + mark);
			}
			//System.out.println("mark: " + mark);
		}
		temp.append(str.substring(mark + 1));
		//System.out.println("fin / temp: " + temp.toString());
		sb.append(temp.reverse());
		
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}
