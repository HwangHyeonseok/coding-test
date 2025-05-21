import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer> maxSizeList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 1번째 수를 고른다.
		
		for(int i=1; i<=N; i++) { // 2번째 수를 고른다.
			ArrayList<Integer> tempList = new ArrayList<>(); // 임시 리스트
			tempList.add(N); // 1~2번째 고른 수는 고정적으로 넣어준다.
			tempList.add(i);
	
			// 이후 3번째부터 넣어준다.
			int j = 2;
			while(tempList.get(j-2)- tempList.get(j-1) >= 0) {
				tempList.add(tempList.get(j-2)- tempList.get(j-1));
				j++;
			}
			
			// 만약 길이가 최대 길이면 maxSizeList로 옮긴다.
			if(tempList.size() > maxSizeList.size()) {
				maxSizeList = new ArrayList<>(tempList);
			}
		}
		
		// output //
		bw.write(String.format("%d\n",maxSizeList.size()));
		for(int num : maxSizeList) {
			bw.write(num + " ");
		}
		bw.flush();
		bw.close();
	}
}