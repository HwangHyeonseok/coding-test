import java.util.*;
import java.io.*;

public class Main {
	static int[] storeLocationNum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// input // 
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");

		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		int storeCnt = Integer.parseInt(br.readLine());
		storeLocationNum = new int[storeCnt];
		
		for(int i=0; i<storeCnt; i++) {
			input = br.readLine();
			st = new StringTokenizer(input, " ");
			
			int dir = Integer.parseInt(st.nextToken());
			int location = Integer.parseInt(st.nextToken());
			
			// 위치를 숫자로 환산
			storeLocationNum[i] = locationToNum(dir, location, width, height);
//			System.out.println(storeLocationNum[i]); // debug
		}
		// 동근이의 위치
		input = br.readLine();
		st = new StringTokenizer(input, " ");
		
		int dir = Integer.parseInt(st.nextToken());
		int location = Integer.parseInt(st.nextToken());
		
		int donggeunLocation = locationToNum(dir, location, width, height);
		
		// 동근이의 위치와 가게의 위치 차이 더하기
		int middle = width+height; // 중간 지점
		int all = width*2 + height*2; // 전체 지점
		int ans = 0;
		for(int i=0; i<storeCnt; i++) {
			if(Math.abs(donggeunLocation - storeLocationNum[i]) > middle)
				ans += (all - Math.abs(donggeunLocation - storeLocationNum[i]));
			else
				ans += (Math.abs(donggeunLocation - storeLocationNum[i]));
//			System.out.println(ans); // debug
		}
		
		// output //
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
	
	// 위치를 숫자로 환산
	public static int locationToNum(int dir, int location, int width, int height) {
		if(dir == 1) {
			return location+1;
		}
		else if(dir == 2) {
			return width+1+height+(width-location);
		}
		else if(dir == 3) {
			return (width*2)+height+(height-location+1);
		}
		else if(dir == 4) {
			return width+1+location;
		}
		
		return -1;
	}
}
