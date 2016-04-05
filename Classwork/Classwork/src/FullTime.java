public class FullTime extends Student{
    private double fee;
    
    public FullTime(String name, double fee){
        super(name);
        setFee(fee);
    }
    
    public void setFee(double fee){
        this.fee = fee;
    }
    
    public double getFee(){
        return fee;
    }
    
    public double tuition(){
        return fee;
    }
}
