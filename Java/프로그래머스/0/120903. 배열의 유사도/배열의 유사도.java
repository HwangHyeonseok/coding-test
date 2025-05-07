// 시간 복잡도 1000*10
class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for(String first : s1) {
            for(String second : s2) {
                if(first.equals(second)) answer++;
            }
        }
        return answer;
    }
}