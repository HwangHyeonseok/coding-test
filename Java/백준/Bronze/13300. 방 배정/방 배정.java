import java.util.*;
import java.io.*;

public class Main {
	static int[][] studentInRoomCnt = new int[2][6]; // [성별][학년]
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		// input // 
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		int N = Integer.parseInt(st.nextToken()); // 수학여행에 참가하는 학생 수
		int K = Integer.parseInt(st.nextToken()); // 한 방에 배정할 수 있는 최대 인원 수
		
		for(int i=0; i<N; i++) {
			input = br.readLine();
			st = new StringTokenizer(input, " ");
			
			int S = Integer.parseInt(st.nextToken()); // 성별 (0~1)
			int Y = Integer.parseInt(st.nextToken()) - 1; // 학년 (1~6) -> 학년 (0~5)
			
			studentInRoomCnt[S][Y]++;
		}
		
		// 순회하며 방 개수 찾기 // 
		int ans = 0;
		for(int i=0; i<=1; i++) { // 성별
			for(int j=0; j<=5; j++) { // 학년
				ans += roomCnt(i,j, K);
				// System.out.println("i =" + i + "j =" + j + "ans = " + ans); // debug
			}
		}
		
		// output //
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
	
	// 방 개수 찾기 로직
	public static int roomCnt(int sex, int grade, int K) {
		if(studentInRoomCnt[sex][grade] == 0) return 0; // 
		else {
			if(studentInRoomCnt[sex][grade] % K == 0) { // 나누어 떨어지는 경우 (4명 학생이 2명씩 짝지어 방을 사용한다고 하면 방은 2개가 필요하다)
				return studentInRoomCnt[sex][grade] / K;
			}
			else { // 나누어 떨어지지 않는 경우 (5명 학생이 2명씩 짝지어 방을 사용한다고 하면 방은 3개가 필요하다)
				return studentInRoomCnt[sex][grade] / K + 1;
			}
		}
	}
}
