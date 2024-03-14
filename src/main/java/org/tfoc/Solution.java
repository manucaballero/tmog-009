package org.tfoc;

import java.util.HashMap;

/**
 * The class containing the solution to this exercise
 */
public class Solution {

    private static final int ROTTEN_ORANGE = 2;
    private static final int FRESH_ORANGE = 1;

    public static Integer search(
            Integer[][] nums) {

        int totalMinutesElapsed = 0;
        int freshOranges = 0;

        for (Integer[] line : nums) {
            for (Integer square : line) {

                if (square == FRESH_ORANGE) {
                    freshOranges++;
                }
            }
        }

        int previousMinuteFreshOranges = freshOranges;
        boolean isPossibleToFinish = true;
        HashMap<String, Boolean> visitedRottenOranges = new HashMap<>();
        while (freshOranges > 0 && isPossibleToFinish){//Mientras queden naranjas por convertir y sean alcanzables

            HashMap<String, Boolean> newRottenOranges = new HashMap<>();//Naranjas contaminadas en el minuto actual
            for(int j = 0; j < nums.length; j++){
                for(int k = 0; k < nums[j].length; k++){

                    int currentSquare = nums[j][k];

                    if(currentSquare == ROTTEN_ORANGE
                            && newRottenOranges.get(j + "-" + k) == null
                            && visitedRottenOranges.get(j + "-" + k) == null){
                        //Si la casilla actual es una naranja contaminada que todavia no ha contaminado a otras
                        //y no ha sido contaminada este minuto, entonces puede infectar a otras

                        //Infectamos casilla superior
                        if(j > 0 && k <= nums[j - 1].length){

                            int aboveSquare = nums[j - 1][k];
                            int aboveLine = j - 1;

                            if(aboveSquare == FRESH_ORANGE){
                                nums[j - 1][k] = 2;
                                newRottenOranges.put(aboveLine + "-" + k, true);
                                freshOranges--;
                            }
                        }
                        //Infectamos casilla inferior
                        if(j < nums.length - 1  && k <= nums[j + 1].length){

                            int belowSquare = nums[j + 1][k];
                            int belowLine = j + 1;

                            if(belowSquare == FRESH_ORANGE){
                                nums[j + 1][k] = 2;
                                newRottenOranges.put(belowLine + "-" + k, true);
                                freshOranges--;
                            }
                        }
                        //Infectamos casilla izquierda
                        if(k > 0){

                            int leftSquare = nums[j][k - 1];
                            int leftColumn = k - 1;

                            if(leftSquare == FRESH_ORANGE){
                                nums[j][k - 1] = 2;
                                newRottenOranges.put(j + "-" + leftColumn, true);
                                freshOranges--;
                            }
                        }
                        //Infectamos casilla derecha
                        if(k < nums[j].length - 1){

                            int rightSquare = nums[j][k + 1];
                            int rightColumn = k + 1;

                            if(rightSquare == FRESH_ORANGE){
                                nums[j][k + 1] = 2;
                                newRottenOranges.put(j + "-" + rightColumn, true);
                                freshOranges--;
                            }
                        }
                        visitedRottenOranges.put(j + "-" + k, true);
                    }
                }
            }
            if(previousMinuteFreshOranges == freshOranges){
                isPossibleToFinish = false;
            }
            previousMinuteFreshOranges = freshOranges;
            totalMinutesElapsed++;
        }
        return freshOranges == 0 ? totalMinutesElapsed : -1;
    }

}
