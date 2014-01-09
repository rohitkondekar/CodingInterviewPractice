package apress.coding.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * How do you implement a function to match regular expressions with Ô.Õ and Ô*Õ in patterns? 
 * The character Ô.Õ in a pattern matches a single character, and Ô*Õ matches zero or any number of characters preceding it. 
 * Matching means that a string fully matches the pattern where all characters in a string match the whole pattern. 
 * For example, the string ÒaaaÓ matches the pattern Òa.aÓ and the pattern Òab*ac*aÓ. However, it does not match the pattern Òaa.aÓ nor Òab*aÓ.
 * @author rohitkondekar
 *
 */

public class Question11_PatternMatching {
	
	
	String pattern;
	String str;
	
	boolean match(int pval,int sval){
		
		if(pval>=pattern.length() && sval>=str.length())
			return true;
		else if(pval>=pattern.length() || sval>=str.length())
			return false;
		else if(pattern.charAt(pval)=='.' || pattern.charAt(pval)=='*' || str.charAt(sval)=='.' || str.charAt(sval)=='*')
			return false;
		
		if(pattern.charAt(pval)!=str.charAt(sval))
			return false;
		else if((pval+1)<pattern.length() && (sval+1)<str.length()){
			
			if(pattern.charAt(pval+1)=='.'){
				if(pattern.charAt(pval)==str.charAt(sval+1))
					return match(pval+2,sval+2);
				else
					return false;
			}
			else if(pattern.charAt(pval+1)=='*'){
				return match(pval,sval+1) || match(pval+2,sval+1);
			}
			else{
				return match(pval+1,sval+1);
			}
		}
		else if((pval+1)==pattern.length()-1 && pattern.charAt(pval+1)=='*'){
			return match(pval+2,sval+1);
		}
		else if((pval+1)==pattern.length()-1 && pattern.charAt(pval+1)=='.'){
			if(pattern.charAt(pval)==str.charAt(sval+1))
				return true;
		}
		
		return false;	
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		
		Question11_PatternMatching Q = new Question11_PatternMatching();
		Q.pattern = inp.readLine();
		Q.str = inp.readLine();
		
		if(Q.pattern==null && Q.str==null)
			System.out.println(true);
		else if(Q.pattern==null || Q.str==null)
			System.out.println(false);
		else
			System.out.println(Q.match(0,0));
	}

}
