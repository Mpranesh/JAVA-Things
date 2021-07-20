package assigmentsjava;

public class Fibanocci {
	public static void main(String[] args) {
		int range = 8;
		int num1 = 0;
		int num2 = 1;
		int sum = 1;
		for (int i = 0; i <=8; i++) {
		sum = num1 + num2;
		System.out.println(sum);
		num1 = num2;
		num2 = sum;
		
		}
		
		
		
		
		
		
	}

}
