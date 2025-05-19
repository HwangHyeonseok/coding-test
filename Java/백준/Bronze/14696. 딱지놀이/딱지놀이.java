import java.util.*;
import java.io.*;

public class Main {
	static final int showMaxCnt = 101; // 최대로 낼 수 있는 카드 개수
	static int[] userA = new int[showMaxCnt]; // userA가 가지고 있는 딱지
	static int[] userB = new int[showMaxCnt]; // userB가 가지고 있는 딱지
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 딱지놀이의 총 라운드 수
		for(int i=0; i<N; i++) {
			// userA, userB가 가진 딱지 정보 초기화
			for(int k=0; k<showMaxCnt; k++) {
				userA[k] = 0;
				userB[k] = 0;
			}
			
			// 사용자 A가 가진 딱지 정보 입력
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			
			int showCnt = Integer.parseInt(st.nextToken()); // a개를 낸다.
			for(int j=0; j<showCnt; j++) {
				userA[Integer.parseInt(st.nextToken())]++;
			}
			
			// 사용자 B가 가진 딱지 정보 입력
			input = br.readLine();
			st = new StringTokenizer(input, " ");
			
			showCnt = Integer.parseInt(st.nextToken()); // b개를 낸다.
			for(int j=0; j<showCnt; j++) {
				userB[Integer.parseInt(st.nextToken())]++;
			}
			
			// 승자를 출력한다.
			String ans = getWinner();
			bw.write(ans+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	// userA와 userB 중 승자를 출력한다.
	// 우선순위 : 별(4) > 동그라미(3) > 네모(2) > 세모(1)
	public static String getWinner() {
		for(int i=4; i>=1; i--) {
			if(userA[i] > userB[i]) return "A";
			else if(userA[i] < userB[i]) return "B";
		}
		
		return "D"; // 판가름 할 수 없는 경우 무승부
	}
}