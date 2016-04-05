package construction;

import java.util.*;

public class CreateLoans {
    public static void main(String[] args){
        int i = 0;
        int primeRate;
        String type;
        Scanner input = new Scanner(System.in);
        Loan[] loans = new Loan[5];

        for(i = 0; i < 2; i++) {
            System.out.println("Please enter a loan type. Choose either Business or Personal. If you don't type it like that you'll get an error.");
            type = input.nextLine().toLowerCase();
            if (type.equalsIgnoreCase("Business")) {
                System.out.println("Please enter the prime interest rate");
                primeRate = input.nextInt();
                System.out.println("What is the account number on the loan?");
                input.nextLine();
                String ln = input.nextLine();
                System.out.println("What is the last name on the account?");
                String last = input.nextLine();
                System.out.println("What is the loan amount? If you put more then 100k it'll only accept up to 100k");
                int la = input.nextInt();
                System.out.println("What is the term on the account? If you enter something other then 1, 3, or 5 it will default to a short term.");
                int term = input.nextInt();
                loans[i] = new BusinessLoan(ln, last, la, term);
                loans[i].setInterestRate(primeRate + 1);
                input.nextLine();
            }
            else if (type.equalsIgnoreCase("Personal")) {
                System.out.println("Please enter the prime interest rate");
                primeRate = input.nextInt();
                System.out.println("What is the account number on the loan?");
                input.nextLine();
                String ln = input.nextLine();
                System.out.println("What is the last name on the account?");
                String last = input.nextLine();
                System.out.println("What is the loan amount? If you put more then 100k it'll only accept up to 100k");
                int la = input.nextInt();
                System.out.println("What is the term on the account? If you enter something other then 1, 3, or 5 it will default to a short term.");
                int term = input.nextInt();
                loans[i] = new PersonalLoan(ln, last, la, term);
                loans[i].setInterestRate(primeRate + 2);
                input.nextLine();
            } else if (!type.equals("personal") && !type.equals("business")){
                System.out.println("You've entered an invalid type. Please restart and try again.");
                System.exit(0);
            }
        }
        
        for(int j = 0; j < 2; j++){
            System.out.println(loans[j].toString());
        }
    }
}
