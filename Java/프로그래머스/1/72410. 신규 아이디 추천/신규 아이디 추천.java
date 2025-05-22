import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        // 1단계 : 영어 대문자 -> 소문자
        new_id = new_id.toLowerCase();
        // System.out.println("1단계 : " + new_id);
        
         // 2단계 : 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 제거
        String temp = "";
        for(int i=0; i<new_id.length(); i++) { // new_id 문자 하나하나에 대해서 검사
            if((new_id.charAt(i) == '-' || 
                new_id.charAt(i) == '_' || 
                new_id.charAt(i) == '.' || 
                (new_id.charAt(i)-'0' >= 0 &&  new_id.charAt(i)-'0' <= 9) ||
                (new_id.charAt(i) >= 'a' &&  new_id.charAt(i) <= 'z')
               ))
            temp += new_id.charAt(i);
        }
        new_id = temp;
        // System.out.println("2단계 : " + new_id);
        
        // 3단계 : 마침표(.)가 2번 이상 연속된 부분을 '.' 으로 변경
        StringBuilder sb = new StringBuilder(new_id);
        boolean comboDot = true;
        while(comboDot != false) { // 연속된 마침표가 발견되지 않을 때까지 반복
            if(sb.length() == 0) break;
            comboDot = false;
            for(int i=0; i<sb.length()-1; i++) {
                if(sb.charAt(i) == '.' && sb.charAt(i+1) == '.') {
                    comboDot = true;
                    sb.deleteCharAt(i);
                }
            }
        }
        
        // System.out.println("3단계 : " + sb);
        
        // 4단계 : 처음이나 끝의 '.' 제거
        if(sb.length() > 0 && sb.charAt(0) == '.') sb.deleteCharAt(0);
        if(sb.length() > 0 && sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        
        // System.out.println("4단계 : " + sb);
        
        // 5단계 : new_id가 빈 문자열이면, new_id에 "a" 대입
        if(sb.length() == 0) {
            sb.append("a");
        }
        // System.out.println("5단계 : " + sb);
        
        // 6단계 : new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        new_id = sb.toString(); // substring을 사용하기 위해
        if(sb.length() >= 16) {
            new_id = new_id.substring(0,15);
            // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
            sb = new StringBuilder(new_id);
            if(sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        }
        
        // System.out.println("6단계 : " + sb);
        
        // 7단계 : new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        while(sb.length() <= 2) {
            sb.append(sb.charAt(sb.length()-1));
        }
        
        // System.out.println("7단계 : " + sb);
        
        return sb.toString();
    }
}