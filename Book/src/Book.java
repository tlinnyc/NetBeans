
import java.io.*;
import java.util.*;

public class Book {
    public static void main(String[] args) throws IOException{
        BufferedReader in1 = new BufferedReader(new FileReader("book1.csv"));
        BufferedReader in2 = new BufferedReader(new FileReader("book2.csv"));
        BufferedReader in3 = new BufferedReader(new FileReader("book1.csv"));
        BufferedReader in4 = new BufferedReader(new FileReader("book2.csv"));
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        
        List<String> first = new ArrayList<String>();
        List<String> second = new ArrayList<String>();
        String store1, store2, store3, store4;
        while((store1 = in1.readLine()) != null){
            first.add(store1);
            count1++;
        }
        while((store2 = in2.readLine()) != null){
            second.add(store2);
            count2++;
        }
        
        String[] array1 = new String[first.size()];
        String[] array2 = new String[second.size()];
        while((store3 = in3.readLine()) != null){
            array1[count3] = store3;
            count3++;
        }
        while((store4 = in4.readLine()) != null){
            array2[count4] = store4;
            count4++;
            
        }
        for(int i = 0; i < first.size(); i++){
            for(int j = 0; j < second.size(); j++){
                if(array1[i].equals(array2[j])){
                    System.out.println(array1[i]);
                    count5++;
                }
            }
        }
        for(int i = 0; i < second.size(); i++){
            for(int j = 0; j < first.size(); j++){
                if(array2[i].equals(array1[j])){
                    count6++;
                }
            }
        }
        
        System.out.println("\nNumber of names in book1: " + count1);
        System.out.println("Number of names in book2: " + count2);
        System.out.println("Total amount of same name: " + count5);
    }
}
