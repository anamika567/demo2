package InterviewQuestions;

import java.util.Arrays;

public class AnagramInterview {

	public static void main(String[] args) {

		boolean status=isAnagram("abcd","bcda");
		if(status==true)
		{
			System.out.println("string is anagram");
		}
		else
		{
			System.out.println("not anagram");
		}
		}
	
	public static boolean isAnagram(String s1,String s2)
	{
		if(s1.length()!=s2.length())
		{
			return false;
		}
		else
		{
			char[] a1=s1.toCharArray();
			char[] a2=s2.toCharArray();
			
			Arrays.sort(a1);
			Arrays.sort(a2);
			
			Arrays.equals(a1, a2);
			return true;
		}
		
	}

}
