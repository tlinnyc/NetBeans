package Stocks;
import java.io.*;
import java.util.*;

public class Stocks {

    public static void main(String[]args)throws Exception{
        Scanner input = new Scanner(System.in);
        Stocks stocks = new Stocks();
        int dateIndex = 0;
        String date = "";
        String month = "";
        String day = "";
        String year = "";
        String[] valueArray = new String[6];
        HashMap<Calendar,List<String>> infoMap = new HashMap<>();
        List<String> dataFields = new ArrayList<String>();
        FileReader fileName = new FileReader("table.txt");
        BufferedReader lineReader = new BufferedReader(fileName);
        List<String> entryList = new ArrayList<String>();
        String line = lineReader.readLine();
        
        while(line != null){
            entryList.add(line);
            line = lineReader.readLine();
        }

        for(int i = 1; i < entryList.size(); i++){
            line = entryList.get(i);
            for(int j = 0; j <= line.length(); j++){
                if(line.charAt(j) == ','){
                    dateIndex = j;
                    break;
                }
            }
            date = line.substring(0,dateIndex);
            Calendar cDate = stocks.toCal(date);
            line = line.substring(dateIndex + 1, line.length());
            valueArray = line.split(",");
            dataFields = new ArrayList<>();
            for(int c = 0; c < valueArray.length; c++){
                dataFields.add(valueArray[c]);
            }
            infoMap.put(cDate, dataFields);
        }
        System.out.print("Enter A Month: ");
        month = input.next();
        System.out.print("Enter A Date: ");
        day = input.next();
        System.out.print("Enter A Year: ");
        year = input.next();
        Calendar getInfo = stocks.toCal(month+"/"+day+"/"+year);
        System.out.print(month+"/"+day+"/"+year+": "+infoMap.get(getInfo)+"\n\n");
    }
    Calendar toCal(String date){
        String[] datePieces = date.split("/");
        int m=Integer.parseInt(datePieces[0]);
        int d=Integer.parseInt(datePieces[1]);
        int y=Integer.parseInt(datePieces[2]);
        return new GregorianCalendar(m, d, y);
    }
}