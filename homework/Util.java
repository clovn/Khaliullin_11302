import java.util.regex.*;

public class Util{

	public static final String VOWELS = "AEIOUYaeiouy";

	public static int countOfNegatives(int[] arr){
		int count = 0;

		for(int i : arr) {
			if(i < 0) count++;
		}

		return count;
	}

	public static boolean isVowel(char c){
		return VOWELS.contains(Character.toString(c));
	}

	public static boolean isLetter(char c){
		return 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z';
	}

	public static boolean check(char left, char right, char num){
		return num >= left && num <= right;
	}

	public static boolean checkVowelsChar(char c){
		return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'Y';
	}

	public static boolean checkAllChar(char c){
		return 'A' <= c && c <= 'z' || c == '-' || c == '-'; 
	}

	public static boolean chetNumber(int num){
		return Pattern.compile("[02468]*").matcher(Integer.toString(Math.abs(num))).matches();	
	}
}