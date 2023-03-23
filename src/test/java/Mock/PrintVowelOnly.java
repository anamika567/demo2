package Mock;

public class PrintVowelOnly {

	public static void main(String[] args) {

		String s="EducAtion";
		String st=s.toLowerCase();
		char ch[]=st.toCharArray();
		for(int i=0;i<ch.length;i++)
		{
			if(ch[i]=='a' || ch[i]=='e'|| ch[i]=='i'|| ch[i]=='o'||ch[i]=='u')
			{
				System.out.println(ch[i]);
			}
		}
	}

}
