package apress.coding.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * An array contains n numbers ranging from 0 to n-1. There are some numbers duplicated in the array. 
 * It is not clear how many numbers are duplicated or how many times a number gets duplicated. How do you find a duplicated number in the array? 
 * For example, if an array of length 7 contains the numbers {2, 3, 1, 0, 2, 5, 3}, the implemented function (or method) should return either 2 or 3.
 */

public class Question6_DuplicateNumber {
	
	//Swapping method used
	public static void main(String[] args) throws Exception{
		
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		String input = inp.readLine();
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		StringTokenizer token = new StringTokenizer(input,",");
		
		while(token.hasMoreTokens()){
			arr.add(Integer.parseInt(token.nextToken()));
		}
		inp.close();
		
		int i=0;
		while(i<arr.size())
		{
			if(arr.get(i)<arr.size())
				i++;
			else
				throw new Exception("Illegal values");
		}
		
		
		while(i<arr.size()){
			int tmp = arr.get(i);
			if(tmp!=i){
				if(arr.get(tmp)==tmp){
					System.out.println("Result : "+tmp);
					return;
				}
				else{
					arr.set(i, arr.get(tmp));
					arr.set(tmp, tmp);
				}
			}
			else{
				i++;
			}
		}
		System.out.println("Result : no duplicates");
		
	}

}
