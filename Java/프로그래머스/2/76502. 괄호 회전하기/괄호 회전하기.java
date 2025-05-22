import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        // 예외 처리 : 괄호가 1개만 있으면 올바른 괄호가 될 수 없다.
        if(s.length() == 1) return 0;
        else {
            for(int i=0; i<s.length(); i++) {
                s = s.substring(1) + s.substring(0,1);
                answer += isCorrectStr(s);
            }
        }
        
        return answer;
    }
    
    // 올바른 괄호 문자열인지 판단 // 올바르면 1, 올바르지 않으면 0
    public static int isCorrectStr(String s) {
        // System.out.println(s);
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++) {
            // 여는 괄호
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            // 닫힌 괄호
            else { 
                if(stack.isEmpty()) return 0; // 1. 스택이 빈 경우
                // 2. 괄호 쌍이 맞지 않은 경우
                if(s.charAt(i) == ')' && stack.peek() != '(') return 0;
                if(s.charAt(i) == '}' && stack.peek() != '{') return 0;
                if(s.charAt(i) == ']' && stack.peek() != '[') return 0;
                stack.pop();
            }
        }
        
        // 3. 검사를 다 마치고 스택이 비지 않은 경우
        if(!stack.isEmpty()) return 0;
        
        return 1;
    }
}