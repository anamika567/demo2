package InterviewQuestions;

public class Program1 {

	public static void main(String[] args) {

		String s="A1B2C3D";
		String a=s.toLowerCase();
		char ch[]=a.toCharArray();

		for(int i=ch.length-1;i>=0;i--)
		{

		if(ch[i]>='a' && ch[i]<='z')
		{
		System.out.print(ch[i]);

	    }
}

	}

}
