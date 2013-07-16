import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static int insertionSort(int[] ar){
        int i, j, v, n = 0;
        for (i = 1; i < ar.length; i++){
            v = ar[i];    //value to insert
            for (j = i-1; j >= 0; j--) {
                if (ar[j] > v) {
                    ar[j+1] = ar[j];     //move over  
                    n++;
                    if (j==0)    
                        ar[0] = v;
                }
                else {
                    ar[j+1] = v;   
                    break;
                }
            } 
        }
        return n;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your
class should be named Solution. */
        Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
        n = insertionSort(ar);
        System.out.println(n);
    }
}
