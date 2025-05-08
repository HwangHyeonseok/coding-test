class Solution {
    public int solution(int n) {
        int answer = 0;
        String nStr = n+"";
        for(char c : nStr.toCharArray()) {
            answer += (c-'0');
        }
        return answer;
    }
}