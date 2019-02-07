package simpletest;

import org.testng.annotations.Factory;

public class TestFactory {
	
	 @Factory
	 public Object[] factoryMethod() {
	        return new Object[] {
	                                new SimpleTestFactory("Apple"),
	                                new SimpleTestFactory("Banana"),
		 							new SimpleTestFactory("Orange")
	                            };
		 
//		 Object[] data = new Object[3];
//		 data[0] = new SimpleTestFactory("Apple");
//		 data[1] = new SimpleTestFactory("Banana");
//		 data[2] = new SimpleTestFactory("Orange");
//		 
//		 return data;
	    }
}
