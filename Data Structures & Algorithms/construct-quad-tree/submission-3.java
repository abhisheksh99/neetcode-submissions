/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return constructDFS(grid, 0, 0, n);
    }

    private Node constructDFS(int[][] grid, int row, int col, int length) {
        if (length == 1) {
            return new Node(grid[row][col] == 1, true);
        }

        int half = length / 2;

        Node topLeft = constructDFS(grid, row, col, half);
        Node topRight = constructDFS(grid, row, col + half, half);
        Node bottomLeft = constructDFS(grid, row + half, col, half);
        Node bottomRight = constructDFS(grid, row + half, col + half, half);

        // If all four children are leaves with the same value, merge into one leaf node
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
            topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true);
        }

        // Otherwise, current node is not a leaf
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}