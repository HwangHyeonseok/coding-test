import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// input //
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine()); // N 일에 걸쳐 매매 진행
			int[] price = new int[N];// 가격을 담은 배열
			
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			for(int j=0; j<N; j++) {
				price[j] = Integer.parseInt(st.nextToken());
			}
			
			// logic //
			long ans = 0; // 총 매매로 이익을 얻은 양
			int curIdx = 0; // 현재 index
			int maxIdx = -1; // 최댓값을 가지는 index
			long earn = 0; // 해당 매매로 번 이익
			while(curIdx < N) {
				maxIdx = getMaxIdx(price, curIdx, N); // 1. 최댓값 찾기(maxIdx)
				earn = deal(price, curIdx, maxIdx); // 2. curIdx~maxIdx-1 까지 매입하고 maxIdx에서 판매
				ans += earn;
				// 3. curIdx 최신화
				curIdx = maxIdx+1;
			}
			
			// output //
			bw.write(String.format("#%d %d\n", i, ans));
		}
		bw.flush();
		bw.close();
	}
	
	// 1. 최댓값 위치 찾기(maxIdx)
	public static int getMaxIdx(int[] price, int curIdx, int N) {
		int maxIdx = -1;
		long maxPrice = -1; 
		for(int i=curIdx; i<N; i++) {
			if(maxPrice < price[i]) {
				maxPrice = price[i];
				maxIdx = i;
			}
		}
		
		return maxIdx;
	}
	
	// 2. curIdx~maxIdx-1 까지 매입하고 maxIdx에서 판매
	public static long deal(int[] price, int curIdx, int maxIdx) {
		long earn = 0; // 이번 매매로 번 금액
		for(int i=curIdx; i<maxIdx; i++) {
			earn += price[maxIdx] - price[i];
		}
		
		return earn;
	}
	
}