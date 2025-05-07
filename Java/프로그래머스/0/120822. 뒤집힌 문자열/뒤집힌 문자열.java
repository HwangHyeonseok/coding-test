import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder(my_string); // my_string 타입을 StringBuilder 타입으로 변환
        String answer = sb.reverse().toString(); // 문자열을 뒤집고 String 자료형으로 변환 
        
        return answer;
    }
}