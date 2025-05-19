import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer> cutCol = new ArrayList<>(); // 가로로 자르는 점선 위치
	static ArrayList<Integer> cutRow = new ArrayList<>(); // 세로로 자르는 점선 위치
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// input // 
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		int paperCol = Integer.parseInt(st.nextToken()); // 종이의 가로 길이 (최대100)
		int paperRow = Integer.parseInt(st.nextToken()); // 종이의 세로 길이 (최대100)
		int sliceCnt = Integer.parseInt(br.readLine()); // 칼로 잘라야 하는 점선의 개수
		
			// 초기 처리 
		cutCol.add(0);
		cutCol.add(paperRow);
		cutRow.add(0);
		cutRow.add(paperCol);
		
		for(int i=0; i<sliceCnt; i++) {
			input = br.readLine();
			st = new StringTokenizer(input, " ");
			
			int sliceLocation = Integer.parseInt(st.nextToken());
			// 가로로 자르는 점선
			if(sliceLocation == 0) {
				cutCol.add(Integer.parseInt(st.nextToken()));
			}
			// 세로로 자르는 점선
			else if(sliceLocation == 1) {
				cutRow.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		// 정렬
		Collections.sort(cutCol);
		Collections.sort(cutRow);
		
//		debug	
//		for(int i=0; i<cutCol.size(); i++) {
//			System.out.println(cutCol.get(i));
//		}
		
		// output // 
		bw.write(findLongCol()*findLongRow()+"");
		bw.flush();
		bw.close();
	}
	
	// 가장 큰 가로 찾기 로직
	public static int findLongCol() {
		int maxCol = 0;
		for(int i=0; i<cutCol.size()-1; i++) {
			maxCol = Math.max(maxCol, cutCol.get(i+1)-cutCol.get(i));
		}
		return maxCol;
	}
	// 가장 큰 세로 찾기 로직
	public static int findLongRow() {
		int maxRow = 0;
		for(int i=0; i<cutRow.size()-1; i++) {
			maxRow = Math.max(maxRow, cutRow.get(i+1)-cutRow.get(i));
		}
		return maxRow;
	}
}