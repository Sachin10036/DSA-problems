import java.util.*;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        Set<String> set = new HashSet<>();
        for (String dir : folder) {
            String[] dirParts = dir.split("/");
            String parentDir = "";
            boolean isSubfolder = false;
            for (int i = 1; i < dirParts.length; i++) {
                parentDir += "/" + dirParts[i];
                if (set.contains(parentDir)) {
                    isSubfolder = true;
                    break;
                }
            }
            if (!isSubfolder) {
                set.add(parentDir);
            }
        }
        return new ArrayList<>(set);
    }
}