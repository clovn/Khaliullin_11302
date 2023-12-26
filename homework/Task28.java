import java.util.Scanner;

public class Task28 {
	public static void main(String[] args){
		boolean flag = false;
		Scanner console = new Scanner(System.in);

		System.out.print("Введите количество массивов: ");
		int n = Integer.parseInt(console.nextLine());
		String[][] arr = new String[n][];

		for(int i = 0; i < n; i++){
			System.out.print("Введите количество элементов в массиве: ");
			int k = Integer.parseInt(console.nextLine());
			arr[i] = new String[k];

			for(int j = 0; j < k; j++){
				arr[i][j] = console.nextLine();
			}
		}

		for(int i = 0; i < arr[0].length; i++){
			for(int j = 0; j < arr.length && !flag; j++){
				if(Util.isVowel(arr[j][i].charAt(0))){
					flag = true;
				}
			}

			if(!flag) break;
		}

		System.out.println(flag);
	}
}