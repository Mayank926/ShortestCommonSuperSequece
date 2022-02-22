// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static String[][] arr;
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        arr = new String[X.length()][Y.length()];
        String mergeSequence = getShortestMergeSequence(X.toCharArray(), Y.toCharArray(), 0, 0);
        return mergeSequence.length();
    }
    
    private static String getShortestMergeSequence(char[] x, char[] y, int xBeg, int yBeg) {
        
        if (x.length == xBeg)
            return new String(y, yBeg, y.length - yBeg);
        if (y.length == yBeg)
            return new String(x, xBeg, x.length - xBeg);
        if (arr[xBeg][yBeg] != null)
            return arr[xBeg][yBeg];

        if (x[xBeg] == y[yBeg]) {
            arr[xBeg][yBeg] = x[xBeg] + getShortestMergeSequence(x, y, xBeg + 1, yBeg + 1);
            return arr[xBeg][yBeg];
        }
        String merge1 = x[xBeg] + getShortestMergeSequence(x, y, xBeg + 1, yBeg);
        String merge2 = y[yBeg] + getShortestMergeSequence(x, y, xBeg, yBeg + 1);
        if (merge1.length() < merge2.length()) {
            arr[xBeg][yBeg] = merge1;
            return merge1;
        } else {
            arr[xBeg][yBeg] = merge2;
            return merge2;
        }
    }
}
