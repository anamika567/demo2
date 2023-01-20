package practice_package;

import org.testng.annotations.Test;

public class SampleTestNGTest_4 {
	
	@Test(groups = "smoke")
	public void sample7() {
		System.out.println("----testscript7");
	}
	
	@Test(groups = "regression")
	public void sample8()
	{
		System.out.println("----testscript8");
	}
	

}
