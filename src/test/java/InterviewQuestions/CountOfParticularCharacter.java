package InterviewQuestions;

public class CountOfParticularCharacter {

	public static void main(String[] args) {

		String s="immunuuuUUties";
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='u' || s.charAt(i)=='U')
			{
				count++;
			}

		}
	
		System.out.println(count);

	}

}
