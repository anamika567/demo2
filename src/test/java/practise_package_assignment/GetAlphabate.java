package practise_package_assignment;

public class GetAlphabate {

	public static void main(String[] args) {

		String s= "hello12bye";
		char ch[]=s.toCharArray();
		int count=0;

		for(int i=0;i<ch.length;i++)
		{
			if(ch[i]>='a' && ch[i]<='z' || ch[i]>='A' && ch[i]<='Z')
			{
				count++;
				System.out.print(ch[i]);
			}

		}
		System.out.println(count);

	}

}
