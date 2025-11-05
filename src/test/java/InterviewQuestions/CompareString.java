package InterviewQuestions;

public class CompareString {

	public static void main(String[] args) {

		String s1="hello";
		String s3="hello";
		String s2=new String("hello");
		System.out.println(s1==s2); // false
		System.out.println(s1.equals(s2)); // true
		
		System.out.println("-----------------------------");

		System.out.println(s1==s3); //true
		System.out.println(s1.equals(s3)); //true

	}

}
