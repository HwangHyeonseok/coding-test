import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// input //
		int N = Integer.parseInt(br.readLine());
		int[] board = new int[N]; // 수열
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		for(int i=0; i<N; i++) {
			board[i] = Integer.parseInt(st.nextToken());
		}
		
		// logic //
		// 1. 연속해서 오르는 수 최대 콤보 개수
		int maxUpCombo = 0;
		int curUpCombo = 1;
		for(int i=0; i<N-1; i++) {
			if(board[i] <= board[i+1]) curUpCombo++;
			else {
				maxUpCombo = Math.max(maxUpCombo , curUpCombo);
				curUpCombo = 1;
			}
		}
		maxUpCombo = Math.max(maxUpCombo , curUpCombo); // 마지막 처리
		
//		System.out.println(maxUpCombo);
		
		// 2. 연속해서 내리는 수 최대 콤보 개수
		int maxDownCombo = 0;
		int curDownCombo = 1;
		for(int i=0; i<N-1; i++) {
			if(board[i] >= board[i+1]) curDownCombo++;
			else {
				maxDownCombo = Math.max(maxDownCombo , curDownCombo);
				curDownCombo = 1;
			}
		}
		maxDownCombo = Math.max(maxDownCombo , curDownCombo); // 마지막 처리
//		System.out.println(maxDownCombo);
		
		// 3. 1번과 2번 결과의 최댓값이 정답
		int ans = Math.max(maxDownCombo, maxUpCombo);
		
		// output // 
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
}