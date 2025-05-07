import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		// first line input 
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		int N = Integer.parseInt(st.nextToken()); // 바구니 수
		int M = Integer.parseInt(st.nextToken()); // 명령 수
		
		int[] basket = new int[N+1]; // 0번 바구니는 쓰지 않는다. 
		
		// second line ~ M line input + logic
		for(int a=0; a<M; a++) {
			String commandInput = br.readLine();
			st = new StringTokenizer(commandInput, " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			for(int b=i; b<=j; b++) {
				basket[b] = k;
			}
			
//			output(basket, N); // debug
		}
		output(basket, N);
		bw.flush();
		bw.close();
	}
	
	// output
	public static void output(int[] basket, int N) throws IOException {
		for(int i=1; i<=N; i++) {
			bw.write(basket[i]+" ");
		}
		
		bw.write("\n");
	}

}
