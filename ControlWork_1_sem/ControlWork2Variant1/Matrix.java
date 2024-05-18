public class Matrix{
	private double[][] array;

	public Matrix(double[][] array){
		this.array = array;
	}

	public static Matrix getSingleMatrix(int n){
		double[][] single = new double[n][n];

		for(int i = 0; i < n; i++){
			single[i][i] += 1;
		}

		return new Matrix(single);
	}

	public Matrix multOnNum(double num){
		double[][] res = new double[array.length][array.length];

		for(int i = 0; i < res.length; i++){
			for(int j = 0; j < res.length; j++){
				res[i][j] = array[i][j]*num;
			}
		}

		return new Matrix(res);
	}

	public String toString(){
		String s = "";
		for(double[] i : array){
			for(double j : i){
				s += j + " ";
			}

			s += "\n";
		}

		return s;
	}

	public Matrix pow(int n){
		double[][] res = new double[array.length][array.length];

		for(int s = 1; s < n; s++){
			for(int i = 0; i < array.length; i++){
				for(int j = 0; j < array.length; j++){
					for(int k = 0; k < array.length; k++){
						res[i][j] += array[i][k]*array[k][j];
					}
				}
			}
		}

		return new Matrix(res);
	}

	public Matrix sum(Matrix a){
		double[][] res = new double[array.length][array.length];

		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array.length; j++){
				res[i][j] = array[i][j] + a.array[i][j];
			}
		}

		return new Matrix(res);
	}
}