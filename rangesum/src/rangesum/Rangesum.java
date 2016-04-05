/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangesum;

/**
 *
 * @author Tommy
 */
public class Rangesum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9};
        System.out.print("The sum of elements 2 through " + "5 is " + rangesum(numbers, 2, 5));
    }
    public static int rangesum(int[] array, int start, int end){
        if(start>end)
            return 0;
        else
            return array[start] + rangesum(array, start+1,end);
    }
}
