package Mock;

public class Program2 {

	public static void main(String[] args) {

		String s="3a$1bc#*2";
		String alpha="";
		String num="";
		String spc="";
		
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)>='a' && s.charAt(i)<='z')
			{
				alpha=alpha+s.charAt(i);
				
			}
			else if(s.charAt(i)>='0' && s.charAt(i)<='9')
			{
			    num=num+s.charAt(i);
				
			}
			else if((s.charAt(i)>='a' && s.charAt(i)<='z' || s.charAt(i)>='0' && s.charAt(i)<='9')==false)
			{
				spc=spc+s.charAt(i);
			}
		
		}
		System.out.println(alpha);
		System.out.println(num);
		System.out.println(spc);


	}

}
