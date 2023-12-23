class Solution {

    public boolean isPathCrossing(String path) {
        // Two variables to keep track of current position
        int x = 0, y = 0;
        // Use a HashSet to store visited coordinates.
        Set<Integer> visited = new HashSet<>();
        // Hash for the origin, adding it as the first visited coordinate
        visited.add(0);
      
        // Iterate over the path characters
        for (int index = 0; index < path.length(); ++index) {
            char direction = path.charAt(index);
          
            // Move in the grid according to the current direction
            switch (direction) {
                case 'N': // Moving north decreases the y-coordinate
                    y--;
                    break;
                case 'S': // Moving south increases the y-coordinate
                    y++;
                    break;
                case 'E': // Moving east increases the x-coordinate
                    x++;
                    break;
                case 'W': // Moving west decreases the x-coordinate
                    x--;
                    break;
            }
          
            // Calculate a unique hash for the current position.
            // Multiplying by a large enough number to not mix coordinates
            int hash = y * 20000 + x;
          
            // Check if this position has been visited before, if so, path crosses
            if (!visited.add(hash)) {
                return true; // early return if the path crosses itself
            }
        }
      
        // If no crossing points were found, return false
        return false;
    }
}
