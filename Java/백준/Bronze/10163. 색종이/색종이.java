import java.util.*;
import java.io.*;

public class Main {
	static int[][] point = new int[1002][1002]; // 색종이가 놓인 최대 평면은 가로 최대 1001칸 * 세로 최대 1001칸
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		for(int i=1; i<=N; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			
			int bx = Integer.parseInt(st.nextToken()); // 좌측 하단 x 좌표
			int by = Integer.parseInt(st.nextToken()); // 좌측 하단 y 좌표
			int width = Integer.parseInt(st.nextToken()); // 너비
			int height = Integer.parseInt(st.nextToken()); // 높이
			
			fill(bx, by, width, height, i);
		}
		
		// output // 
		for(int i=1; i<=N; i++) {
			bw.write(checkArea(i)+"\n");
		}

		bw.flush();
		bw.close();
	}
	
	// 특정 색종이 번호수(paperNum)로 칠하는 로직
	public static void fill(int bx, int by, int width, int height, int paperNum) {
		for(int i=by; i<by+height; i++) {
			for(int j=bx; j<bx+width; j++) {
				point[i][j] = paperNum;
			}
		}
	}
	
	// paperNum번의 색종이가 각각 몇 개 보이는지 확인하는 로직
	public static int checkArea(int paperNum) {
		int area = 0;
		for(int i=0; i<point.length; i++) {
			for(int j=0; j<point[0].length; j++) {
				if(point[i][j] == paperNum) area++;
			}
		}
		return area;
	}
}