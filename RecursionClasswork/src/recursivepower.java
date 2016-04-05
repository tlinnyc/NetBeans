
import java.util.*;


public class recursivepower {
    static int base, exponent;
    static int casenum = 1;
    static int[] numbers = {50, 20, 32, 4, 12, 53, 92};
    static int bank = 0;
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter a base");
        base = Integer.parseInt(kb.nextLine());
        System.out.println("Enter an exponent");
        exponent = Integer.parseInt(kb.nextLine());
        power(base, exponent);
        recursiveMaximum(numbers);
        sumSquares();
    }
    public static void power(int base, int exponent){
        if(exponent % 2 == 0){
            casenum = 1;
        }
        if(exponent % 2 == 1){
            casenum = 2;
        }
        switch(casenum){
            case 1: System.out.println("Your exponent is an even number");
                break;
            case 2: System.out.println("Your exponent is an odd number");
                break;
        }
    }
    public static void recursiveMaximum(int[] array){
        for(int i = 0; i < numbers.length; i++){
            if(array[i] > bank){
                bank = array[i];
            }
        }
        System.out.println("The largest number in this array is " + bank);
    }
    public static void sumSquares(){
        int temp = 0;
        for(int i = 0; i < 20; i++){
            temp += (i*i);
        }
        System.out.println("The sum of squares of the numbers from 0 to 20 is " + temp);
    }
}
