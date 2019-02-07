package simpletest;

import org.testng.annotations.*;

public class SimpleTestFactory
	{
	    private String param = "";
	 
	    public SimpleTestFactory(String param) {
	        this.param = param;
	    }
	 
	    @BeforeClass
	    public void beforeClass() {
	        System.out.println("Before SimpleTest class executed.");
	    }
	 
	    @Test
	    public void testMethod() {
	        System.out.println("testMethod parameter value is: " + param);
	    }
	}
	 



