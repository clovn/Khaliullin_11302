public class Adapter implements IC{
	ID d;

	public Adapter(ID d){
		this.d = d;
	}

	void f(){
		d.h();
	}

	void g(){
		d.q();
	}
}