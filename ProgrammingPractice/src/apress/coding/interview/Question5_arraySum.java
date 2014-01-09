package apress.coding.interview;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

/**
 * 
 * @author rohitkondekar
 *
 * An array contains n numbers ranging from 0 to n-2. 
 * There is exactly one number duplicated in the array. How do you find the duplicated number? 
 * For example, if an array with length 5 contains numbers {0, 2, 1, 3, 2}, the duplicated number is 2.
 */

public class Question5_arraySum {
	
	int getSum(int n){
		return n*(n-1)/2;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(inp.readLine()," ");
		int sum=0;
		int i=0;
		while(token.hasMoreTokens())
		{
			sum+=Integer.parseInt(token.nextToken());
			i++;
		}

		Question5_arraySum q5 = new Question5_arraySum();
		System.out.println(sum-q5.getSum(i-1));
	}

}
