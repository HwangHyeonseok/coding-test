import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
            for(int i=1; i<=Math.sqrt(n); i++) {
                if(n%i == 0) {
                    answer+=2;
                }
            }
        
        if(Math.sqrt(n) % 1 == 0) answer--;
        return answer;
    }
}