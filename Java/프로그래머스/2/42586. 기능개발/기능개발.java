import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        // [93, 30, 55] [1, 30, 5] -> [7, 3, 9] // 걸리는 일 수 저장
        int[] days = new int[progresses.length];
        for(int i=0; i<days.length; i++) {
            if((100-progresses[i]) % speeds[i] == 0)
                days[i] = (100-progresses[i]) / speeds[i];
            else
                days[i] = (100-progresses[i]) / speeds[i] + 1;
        }
        
        // days 확인 Test
        // for(int i=0; i<days.length; i++) {
        //     System.out.println(days[i]);
        // }
        
        for(int i=0; i<days.length; i+=0) {
            int minus = days[i];
            for(int j=i; j<days.length; j++) {
                days[j] -= minus; 
            }
            
            // Test
            // for(int k=0; k<days.length; k++) {
            //     System.out.print(days[k]+ " ");
            // }
            // System.out.println();
            
            // 진도율이 100% (남은 days[j]가 0이하) 인 것들에 한해 작업 수행
            int combo = 0;
            while(days[i] <= 0) {
                combo++;
                i++;
                if(i == days.length) break;
            }
            
            // System.out.println(combo);
            answer.add(combo);
        }
        
        return answer;
    }
}