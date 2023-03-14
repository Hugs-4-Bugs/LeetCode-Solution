import java.util.*;

public class Solution {

    //Takes a 2D array as the input
    public int numIslands(char[][] grid) {

        //If empty, returns 0
        if(grid == null || grid.length == 0)
        {
            return 0;
        }

        //Tracking the number of islands
        int numberOfIslands = 0;

        //Looping over the entire grid and checking each cell
        //to find the islands
        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[0].length; y++) {

                //finding the number of islands using sink method
                numberOfIslands += sink(grid, x, y);
            }
        }

        return numberOfIslands;
    }

    int sink(char[][] grid, int x, int y) {

        //If x or y is out of the boundary, or the value of the cell is 0,
        //returns 0
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length ||
                grid[x][y] == '0') {
            return 0;
        }

        //Otherwise marks the cell as visited
        grid[x][y] = '0';

        //recursive call to check each direction (top, bottom, right, left)
        //of the current cell for existing islands
        sink(grid, x + 1, y);
        sink(grid, x - 1, y);
        sink(grid, x, y + 1);
        sink(grid, x, y - 1);

        //returning 1 adds to the total number of islands
        return 1;
    }
}
