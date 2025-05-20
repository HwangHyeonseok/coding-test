import java.util.*;
import java.io.*;

public class Main {
	static final int maxArea = 1000;
	static int[] board = new int[maxArea+2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// input //
		int N = Integer.parseInt(br.readLine()); // 기둥의 개수
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			
			int idx = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			board[idx] = height;
		}
		
		// logic // 
		
		// 건물 전체의 최대 높이 구하기
		int tallIdx = getTallHeightIdx(0);
		
		// 전반부의 면적
		int prevArea = getprevArea(tallIdx);
		
		// 후반부의 면적
		int finalArea = getfinalArea(tallIdx);
		
		int ans = prevArea+finalArea; // 전반부의 면적 + 후반부의 면적
//		System.out.print(prevArea + " " + finalArea + "\n");
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
	
	// 건물 높이의 최대 지점을 찾는 로직 (start~끝 지점)
	public static int getTallHeightIdx(int start) {
		int maxIdx = -1; // 건물의 최대 높이를 가지는 지점
		int maxHeight = 0;
		for(int i=start; i<board.length; i++) {
			if(maxHeight <= board[i]) {
				maxIdx = i;
				maxHeight = board[i];
			}
		}
		
		return maxIdx;
	}
	
	// 끝 지점(기둥에서 가장 오른쪽에 있는 위치)를 찾는 로직
	public static int getRightGidongIdx() {
		int rightGidongIdx = 0;
		for(int i=0; i<board.length; i++) {
			if(board[i] != 0) rightGidongIdx = i;
		}
		
		return rightGidongIdx;
	}
	
	// 전반부 : 처음~건물 높이의 최대 지점 : 처음부터 보면서 높이의 최댓값으로 본다.
	public static int getprevArea(int tallIdx) {
		int prevArea = 0; // 전반부의 면적
		int curTallHeight = 0; // 현재의 최대 높이
		for(int i=0; i<=tallIdx; i++) {
			curTallHeight = Math.max(board[i], curTallHeight);
			prevArea += curTallHeight;
		}
		
		return prevArea;
	}
	
	// 후반부 : 건물 높이의 최대 지점+1~끝 : 후반부의 높이 중 최댓값으로 쭉 본다.
	public static int getfinalArea(int tallIdx) {
		int finalArea = 0;
	    int curTallHeight = 0;
		int finalTallHeightIdx = getTallHeightIdx(tallIdx+1); // tallIdx+1 지점부터 끝 지점(후반부 범위)의 건물 높이의 최대 지점을 찾는다.
		int rightGidongIdx = getRightGidongIdx(); // 끝 지점을 찾아야 한다.
		
//		for(int i=tallIdx+1; i<=rightGidongIdx; i++) {
//			finalArea += board[finalTallHeightIdx];
//		}
	    for(int i = rightGidongIdx; i > tallIdx; i--) {
	        curTallHeight = Math.max(curTallHeight, board[i]);
	        finalArea += curTallHeight;
	    }
		
		return finalArea;
	}
}
