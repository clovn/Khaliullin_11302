import java.util.Scanner;

public class Task24 {
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);

		System.out.print("Введите размер массива: ");
		int n = Integer.parseInt(console.nextLine());
		int[] arr = new int[n];

		System.out.print("Введите элементы массива: ");
		for(int i = 0; i < n; i++){
			arr[i] = console.nextInt();
		}

		System.out.println(Util.countOfNegatives(arr) >= 2);
	}
}