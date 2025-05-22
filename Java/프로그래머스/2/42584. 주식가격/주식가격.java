import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> s = new ArrayDeque<>();
        
        for(int i=0; i<prices.length; i++) {
            // 스택이 빈 경우 push
            if(s.isEmpty()) {
                s.push(i);
                continue;
            }
            
            // 가격이 떨어지는 시점이 오면 기록하고 pop
            while(!s.isEmpty() && prices[s.peek()] > prices[i]) {
                answer[s.peek()] = i-s.peek();
                s.pop();
            }
            
            s.push(i);
        }
        
        // 스택에 남아 있는 것 나머지 처리
        int maxDay = prices.length-1;
        while(!s.isEmpty()) {
            answer[s.peek()] = maxDay-s.peek();
            s.pop();
        }
        
        return answer;
    }
}