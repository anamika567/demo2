package InterviewQuestions;

import java.util.Arrays;

public class AnagramInterview2 {

	public static void main(String[] args) {

	     String a1="abcd";
	     String a2="bcda";
	     
	     char[] s1=a1.toCharArray();
	     char[] s2=a2.toCharArray();
	     
	     Arrays.sort(s1);
	     Arrays.sort(s2);
	     
	     
	     boolean result = Arrays.equals(s1, s2);
	     if(result==true)
	     {
	    	 System.out.println("String is equal or anagram");
	     }
	     
	     else
	     {
	    	 System.out.println("not equal not anagram");
	     }
	     

	}

}
