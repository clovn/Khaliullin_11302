import java.util.Scanner;

public class Task25 {
	public static void main(String[] args){
		int count = 0;
		Scanner console = new Scanner(System.in);

		System.out.print("Введите строку: ");
		String s = console.nextLine();

		for(char i : s.toCharArray()){
			if(Util.isVowel(i)) count++;
			if(count > 3) break;
		}

		System.out.println(count == 3);
	}
}