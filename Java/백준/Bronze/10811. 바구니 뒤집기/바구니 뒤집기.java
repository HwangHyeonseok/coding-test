// 알고리즘 직접 구현
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		int N = Integer.parseInt(st.nextToken()); // 바구니 개수
		int M = Integer.parseInt(st.nextToken()); // 명령 수
		int[] basket = new int[N+1]; // 바구니 번호 (0번째 바구니는 취급하지 않음)
		
		// 바구니 초기화
		initialBasket(N, basket);
		
		// 명령 처리 (i번째 바구니부터 j번째 바구니 거꾸로)
		for(int a=0; a<M; a++) {
			String switchCommand = br.readLine();
			st = new StringTokenizer(switchCommand, " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			reverse(i,j,basket);
//			test(N, basket);
		}
		
//		// output
		for(int i=1; i<=N; i++) {
			bw.write(basket[i]+" ");
		}
		bw.flush();
		bw.close();
	}
	
	// debug
	public static void test(int N, int[] basket) throws IOException {
		for(int i=1; i<=N; i++) {
			bw.write(basket[i]+" ");
		}
		bw.write("\n");
	}
	
	// initial basket (first basket num : 1 | second basket num : 2 .. )
	public static void initialBasket(int N, int[] basket) {
		for(int i=1; i<=N; i++) {
			basket[i] = i;
		}
	}
	
	// swap logic (start<->end swap)
	public static void swap(int startIdx, int endIdx, int[] basket) {
//		System.out.println("start : " + startIdx + " end : " + endIdx);
		int temp = basket[startIdx];
		basket[startIdx] = basket[endIdx];
		basket[endIdx] = temp;
	}
	
	 // reverse logic (i~j까지 reverse 하는 로직)
	public static void reverse(int start, int end, int[] basket) {
		// 양 끝을 (end-start)/2 번 swap 한다.
		for(int i=0; i<(end-start+1)/2; i++) { // swap 횟수 
			swap(start+i, end-i, basket);
		}
	}
}
