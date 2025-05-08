import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String my_string) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(char c : my_string.toCharArray()) {
            if(c-'0' >= 0 && c-'9' <= 9) {
                answer.add(c-'0');
            }
        }
        
        Collections.sort(answer);
        return answer;
    }
}