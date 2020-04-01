package FactoryMethod;

public class RealTransCreator_TransCompany extends TransCreator {
	
	@Override
	public TransProduct transCreate(String trans) {
		if(trans.equals("Bicycle")) {
			return new TransProduct_Bicycle();
		}else {
			return new TransProduct_Taxi();
		}
	}
}
