package Mock;

public class SeleniumPattern {

//	s 
//	s e 
//	s e l 
//	s e l e 
//	s e l e n 
//	s e l e n i 
//	s e l e n i u 
//	s e l e n i u m 

	public static void main(String[] args) {

		String s="selenium";
		char ch[]=s.toCharArray();
		int row=8;
		int value=1;
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<value;j++)
			{
				System.out.print(ch[j]+" ");
			}
			System.out.println();
			value++;
		}
	}

}
