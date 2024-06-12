class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new  ArrayList<>();
        if(digits.length() ==0) return res;
        String output = "";
        int idx = 0;
        String mapping[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        solve(digits, output, res, idx, mapping);
        return res;
    }
    private void solve(String digits, String output, ArrayList<String> res, int idx, String mapping[]){
        if(idx >= digits.length()){
            res.add(output);
            return;
        }
        int number = digits.charAt(idx) - '0';
        String str = mapping[number];
        for(int i=0; i<str.length(); i++){
            output += str.charAt(i);
            solve(digits, output, res, idx+1, mapping);
            output = output.substring(0, output.length()-1);
        }
    }
}