import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// input // 
		int N = Integer.parseInt(br.readLine());
		int[] arr1 = new int[N];
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		for(int i=0; i<N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		int findNum = Integer.parseInt(br.readLine());
		
		int checkCnt = 0;
		for(int i=0; i<N; i++) {
			if(arr1[i] == findNum) {
				checkCnt++;
			}
		}
		
		bw.write(checkCnt+"");
		bw.flush();
		bw.close();
	}
}
