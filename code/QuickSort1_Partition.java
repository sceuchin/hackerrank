/* Head ends here */
import java.util.*;
public class Solution {
       
    static void partition(int[] ar) {
        int i, lo = 0, hi = 0, l = 0, h = 0;
        int n = ar.length;
        int p = ar[0];
        int[] low = new int [n];
        int[] high = new int [n];
        
        for (i = 1; i < n; i++) {
            if (ar[i] < p)    low[lo++] = ar[i];
            if (ar[i] > p)    high[hi++] = ar[i];
        }
        
        for (i = 0; i < n; i++) {
            if (i < lo)        ar[i] = low[l++];
            else if (i == lo)  ar[i] = p;
            else               ar[i] = high[h++];
        }   
             
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
           partition(ar);
       }    
   }
