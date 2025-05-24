import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++) {
			int ans = 1;
			String input = br.readLine();
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i) != input.charAt(input.length()-1-i)) {
					ans = 0;
				}
			}
			
			bw.write(String.format("#%d %d\n", t, ans));
		}
		bw.flush();
		bw.close();
	}
}