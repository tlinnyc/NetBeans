package construction;

public class BusinessLoan extends Loan{
    public BusinessLoan(String num, String last, double loan, double term){
        setLoanNumber(num);
        setLastName(last);
        setLoanAmount(loan);
        setYearTerm(term);
        interestrate = (primerate * 0.01) + primerate;
        setInterestRate(interestrate);
    }
    
    public String loan(){
        return "aaa";
    }
}
