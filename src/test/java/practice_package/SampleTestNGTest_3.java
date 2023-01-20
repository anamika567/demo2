package practice_package;

import org.testng.annotations.Test;

public class SampleTestNGTest_3 {
	
	@Test(groups = "regression")
	public void sample5() {
		System.out.println("----testscript5");
	}
	
	@Test(groups = {"smoke","regression"})
	public void sample6()
	{
		System.out.println("----testscript6");
	}
	

}
