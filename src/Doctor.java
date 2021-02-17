import java.util.Scanner;

public class Doctor {

	private String DNI;
	private String name;
	private String lastname;
	private String age;
	private String speciality;
	private double salary;
	private String hourBegin;
	private String hourEnd;

	public Doctor(String dNI, String name, String lastname, String age, String speciality, double salary,
			String hourBegin, String hourEnd) {

		this.DNI = dNI;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.speciality = speciality;
		this.salary = salary;
		this.hourBegin = hourBegin;
		this.hourEnd = hourEnd;

	}

	public String getHourBegin() {
		return hourBegin;
	}

	public void setHourBegin(String hourBegin) {
		this.hourBegin = hourBegin;
	}

	public String getHourEnd() {
		return hourEnd;
	}

	public void setHourEnd(String hourEnd) {
		this.hourEnd = hourEnd;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Doctor [DNI=" + DNI + ", name=" + name + ", lastname=" + lastname + ", age=" + age + ", speciality="
				+ speciality + ", salary=" + salary + ", hourBegin=" + hourBegin + ", hourEnd=" + hourEnd + "]";
	}
	
	/*
	 * Modifica los campos del doctor, indicandole a traves de un scanner la opcion que quieres modificar
	 */

	public void modifyDoctor() {

		toString();

		Scanner sc = new Scanner(System.in);

		System.out.println("Que datos quieres modificar:");
		System.out.println("Pulsa 1 : Modifica Nombre");
		System.out.println("Pulsa 2 : Modifica Apellido");
		System.out.println("Pulsa 3 : Modifica Edad");
		System.out.println("Pulsa 4 : Modifica Especialidad");
		System.out.println("Pulsa 5 : Modifica Salario");
		System.out.println("Pulsa 6 : Modifica Hora Entrada");
		System.out.println("Pulsa 7 : Modifica Hora Salida");

		int opcion = sc.nextInt();

		Scanner sca = new Scanner(System.in);

		String nom;
		String ape;
		String edad;
		String especialidad;
		double salario;
		String hent;
		String hsal;

		if (opcion == 1) {

			System.out.println("Introduce el nuevo nombre");
			nom = sca.next();
			setName(nom);

		}

		if (opcion == 2) {

			System.out.println("Introduce el nuevo apellido");
			ape = sca.next();
			setLastname(ape);

		}

		if (opcion == 3) {

			System.out.println("Introduce la nueva edad");
			edad = sca.next();
			setAge(edad);

		}

		if (opcion == 4) {

			System.out.println("Introduce la nueva especialidad");
			especialidad = sca.next();
			setSpeciality(especialidad);

		}

		if (opcion == 5) {

			System.out.println("Introduce el nuevo salario");
			salario = sc.nextDouble();
			setSalary(salario);
		}
		
		if (opcion == 6) {

			System.out.println("Introduce la nueva hora de entrada");
			hent = sca.next();
			setHourBegin(hent);
		}
		
		if (opcion == 7) {

			System.out.println("Introduce el nuevo salario");
			hsal = sca.next();
			setHourEnd(hsal);
		}

	}

}
