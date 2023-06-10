package InterviewQuestions;

public class Program4 {

	public static void main(String[] args) {


		String s="my name is xyz";
		String st[]=s.split(" ");
		System.out.print(st[0]+" ");
		for(int i=1;i<=st.length-1;i++)
		{
			String s1=st[i];
			for(int j=s1.length()-1;j>=0;j--)
			{
				System.out.print(s1.charAt(j));
			}
			System.out.print(" ");
		}


	}

}
