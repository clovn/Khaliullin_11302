import java.util.Scanner;

public class Task05 {
	public static void main(String[] args){
		double ESP = 1e-10;

		Scanner console = new Scanner(System.in);
		double x = console.nextDouble();

		double result = 0;
        long fact = 1;
        int ser = 1;
        int sign = 1;
        double deg = x;
        double term = sign * deg / ser;


        while (Math.abs(term) > ESP && ser < 20){
            result += term;
            ser += 1;
            sign = -1 * sign;
            deg *= x;
            term = sign * deg / ser;
        }

        System.out.println(result);
	}
}