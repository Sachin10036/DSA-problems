class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char el = s.charAt(i);
            if(el == '(' || el == '[' || el == '{'){
                st.push(el);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                char ch = st.pop();
                if((el == ')' && ch =='(') || (el ==']' && ch =='[') || (el =='}' && ch =='{')){
                    continue;
                }
                else return false;
            }
        }
        return st.isEmpty();
    }
}