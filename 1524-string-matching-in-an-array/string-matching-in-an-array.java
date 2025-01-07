class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();        
        int n = words.length;
        
        List<String>[] list = new List[31];
        for(int i = 0; i < 31; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            list[words[i].length()].add(words[i]);
        }

        for(int i = 1; i < 31; i++){
            if(list[i].isEmpty()) continue;
            for(String subStr : list[i]){
                
                for(int j = i + 1; j < 31; j++){
                    if(list[j].isEmpty()) continue;
                    for(String str : list[j]){
                        
                        if(str.contains(subStr)){
                            res.add(subStr);
                            j = 31; // break out of both loops
                            break;
                        }
                    }
                }
            }
        }
        return res;        
    }
}