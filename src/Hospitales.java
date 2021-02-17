import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hospitales {

	private int num = 1;
	private HashMap<Integer, Hospital> hospitals = new HashMap<Integer, Hospital>();
	private HashMap<Integer, String> passwords = new HashMap<Integer, String>();

	public Hospitales() {
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum() {
		this.num++;
	}

	public void setNum2() {
		this.num--;

	}

	public HashMap<Integer, Hospital> getHospitals() {
		return hospitals;
	}

	public void setHospitals(HashMap<Integer, Hospital> hospitals) {
		this.hospitals = hospitals;
	}

	public HashMap<Integer, String> getPasswords() {
		return passwords;
	}

	public void setPasswords(HashMap<Integer, String> passwords) {
		this.passwords = passwords;
	}

	public int countHos() {

		return hospitals.size();
	}

	public void addHospital(int num, Hospital hos) {

		hospitals.put(num, hos);
	}

	public void addPassword(int num, String pass) {

		passwords.put(num, pass);

	}

	public void deleteHospital(int num) {

		hospitals.remove(num);

	}
	
	/*
	 * Recorre el hasmap de hospitales y te los muestra
	 */

	public void showHospitals() {

		for (Map.Entry<Integer, Hospital> entry : hospitals.entrySet()) {

			System.out.println(entry.getKey() + " - " + "Nombre = " + entry.getValue().getName());
		}

	}
	
	/*
	 * Recorre el hasmap de contraseñas y saca la contraseña que coincide con esa key
	 */

	public String getPass(int num) {

		for (Map.Entry<Integer, String> entry : passwords.entrySet()) {

			if (entry.getKey() == num) {

				return entry.getValue();
			}

		}
		return null;

	}
	
	/*
	 * Recorre el hasmap de hospitals y te saca el hospital del que coincida con esa key
	 */

	public Hospital getHospital(int num) {

		for (Map.Entry<Integer, Hospital> entry : hospitals.entrySet()) {

			if (num == entry.getKey()) {

				return entry.getValue();
			}

		}
		return null;

	}
	
	/*
	 * Nos sirve para borrar Hospitales, cuando coincide la contraseña, tienes 3 intentos
	 */

	public void removeHos(int num) {

		int cont = 0;

		Scanner contrasena = new Scanner(System.in);

		while (cont < 3) {

			System.out.println("Introduce la contraseña del Hospital");

			String pass = contrasena.next();

			if (pass.equals(getPass(num))) {

				deleteHospital(num);
				return;

			}

			cont++;
			System.out.println("La contraseña no es correcta");

		}
	}

}
