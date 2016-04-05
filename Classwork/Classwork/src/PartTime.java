public class PartTime extends Student{
    private double fee, credits;
    
    public PartTime(String name, double fee, double credits){
        super(name);
        setFee(fee);
        setCredits(credits);
    }
    
    public void setFee(double fee){
        this.fee = fee;
    }
    
    public double getFee(){
        return fee;
    }
    
    public void setCredits(double credits){
        this.credits = credits;
    }
    
    public double getCredits(){
        return credits;
    }
    
    public double tuition(){
        return fee*credits;
    }
}
