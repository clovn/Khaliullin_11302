import java.util.Scanner;
import java.util.regex.*;

public class Task6 {
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		String str = console.nextLine();

		Pattern p = Pattern.compile("[AEIOUY].*[AEIOUY]");
		Matcher m = p.matcher(str);

		System.out.println(m.matches());


		int s = 0;
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(s == 0){
				if(Util.checkVowelsChar(c)){
					s = 1;
				} else {
					s = -1;
				}
			} else if(s == 1 && i == str.length() - 1){
				if(Util.checkVowelsChar(c)){
					s = 2;
				} else {
					s = -1;
				}
			} 
		}

		System.out.println(s == 2);
	}
}