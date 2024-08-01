class Solution {
    public int countSeniors(String[] details) {

     int count=0;
     for(int i=0;i<details.length;i++)
     {
         int a=details[i].charAt(11)-'0';
         a*=10;
         a+=details[i].charAt(12)-'0';
         if(a>60)
         {
             count++;
         }
     }
     return count;    
    }
}