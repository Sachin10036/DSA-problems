class Solution {
    public boolean isCircularSentence(String sentence) {
        String arr[] = sentence.split(" ");
        for(int i=0; i<arr.length-1; i++){
            String str1 = arr[i];
            String str2 = arr[i+1];
            if(str1.charAt(str1.length()-1) != str2.charAt(0)){
                return false;
            }
        }
        if(sentence.charAt(0) != sentence.charAt(sentence.length()-1)){
            return false;
        }
        return true;
    }
}