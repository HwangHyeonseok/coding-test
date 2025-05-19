import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer> list = new ArrayList<>();
	static ArrayList<Integer> pickNumList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// input //
		int studentCnt = Integer.parseInt(br.readLine()); // 학생 수
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		for(int i=0; i<studentCnt; i++) {
			pickNumList.add(Integer.parseInt(st.nextToken()));
		}
		
		// logic //
		line(studentCnt);
		
		// output //
		for(int i : list) {
			bw.write(i + " ");
		}
		bw.flush();
		bw.close();
	}
	
	// 줄 서기 로직 //
	public static void line(int studentCnt) {
		for(int i=1; i<=studentCnt; i++) {
			// 첫 번째 학생인 경우
			if(i==1) {
				list.add(1);
				continue;
			}
			// 2~N번째 학생까지는 (i-1)-pickNumList.get(i-1) 인덱스에 i 값 추가
			else {
				list.add((i-1)-pickNumList.get(i-1),i);
			}
		}
	}
}
