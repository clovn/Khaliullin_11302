import java.util.Scanner;

public class Task26 {
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);

		System.out.print("Введите размер массива: ");
		int n = Integer.parseInt(console.nextLine());
		int[] arr = new int[n];

		System.out.print("Введите элементы массива: ");
		for(int i = 0; i < n; i++){
			arr[i] = console.nextInt();
		}

		boolean flag = true;

		for(int i : arr){
			if(i < 0) continue;
			if(!chetDigit(i)) flag = false;
		}

		System.out.println(flag);

	}

	public static boolean chetDigit(int num){
		while(num != 0){
			if(num % 10 % 2 == 0) return true;

			num /= 10; 
		}

		return false;
	}
}