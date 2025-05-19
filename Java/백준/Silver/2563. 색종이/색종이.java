import java.util.*;
import java.io.*;

public class Main {
	static final int columnSize = 10; // "검은색" 색종이의 세로 길이
	static final int rowSize = 10;  // "검은색" 색종이의 가로 길이
	static int[][] board = new int[101][101]; // 도화지의 가로 세로 길이 : 100
	// 색종이가 도화지 밖으로 나가는 경우는 고려하지 않는다.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// input //
		int colorPaperCnt = Integer.parseInt(br.readLine()); // 색종이의 수
		for(int i=0; i<colorPaperCnt; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			int bx = Integer.parseInt(st.nextToken()); // 좌측 하단 x 좌표
			int by = Integer.parseInt(st.nextToken()); // 좌측 하단 y 좌표
			fill(bx, by);
		}
		
		// output //
		bw.write(area()+"");
		bw.flush();
		bw.close();
	}
	
	// 가로 10, 세로 10 영역에 칠하는 로직
	public static void fill(int bx, int by) {
		for(int i=by; i<by+rowSize; i++) {
			for(int j=bx; j<bx+columnSize; j++) {
				board[i][j] = 1;
			}
		}
	}
	
	// 1로 채워진 개수 즉, 검은색 영역의 넓이 구하는 로직
	public static int area() {
		int area = 0;
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j] == 1) area++;
			}
		}
		return area;
	}
}