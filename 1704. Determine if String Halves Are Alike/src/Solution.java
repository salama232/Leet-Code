//You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
//
//Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
//
//Return true if a and b are alike. Otherwise, return false.
//
// 
//
//Example 1:
//
//Input: s = "book"
//Output: true
//Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
//Example 2:
//
//Input: s = "textbook"
//Output: false
//Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
//Notice that the vowel o is counted twice.
//Example 3:
//
//Input: s = "MerryChristmas"
//Output: false
//Example 4:
//
//Input: s = "AbCdEfGh"
//Output: true
// 
//
//Constraints:
//
//2 <= s.length <= 1000
//s.length is even.
//s consists of uppercase and lowercase letters.



import java.util.HashSet;
import java.util.Set;


public class Solution {
	  public static  boolean halvesAreAlike(String s) {
		  Set<Character> vowels = new HashSet<Character>(); 
		  
		  vowels.add('a');
		  vowels.add('e');
		  vowels.add('i');
		  vowels.add('o');
		  vowels.add('u');
		  vowels.add('A');
		  vowels.add('E');
		  vowels.add('I');
		  vowels.add('O');
		  vowels.add('U');
	        
	       int left=0;
	       int right=s.length()-1;
	       int vleft=0;
	       int vright=0;
	       
	       while (left<right)
	       {
	    	   if (vowels.contains(s.charAt(right)))
	    		   vright++;
	    	   if (vowels.contains(s.charAt(left)))
	    		   vleft++;
	    	   left++;
	    	   right--;
	  
	       }
	       
	       
	       if (vright==vleft)
	    		   return true;
	       else
	    	   	return false;
	        
	    }
	  
	  
	  
			  
		
	public static void main (String [] args)
		{
			
		
		System.out.print(halvesAreAlike(new String("AbCdEfGh")));
			
		}
}

