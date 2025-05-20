// dx dy 테크닉
import java.util.*;
import java.io.*;

public class Main {
	static int[][] board; // 좌석
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		// input // 
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		int C = Integer.parseInt(st.nextToken()); // 공연장의 격자 크기 
		int R = Integer.parseInt(st.nextToken()); // 공연장의 격자 크기 
		int K = Integer.parseInt(br.readLine()); // 어떤 관객의 대기 번호
		
		board = new int[R][C];
		
		// 모든 좌석이 배정되어 해당 대기번호 관객에게 좌석을 배정할 수 없는 경우
		if(C*R < K) {
			bw.write("0");
			bw.flush();
			bw.close();
			return;
		}
		
		seat(R, C); // 좌석 배정
		
//		debug(R, C); // 좌석 대기번호 debug
		getLocation(R, C, K); // 좌석 번호가 K인 위치를 조회
	}
	
	// 좌석의 배정 결과 로직 (시계 방향)
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void seat(int R, int C) {
		// 시작 위치
		int sr = R-1;
		int sc = 0;
		
		int dir = 0; // 이동 방향
		int fillNum = 1; // 채울 숫자
		// 시작 위치는 채운다.
		board[sr][sc] = fillNum;
		fillNum++;
		
		while(fillNum != R*C+1) {
			int nr = sr + dr[dir%4];
			int nc = sc + dc[dir%4];
			
			// 범위 밖이거나 이미 있는 경우
			if(nr < 0 || nc < 0 || nr >= R || nc >= C || board[nr][nc] != 0) {
				dir++;
//				System.out.println("nr : " + nr + " nc : " + nc); // debug
				continue;
			}
			
			board[nr][nc] = fillNum;
			fillNum++;
			sr = nr;
			sc = nc;
		}
	}
	
	// 좌석 대기번호 debug용
	public static void debug(int R, int C) {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// 대기번호가 K인 좌석 위치 출력
	public static void getLocation(int R, int C, int K) throws IOException {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(board[i][j] == K) {
					bw.write(String.format("%d %d", j+1, R-i));
				}
			}
		}
		bw.flush();
		bw.close();
	}
}