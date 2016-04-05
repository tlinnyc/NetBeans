package construction;

public abstract class Loan implements LoanConstants{
    public String lastname, loannum;
    public double loanamount, interestrate, yearterm, primerate;
    
    
    public void setLoanNumber(String num){
        loannum = num;
    }
    public String getLoanNumber(){
        return loannum;
    }
    
    public void setLastName(String last){
        lastname = last;
    }
    public String getLastName(){
        return lastname;
    }
    
    public void setLoanAmount(double amount){
        loanamount = amount;
        if (loanamount > maxloan){
            loanamount = maxloan;
        }
    }
    public Double getLoanAmount(){
        return loanamount;
    }
    
    public void setInterestRate(double rate){
        interestrate = rate;
    }
    public Double getInterestRate(){
        return interestrate;
    }
    
    public void setYearTerm(double term){
        if (term == 1){
            yearterm = shortterm;
        }else if (term == 3){
            yearterm = medterm;
        }else if(term == 5){
            yearterm = longterm;
        }else{
            yearterm = shortterm;
        }
    }
    public Double getYearTerm(){
        return yearterm;
    }
    
    public String toString(){
        return String.format("Loan Number: %s\nLast Name: %s\nLoan Amount: %s"
                + "\nInterest Rate: %s%%\nLoan Term: %s years\n", loannum, lastname,
                loanamount, interestrate, yearterm);
    }
    
    public abstract String loan();
}