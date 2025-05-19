import java.util.*;
import java.io.*;

public class Main {
	static final int bingoBoardLength = 5; // 빙고판은 5*5
	static int[][] bingoBoard = new int[bingoBoardLength][bingoBoardLength]; // 빙고판에 담긴 번호들
	static int[][] checkBoard = new int[bingoBoardLength][bingoBoardLength]; // 사회자가 부른 번호 중 맞춘 것을 체크 (맞으면 1)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 빙고판에 쓰여진 수 input //
		for(int i=0; i<bingoBoardLength; i++) { 
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			for(int j=0; j<bingoBoardLength; j++) {
				bingoBoard[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 사회자가 부른 수에 따라 1) 빙고판에 표시하고 2) 3bingo가 되었는지 체크
		int ans = 0; // 사회자가 부른 숫자 개수
		outerLoop:
		for(int i=0; i<5; i++) {
			// 사회자가 부른 수 input // 
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			for(int j=0; j<5; j++) {
				int findNum = Integer.parseInt(st.nextToken());
				ans++;
				findNumberAndCheck(findNum); // 사회자가 부른 수 표시하기
				// 3빙고인지 체크 
				if(check3Bingo() == true) {
					bw.write(ans+"");
					break outerLoop;
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	// 사회자가 부른 수 표시하기
	public static void findNumberAndCheck(int findNum) {
		for(int i=0; i<bingoBoardLength; i++) {
			for(int j=0; j<bingoBoardLength; j++) {
				if(bingoBoard[i][j] == findNum) {
					checkBoard[i][j] = 1;
				}
			}
		}
	}
	
	// 3 bingo 상태인지 체크하기
	public static boolean check3Bingo() {
		int bingoCnt = 0; // 빙고 횟수
		
		// 빙고 Case 1 : 1 1 1 1 1 (가로로 모두 1)
		for(int i=0; i<bingoBoardLength; i++) {
			int checkCnt = 0; // checkCnt가 5가 되어야 빙고
			for(int j=0; j<bingoBoardLength; j++) {
				if(checkBoard[i][j] == 1) checkCnt++;
				else break;
			}
			
			if(checkCnt == 5) bingoCnt++;
		}
		
		// 빙고 Case 2 : 세로로 모두 1
		for(int i=0; i<bingoBoardLength; i++) {
			int checkCnt = 0; // checkCnt가 5가 되어야 빙고
			for(int j=0; j<bingoBoardLength; j++) {
				if(checkBoard[j][i] == 1) checkCnt++;
				else break;
			}
			
			if(checkCnt == 5) bingoCnt++;
		}
		
		// 빙고 Case 3 : 좌측 하단부터 우측 상단으로 이어지는 1
		int checkCnt = 0; // checkCnt가 5가 되어야 빙고
		for(int i=0; i<bingoBoardLength; i++) {
			if(checkBoard[0+i][4-i] == 1) checkCnt++;
			else break;
		}
		if(checkCnt == 5) bingoCnt++;
		
		// 빙고 Case 4 : 좌측 상단부터 우측 하단으로 이어지는 1
		checkCnt = 0; // checkCnt가 5가 되어야 빙고
		for(int i=0; i<bingoBoardLength; i++) {
			if(checkBoard[i][i] == 1) checkCnt++;
			else break;
		}
		if(checkCnt == 5) bingoCnt++;
		
		
		// 3빙고 이상인지 체크
		if(bingoCnt >= 3) return true;
		else return false;
	}
}