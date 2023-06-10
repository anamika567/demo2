package InterviewQuestions;

public class MomDadPalindrome {

	public static void main(String[] args) {

		String s="DAD MOM CHILD";
		String st[]=s.split(" ");
		
		for(int i=0;i<st.length;i++)
		{
			String sn="";
			String sy=st[i];
			
			for(int j=sy.length()-1;j>=0;j--)
			{
				sn=sn+sy.charAt(j);
			}
			
			if(st[i].equals(sn))
			{
				System.out.print(st[i]+" ");
			}
		}
	}

}
