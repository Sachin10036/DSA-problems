class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        
        int n = quality.length;
        
        List<Pair<Double, Integer>> wageToQualityRatioList = new ArrayList<>();
        
        for (int i = 0 ; i < n ; i++) {
            wageToQualityRatioList.add(new Pair((double) wage[i] / quality[i], quality[i]));
        }
        
        Collections.sort(wageToQualityRatioList, (x, y) -> Double.compare(x.getKey(), y.getKey()));
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> (y - x));
        
        
        int curTotalQuality = 0;
        int curQuality = 0;
        
        for (int i = 0 ; i < k ; i++) {
            curQuality = wageToQualityRatioList.get(i).getValue();
            maxHeap.add(curQuality);
            curTotalQuality += curQuality;
        }
        
        double curRatio = wageToQualityRatioList.get(k-1).getKey();
        double ans = curTotalQuality * curRatio;
        
        for (int i = k ; i < n ; i++) {
            curRatio = wageToQualityRatioList.get(i).getKey();
            curQuality = wageToQualityRatioList.get(i).getValue();
            
            maxHeap.add(curQuality);
            curTotalQuality += curQuality - maxHeap.poll();
            ans = Math.min(ans, curTotalQuality * curRatio);
        }
        
        return ans;
    }
}