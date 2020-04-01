package FactoryMethod;

public class TransProduct_Taxi extends TransProduct {

	@Override
	void useTrans() {
		System.out.println("Using Taxi");
	};
}
