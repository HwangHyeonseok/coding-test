class Solution {
    public int solution(int[] box, int n) {
        int answer = 1;
        for(int side : box) {
            answer *= (side/n);
        }
        return answer;
    }
}