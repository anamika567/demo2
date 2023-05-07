package Mock;

import java.util.LinkedHashSet;

public class PatternUsingCollection {

	public static void main(String[] args) {

		String s="abcdaabbccddabd";
		LinkedHashSet<Character> a=new LinkedHashSet<Character>();
		for(int i=0;i<s.length();i++)
		{
			a.add(s.charAt(i));
		}
		for(Character set:a)
		{
			for(int i=0;i<s.length();i++)
			{
				
				if(set.equals(s.charAt(i)));
				{
				System.out.print(set);

				}
			}
			System.out.println();

		}
	}

}
