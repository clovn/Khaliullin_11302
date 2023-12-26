import java.util.Scanner;

public class Task03 {
	public static void main(String[] args){
		double ESP = 1e-10;

		Scanner console = new Scanner(System.in);
		double x = console.nextDouble() * Math.PI / 180.0;

		double result = 0;
        long fact = 1;
        int ser = 1;
        int sign = 1;
        double deg = x;
        double term = sign * deg / fact;
        while (Math.abs(term)>ESP && ser < 20){
            result += term;
            ser += 1;
            fact *= (2*ser - 1)* (2*ser - 2);
            sign = -1 * sign;
            deg *= x * x;
            term = sign * deg / fact;
        }

        System.out.println(result);
	}
}