package FactoryMethod;

public abstract class TransCreator {
	//TransProduct 생성하는 팩토리 메소드(자전거, 택시)
	public abstract TransProduct transCreate(String trans);
}
