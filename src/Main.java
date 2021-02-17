import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hospitales hos;

		hos = new Hospitales();

		Hospital h;

		h = new Hospital("San Pedro", 3000000);

		Doctor d;

		d = new Doctor("47852478L", "Mario", "Carreras", "22", "pulmonology", 100, "08:00", "14:00");

		h.setMoney(h.getMoney() - 100000);

		h.checkSpecialitiesDoctor(d);

		Doctor d1;

		d1 = new Doctor("47872478L", "Pepe", "Garcia", "58", "cardiology", 10500, "14:00", "20:00");

		h.setMoney(h.getMoney() - 1050000);

		h.checkSpecialitiesDoctor(d1);

		Doctor d2;

		d2 = new Doctor("36985742Y", "Juan", "Rodriguez", "43", "pediatrics", 20000, "07:00", "13:00");

		h.setMoney(h.getMoney() - 20000);

		h.checkSpecialitiesDoctor(d2);

		Patient p;

		p = new Patient("78963587T", "145789653214", "Manolo", "Valer", "19", "679258741", "pediatrics");

		h.addPatient(p);

		Patient p1;

		p1 = new Patient("25686987E", "145398652349", "Javier", "Laorden", "35", "789652418", "pulmonology");

		h.addPatient(p1);

		Patient p2;

		p2 = new Patient("35987546W", "698532147856", "Andrea", "Cabral", "29", "698452176", "cardiology");

		h.addPatient(p2);

		hos.addHospital(hos.getNum(), h);

		hos.addPassword(hos.getNum(), "sanpedro");

		hos.setNum();

		menuHos(hos);

		// menu(h);

	}
	
	/*
	 * Crear un nuevo doctor
	 */

	public static void createNewDoctor(Hospital h) {

		Scanner sc = new Scanner(System.in);

		Scanner sca = new Scanner(System.in);

		String dni = null, nombre, apellido, especialidad, edad = null, hentrada, hsalida;

		double salario;

		System.out.println("Introduce el DNI");

		dni = sc.next();

		while (h.checkDNIDoc(dni) == false) {

			System.out.println("Introduce el DNI");

			dni = sc.next();

		}

		System.out.println("Introduce el nombre");

		nombre = sc.next();

		System.out.println("Introduce el apellido");

		apellido = sc.next();

		System.out.println("Introduce la especialidad");

		especialidad = sc.next();

		System.out.println("Introduce la edad");

		edad = sc.next();

		while (h.checkAge(edad) == false) {

			System.out.println("Introduce la edad");

			edad = sc.next();

		}

		System.out.println("Introduce el salario");

		salario = sca.nextDouble();

		System.out.println("Introduce la hora de entrada");

		hentrada = sc.next();

		System.out.println("Introduce la hora de salida");

		hsalida = sc.next();
		
		/*
		 * Comprueba si tenemos presupuesto para contratar al doctor
		 * Si el salario es mayor que el presupuesto no te deja
		 */

		if (h.getMoney() >= salario) {

			Doctor d = new Doctor(dni, nombre, apellido, edad, especialidad, salario, hentrada, hsalida);

			h.checkSpecialitiesDoctor(d);

			h.setMoney(h.getMoney() - salario);

		} else {

			System.out.println("No tienes presupuesto para contratar a mas doctores");

		}

	}
	
	/*
	 * Crear un nuevo paciente
	 */

	public static void createNewPatient(Hospital h) {

		Scanner sc = new Scanner(System.in);

		String dni = "", numss = "", nombre = null, apellido = null, telefono = "", enfermedad = null, edad = "";

		System.out.println("Introduce el DNI");

		dni = sc.next();

		while (h.checkDNIPatient(dni) == false) {

			System.out.println("Introduce el DNI");

			dni = sc.next();

		}

		System.out.println("Introduce el número de la SS");

		numss = sc.next();

		while (h.checkSS(numss) == false) {

			System.out.println("Introduce el número de la SS");

			numss = sc.next();

		}

		System.out.println("Introduce el nombre");

		nombre = sc.next();

		System.out.println("Introduce el apellido");

		apellido = sc.next();

		System.out.println("Introduce la edad");

		edad = sc.next();

		while (h.checkAge(edad) == false) {

			System.out.println("Introduce la edad");

			edad = sc.next();

		}

		System.out.println("Introduce el teléfono");

		telefono = sc.next();

		while (h.checkTlf(telefono) == false) {

			System.out.println("Introduce el teléfono");

			telefono = sc.next();

		}

		System.out.println("Introduce la enfermedad");

		enfermedad = sc.next();

		Patient p = new Patient(dni, numss, nombre, apellido, edad, telefono, enfermedad);

		h.addPatient(p);

	}
	
	/*
	 * Menu Hospitales
	 */

	public static void menu(Hospital h) {

		Scanner sc = new Scanner(System.in);

		Scanner sca = new Scanner(System.in);

		int opcion = 0;

		System.out.println("BIENVENIDO AL HOSPITAL " + h.getName());

		while (opcion != 13) {

			System.out.println(
					"AHORA HAY " + h.countDoctors() + " DOCTORES Y " + h.countSatispatient() + " PACIENTES ATENDIDOS ");

			System.out.println("Elige una de estas opciones:");
			System.out.println("1 - Registrar Paciente");
			System.out.println("2 - Registrar Doctor");
			System.out.println("3 - Modificar Paciente");
			System.out.println("4 - Modificar Doctor");
			System.out.println("5 - Pacientes");
			System.out.println("6 - Mostrar todos los Doctores");
			System.out.println("7 - Eliminar Doctor");
			System.out.println("8 - Atender un paciente");
			System.out.println("9 - Informacion de las enfermedades que se pueden atender");
			System.out.println("10 - Nueva Especialidad");
			System.out.println("11 - Horario disponible doctor");
			System.out.println("12 - Mostrar presupuesto");
			System.out.println("13 - Salir");

			opcion = sc.nextInt();

			if (opcion == 1) {

				createNewPatient(h);
			}

			if (opcion == 2) {

				createNewDoctor(h);
			}

			if (opcion == 3) {

				System.out.println("Introduce el DNI del Paciente");

				String dni = sca.nextLine();

				h.checkDNIpatient(dni);

			}

			if (opcion == 4) {

				System.out.println("Introduce el DNI del doctor");

				String dni = sca.nextLine();

				h.checkDNIdoctor(dni);
			}

			if (opcion == 5) {

				h.menuPatient();

			}

			if (opcion == 6) {

				h.showDoctors();

			}

			if (opcion == 7) {

				System.out.println("Introduce el DNI del doctor que quieres borrar");

				String dni = sca.nextLine();

				h.deleteDoctor(dni);

			}

			if (opcion == 8) {

				h.checkDiseasePatient();

			}

			if (opcion == 9) {

				h.infoSpecialities();

			}

			if (opcion == 10) {

				System.out.println("Introduce la nueva especialidad :");

				String specialidad = sca.nextLine();

				h.addSpecialiti(specialidad);

			}

			if (opcion == 11) {

				System.out.println("Introduce el dni del doctor");

				String dni2 = sca.nextLine();

				h.hourDoctors(dni2);

			}

			if (opcion == 12) {

				System.out.println("El hospital dispone de " + h.getMoney() + " €");
			}

			if (opcion == 13) {

				return;
			}

		}

	}
	
	/*
	 * Crear un hospital
	 */

	public static void createHospital(Hospitales hospi) {

		/* Solo podemos crear 5 hospitales */

		if (hospi.countHos() < 5) {

			Scanner scan = new Scanner(System.in);

			Scanner scanner = new Scanner(System.in);

			String nombre, password;

			int money;

			System.out.println("Introduce el nombre");

			nombre = scanner.nextLine();

			System.out.println("Introduce la contraseña");

			password = scanner.nextLine();

			System.out.println("Introduce el presupuesto");

			money = scan.nextInt();

			Hospital h = new Hospital(nombre, money);

			hospi.addHospital(hospi.getNum(), h);

			hospi.addPassword(hospi.getNum(), password);

			hospi.setNum();

		} else {

			System.out.println("Has creado el maximo de Hospitales");

		}
	}
	
	/*
	 * Menu principal
	 */

	public static void menuHos(Hospitales hospi) {

		Scanner enteros = new Scanner(System.in);

		Scanner numeros = new Scanner(System.in);

		System.out.println("Bienvenido a los Hospitales de Mario");

		int opcion = 0;

		while (opcion != 8) {

			System.out
					.println("EN ESTE MOMENTO DISPONEMOS DE " + hospi.countHos() + " HOSPITALES DONDE PODER ATENDERLE");

			System.out.println("<<LISTAR HOSPITALES POR NOMBRE>>");

			hospi.showHospitals();

			System.out.println("6 - Nuevo Hospital");

			System.out.println("7 - Eliminar Hospital");

			System.out.println("8 - Salir");

			System.out.println("ELIGE LA OPCIÓN QUE QUIERAS REALIZAR");

			opcion = numeros.nextInt();

			if (opcion == 1) {

				menu(hospi.getHospital(opcion));
			}

			if (opcion == 2) {

				menu(hospi.getHospital(opcion));
			}

			if (opcion == 3) {

				menu(hospi.getHospital(opcion));
			}

			if (opcion == 4) {

				menu(hospi.getHospital(opcion));
			}

			if (opcion == 5) {

				menu(hospi.getHospital(opcion));
			}

			if (opcion == 6) {

				createHospital(hospi);
			}

			if (opcion == 7) {

				hospi.showHospitals();

				System.out.println("Elige el Hospital que quieres borrar");

				int opcion2 = numeros.nextInt();

				hospi.removeHos(opcion2);

				hospi.setNum2();

				/* Tenemos tres intentos para introducir la contraseña */

			}

			if (opcion == 8) {

				return;
			}

		}

	}

}
