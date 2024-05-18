public class Surgeon extends MedicalWorker{

	public void work(){
		System.out.println("Проведение операции");
	}

	public void teach(Intern i){
		i.study();
	}

}	