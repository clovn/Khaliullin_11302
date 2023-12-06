import java.util.regex.*;

public class Tasks {
	private static final String VOWELS = "AEIOUYaeiouy";

	private static int countOfNegatives(int[] arr){
		int count = 0;

		for(int i : arr) {
			if(i < 0) count++;
		}

		return count;
	}

	private static boolean isVowel(char c){
		return VOWELS.contains(Character.toString(c));
	}

	private static boolean isLetter(char c){
		return 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z';
	}

	private static boolean chetNumber(int num){
		return Pattern.compile("[02468]*").matcher(Integer.toString(Math.abs(num)))c.matches();	
	}

	public static boolean hasNegative(int[] arr){
		return countOfNegatives(arr) > 0;
	}

	public static boolean allVowels(String s){
		for(char i : s.toCharArray()){
			if(isLetter(i) && !isVowel(i)) return false;
		}

		return true;
	}

	public static boolean hasTwoNegative(int[] arr){
		return countOfNegatives(arr) >= 2;
	}

	public static boolean hasThreeVowels(String s){
		int count = 0;

		for(char i : s.toCharArray()){
			if(isVowel(i)) count++;
			if(count > 3) return false;
		}

		return count == 3;
	}

	public static boolean hasChet(int[] arr){
		for(int i : arr){
			if(i > 0 && i % 2 == 0) return true;
		}

		return false;
	}

	public static boolean hasLine3(int[][] arr){
		boolean flag = true;

		for(int[] a : arr){
			for(int i : a){
				if(i % 3 != 0) flag = false;
			}

			if(flag) return true;
		}

		return false;
	}

	public static boolean hasStringStartVowel(String[][] arr){
		boolean flag = false;

		for(int i = 0; i < arr[0].length; i++){
			for(int j = 0; j < arr.length && !flag; j++){
				if(isVowel(arr[j][i].charAt(0))){
					flag = true;
				}
			}

			if(!flag) return false;
		}

		return true;
	}

	public static boolean hasChetNumber(int[][] arr){
		boolean flag = false;

		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length && !flag; j++){
				if(chetNumber(arr[i][j])){
					flag = true;
				}
			}

			if(!flag) return false;
		}

		return true;
	}

	public static boolean hasStringStartVowel2(String[][] arr){
		for(int i = 0; i < arr[0].length; i++){
			int count = 0;

			for(int j = 0; j < arr.length; j++){
				if(isVowel(arr[j][i].charAt(0))){
					count++;
				}

				if(count > 2) return false; 
			}
		}

		return true;
	}

	public static boolean hasChetNumber3(int[][] arr){
		for(int i = 0; i < arr.length; i++){
			int count = 0;

			for(int j = 0; j < arr[0].length && count < 3; j++){
				if(chetNumber(arr[i][j])){
					count++;
				}
			}

			if(count < 3) return false;
		}

		return true;
	}
}