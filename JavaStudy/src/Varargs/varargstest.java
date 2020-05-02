package Varargs;

public class varargstest{
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		showAll("Box");
		showAll("Box", "Toy");
		showAll("Box", "Toy", "Apple");
		
		System.out.println();
		Viewable view = new Viewer();
		
		view.showIt("Hello Annotation");
		view.brShowIt("Hello Annotation");
		
	}

	public static void showAll(String... vargs) {
		System.out.println("LEN: " + vargs.length);

		for (String s : vargs)
			System.out.print(s + '\t');
		System.out.println();
	}
}

interface Viewable{
	
	@Deprecated
	public void showIt(String str);
	
	public void brShowIt(String str);
	
}

class Viewer implements Viewable{
	@Override
	@SuppressWarnings("deprecation")
	public void showIt(String str) {
		System.out.println(str);
	}
	
	@Override
	public void brShowIt(String str) {
		System.out.println("["+str+"]");
		
	}
}

