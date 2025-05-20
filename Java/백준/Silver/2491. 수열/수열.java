import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// input //
		int N = Integer.parseInt(br.readLine()); // 수열의 길이
		arr = new int[N];
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// logic //
		// 1. 연속해서 커지는 최대 개수 세기
		int upComboCnt = 1;
		int maxUpComboCnt = 1;
		for(int i=0; i<N-1; i++) {
			if(arr[i] <= arr[i+1]) upComboCnt++;
			else upComboCnt = 1;
			
			maxUpComboCnt = Math.max(upComboCnt,maxUpComboCnt);
		}
		
		// 2. 연속해서 작아지는 최대 개수 세기
		int downComboCnt = 1;
		int maxDownComboCnt = 1;
		for(int i=0; i<N-1; i++) {
			if(arr[i] >= arr[i+1]) downComboCnt++;
			else downComboCnt = 1;
			
			maxDownComboCnt = Math.max(downComboCnt,maxDownComboCnt);
		}
		
		// output //
		bw.write(String.format("%d", Math.max(maxUpComboCnt, maxDownComboCnt)));
		bw.flush();
		bw.close();
	}
}