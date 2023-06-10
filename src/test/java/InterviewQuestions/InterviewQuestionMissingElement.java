package InterviewQuestions;

public class InterviewQuestionMissingElement {

	public static void main(String[] args) {

		int ar[]= {1,6,8,11};
		System.out.println("missing elements:");
		for(int i=0;i<ar.length-1;i++)
		{
			for(int j=ar[i]+1;j<ar[i+1];j++)
			{
				System.out.print(j+" ");
			}
		}
	}

}
