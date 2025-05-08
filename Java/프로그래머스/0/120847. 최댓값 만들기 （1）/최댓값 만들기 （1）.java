import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Integer[] num = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(num, Collections.reverseOrder());
        return num[0]*num[1];
    }
}