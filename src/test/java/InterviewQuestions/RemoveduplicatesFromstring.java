package InterviewQuestions;

import java.util.LinkedHashSet;

public class RemoveduplicatesFromstring {

	public static void main(String[] args) {

		String s="aabbbaccds";
		char ch[]=s.toCharArray();
		LinkedHashSet<Character> set=new LinkedHashSet<Character>();
		for(int i=0;i<ch.length;i++)
		{
			set.add(ch[i]);
		}
		for(Character it:set)
		{
			System.out.print(it);
		}
	}

}
