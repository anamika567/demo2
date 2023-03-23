package Mock;

public class ExecuteDemo {

	public static void main(String[] args) {

		Demo d=new Demo();
		d.m1();
		
		Test t=new Test();
		t.m1();
		
		Test t1=new Demo();
		t1.m1();
		
		Demo d1=(Demo) t1;
		d1.m1();
	}

}
