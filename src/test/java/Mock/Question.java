package Mock;

public class Question {

	public static void main(String[] args) {

		int a=0;
		int b=1;
		int c;
		
		for(int i=0;i<20;i++)
		{
			
		System.out.print(a+" ");
		c=a+b;
		a=b;
		b=c;
		
		if(a/3==0)
		{
			System.out.print(a);
		}
		}
	}

}
