import java.util.Scanner;

public class Task29 {
	public static void main(String[] args){
		boolean flag = false;

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

		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length && !flag; j++){
				if(Util.chetNumber(arr[i][j])){
					flag = true;
				}
			}

			if(!flag) break;
		}

		System.out.println(flag);
	}
}