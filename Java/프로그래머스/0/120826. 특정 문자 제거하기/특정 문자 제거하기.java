class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        for(char c : my_string.toCharArray()) {
            if(c == letter.charAt(0)) continue;
            
            answer += c;
        }
        return answer;
    }
}