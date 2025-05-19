import java.util.*;
import java.io.*;

public class Main {
	static final int nanjaengyiCnt = 9;
	static ArrayList<Integer> height = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// input // 
		for(int i=0; i<nanjaengyiCnt; i++) {
			height.add(Integer.parseInt(br.readLine()));
		}
		
		// logic //
		for(int i=0; i<nanjaengyiCnt; i++) { 
			for(int j=0; j<nanjaengyiCnt; j++) {
				if(i==j) continue; // i와 j는 서로 다른 것을 빼야 한다. (9 난쟁이 중 i,j번째 난쟁이를 빼고 7 난쟁이로 계산)
				// i와 j를 빼고 합이 100이 되는지 체크
				if(checkSum100(i,j) == true) {
					height.remove(i);
					height.remove(j-1);
					Collections.sort(height);
					// output //
					for(int k=0; k<nanjaengyiCnt-2; k++) {
						bw.write(height.get(k)+"\n");
					}
					bw.flush();
					bw.close();
					return;
				}
			}
		}
	}
	
	// i,j 를 빼고 모두 더했을 때 100이 되는지 체크하는 로직
	public static boolean checkSum100(int i, int j) {
		int sum = 0;
		for(int a=0; a<nanjaengyiCnt; a++) {
			if(a == i || a == j) continue; // i,j는 제외한다.
			sum += height.get(a);
		}
		
		if(sum == 100) return true;
		else return false;
	}
}
