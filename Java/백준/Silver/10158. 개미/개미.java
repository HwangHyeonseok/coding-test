import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// input //
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		input = br.readLine();
		st = new StringTokenizer(input, " ");
		
		int p = Integer.parseInt(st.nextToken()); // 시작 x
		int q = Integer.parseInt(st.nextToken()); // 시작 y
		
		int t = Integer.parseInt(br.readLine()); // 이동 시간
		
		// logic //
		int x = (p+t) % (2*w);
		if(x > w) x = 2*w-x;
		
		int y = (q+t) % (2*h);
		if(y > h) y = 2*h-y;
		
		// output // 
		bw.write(String.format("%d %d", x, y));
		bw.flush();
		bw.close();
	}
}