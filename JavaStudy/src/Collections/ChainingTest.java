package Collections;

public class ChainingTest {
	
	static class CalculatorTest{
		int data ;
		
		public CalculatorTest(int a) {
			data = a;
		}
		public CalculatorTest add(int add) {
			data +=add;
			return this;
		}
		public CalculatorTest sub(int sub) {
			data -= sub;
			return this;
		}
		public int print() {
			return data;
		}
	}
	
	public static void main(String[] args) {
		
		CalculatorTest cal = new CalculatorTest(0);
		
		int ass = cal.add(4)
					.add(5)
					.sub(3)
					.add(10)
					.print();
		
		System.out.println(ass);
		
	}
	
	
}
