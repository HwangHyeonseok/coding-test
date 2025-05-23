import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// input //
		int studentCnt = Integer.parseInt(br.readLine());
		int[] pickNum = new int[studentCnt]; // 뽑은 번호
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		for(int i=0; i<studentCnt; i++) {
			pickNum[i] = Integer.parseInt(st.nextToken());
		}
		
		// logic //
		// i-pickNum[i] 인덱스에 값 삽입
		ArrayList<Integer> studentLine = new ArrayList<>(); // 학생이 줄 선 현황을 저장
		for(int i=0; i<studentCnt; i++) {
			studentLine.add(i-pickNum[i], i+1);
		}
		
		// output //
		for(int ans : studentLine) {
			bw.write(ans+" ");
		}
		bw.flush();
		bw.close();
	}
}