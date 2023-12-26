import java.util.Scanner;

public class Task27 {
	public static void main(String[] args){
		boolean flag = true;

		Scanner console = new Scanner(System.in);

		System.out.print("Введите количество массивов: ");
		int n = Integer.parseInt(console.nextLine());
		int[][] arr = new int[n][];

		for(int i = 0; i < n; i++){
			System.out.print("Введите количество элементов в массиве: ");
			int k = Integer.parseInt(console.nextLine());
			arr[i] = new int[k];

			for(int j = 0; j < k; j++){
				arr[i][j] = Integer.parseInt(console.nextLine());
			}
		}

		for(int[] a : arr){
			for(int i : a){
				if(i % 3 != 0) flag = false;
			}

			if(flag) break;
		}

		System.out.println(flag);
	}
}