public class Recursion {
    static int counter = 2;
    static Integer[] array = new Integer[20];
    public static void main(String[] args){
        String bank = "";
        String holder = "  ";
        array[0] = 1;
        for(int i = 0; i < 20; i++){
            bank = bank + "Step " + (i+1) + ": " + holder + factorial(i) + "\n";
            holder += "  ";
            counter++;
            System.out.print(bank);
            System.out.print((i+1) + "! = " + array[i] + "\n");
        }
    }
    public static String factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            array[i] = fact;
        }
        String temp = (counter-1) + " * factorial( " + (counter-2) + " )";
        return temp;
    }
}
