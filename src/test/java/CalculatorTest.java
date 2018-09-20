import static org.junit.Assert.*;

import org.junit.Test;

import com.mahesh.Calculator;

public class CalculatorTest {

	Calculator cal=new Calculator();
	 @Test	
		public void addTest() {
		int output=cal.addFunction(6, 5);
			assertEquals(11, output);
		}
	 @Test
		public void substractTest() {
			int output=cal.substractFunction(9, 3);
			assertEquals(6, output);
		}
	 @Test
		public void multiplyTest() {
			int output=cal.multiplyFunction(4, 7);
			assertEquals(28, output);
		}
	 @Test
		public void divideTest() {
			int output=cal.divideFunction(6, 3);
			assertEquals(2, output);
		}

}
