package sample_test;

import org.testng.annotations.Test;

public class NewTest {
	
  @Test(priority = 2)
  public void create() {
	  System.out.println("created");
  }
  
  @Test(priority = 1,invocationCount = 3)
  public void update() {
	  System.out.println("updated");
  }
  
  @Test(priority = 0,dependsOnMethods = "create")
  public void delete() {
	  System.out.println("deleted");
  }
}
