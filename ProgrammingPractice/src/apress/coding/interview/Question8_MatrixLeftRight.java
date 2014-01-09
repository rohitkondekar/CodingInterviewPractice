package apress.coding.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * In a 2-D matrix, every row is increasingly sorted from left to right, and every column is increasingly sorted from top to bottom. 
 * Please implement a function to check whether a number is in such a matrix or not. 
 */
public class Question8_MatrixLeftRight {

	
	/**
	 * check for null
	 * check for 1 element
	 * check for row mat
	 * check for col mat
	 * not present
	 */
	
	public boolean checkElement(int val, int[][] mat){
		
		if(mat==null || mat[mat.length-1][mat[0].length-1]<val)
			return false;
		
		int row=0;
		int col=mat[0].length-1;
		
		while(row<mat.length && col>=0){
			if(mat[row][col]==val)
				return true;
			else if(mat[row][col]>val)
				col--;
			else
				row++;
		}

		return false;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Question8_MatrixLeftRight Q = new Question8_MatrixLeftRight();
		InputStream in = Q.getClass().getResourceAsStream("/apress/coding/interview/text/Question8_dataFile");
		BufferedReader inp = new BufferedReader(new InputStreamReader(in));
		
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
		
		
		System.out.println(Q.checkElement(val, mat));
		
	}

}
