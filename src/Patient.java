import java.util.Iterator;
import java.util.Scanner;

public class Patient {

	private String DNI;
	private String ssn;
	private String name;
	private String lastname;
	private String age;
	private String phone;
	private String disease;

	public Patient(String dNI, String ssn, String name, String lastname, String age, String phone, String disease) {

		this.DNI = dNI;
		this.ssn = ssn;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.phone = phone;
		this.disease = disease;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	@Override
	public String toString() {
		return "Patient [DNI=" + DNI + ", ssn=" + ssn + ", name=" + name + ", lastname=" + lastname + ", age=" + age
				+ ", phone=" + phone + ", disease=" + disease + "]";
	}

	/*
	 * Elegir la opcion que quieres modificar del paciente
	 */

	public void modifyPatient() {

		toString();

		Scanner sc = new Scanner(System.in);

		System.out.println("Que datos quieres modificar:");
		System.out.println("Pulsa 1 : Modifica Nombre");
		System.out.println("Pulsa 2 : Modifica Apellido");
		System.out.println("Pulsa 3 : Modifica Edad");
		System.out.println("Pulsa 4 : Modifica Numero Seguridad Social");
		System.out.println("Pulsa 5 : Modifica Telefono");
		System.out.println("Pulsa 6 : Modifica Enfermedad");

		int opcion = sc.nextInt();

		Scanner sca = new Scanner(System.in);

		String nom;
		String ape;
		String edad;
		String nsocial;
		String tlf;
		String enfer;

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

			System.out.println("Introduce el nuevo numero de la SS");
			nsocial = sca.next();
			setSsn(nsocial);

		}

		if (opcion == 5) {

			System.out.println("Introduce el nuevo telefono");
			tlf = sca.next();
			setPhone(tlf);
		}

		if (opcion == 6) {

			System.out.println("Introduce la nueva enfermedad");
			enfer = sca.next();
			setDisease(enfer);

		}

	}

}
