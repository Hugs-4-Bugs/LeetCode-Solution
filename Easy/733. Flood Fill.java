class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        
        flood(image, image[sr][sc], newColor, sr, sc);
        
        return image;
    }
    
public void flood(int[][] image, int color, int newColor, int sr, int sc) {
        if (sr < 0 || sc < 0 ||  sr >= image.length || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }
        
        image[sr][sc] = newColor;
        
        int topRowNeighbour = sr - 1;
        int bottomRowNeighbour = sr + 1;
        int leftColumnNeigbour = sc - 1;
        int rightColumnNeighbour = sc + 1;
        
        flood(image, color, newColor, topRowNeighbour, sc );
        flood(image, color, newColor, bottomRowNeighbour, sc );
        flood(image, color, newColor, sr, leftColumnNeigbour );
        flood(image, color, newColor, sr, rightColumnNeighbour );
    }
}
