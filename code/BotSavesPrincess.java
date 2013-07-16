import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
/* Head ends here */
static void displayPathtoPrincess(int n, String [] grid){
    
    int i, j, m_i=0, m_j=0, p_i=0, p_j=0, horz, vert;
    char[] gridArray = new char[3];
    
    //Find bot and princess
    for (i=0; i<n; i++) 
    {   
        gridArray = grid[i].toCharArray();
        for (j=0; j<n; j++)
        {
            if (gridArray[j]=='m')        { m_i = i; m_j = j; }
            else if (gridArray[j]=='p')    { p_i = i; p_j = j; }
        }
    }
    
    horz = p_j - m_j;
    vert = p_i - m_i;
        
    if (horz<0)
        for (i=0; i<-horz; i++)
            System.out.println("LEFT");
    else if (horz>0)
        for (i=0; i<horz; i++)
            System.out.println("RIGHT");   
        
    if (vert<0)
        for (i=0; i<-vert; i++)
            System.out.println("UP");
    else if (vert>0)
        for (i=0; i<vert; i++)
            System.out.println("DOWN");   
                               
  }
/* Tail starts here */
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[] = new String[m];
        for(int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

    displayPathtoPrincess(m,grid);
    }
}
