//BFS
class Solution{
    public int numIslands(char[][] grid) {
    int count=0;
    for(int i=0;i<grid.length;i++)
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]=='1'){
                bfsFill(grid,i,j);
                count++;
            }
        }
    return count;
}
private void bfsFill(char[][] grid,int x, int y){
    grid[x][y]='0';
    int n = grid.length;
    int m = grid[0].length;
    LinkedList<Integer> queue = new LinkedList<Integer>();  
    int code = x*m+y;  
    queue.offer(code);  
    while(!queue.isEmpty())  
    {  
        code = queue.poll();  
        int i = code/m;  
        int j = code%m;  
        if(i>0 && grid[i-1][j]=='1')    //search upward and mark adjacent '1's as '0'.
        {  
            queue.offer((i-1)*m+j);  
            grid[i-1][j]='0';  
        }  
        if(i<n-1 && grid[i+1][j]=='1')  //down
        {  
            queue.offer((i+1)*m+j);  
            grid[i+1][j]='0';  
        }  
        if(j>0 && grid[i][j-1]=='1')  //left
        {  
            queue.offer(i*m+j-1);  
            grid[i][j-1]='0';  
        }  
        if(j<m-1 && grid[i][j+1]=='1')  //right
        {  
            queue.offer(i*m+j+1);  
            grid[i][j+1]='0';  
        }
    } 
}

}








// DFS
// class Solution{
//     public int numIslands(char[][] grid) {
//     int count=0;
//     for(int i=0;i<grid.length;i++)
//         for(int j=0;j<grid[0].length;j++){
//             if(grid[i][j]=='1'){
//                 dfsFill(grid,i,j);
//                 count++;
//             }
//         }
//     return count;
// }
// private void dfsFill(char[][] grid,int i, int j){
//     if(i>=0 && j>=0 && i<grid.length && j<grid[0].length&&grid[i][j]=='1'){
//         grid[i][j]='0';
//         dfsFill(grid, i + 1, j);
//         dfsFill(grid, i - 1, j);
//         dfsFill(grid, i, j + 1);
//         dfsFill(grid, i, j - 1);
//     }
// }
// }









// Solution for 8 directions
//   class Pair{
//        int first;
//        int second;
//        public Pair(int first, int second){
//            this.first = first;
//            this.second = second;
//        }
//    }
// class Solution {
    
//     private void bfs(int ro, int co, int[][] vis, char[][] grid){
//         vis[ro][co] = 1;
//         Queue<Pair> q = new LinkedList<Pair>();
//         q.add(new Pair(ro, co));
        
//          int n = grid.length;
//         int m = grid[0].length;
        
//         while(!q.isEmpty()){
//             int row = q.peek().first;
//             int col = q.peek().second;
//             q.remove();
            
            
//             for(int delrow = -1; delrow <= 1; delrow++){
//                  for(int delcol = -1; delcol <= 1; delcol++){
                
//                      int nrow = row + delrow;
//                      int ncol = row + delcol;
                     
//                      if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
//                          vis[nrow][ncol] = 1;
//                          q.add(new Pair(nrow, ncol));
//                      }
//             }
//             }
//         }
//     }
    
//     public int numIslands(char[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         int[][] vis = new int[n][m];
//         int cnt = 0;
        
//         for(int row = 0; row < n; row++){
//             for(int col = 0; col < m; col++){
//                 if(vis[row][col] == 0 && grid[row][col] == '1'){
//                     cnt++;
//                     bfs(row, col, vis, grid);
//                 }
//             }
//         }
//         return cnt;
//     }
// }
