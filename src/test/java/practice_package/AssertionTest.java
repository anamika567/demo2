package practice_package;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {
	
	    @Test
		public void sample_1()
		{
			System.out.println("---testscript1----");
			System.out.println("----testscript2----");
			assertEquals("A", "B");
			System.out.println("----testscript3---");
			System.out.println("----testscript4----");
		}
	    
	    @Test
	    public void sample_2()
		{
			System.out.println("---testscript5----");
			System.out.println("----testscript6----");
			assertEquals("A","B" , "script is failed");
			System.out.println("----testscript7---");
			System.out.println("----testscript8----");
		}
	    
	    @Test
	    public void sample_3()
		{
			String a=null;
			assertNull(a);
			System.out.println("--------");
		}
	    
	    @Test
	    public void sample_4()
		{
			System.out.println("---testscript9----");
			SoftAssert as=new SoftAssert();
			as.assertEquals("X", "Y");
			System.out.println("----testscript10----");
			as.assertAll();
		}
	
	
	
	}


