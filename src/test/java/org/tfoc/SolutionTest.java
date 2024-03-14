package org.tfoc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class SolutionTest {

    @Test
    void example01(){
        //grid = [[2,1,1],[1,1,0],[0,1,1]]
        // 2 1 1
        // 1 1 0
        // 0 1 1
        Integer[][] grid = new Integer[3][3];
        grid[0][0] = 2;
        grid[0][1] = 1;
        grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][1] = 1;
        grid[1][2] = 0;
        grid[2][0] = 0;
        grid[2][1] = 1;
        grid[2][2] = 1;

        assertEquals(4, Solution.search(grid));
    }

    @Test
    void example02(){
        //grid = [[2,1,1],[0,1,1],[1,0,1]]
        // 2 1 1
        // 0 1 1
        // 1 0 1

        //Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

        Integer[][] grid = new Integer[3][3];
        grid[0][0] = 2;
        grid[0][1] = 1;
        grid[0][2] = 1;
        grid[1][0] = 0;
        grid[1][1] = 1;
        grid[1][2] = 1;
        grid[2][0] = 1;
        grid[2][1] = 0;
        grid[2][2] = 1;

        assertEquals(-1, Solution.search(grid));
    }

    @Test
    void example03(){
        //grid = [[0,2]]
        // 0 2

        Integer[][] grid = new Integer[1][2];
        grid[0][0] = 0;
        grid[0][1] = 2;

        assertEquals(0, Solution.search(grid));
    }

}