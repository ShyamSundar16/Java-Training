package com.amzn;

/**
 * Created by Shyam Sundar on 4/7/21.
 */

/**
 * Approach:
 * First, four variables containing the indices for the corner points of the array are initialized.
 * The algorithm starts from the top left corner of the array, and traverses the first row from left to right. Once it traverses the whole row it does not need to revisit it, thus, it increments the top corner index.
 * Once complete, it traverses the rightmost column top to bottom. Again, once this completes, there is no need to revisit the rightmost column, thus, it decrements the right corner index.
 * Next, the algorithm traverses the bottommost row and decrements the bottom corner index afterward.
 * Lastly, the algorithm traverses the leftmost column, incrementing the left corner index once it’s done.
 */

public class SpiralMatrix {
    void doSpiralTraversal(int matrix[][]) {
        int top = 0, bottom = matrix.length-1, left = 0, right = matrix[0].length - 1, direction = 1;
        while (top <= bottom && left <= right) {
            if (direction == 1) {
                for (int i = left; i <= right; ++i) {
                    System.out.print(matrix[top][i]+" ");
                }
                ++top;
                direction = 2;
            } else if (direction == 2) {
                for (int i = top; i <= bottom; ++i) {
                    System.out.print(matrix[i][right]+" ");
                }
                --right;
                direction = 3;
            } else if (direction == 3) {
                for (int i = right; i >= left; --i) {
                    System.out.print(matrix[bottom][i]+" ");
                }
                --bottom;
                direction = 4;
            } else if (direction == 4) {
                for (int i = bottom; i >=top; --i) {
                    System.out.print(matrix[i][left]+" ");
                }
                ++left;
                direction = 1;
            }
        }

    }

    public static void main(String[] args) {
        int a[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},{13,14,15,16}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        spiralMatrix.doSpiralTraversal(a);
    }
}
