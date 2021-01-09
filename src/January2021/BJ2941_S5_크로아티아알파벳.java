package January2021;
import java.io.*;

public class BJ2941_S5_크로아티아알파벳 {
	static int ans;
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		str = br.readLine() + "     ";
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') break;
			System.out.print("i = " + i);
			switch(str.charAt(i)) {
				case 'z':
					if (str.charAt(i + 1) == '=') i++;
					ans++;
					break;
				case 'd':
					if (str.substring(i + 1, i + 3).equals("z=")) i += 2;
					else if (str.charAt(i + 1) == '-') i++;
					ans++;
					break;
				case 'c':
					if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') i++;
					ans++;
					break;
				case 's':
					if (str.charAt(i + 1) == '=') i++;
					ans++;
					break;
				case 'l':
					if (str.charAt(i + 1) == 'j') i++;
					ans++;
					break;
				case 'n':
					if (str.charAt(i + 1) == 'j') i++;
					ans++;
					break;
				default:
					ans++;
					break;
			}
			System.out.println(", ans = " + ans);
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}

}
