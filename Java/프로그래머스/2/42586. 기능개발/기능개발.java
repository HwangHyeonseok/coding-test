import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Deque<Integer> s = new ArrayDeque<>();
        
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
        
        // Monotonic Stack 활용
        int combo = 0;
        for(int i=0; i<days.length; i++) {
            while(!s.isEmpty() && days[s.peek()] < days[i]) {
                combo++;
                s.pop();
            }
            
            if(s.isEmpty() && i != 0) {
                answer.add(combo);
                combo = 0;
            }
            
            s.push(i);
        }
        
        // 마무리 처리
        while(!s.isEmpty()) {
            combo++;
            s.pop();
        }
        answer.add(combo);
        
        
        return answer;
    }
}