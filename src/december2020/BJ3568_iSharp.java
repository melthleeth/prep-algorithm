package december2020;

import java.util.*;
import java.io.*;

//2020.12.22
// 문제를 잘 읽자.. 그냥 반대로 뒤집기만 하면 되는 거였다..

public class BJ3568_iSharp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        
        StringBuilder[] sb = new StringBuilder[str.length + 1];
        for (int i = 0; i <= str.length; i++)
            sb[i] = new StringBuilder();
        
        for (int i = 1; i < str.length; i++) {
        	sb[i].append(str[0]);
            
        	int idx = getIdx(str[i]);
        	String varName = str[i].substring(0, idx);
            
            sb[i].append(getType(idx, str[i]));
            sb[i].append(" " + varName + ";\n");
        }

        for (int i = 1; i < str.length; i++)
            bw.write(sb[i].toString());

        br.close();
        bw.close();
    }
    
    public static int getIdx(String str) {
    	int idx = str.length() - 1;
    	for (int j = 0; j < str.length(); j++) {
        	char c = str.charAt(j);
        	if ((c == '*' || c == '[' || c == '&')) return j;
        }
    	return idx;
    }
    
    public static String getType(int idx, String str) {
    	StringBuilder result = new StringBuilder();
    	for (int j = str.length() - 1; j >= idx; j--) {
    		char c = str.charAt(j);
    		
        	switch(c) {
            case '&':
            case '*':
            	result.append(c);
            	break;
            case ']':
            	result.append("[]");
            	j--;
            	break;
            }
    	}
    	
    	return result.toString();
    }
}
