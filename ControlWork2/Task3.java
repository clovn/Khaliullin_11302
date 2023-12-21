import java.util.Scanner;

public class Task3 {
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		System.out.println("Введите n");
		int n = Integer.parseInt(console.nextLine());
		int[] digits = new int[10];

		for(int i = 0; i < n; i++){
			System.out.println("Введите " + n + " чисел " + (i + 1) + " массива");
			for(int j = 0; j < n; j++){
				for(char c : console.nextLine().toCharArray()){
					digits[Integer.parseInt(c + "")] += 1;
				}
			}
		}

		for(int i = 0; i < digits.length; i++){
			System.out.println(i + ": " + digits[i] + " times");
		}
	}
}