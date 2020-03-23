package Generic;

class Box<T>{
	
	private T ob;

	public T getOb() {
		return ob;
	}

	public void setOb(T ob) {
		this.ob = ob;
	}

	
}

class Box1<T extends Number>{
	
	private T ob;
	
	public void setOb(T a) {
		ob = a;
	}
	public int toIntValue() {
		
		return ob.intValue();
	}
}

//메소드에 제네릭 선언
class BoxFactory{
	public static <T> Box<T> makeBox(T o){
		Box<T> box = new Box<>();
		
		box.setOb(o);
		return box;
	}
	
	//<T extends Number>는 타입 인자를 Number를 상속하는 클래스로 제한함을 의미한다.
	public static <T extends Number> Box<T> makeBox1(T o){
		Box<T> box = new Box<>();
		//타입 인자 제한으로 intValue호출 가능하다.
		System.out.println("Boxed data: "+ o.intValue());
		return box;
	}
	
	//타입 인자를 Number를 상속하는 클래스로 제한
	public <T extends Number> T openBox(Box<T> box) {
		
		//타입 인자 제한으로 intValue호출 가능하다.
		System.out.println("Unboxed data : "+box.getOb().intValue());
		return box.getOb();
	}
}

class Toy{
	public String toString() {
		return "I am a Toy";
		}
	}

class Car extends Toy{
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return "I am a Car";
	}
}


class BoxHandler{
	public static void outBox(Box<? extends Toy> box) {
		Toy t = box.getOb();
		box.getOb();
		System.out.println(t);
		
	}
	
	public static void inBox(Box<Toy> box, Toy n) {
		System.out.println(box+"확인"+n);
		box.setOb(n);
	}
	
}

public class GenericTest {

	public static void main(String[] args) {
		Box<String> wBox = new Box<>();
		wBox.setOb("I am so happy.");
		System.out.println(wBox.getOb());
		Box<Box<String>> zBox = new Box<>();
		wBox.setOb("tt");
		zBox.setOb(wBox);
		
		Box<Box<Box<String>>> yBox = new Box<>();
		yBox.setOb(zBox);
		
		System.out.println(yBox.getOb().getOb().getOb());
		
		
		Box1<Double> aa = new Box1<>();
		
		aa.setOb(321133d);
		double dddf = aa.toIntValue();
		
		System.out.println(dddf);
		
		Box<String> sBox = BoxFactory.<String>makeBox("Sweet");
		Box<Double> aBox = BoxFactory.makeBox(7.59);
		System.out.println(sBox.getOb());
		
		System.out.println(aBox.getOb());
		
		Box<Integer> xBox = BoxFactory.makeBox1(4412);
		System.out.println(xBox.getOb());
		
		Box<Integer> sdf = new Box<>();
		sdf.setOb(123);
		BoxFactory test = new BoxFactory();
		
		System.out.println(test.openBox(sdf));
		
		
		//와일드카드 제한 이유
		Box<Car> d = new Box<>();
		
		Car ds = new Car();
		
		Toy n = new Toy();
		d.setOb(ds);
		System.out.println(d.getOb());
		
		Box<Toy> dss = new Box<>();
		Toy da = new Toy();
		dss.setOb(da);
		
		BoxHandler.outBox(d);
		BoxHandler.outBox(dss);
	}
}
