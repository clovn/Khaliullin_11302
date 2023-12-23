public class Circle {
	private double radius;
	private double centerX;
	private double centerY;

	public Circle(double radius, double x, double y){
		if(radius <= 0){
			throw new RuntimeException("Радиус не может быть меньше или равен 0");
		}
		this.radius = radius;
		centerX = x;
		centerY = y;
	}

	public double length(){
		return 2*Math.PI*radius;
	}

	public double square(){
		return Math.PI*radius*radius;
	}

	public void resize(double n){
		radius *= Math.sqrt(1 + n / 100);
	}

	public double sectorSquare(double deg){
		return square() * (deg/360);
	}

	public boolean equals(Circle obj){
		return radius == obj.radius;
	}

	public int otnoshenie(Circle obj){
		double centersLength = Math.sqrt(Math.pow(centerX - obj.centerX, 2) + Math.pow(centerY - obj.centerY, 2));

		if(centersLength + radius < obj.radius){
			return 3;
		} else if (centerX == obj.centerX && centerY == obj.centerY && radius == obj.radius){
			return 0;
		} else if(centersLength + radius == obj.radius){
			return -2;
		} else if(centersLength > radius + obj.radius){
			return 2;
		} else if(centersLength == radius + obj.radius){
			return 1;
		} else {
			return -1;
		}
	}

	public String toString(){
		return "R = " + radius + ", координаты центра: (" + centerX + ", " + centerY + ")"; 
	}
}