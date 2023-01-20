package practice_package;

import org.testng.annotations.Test;

public class SampleTestNGTest_2 {
	
	@Test(groups = "smoke")
	public void sample3() {
		System.out.println("----testscript3");
	}
	
	@Test(groups = "regression")
	public void sample4()
	{
		System.out.println("----testscript4");
	}
	

}
