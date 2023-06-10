package InterviewQuestions;

import java.util.LinkedHashSet;

public class OccuranceOfEachCharacter {

	public static void main(String[] args) {

		String s="Thegrassisgreen";
		char st[]=s.toCharArray();
		LinkedHashSet<Character> set=new LinkedHashSet<Character>();
		for(int i=0;i<st.length;i++)
		{
			set.add(st[i]);
		}
		
		for(Character it:set)
		{
			int count=0;
			for(int i=0;i<st.length;i++)
			{
				if(it==st[i])
				{
					count++;
				}
			}
			
			System.out.println(it+ " is "+count+ "times");
		}
	}

}
