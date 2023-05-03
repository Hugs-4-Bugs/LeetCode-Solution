// APPROACH 1: ARRAY


// class Solution {
//     public int[][] matrixReshape(int[][] mat, int r, int c) {
//         if (mat.length * mat[0].length != r * c)
//             return mat;
//         int[][] answ = new int[r][c];
//         for(int i = 0; i < r * c; i++)
//             answ[i / c][i % c] = mat[i / mat[0].length][i % mat[0].length];
//         return answ;
//     }
// }









// APPROACH 2 


// class Solution {
//     public int[][] matrixReshape(int[][] mat, int r, int c) {
        
//         //Storing the values of mat matrix
//         //i.e m = rows & n = cols
//         int rows = mat.length;
//         int cols = mat[0].length;
        
//         //if the product of rows & cols of mat matrix and the new matrix are not same then return original matrix
//         if((rows * cols) != (r * c)) return mat;
        
//         //Creating the new matrix
//         int[][] output = new int[r][c];
//         int output_rows = 0;
//         int output_cols = 0;
        
        
//         //Traversing the mat matrix and storing the its values in new matrix output cols wise
//         for(int i = 0; i < rows; i++)
//         {
//             for(int j = 0; j < cols; j++)
//             {
//                 output[output_rows][output_cols] = mat[i][j];
//                 output_cols++;
                
//                 //if the cols value reached then change the row and set the cols value to 0.
//                 if(output_cols == c)
//                 {
//                     output_cols = 0;
//                     output_rows++;
//                 }
//             }
//         }
        
//         return output;
//     }
// }









// APPROACH 3: MODULO ARITHIMETIC


// class Solution {
//     public int[][] matrixReshape(int[][] mat, int r, int c) {
//         int m=mat.length;
//         int n=mat[0].length;
//         if(r*c!=m*n)
//             return mat;
//         int [][] ans=new int[r][c];
//         for(int i=0;i<r*c;i++)
//             ans[i/c][i%c]=mat[i/n][i%n];
//         return ans;
//     }
// }








// APPROACH 4 : Easy Solution Java in Single for loop


class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length * mat[0].length != r*c){
            return mat;
        }
      
        int rshape[][] = new int [r][c];
        
         for (int i = 0;
             i < c*r; i++) {
 

            int row1 = i / mat[0].length;
            int col1 = i % mat[0].length;
            int row2 = i / c;
            int col2 = i % c;

            rshape[row2][col2] = mat[row1][col1];
            
        }
       
        return rshape;
    }
}
