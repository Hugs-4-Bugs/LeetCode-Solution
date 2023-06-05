class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        int xMove = coordinates[1][0] - coordinates[0][0];
        int yMove = coordinates[1][1] - coordinates[0][1];

        for(int i=1; i<coordinates.length; i++){
            int x = coordinates[i][0] - coordinates[i-1][0];
            int y = coordinates[i][1] - coordinates[i-1][1];


            // linear function -> y = k * x + b;
            // Here we need to discuss y = k * x;
            // k = yMove / xMove;
            // y * xMove = x * yMove;

            if(y * xMove != x * yMove) return false;
        }
        return true;
    
    }
}



// The coordinate should follow the order 

// 1,2
// 2,3
// 3,4
// 4,5
// 5,6
// 6,7
// 7,8
// 8,9
// ..
// . etc to be the straight line
