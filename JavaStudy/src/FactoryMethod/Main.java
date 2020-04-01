package FactoryMethod;

public class Main {

		public static void main(String[] args) {
			
			//디자인패턴 팩토리매소드 공부
			//교통 수단을 만들어내는 생산자 선언.
			TransCreator tc = new RealTransCreator_TransCompany();
			
			TransProduct tp;
			//자전거 생성
			tp = tc.transCreate("Bicycle"); // new TransProduct_Bicycle();이 생성되어 tp에 주입된다.
			tp.useTrans(); //결국 tp는 TrnasProduct tp = new TransProduct_Bicycle();이 된다.
			
			tp = tc.transCreate("taxi"); //마찬가지로 TransProduct tp = new TransProduct_Bicycle();
			tp.useTrans();
		}
}
