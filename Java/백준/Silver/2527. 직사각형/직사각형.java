import java.util.*;
import java.io.*;

public class Main {
	static int x1;
	static int y1;
	static int p1;
	static int q1;
	static int x2;
	static int y2;
	static int p2;
	static int q2;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		for(int i=0; i<4; i++) {
			// input //
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			p1 = Integer.parseInt(st.nextToken());
			q1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			p2 = Integer.parseInt(st.nextToken());
			q2 = Integer.parseInt(st.nextToken());
			
			if(isNoSame() == true) continue; // d
			if(isPointSame() == true) continue; // c
			if(isSideSame() == true) continue; // b
			else System.out.println("a"); // a
		}
	}
	public static boolean isSideSame() {
		// 변이 겹치는 경우 4가지 생각
		if(x1 == p2 || x2 == p1 || q1 == y2 || q2 == y1) {
			System.out.println("b");
			return true;
		}
		return false;
	}
	
	public static boolean isPointSame() {
		// 1번 직사각형의 각 좌상, 좌하, 우상, 우하의 점의 좌표를 
		// 2번 직사각형의 각 우하, 우상, 좌하, 좌상의 점의 좌표와 일치하는지 체크
	    if ((p1 == x2 && q1 == y2) || (p1 == x2 && y1 == q2) || (x1 == p2 && y1 == q2) || (x1 == p2 && q1 == y2)) {
            System.out.println("c");
            return true;
		}
        return false;
	}
	
	// 공통부분이 없는 것을 찾는 로직
	public static boolean isNoSame() {
		// 공통부분이 없는 경우 4가지 케이스를 생각
		if(p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
			System.out.println("d");
			return true;
		}
		return false;
	}
}
