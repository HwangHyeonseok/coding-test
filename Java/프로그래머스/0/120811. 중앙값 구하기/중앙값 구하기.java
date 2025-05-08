import java.util.*;

class Solution {
    public int solution(int[] array) {
        // 내림차순 정렬
        Integer[] arrayWrapper = Arrays.stream(array).boxed().toArray(Integer[]::new);
        Arrays.sort(arrayWrapper, Collections.reverseOrder());
        
        return arrayWrapper[array.length/2];
    }
}