class Solution {
    public String solution(String my_string, int n) {
        StringBuilder answer = new StringBuilder("");
        
        for(char c : my_string.toCharArray()) {
            for(int i=0; i<n; i++) { // n 번 반복하여 출력
                answer.append(c);   
            }
        }
        
        return answer.toString();
    }
}