import java.util.Scanner;

public class Task1 {
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		System.out.println("Введите длину массива");
		String[] strings = new String[Integer.parseInt(console.nextLine())];

		System.out.println("Введите строки массива(каждую строку на отдельной строчке)");
		for(int i = 0; i < strings.length; i++){
			strings[i] = console.nextLine();
		}

		int count = 0;

		for(String str : strings){
			if(isPalindrom(str)) count++;
			if(count > 2){
				break;
			}
		}

		System.out.println(count == 2);
	}

	public static boolean isPalindrom(String str){
		for(int i = 0; i < str.length() / 2; i++){
			if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}

		return true;
	}
}