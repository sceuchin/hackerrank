

/* Head ends here */
import java.util.*;
public class Solution {
       
          static void insertionSort(int[] ar) {
              int i, v = ar[ar.length-1];
              for(i=ar.length-2; i>=0; i--){
                  if (ar[i] > v) {
                      ar[i+1] = ar[i];
                  }
                  else {
                      ar[i+1] = v;
                      break;
                  }
                  printArray(ar);
              }
              if (ar[0] > v)    
                  ar[0] = v;
              printArray(ar);
       }   

/* Tail starts here */
 
 static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }
       
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           insertionSort(ar);
       }    
   }
