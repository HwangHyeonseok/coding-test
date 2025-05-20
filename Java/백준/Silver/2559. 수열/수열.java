// overflow 가능성 : N,K가 100000이고 모든 수가 100으로 입력되었을 때 최대 1000만이므로, overflow 발생 X (21억까지 가능)
// N,K가 100000 이므로 O(N^2)은 안된다.

import java.util.*;
import java.io.*;

public class Main {
	static int[] temperature;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// input // 
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		int N = Integer.parseInt(st.nextToken()); // 온도를 측정한 전체 날짜의 수
		int K = Integer.parseInt(st.nextToken()); // 합을 구하기 위한 연속적인 날짜의 수
		
		temperature = new int[N];
		
		input = br.readLine();
		st = new StringTokenizer(input," ");
		for(int i=0; i<N; i++) {
			temperature[i] = Integer.parseInt(st.nextToken());
		}
		
		bw.write(getMaxTemperature(N,K)+"");
		bw.flush();
		bw.close();
	}
	
	// K개 만큼 보면서 온도의 합이 최대가 되는 값 찾기
	public static int getMaxTemperature(int N, int K) {
		int max = Integer.MIN_VALUE;// 온도의 합이 최대가 되는 값
		// 0 번째 인덱스부터 K 번째 인덱스까지의 합 
		int curSum = 0;
		for(int i=0; i<K; i++) {
			curSum += temperature[i];
		}
		
		max = max > curSum ? max : curSum;
		
		// 부분합 테크닉
		for(int i=0; i<N-K; i++) {
			curSum -= temperature[i];
			curSum += temperature[i+K];
			
			max = max > curSum ? max : curSum;
		}
		
		return max;
	}
}