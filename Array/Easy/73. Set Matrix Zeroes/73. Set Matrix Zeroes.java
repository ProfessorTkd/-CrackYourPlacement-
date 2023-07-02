// TC - O(mn), SC - O(m + n)
class Solution {
    public void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            Set<Integer> row = new HashSet(), col = new HashSet();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        row.add(i);
                        col.add(j);
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (row.contains(i) || col.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
}


//Optimized
// TC: O(2*n*m)
// SC: O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
        int col0=1;
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int i=0;i<rows;i++){
            if(matrix[i][0]==0) 
              col0=0;
            for(int j=1;j<cols;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=matrix[0][j]=0;
                }
            }
        }
            for(int i=rows-1;i>=0;i--){
                for(int j=cols-1;j>=1;j--){
                    if(matrix[i][0]==0 ||matrix[0][j]==0){
                        matrix[i][j]=0;
                    }
                }
                if(col0==0) 
                  matrix[i][0]=0;
            }
    }
}



// TC - O(mn), SC - O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            boolean firstRow = false;
            boolean firstCol = false;

            // first col
            for (int i = 0; i < m; i++)
                if (matrix[i][0] == 0)
                    firstCol = true;


            // first row
            for (int j = 0; j < n; j++)
                if (matrix[0][j] == 0)
                    firstRow = true;

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }

            if (firstCol) {
                for (int i = 0; i < m; i++)
                    matrix[i][0] = 0;
            }

            if (firstRow) {
                for (int j = 0; j < n; j++)
                    matrix[0][j] = 0;
            }
        }
    }

