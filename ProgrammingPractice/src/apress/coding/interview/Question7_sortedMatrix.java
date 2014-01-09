package apress.coding.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * In a 2-D matrix, every row is increasingly sorted from left to right, and the last number in each row is 
 * not greater than the first number of the next row. A sample matrix follows. Please implement a function to check 
 * whether a number is in such a matrix or not. It returns true if it tries to find the number 7 in the sample matrix, 
 * but it returns false if it tries to find the number 12.
 */

public class Question7_sortedMatrix {

	boolean searchMatrix(int val, int[][] mat){
		
		int start = 0;
		int end = mat.length-1;
		int mid = (start+end)/2;;
		
		if(mat==null)
			return false;
		
		
		if(mat[mid][0]==val)
			return true;
		
		while(start<end){
			mid = (start+end)/2;
			if(mat[mid][0] == val)
				return true;
			else
			{
				if(val>mat[mid][0] && val<mat[mid+1][0])
					break;
				else if (val>mat[mid][0])
					start=mid+1;
				else
					end=mid-1;
			}
		}
		
		mid = (start+end)/2;
		
		start=0;
		end=mat[0].length-1;
		int mid1 = (start+end)/2;
		
		if(mat[mid][mid1]==val)
			return true;
		
		while(start<end){
			mid1 = (start+end)/2;
			if(mat[mid][mid1] == val)
				return true;
			else
			{
				if(mat[mid][mid1]>val)
					end=mid1-1;
				else
					start=mid1+1;
			}
		}
		
		mid1 = (start+end)/2;
		if(mat[mid][mid1]==val)
			return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		
		int val = Integer.parseInt(inp.readLine());
		int m = Integer.parseInt(inp.readLine());
		int n = Integer.parseInt(inp.readLine());
		
		int[][] mat = new int[m][n];
		
		
		String input = inp.readLine();
		StringTokenizer token = new StringTokenizer(input,",");
		
		while(token.hasMoreTokens()){
			for(int i=0;i<m;i++)
				for(int j=0;j<n;j++)
					mat[i][j] = Integer.parseInt(token.nextToken());
		}
		
		Question7_sortedMatrix Q = new Question7_sortedMatrix();
		System.out.println(Q.searchMatrix(val, mat));
		
	}
}
