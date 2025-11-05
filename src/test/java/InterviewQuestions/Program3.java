package InterviewQuestions;

public class Program3 {

	public static void main(String[] args) {

		String s[]= {"abc","avd","gvk"};
		String rev="";

		for(int i=0;i<s.length;i++)
		{
			String st=s[i];
			for(int j=st.length()-1;j>=0;j--)
			{
				rev=rev+st.charAt(j); 
			}	
		}
		System.out.print(rev);

	}

}
