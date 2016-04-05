package stock;

import java.io.*;
import java.util.*;

public class Stock {
	public static void main(String[] args) throws FileNotFoundException, IOException {
            int count = 0;
            int d = 0;
            String month = "";
            String day = "";
            String year = "";
            Scanner scan1;
//            Calendar date = null;
            Stock stock = new Stock();
            Map<Calendar, List<String>> map = new HashMap<Calendar, List<String>>();
            
            try (Scanner scan = new Scanner(new File("table2.txt"))) {
                scan1 = new Scanner(new File("table2.txt"));
                while(scan.hasNext()){
                    scan.nextLine();
                    count++;
                }
            }
            String tempArray[] = new String[count];
            while(scan1.hasNext()){
                  for(int i = 0; i < count; i++){
                      tempArray[i] = scan1.nextLine();
                  }
            }
            scan1.close();
            String dateArray[] = new String[count];
            String dataArray[] = new String[count];
            for(int i = 0; i < count; i++){
                for(int j = 0; j < tempArray[i].length(); j++){
                    if(tempArray[i].charAt(j) == ','){
                        d = j;
                        break;
                    }
                }
                dateArray[i] = tempArray[i].substring(0, d);
                dataArray[i] = tempArray[i].substring(d + 1).replaceAll(",", ", ");
                Calendar date = stock.toCal(dateArray[i]);
                map.put(date, Arrays.asList(dataArray[i]));
            }
            
            
            for(int i = 0; i < count; i++){
//                map.put(date,Arrays.asList(dataArray[i]));
                System.out.println(dateArray[i] + ": [" + dataArray[i] + "]");
            }
            
            Scanner input = new Scanner(System.in);
            System.out.println("This stock history is between the period of " + dateArray[count - 1] + " to " + dateArray[1]);
            System.out.print("Enter a month (Ex. 5 for May): ");
            month = input.next();
            System.out.print("Enter a day (1 - 31): ");
            day = input.next();
            System.out.print("Enter a year (Ex. 2008): ");
            year = input.next();
            System.out.println(dateArray[0] + ": [" + dataArray[0] + "]");
            System.out.println(map);
//            System.out.println(temp + ": " + map.get(temp));
	}
        
        Calendar toCal(String date){
            String datePieces[]=date.split("/");
            int m=Integer.parseInt(datePieces[0]);
            int d=Integer.parseInt(datePieces[1]);
            int y=Integer.parseInt(datePieces[2]);
        return new GregorianCalendar(m, d, y);}
}
//
//package Stocks;
//import java.io.*;
//import java.util.*;
//
//public class Stocks {
//
//    public static void main(String[]args)throws Exception{
//        Scanner input = new Scanner(System.in);
//        Stocks stocks = new Stocks();
//        int dateIndex = 0;
//        String date = "";
//        String month = "";
//        String day = "";
//        String year = "";
//        String[] valueArray = new String[6];
//        HashMap<Calendar,List<String>> infoMap = new HashMap<>();
//        List<String> dataFields = new ArrayList<String>();
//        FileReader fileName = new FileReader("table.txt");
//        BufferedReader lineReader = new BufferedReader(fileName);
//        List<String> entryList = new ArrayList<String>();
//        String line = lineReader.readLine();
//        
//        while(line != null){
//            entryList.add(line);
//            line = lineReader.readLine();
//        }
//
//        for(int i = 1; i < entryList.size(); i++){
//            line = entryList.get(i);
//            for(int j = 0; j <= line.length(); j++){
//                if(line.charAt(j) == ','){
//                    dateIndex = j;
//                    break;
//                }
//            }
//            date = line.substring(0,dateIndex);
//            Calendar cDate = stocks.toCal(date);
//            line = line.substring(dateIndex + 1, line.length());
//            valueArray = line.split(",");
//            dataFields = new ArrayList<>();
//            for(int c = 0; c < valueArray.length; c++){
//                dataFields.add(valueArray[c]);
//            }
//            infoMap.put(cDate, dataFields);
//        }
//        System.out.print("Enter A Month: ");
//        month = input.next();
//        System.out.print("Enter A Date: ");
//        day = input.next();
//        System.out.print("Enter A Year: ");
//        year = input.next();
//        Calendar getInfo = stocks.toCal(month+"/"+day+"/"+year);
//        System.out.print(month+"/"+day+"/"+year+": "+infoMap.get(getInfo)+"\n\n");
//    }
//    Calendar toCal(String date){
//        String[] datePieces = date.split("/");
//        int m=Integer.parseInt(datePieces[0]);
//        int d=Integer.parseInt(datePieces[1]);
//        int y=Integer.parseInt(datePieces[2]);
//        return new GregorianCalendar(m, d, y);
//    }
//}