package construction;

public class PersonalLoan extends Loan{
    public PersonalLoan(String num, String last, double loan, double term){
        setLoanNumber(num);
        setLastName(last);
        setLoanAmount(loan);
        setYearTerm(term);
        interestrate = (int)((primerate * 0.02) + primerate);
        setInterestRate(interestrate);
    }
    
    public String loan(){
        return "aaa";
    }
}
