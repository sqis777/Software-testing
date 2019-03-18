package triangle;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class testCalculate {
	
	private static triCalculate cal = null;
	
	@Before
	public void steUp() {
	  cal = new triCalculate();
	}
	//避免反复声明，使代码更加简洁
	
	@Test
	public void testTriangle() {
	    assertEquals(0,cal.triangle(79));   
	}
	
	@Test
	public void testTriangle1() {
	    assertEquals(1,cal.triangle(32));	    
	}
	
	@Test
	public void testTriangle2() {
	    assertEquals(0,cal.triangle(84));	    
	}
	
	@Test
	public void testTriangle3() {
	    assertEquals(1,cal.triangle(83));	    
	}
	
	@Test
	public void testTriangle4() {
	    assertEquals(0,cal.triangle(15)); 
	}
	
}
