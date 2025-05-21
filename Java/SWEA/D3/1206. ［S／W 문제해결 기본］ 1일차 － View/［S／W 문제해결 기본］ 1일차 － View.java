import java.util.*;
import java.io.*;

public class Solution {
	static final int TC = 10; // 테스트 케이스 10개
	static int[] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int t=1; t<=TC; t++) {
			int gunmulCnt = Integer.parseInt(br.readLine()); // 건물 개수
			board = new int[gunmulCnt];
			// 각 빌딩의 높이 입력
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			for(int i=0; i<gunmulCnt; i++) {
				board[i] = Integer.parseInt(st.nextToken());
			}
			
			// logic //
			int jomang = 0; // 조망권이 확보된 세대 
			for(int i=2; i<gunmulCnt-2; i++) {
				// 1. idx-2~idx+2 까지의 최댓값을 찾는다. (idx 제외)
				int maxNum = 0;
				for(int j=i-2; j<=i+2; j++) {
					if(i == j) continue;
					maxNum = Math.max(board[j], maxNum);
				}
				
				// 2. 만약  idx-2~idx+2 까지의 최댓값(idx 제외) < 해당 idx 값 이라면,
//				해당 idx 값 - idx-2~idx+2 까지의 최댓값 을 한다.
				if(maxNum < board[i]) jomang += (board[i] - maxNum);
			}
			
			// output //
			bw.write(String.format("#%d %d\n", t, jomang));
		}
		bw.flush();
		bw.close();
	}
}