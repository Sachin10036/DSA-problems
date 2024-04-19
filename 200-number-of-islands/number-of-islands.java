class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    bfs(grid,i,j,visited);
                    ans++;
                }
            }
        }
        return ans;
    }
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    void bfs(char[][] grid,int i,int j,boolean[][] visited){
        Queue<Pair> q = new LinkedList<Pair>();
        visited[i][j]=true;
        q.add(new Pair(i,j));
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();
            for(int k=0;k<4;k++){
                int rowNum = r + dx[k];
                int colNum = c + dy[k];
                if(0<=rowNum && rowNum<grid.length && colNum>=0 && colNum<grid[0].length && grid[rowNum][colNum]=='1' && visited[rowNum][colNum]==false){
                    visited[rowNum][colNum]=true;
                    q.add(new Pair(rowNum,colNum));
                }
            }
        }
    }
}