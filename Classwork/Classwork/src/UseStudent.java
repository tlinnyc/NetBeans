public class UseStudent {
    public static void main(String args[]){
        FullTime FT = new FullTime("Adam", 2000); //Parameters: (String name, double fee)
        PartTime PT = new PartTime("Bob", 200, 14); //Parameters: (String name, double fee, double credits)
        
        System.out.println("Full Time Name: " + FT.getName() + "\nFee: $" + FT.getFee() +
                "\nTuition: $" + FT.tuition());
        System.out.println("\nPart Time Name: " + PT.getName() + "\nFee per credit: $" +
                PT.getFee() + "\nCredits: " + PT.getCredits() + 
                "\nTuition: $" + PT.tuition());
    }
}
