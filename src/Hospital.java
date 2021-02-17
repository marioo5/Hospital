import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Hospital {

	private String name;
	private double money;
	private ArrayList<String> specialities = new ArrayList<String>();
	private ArrayList<Patient> patientsWait = new ArrayList<Patient>();
	private ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	private HashMap<Patient, Doctor> attendedPatients = new HashMap<Patient, Doctor>();
	private ArrayList<Patient> disattendedPatients = new ArrayList<Patient>();

	public Hospital(String name, int money) {

		this.name = name;
		this.money = money;
		this.specialities.add("dermatology");
		this.specialities.add("cardiology");
		this.specialities.add("pulmonology");
		this.specialities.add("pediatrics");
		this.specialities.add("traumatology");

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public ArrayList<String> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(ArrayList<String> specialities) {
		this.specialities = specialities;
	}

	public ArrayList<Patient> getPatients() {
		return patientsWait;
	}

	public void setPatients(ArrayList<Patient> patients) {
		this.patientsWait = patients;
	}

	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(ArrayList<Doctor> doctors) {
		this.doctors = doctors;
	}

	public ArrayList<Patient> getDisattendedPatients() {
		return disattendedPatients;
	}

	public void setDisattendedPatients(ArrayList<Patient> disattendedPatients) {
		this.disattendedPatients = disattendedPatients;
	}

	@Override
	public String toString() {
		return "Hospital [name=" + name + ", money=" + money + ", specialities=" + specialities + ", patients="
				+ patientsWait + ", doctors=" + doctors + "]";
	}

	/*
	 * Este método comprueba, si el doctor que vamos a añadir, su especialidad es de
	 * las que atendemos en el Hospital y si es correcta añade el Doctor al Hospital
	 */

	public void checkSpecialitiesDoctor(Doctor doc) {

		for (Iterator iterator = specialities.iterator(); iterator.hasNext();) {
			String disease = (String) iterator.next();

			if (disease.equals(doc.getSpeciality())) {

				doctors.add(doc);
				System.out.println("Se ha añadido correctamente");
				return;
			}

		}

		System.out.println("En este hospital no atendemos esas enfermedades");

	}

	/*
	 * Va a mostrar las especialidades que se pueden atender y las que no han podido
	 * ser atendidas
	 */

	public void infoSpecialities() {

		Scanner sc = new Scanner(System.in);

		int opcion = 0;

		while (opcion != 3) {

			System.out.println("Elige una de estas opciones:");
			System.out.println("1 - Listar especialidades que se pueden atender");
			System.out.println("2 - Listar especialidades que no se han podido atender");
			System.out.println("3 - Salir");

			opcion = sc.nextInt();

			if (opcion == 1) {

				for (Iterator iterator = doctors.iterator(); iterator.hasNext();) {
					Doctor doctor = (Doctor) iterator.next();

					System.out.println("Podemos atender en el Hospital " + getName() + " la especialidad : "
							+ doctor.getSpeciality());

				}

			}

			if (opcion == 2) {

				for (Iterator iterator = disattendedPatients.iterator(); iterator.hasNext();) {
					Patient patient = (Patient) iterator.next();

					System.out.println("Esta enfermedad no se puede atender : " + patient.getDisease());

				}

			}

			if (opcion == 3) {

				return;

			}

		}

	}

	/*
	 * Vamos a crear un método que comprueba si el paciente puede ser atendido y lo
	 * añade a la lista de atendidos, Sino le dice que no puede y lo añade a la
	 * lista de no atendidos
	 */

	public void checkDiseasePatient() {

		if (patientsWait == null || patientsWait.size() == 0) {

			System.out.println("No quedan mas pacientes por atender");
		}

		else {

			Patient p = patientsWait.get(0);
			boolean atendido = false;

			for (Iterator iterator = doctors.iterator(); iterator.hasNext();) {
				Doctor doctor = (Doctor) iterator.next();

				if (p.getDisease().equals(doctor.getSpeciality())) {

					System.out.println("Hola, podras ser atendido por el Doctor: " + doctor.getName() + " "
							+ doctor.getLastname());
					atendido = true;
					attendedPatients.put(p, doctor);
					break;

				}

			}

			if (atendido == false) {
				System.out.println("Hoy no es posible atender a este paciente en este hospital. Lo siento mucho.");
				disattendedPatients.add(p);
			}

			patientsWait.remove(p);

		}

	}

	/* Añade pacientes al arrayList de pacientes en espera */

	public void addPatient(Patient p) {

		patientsWait.add(p);
	}

	/* Añade doctores al arrayList de doctores */

	public void addDoctor(Doctor doc) {

		doctors.add(doc);
	}

	/*
	 * Añade una especialidad al hospital
	 */

	public void addSpecialiti(String specia) {

		for (Iterator iterator = specialities.iterator(); iterator.hasNext();) {
			String disease = (String) iterator.next();

			if (disease.equals(specia)) {

				System.out.println("Esa especialidad ya existe en el hospital");
				return;
			}

		}

		specialities.add(specia);

	}

	/* Elimina doctores del hospital, comprobando el dni */

	public void deleteDoctor(String dni) {

		for (Iterator iterator = doctors.iterator(); iterator.hasNext();) {
			Doctor doctor = (Doctor) iterator.next();

			if (dni.equals(doctor.getDNI())) {

				doctors.remove(doctor);
				return;
			}

		}

		System.out.println("No existe un doctor en el Hospital con ese DNI");

	}

	/*
	 * Muestra el número de doctores que hay en el hospital
	 */

	public int countDoctors() {

		return doctors.size();

	}

	/*
	 * Muestra el número de clientes satisfechos (que han sido atendidos por un
	 * doctor)
	 */

	public int countSatispatient() {

		return attendedPatients.size();

	}

	/*
	 * Muestra los doctores que estan en el hospital
	 */

	public void showDoctors() {

		for (Iterator iterator = doctors.iterator(); iterator.hasNext();) {
			Doctor doctor = (Doctor) iterator.next();

			System.out.println(doctor);

		}

	}

	/*
	 * Muestra los pacientes que estan en espera
	 */

	public void showPatients() {

		for (Iterator iterator = patientsWait.iterator(); iterator.hasNext();) {
			Patient paciente = (Patient) iterator.next();

			System.out.println(paciente);

		}

	}

	/*
	 * Muestra los pacientes atendidos
	 */

	public void showPatientsAttend() {

		for (Map.Entry<Patient, Doctor> entry : attendedPatients.entrySet()) {

			System.out.println("Paciente =" + entry.getKey() + ", Doctor=" + entry.getValue());
		}

	}

	/*
	 * Muestra los pacientes que han sido atendidos by a Doctor, introduciendo el
	 * dni
	 */

	public void showPatientsAttendDoc(String dni) {

		for (Map.Entry<Patient, Doctor> entry : attendedPatients.entrySet()) {

			if (dni.equals(entry.getValue().getDNI())) {

				System.out.println(entry.getKey());
				return;
			}
		}

		System.out.println("El dni no coincide con el del doctor");

	}
	/*
	 * Muestra los pacientes que no han podido ser atendidos
	 */

	public void showPatientsdisAttend() {

		for (Iterator iterator = disattendedPatients.iterator(); iterator.hasNext();) {
			Patient paciente = (Patient) iterator.next();

			System.out.println(paciente);

		}

	}

	/*
	 * Menu, que te muestra todos los tipos de pacientes
	 */

	public void menuPatient() {

		Scanner sc = new Scanner(System.in);

		Scanner sca = new Scanner(System.in);

		int opcion = 0;

		while (opcion != 5) {

			System.out.println("Elige una de estas opciones:");
			System.out.println("1 - Listar pacientes atendidos");
			System.out.println("2 - Listar pacientes atendidos por un Doctor");
			System.out.println("3 - Listar pacientes en espera");
			System.out.println("4 - Listar pacientes que no han podido ser atendidos");
			System.out.println("5 - Salir");

			opcion = sc.nextInt();

			if (opcion == 1) {

				showPatientsAttend();
			}

			if (opcion == 2) {

				System.out.println("Introduce el DNI del Doctor");

				String dni = sca.nextLine();

				showPatientsAttendDoc(dni);
			}

			if (opcion == 3) {

				showPatients();

			}

			if (opcion == 4) {

				showPatientsdisAttend();
			}

			if (opcion == 5) {

				return;

			}

		}

	}

	/*
	 * Comprueba que existe un doctor con el dni que introduzcamos En caso de
	 * coincidir nos deja modificarlo
	 */

	public void checkDNIdoctor(String dni) {

		for (Iterator iterator = doctors.iterator(); iterator.hasNext();) {
			Doctor doctor = (Doctor) iterator.next();

			if (dni.equals(doctor.getDNI())) {

				doctor.modifyDoctor();
				return;
			}

		}

		System.out.println("No existe un doctor en el Hospital con ese DNI");

	}

	/*
	 * Comprueba que exista un paciente con ese dni En ese caso te permite modificar
	 * el paciente
	 */

	public void checkDNIpatient(String dni) {

		for (Iterator iterator = patientsWait.iterator(); iterator.hasNext();) {
			Patient patient = (Patient) iterator.next();

			if (dni.equals(patient.getDNI())) {

				patient.modifyPatient();
				return;

			}

		}

		System.out.println("No existe un paciente en el Hospital con ese DNI");

	}

	/*
	 * Comprueba que el dni es valido, que son 8 numeros y un numero, y no existe un
	 * doctor con ese dni
	 */

	public boolean checkDNIDoc(String dni) {

		for (Iterator iterator = doctors.iterator(); iterator.hasNext();) {
			Doctor doctor = (Doctor) iterator.next();

			if (dni.equals(doctor.getDNI())) {

				System.out.println("Ya existe un usuario con ese dni");
				return false;
			}

		}

		if (dni.length() == 9 && isNumeric(dni.substring(0, 8)) && Character.isLetter(dni.charAt(8))) {

			return true;

		} else {

			System.out.println("El dni introducido no es valido");
			return false;

		}

	}

	/*
	 * Comprueba que el dni es valido y no coincide con alguno de los creados
	 */

	public boolean checkDNIPatient(String dni) {

		for (Iterator iterator = patientsWait.iterator(); iterator.hasNext();) {
			Patient patient = (Patient) iterator.next();

			if (dni.equals(patient.getDNI())) {

				System.out.println("Ya existe un usuario con ese dni");
				return false;
			}

		}

		if (dni.length() == 9 && isNumeric(dni.substring(0, 8)) && Character.isLetter(dni.charAt(8))) {

			return true;

		} else {

			System.out.println("El dni introducido no es valido");
			return false;

		}

	}

	/*
	 * Comprueba que el numero de la ss es valido
	 */

	public boolean checkSS(String ss) {

		for (Iterator iterator = patientsWait.iterator(); iterator.hasNext();) {
			Patient patient = (Patient) iterator.next();

			if (ss.equals(patient.getSsn())) {

				System.out.println("Ya existe un paciente con ese número de la SS");
				return false;
			}

		}

		if (ss.length() == 12 && isNumeric(ss)) {

			return true;

		}

		else {

			System.out.println("El número de la seguridad social no es válido");
			return false;

		}

	}

	/*
	 * Comprueba que la edad es valida
	 */

	public boolean checkAge(String age) {

		if ((age.length() == 1 && isNumeric(age)) || (age.length() == 2 && isNumeric(age))
				|| (age.length() == 3 && isNumeric(age)) && Integer.parseInt(age) <= 110) {

			return true;

		} else {

			System.out.println("La edad introducida no es valida");
			return false;

		}

	}

	/*
	 * Comprueba que el número de tlf es valido
	 */

	public boolean checkTlf(String tlf) {

		if ((tlf.charAt(0) == '6' && tlf.length() == 9 && isNumeric(tlf))
				|| (tlf.charAt(0) == '7' && tlf.length() == 9 && isNumeric(tlf))) {

			return true;

		} else {

			System.out.println("El telefono introducido no es correcto");
			return false;

		}

	}

	/*
	 * Introduciendo el dni de un doctor te dice sus horas disponibles
	 */

	public void hourDoctors(String dni) {

		for (Iterator iterator = doctors.iterator(); iterator.hasNext();) {
			Doctor doctor = (Doctor) iterator.next();

			if (dni.equals(doctor.getDNI())) {

				System.out.println("El doctor " + doctor.getName() + " esta disponible de " + doctor.getHourBegin()
						+ " a " + doctor.getHourEnd());
				return;
			}

		}

		System.out.println("No existe un doctor en el Hospital con ese DNI");

	}

	/*
	 * Funcion externa, comprueba si un string es un numero
	 */

	public static boolean isNumeric(String cadena) {

		boolean resultado = false;

		for (int i = 0; i < cadena.length(); i++) {

			try {
				Integer.parseInt(cadena.charAt(i) + "");
				resultado = true;
			} catch (NumberFormatException excepcion) {
				return false;
			}

		}
		return resultado;

	}

}
