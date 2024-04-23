class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int val = 0;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                val = val * 10 + ch - '0';
            }else if(ch == '['){
                numStack.push(val);
                val = 0;
                strStack.push(sb);
                sb = new StringBuilder();
            }else if(ch == ']'){
                String temp = sb.toString();
                sb = strStack.pop();
                int time = numStack.pop();
                while(time > 0){
                    sb.append(temp);
                    time--;
                }
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}