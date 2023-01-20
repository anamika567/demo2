package sample_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.insurance.GenericUtilities.BaseClass;

public class SampleTest {
	
	@Test(retryAnalyzer = com.insurance.GenericUtilities.RetryImpClass.class)
	public void amozontest() {
		Assert.assertEquals("A", "B");
	}

}
