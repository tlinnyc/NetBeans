public class QuickSort{
   int[] data = {37, 2, 6, 4, 89, 8, 10, 12, 68, 45};
   public QuickSort(){
       String temp = "";
       for(int i = 0; i < data.length; i++){
           temp += (data[i] + " ");
       }
       System.out.println(temp);
   }
   public void sort(){
      quicksortHelper(0, data.length - 1);
   }
   public void quicksortHelper(int left, int right){
      int pointer = left;
      int rightEdge = right; 
      int leftEdge = pointer + 1; 
      while (leftEdge <= rightEdge)
         if (data[leftEdge] <= data[pointer]){
            swap(leftEdge, pointer);
            pointer++;
            leftEdge++;
            String temp = "";
            for(int i = 0; i < data.length; i++){
                temp += (data[i] + " ");
            }
            System.out.println(temp);
         }else{
            swap( leftEdge, rightEdge );
            rightEdge--;
         }
      if (left < (pointer - 1)){
         quicksortHelper(left, pointer - 1);
      }
      if ((pointer + 1) < right){
         quicksortHelper(pointer + 1, right);
      }
      
      
   }
   public void swap(int first, int second){
      int temp = data[first];
      data[first] = data[second];
      data[second] = temp;
   }
   public String toString(){
      StringBuilder temp = new StringBuilder();

      for(int i = 0; i < data.length; i++){
          temp.append(data[i]).append(" ");
      }
      temp.append( "\n" );
      return temp.toString();
   }
   public static void main(String[] args){
       QuickSort qs = new QuickSort();
       qs.sort();
       System.out.print(qs.toString());
   }
}