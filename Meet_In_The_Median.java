/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		PrintWriter pr = new PrintWriter(System.out);
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-- > 0){
		    int n = scn.nextInt();
		    int k = scn.nextInt();
		    int[] arr = new int[n];
		    int[] arr1 = new int[n];
		    for(int i = 0 ; i < n; i++){
		        arr[i] = scn.nextInt();
		        arr1[i] = arr[i];
		    }
		    Arrays.sort(arr1);
		    long ans = 0;
		    boolean even = k%2 == 0;
		    HashSet<Integer> set = new HashSet<>();
		    for(int i = arr1.length-1,j = 0;j < k;j++,i--){
		        if(j == (k/2)) ans+=arr1[i];
		        set.add(arr1[i]);
		    }
		    pr.println(ans);
		    for(int i : arr)if(set.contains(i)) pr.print(i+" ");
		    pr.println();
		    
		}
		pr.flush();
	}
}
