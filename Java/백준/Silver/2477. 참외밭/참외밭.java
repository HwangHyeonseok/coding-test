// 풀이 idea : 참외밭의 면적 = 전체 넓이 - 작은 사각형의 넓이
//1) 전체 넓이 : 동,서 이동 중 제일 큰 변의 길이 * 남,북 이동 중 제일 큰 변의 길이이다.
//2) 작은 사각형의 넓이 : 가장 긴 가로 변의 abs(직전 세로 길이-직후 세로 길이) * 가장 긴 세로 변의 abs(직전 가로 길이-직후 가로 길이)

import java.util.*;
import java.io.*;

public class Main {
	static final int sideCnt = 6; // 변의 개수
	static int[] dirCnt = new int[5]; // 동서남북으로 이동한 횟수
	static int[] sideArr = new int[6]; // side 값 저장
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// input // 
		int K = Integer.parseInt(br.readLine()); // 1제곱미터당 자라는 참외의 개수
		
		int smallArea = -1; // 작은 사각형의 넓이
		int maxColSide = 0; // 3,4(남,북 이동) 중 최대 side 값
		int maxColIdx = 0; // 3,4(남,북 이동) 중 최대 side를 가지는 위치
		int maxRowSide = 0; // 1,2(동,서 이동) 중 최대 side 값
		int maxRowIdx = 0; // 1,2(동,서 이동) 중 최대 side를 가지는 위치
		for(int i=0; i<sideCnt; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			
			int dir = Integer.parseInt(st.nextToken()); // 1: 동쪽, 2: 서쪽, 3: 남쪽, 4: 북쪽
			int side = Integer.parseInt(st.nextToken()); // 변의 길이
			
			dirCnt[dir]++;
			sideArr[i] = side;
			
			// 가장 긴 사각형의 가로/세로 길이를 구하고 그 위치를 알아낸다.
			if((dir == 1 || dir == 2) && maxRowSide < side) {
				maxRowSide = side;
				maxRowIdx = i;
			}
			else if((dir == 3 || dir == 4) && maxColSide < side) {
				maxColSide = side;
				maxColIdx = i;
			}
		}
		
		// 참외밭의 넓이 = 전체 사각형 넓이 - 작은 사각형의 넓이
		int camwoeArea = getAllArea(maxColSide, maxRowSide) - getSmallArea(maxColIdx, maxRowIdx);
		
		// output // 
		bw.write((camwoeArea*K) + ""); // 참외밭의 넓이 * 1제곱미터당 자라는 참외의 개수(K)
		bw.flush();
		bw.close();
	}
	
	// 1) 전체 넓이 : 동,서 이동 중 제일 큰 변의 길이 * 남,북 이동 중 제일 큰 변의 길이
	public static int getAllArea(int maxColSide, int maxRowSide) {
		return maxColSide*maxRowSide;
	}
	
	// 2) 작은 사각형의 넓이 로직 : 가장 긴 가로 변의 abs(직전 세로 길이-직후 세로 길이) * 가장 긴 세로 변의 abs(직전 가로 길이-직후 가로 길이)
	public static int getSmallArea(int maxColIdx, int maxRowIdx) {
		int tallRow = Math.abs(sideArr[(maxColIdx-1+6)%6]-sideArr[(maxColIdx+1+6)%6]); // 작은 사각형의 가로 길이
		int tallCol = Math.abs(sideArr[(maxRowIdx-1+6)%6]-sideArr[(maxRowIdx+1+6)%6]); // 작은 사각형의 세로 길이
		return tallRow * tallCol;
	}
}