import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// input
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		// logic
		int maxVal = Integer.MIN_VALUE;
		int minVal = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			int checkNum = Integer.parseInt(st.nextToken());
			if(maxVal < checkNum) { // 최대값보다 더 큰 수가 들어온 경우 최신화
				maxVal = checkNum;
			}
			if(minVal > checkNum) { // 최솟값보다 더 작은 수가 들어온 경우 최신화
				minVal = checkNum;
			}
		}
		
		// output
		bw.write(String.format("%d %d", minVal, maxVal));
		bw.flush();
		bw.close();
	}
}
