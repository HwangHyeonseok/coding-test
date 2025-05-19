import java.util.*;
import java.io.*;

public class Main {
	static final int inputCnt = 4; // 입력은 4줄 고정
	static final int pointCnt = 4; // 좌측 하단 x,y | 우측 상단 x,y 
	static final int MAXPoint = 101; // x,y 좌표는 최대 100
	static int[][] point = new int[MAXPoint][MAXPoint];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0; i<inputCnt; i++) {
			// input //
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			
			int bx = Integer.parseInt(st.nextToken()); // 왼쪽 아래 x좌표
			int by = Integer.parseInt(st.nextToken()); // 왼쪽 아래 y좌표
			int tx = Integer.parseInt(st.nextToken()); // 오른쪽 위 x좌표
			int ty = Integer.parseInt(st.nextToken()); // 오른쪽 위 y좌표
			
			fillSquare(bx, by, tx, ty); // 사각형 채우기 로직
		}
		
//		debug(); // 디버깅 용도
		
		// 사각형의 개수 세는 로직
		int ans = getPointArea();
		
		// output //
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
	
	
	// 사각형(point) 영역에 1을 칠해주는 로직
	public static void fillSquare(int bx, int by, int tx, int ty) {
		for(int i=by; i<ty; i++) {
			for(int j=bx; j<tx; j++) {
				point[i][j] = 1;
			}
		}
	}
	
	// 디버깅용
	public static void debug() {
		for(int i=0; i<MAXPoint; i++) {
			for(int j=0; j<MAXPoint; j++) {
				System.out.print(point[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	// 사각형의 개수를 세는 로직 (1로 칠해진 개수 세기)
	public static int getPointArea() {
		int area = 0;
		for(int i=0; i<MAXPoint; i++) {
			for(int j=0; j<MAXPoint; j++) {
				if(point[i][j] == 1) area++;
			}
		}
		
		return area;
	}
}