package January2021;
import java.util.*;
import java.io.*;

// 2021.01.03 왜 스택 안썼냐?

public class BJ17413_S3_단어뒤집기2스택 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> s = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '<') {
				while(!s.isEmpty()) sb.append(s.pop());
				while(str.charAt(i) != '>') sb.append(str.charAt(i++));
				sb.append(str.charAt(i));
			}
			else if (str.charAt(i) == ' ') {
				while(!s.isEmpty()) sb.append(s.pop());
				sb.append(str.charAt(i));	
			} else s.push(str.charAt(i));
		}
		while(!s.isEmpty()) sb.append(s.pop());
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}
