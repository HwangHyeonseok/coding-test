import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// input //
		int N = Integer.parseInt(br.readLine()); // 첫 번째 수 선택
		
		// logic // 
		int maxCombo = 2;
		ArrayList<Integer> ans = new ArrayList<>(); // 최대 개수를 가지는 숫자 리스트
		for(int i=1; i<=N; i++) { // 두 번째 수 선택
			// init
			ArrayList<Integer> numList = new ArrayList<>();
			numList.add(N);
			numList.add(i);
			
			// 세 번째 수부터 계속해서 음수가 나올 때까지 연산 진행
			while(true) {
				// 다음 수가 음수라면
				if(numList.get(numList.size()-2) - numList.get(numList.size()-1) < 0) {
					if(maxCombo < numList.size()) { // 만약 최대 개수인 경우
						maxCombo = numList.size();
						ans = new ArrayList<>(numList);
					}
					break;
				}
				else {
					numList.add(numList.get(numList.size()-2) - numList.get(numList.size()-1));
				}
			}
		}
		
		bw.write(maxCombo+"\n");
		// ans 출력
		for(int i : ans) {
			bw.write(i+" ");
		}
		bw.flush();
		bw.close();
	}
}