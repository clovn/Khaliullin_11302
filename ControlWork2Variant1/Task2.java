import java.util.Scanner;
//Var 1
public class Task2 {
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);

		System.out.println("Введите размер матрицы(одно число)");
		int m = Integer.parseInt(console.nextLine());
		double[][] in = new double[m][m];

		System.out.println("Введите матрицу");
		for(int i = 0; i < m; i++){
			for(int j = 0; j < m; j++){
				System.out.print("(" + i + "," + j + "):");
				in[i][j] = Double.parseDouble(console.nextLine());
			}
		}

		Matrix matrix = new Matrix(in);

		System.out.println("Введите n");
		int n = Integer.parseInt(console.nextLine());

		double[] p = new double[n + 1];
		System.out.println("Введите p0, p1,...,pn");
		for(int i = 0; i < p.length; i++){
			p[i] = console.nextDouble();
		}

		Matrix res = Matrix.getSingleMatrix(m).multOnNum(p[0]);

		for(int i = 1; i <= n; i++){
			res = res.sum(matrix.pow(i).multOnNum(p[i]));
		}

		System.out.println(res);
	}
}