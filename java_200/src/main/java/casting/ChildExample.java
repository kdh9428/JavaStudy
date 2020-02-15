package casting;

public class ChildExample {
	
	public static void main(String[] args) {
		Parent parent = new Child();
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		
		
		//parent.field2 = "data2"; 사용불가, 부모 타입
		
		//parent.field3();사용불가, 부모 타입
		
		
		//원래 Child()로 인스턴스를 생성했기 때문에 가능, Parent parent = new Parent();는 불가능하다.
		Child child = (Child) parent;
		
		child.field2 = "data2";
		child.mehtod3();
		
		
				
	}

}
