import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine(); // first line
		StringTokenizer st = new StringTokenizer(input, " ");
		
		int N = Integer.parseInt(st.nextToken()); // 바구니 개수
		int M = Integer.parseInt(st.nextToken()); // 명령 개수
		int[] basket = new int[N+1]; // 바구니에 담긴 공의 숫자 (0번에는 담지 않는다.)
		initalBasket(basket, N);
		
		for(int a=0; a<M; a++) {
			input = br.readLine(); // 2~M line
			st = new StringTokenizer(input, " ");
			
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			// logic
			swap(i,j,basket);
		}
		
		// output
		for(int i=1; i<=N; i++) {
			bw.write(basket[i]+" ");
		}
		bw.flush();
		bw.close();
	}

	// basket initial (first basket -> ballNum : 1 | second basket -> ballNum : 2  ..)
	public static void initalBasket(int[] basket, int N) {
		for(int i=1; i<=N; i++) { // 0은 사용하지 않음
 			basket[i] = i;
		}
	}
	
	// swap logic (i<->j swap)
	public static void swap(int i, int j, int[] basket) {
		int temp = basket[i];
		basket[i] = basket[j];
		basket[j] = temp;
	}
}