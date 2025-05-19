import java.util.*;
import java.io.*;

public class Main {
	static int[] switchCondition; // switch 상태
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// input //
		int switchCnt = Integer.parseInt(br.readLine()); // 스위치 개수 (<=100)
		switchCondition = new int[switchCnt];
			// 스위치 상태 입력 받기
		String input = br.readLine(); 
		StringTokenizer st = new StringTokenizer(input, " ");
		for(int i=0; i<switchCnt; i++) {
			switchCondition[i] = Integer.parseInt(st.nextToken());
		}
		int studentCnt = Integer.parseInt(br.readLine()); // 학생 수 (<=100)
		for(int i=0; i<studentCnt; i++) {
			input = br.readLine();
			st = new StringTokenizer(input, " ");
			
			int sex = Integer.parseInt(st.nextToken()); // 성별 (남: 1, 여 : 2)
			int givenNum = Integer.parseInt(st.nextToken()); // 학생이 받은 수
			
			// 남자일 경우
			if(sex == 1) {
				manLogic(givenNum);
			}
			// 여자일 경우 
			else if(sex == 2) {
				womenLogic(givenNum);
			}
		}
		
		// output //
		// 스위치의 상태를 1번 스위치에서 시작하여 마지막 스위치까지 한 줄에 20개씩 출력한다.
		// 예를 들어 21번 스위치가 있다면 이 스위치의 상태는 둘째 줄 맨 앞에 출력
		for(int i=0; i<switchCondition.length; i++) {
			bw.write(switchCondition[i]+" ");
			if(i != 0 && (i+1)%20 == 0) bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	// 남자인 경우 로직 : 남자가 가진 숫자가 3이라면 -> 3번째, 6번째 값을 변환 (2인덱스, 5인덱스)
	public static void manLogic(int givenNum) {
		for(int i=givenNum-1; i<switchCondition.length; i+=givenNum) {
			if(switchCondition[i] == 1) switchCondition[i] = 0;
			else if(switchCondition[i] == 0) switchCondition[i] = 1;
		}
	}
	
	// 여자인 경우 로직 : 여자가 가진 숫자를 기점으로 좌우 대칭이 되기 전까지의 수들을 모두 변환한다.
	public static void womenLogic(int givenNum) {
		givenNum--; // 배열은 인덱스이므로 보정
		int i = 0; // 반복 횟수 
		
		while(true) { // 좌우 대칭이 되지 않을 때까지 진행
			i++;
			if(givenNum - i < 0 || givenNum + i >= switchCondition.length) break; // 배열 범위를 벗어나는 경우 종료
			if(switchCondition[givenNum - i] != switchCondition[givenNum + i]) break; // 대칭이 아닌 경우 종료
		}
		
		
		// 단, 처음(주어진 숫자)은 무조건 변환해준다.
		if(switchCondition[givenNum] == 1) switchCondition[givenNum] = 0;
		else if(switchCondition[givenNum] == 0) switchCondition[givenNum] = 1;
		
		// 대칭인 만큼 switch 값 변환
		for(int a=1; a<i; a++) {
			if(switchCondition[givenNum-a] == 1) switchCondition[givenNum-a] = 0;
			else if(switchCondition[givenNum-a] == 0) switchCondition[givenNum-a] = 1;
			
			if(switchCondition[givenNum+a] == 1) switchCondition[givenNum+a] = 0;
			else if(switchCondition[givenNum+a] == 0) switchCondition[givenNum+a] = 1;
		}
	}
}