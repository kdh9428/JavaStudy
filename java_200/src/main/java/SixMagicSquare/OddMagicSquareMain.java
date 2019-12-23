package SixMagicSquare;

import java.util.Scanner;

public class OddMagicSquareMain {

	public static void main(String[] args) {
		System.out.println("홀수 정수를 입력하세요");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		OddMagicSquare odd = new OddMagicSquare(n);
		odd.make();
		odd.print();
	}

}
