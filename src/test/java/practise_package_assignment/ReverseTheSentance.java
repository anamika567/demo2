package practise_package_assignment;

public class ReverseTheSentance {

	public static void main(String[] args) {

		String s="java is wonderfull language";
		String[] st = s.split(" ");
		String rev="";
		for(int i=st.length-1;i>=0;i--)
		{
			
			rev=rev+st[i]+" ";
		}
		System.out.print(rev);
		
	}

}
