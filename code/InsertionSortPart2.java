import java.util.*;
public class Solution {
    
    public static void insertionSort(int[] ar){
        int i, j, v, n = ar.length;
        for (i = 1; i < n; i++){
            v = ar[i];    //value to insert
            for (j = i-1; j >= 0; j--) {
                if (ar[j] > v) {
                    ar[j+1] = ar[j];     //move over  
                    if (j==0)    
                        ar[0] = v;
                }
                else {
                    ar[j+1] = v;   
                    break;
                }
            }
            printArray(ar);
        }
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
