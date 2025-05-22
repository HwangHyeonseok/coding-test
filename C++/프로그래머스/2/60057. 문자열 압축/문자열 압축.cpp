// 문법 test
// System.out.println(s.substring(0,1)); // "x"
// System.out.println(s.substring(0,2)); // "xa"

import java.util.*;
class Solution {
    static ArrayList<String> sliceArr; // "abcde"를 2개씩 자르면 {ab, cd, e}
    static ArrayList<String> apchukArr = new ArrayList<>(); // 압축한 문자 (1글자~N글자)
    
    public int solution(String s) {
        if(s.length() == 1) { // 1글자인 경우 예외처리
            return 1;
        }
        
        for(int i=1; i<=s.length()/2; i++) { // 문자열을 i개 단위로 잘라 압축한다.
            sliceArr = new ArrayList<>();
            
            // 문자열을 i 개로 자르기 abcde 이고 i가 2라면 => {ab, cd, e}
            String temp = "";
            for(char a : s.toCharArray()) {
                temp += a;
                if(temp.length()%i == 0) {
                    sliceArr.add(temp);
                    temp = "";
                }
            }
            sliceArr.add(temp); // 마지막(남은) temp 처리
            
            // sliceArrTest(sliceArr, i); // test
            
            // 같은 문자열 이어 붙이기
            int combo = 1; // 같은 문자가 연속해서 나온 횟수
            String prevStr = ""; // 이전 문자열
            String ans = ""; // 압축한 문자열
            for(String a : sliceArr) {
                // 처음 prevStr 채워주기
                if(prevStr.length() == 0) {
                    prevStr = a;
                    continue;
                }
                
                if(a.equals(prevStr)) { // 이전 문자열과 같다면 combo를 올려주고
                    combo++;    
                }
                else { // 다르다면 이전까지를 combo 만큼 합쳐준다. (단, combo가 1인 경우는 처리하지 않는다.)
                    if(combo == 1) {
                        ans += prevStr;
                        prevStr = a;
                        continue;
                    }
                    ans += (combo+prevStr);
                    combo = 1;
                    prevStr = a;
                }
            }
            
            // 마지막 남은 문자 처리
            if(combo == 1) ans += prevStr;
            else ans += (combo+prevStr);
            
            // System.out.println(ans); // 압축 결과 test
            apchukArr.add(ans);
        }
        
        // 압축 결과 중에서 길이가 가장 작은 것을 출력
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<apchukArr.size(); i++) {
            answer = Math.min(answer, apchukArr.get(i).length());
        }
        
        return answer;
    }
    
    // sliceArr에 담긴 값 test
    public static void sliceArrTest(ArrayList<String> sliceArr, int i) {
        for(String s : sliceArr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}