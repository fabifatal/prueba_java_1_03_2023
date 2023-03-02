package com.evaluacionjava.fabian_zuniga_evaluacion_java;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.evaluacionjava.fabian_zuniga_evaluacion_java.models.Nombre;
import com.evaluacionjava.fabian_zuniga_evaluacion_java.models.Materia;
import com.evaluacionjava.fabian_zuniga_evaluacion_java.models.Profesor;
import com.evaluacionjava.fabian_zuniga_evaluacion_java.models.Alumno;
import com.evaluacionjava.fabian_zuniga_evaluacion_java.models.Curso;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;


@SpringBootApplication
public class FabianZunigaEvaluacionJavaApplication {
	/* 							Caso Práctico

	Te contactaron desde un colegio municipal para que los ayudes a generar un software
	pensando en ordenar su funcionamiento, este colegio siempre a funcionado de manera análoga
	por 20 años y esto ha generado errores de pérdidas de datos de alumnos antiguos,
	documentos estropeados y nula posibilidad de generar estadísticas de rendimiento del colegio.
	En esta instancia tu tarea será generar los objetos necesarios para cubrir las necesidades del
	colegio, utilizando herencia.
	Además debes generar 3 funciones distintas que te ayudarán a los distintos procesos del
	colegio
	Puntos a considerar:
	● El colegio cuenta con distintos cursos, profesores, materias y alumnos
	● Se debe crear una función que permita al profesor ingresar notas por estudiante y que
	luego permita obtener el promedio de cada estudiante.
	● Se debe crear una función que permita guardar un arreglo de una cierta cantidad de
	alumnos por curso y que luego los muestre.
	● Se debe crear una función que dado un arreglo de notas obtenga la mejor nota, la peor
	nota y el promedio de notas.
	Puntos a evaluar:
	● Creación de objetos pertinentes al caso.
	● Creación de funciones.
	● Proyecto funcional.
	● Debes enviar el link de tu repositorio con el script correspondiente al correo
	generation.chilec4@gmail.com con el siguiente asunto
	○ Evaluación JAVA Objetos - <Nombre Apellido>*/


	/*
	000000	00   00	 0000000  00      00  000000  0000000	
	00		 00 00	 00   00  00	  00  00	  00   00
	000000	  000 	 0000000  00	  00  00      0000000
	00		 00 00	 00		  00      00  00	  00   00
	000000	00	 00	 00		  000000  00  000000  00   00
	 */

	/*
	Para abordar el ejercicio analicé los cuatro elementos base (cursos, profesores, materias y alumnos)
	y encontré que tenían en común el elemento nombre, por lo que cree una clase padre que se llamara así.
	Curso --> Además del nombre, posee un Array de Alumnos, lo que nos permitirá iterar sobre este de mejor manera.
	Alumno --> Además del nombre, posee un HashMap que asocia Materia con un Array de notas. Si bien esta clase me dio
		variosdolores de cabeza, fue muy util para guardar información compleja y dar alternativas a la hora de mostrar
		la información.
	Materia --> Además del nombre, tiene asociado un Profesor, el cuál nunca fue usado. 
	Finalmente la clase profesor no le encontré utilidad en el proyecto con el tiempo que me demoré,
	pero se podría incluir en el futuro para obtener resultados cómo desempeño de las Materias que imparte u otros tipos
	de operaciones y funciones.

	Los métodos fueron utilizados en las clases Alumno y Curso, que guardaban el grueso de la información.
	En el trancurso de la creación de este programa quedaron métodos sin utilizar o que se podrían utilizar en una versión
	posterior de este código. Asi mismo, me parece que hay uno dos métodos que repiten su función, pero por miedo a que se caiga
	el código he decidido mantenerlo allí hasta el momento en que pueda tener un tranquilo prueba y error que permita limipar
	de mejor manera este repositorio.

	Decidí crear funciones que agilizaran el ingresar información por terminal y también para momentos dónde debía determinar
	un número mínimo y máximo para ingresar una opción.
	
	Luego, definí funciones que permitieran al usuario crear Cursos, Alumnos y Materia a voluntad, para lo que me serví principalmente
	de Arrays de cada una de estas clases.

	Posteriormente cree las funciones que me permitirían acceder a los cursos, alumnos y materias, como si de carpetas se tratasen.
	
	Finalmente definí las notas que estarían en el menú y que asumí que funcionarían de forma más global en el programa y que
	no ameritaban para crearlas como métodos. Sin embargo, en la última revisión de este código, me doy cuenta que probablemente
	las funciones de menor y mayor nota podrían incluirse tanto en la clase Curso como la de Alumno.
	
	Espero que programa cumpla con lo requerido y un poco más. Lamento haber dejado elementos del código que no fueron usados o
	que no están debidamente comentados.

	Para terminar, me gustaría comentar que si el método de prueba de este programa vía terminal se vuelve engorroso, hay distintos
	fragmentos de código comentados (y debidamente indicados) que sirven para hacer versiones de prueba sin tener que ingresar cada
	nota por separado (por ejemplo).

	Muchas gracias por todo! <3 

	FabiFatal.

	*/ 
	
	//--------------------------Funciones para ingresar datos por teclado---------------------
	public static int intIn (String consulta){
		Scanner teclado = new Scanner (System.in);
		System.out.println(consulta);
		int num = teclado.nextInt();
		return num;
	}
	public static double doubleIn (String consulta){
		Scanner teclado = new Scanner (System.in);
		System.out.println(consulta);
		double num = teclado.nextDouble();
		return num;
	}
	public static String strIn (String consulta){
		Scanner teclado = new Scanner (System.in);
		System.out.println(consulta);
		String str = teclado.nextLine();
		return str;
	}
	public static int intInMinMax (String texto, int min, int max, int breakLoop){
		int opcion;
		do {
			opcion = intIn(texto);
			if (opcion == breakLoop){
				break;
			}else if (opcion < min || opcion > max){
				System.out.println("La opción debe ser mayor o igual a "+min+" y menor o igual a "+max+".");
			}
		}while (opcion < min || opcion > max);
		return opcion;
	}
	//-------------------------------------------------------------------
	

	
	//---------------Funciones Configuración Colegio-------------------

	//Ingreso curso
	public static ArrayList <Curso> inCursos (int cantCursos){
		ArrayList <Curso> cursosArray = new ArrayList<>();
		ArrayList <Alumno> alumArray = new ArrayList<>();
		for (int i = 0; i < cantCursos ; i++){
			String nomCurso = strIn("Ingrese el nombre del curso: ");
			Curso curso = new Curso(nomCurso,alumArray);
			cursosArray.add(curso);
		}
		return cursosArray;
	}

	//Ingreso alumnos
	public static ArrayList <String> inAlum(int cantAlum){
		ArrayList <String> alumArray = new ArrayList<>();
		for (int i = 0; i < cantAlum ; i++){
			String nomAlum = strIn("Ingrese nombre de alumno "+(i+1));
			alumArray.add(nomAlum);
		}
		return alumArray;
	}

	//Ingreso Materia
	public static ArrayList <Materia> inMateria (int cantMateria){
		ArrayList <Materia> materiaArray = new ArrayList<>();
		Profesor profesor = new Profesor();
		for (int i = 0; i < cantMateria ; i++){
			String nomMateria = strIn("Ingrese el nombre de la materia: ");
			Materia materia = new Materia(nomMateria, profesor);
			materiaArray.add(materia);
		}
		return materiaArray;
	}

	//Ingreso notas
	public static ArrayList <Double> inNotas(Curso curso, Alumno alumno, Materia materia){
		int cantNotas = intIn("¿Cuántas notas deseas registrar para "+alumno.getNombre()
		+" del curso "+curso.getNombre()+" en la asignatura de "+materia.getNombre()+"?");
		ArrayList <Double> notasArray = new ArrayList<>();
		for (int i = 0 ; i < cantNotas ; i++){
			Double nota = 0.0;
			while (nota < 1 || nota > 7){
				nota = doubleIn("Ingrese nota "+(i+1));
				if (nota < 1 || nota > 7){
					System.out.print("La nota no puede ser menor a 1 ni mayor a 7. Intente de nuevo, por favor.");
				}
			}
			notasArray.add(nota);
		}
		return notasArray;
	}
	//-------------------------------------------------------------------

	//---------Codigos por probar/mejorar--------------------
	//----------Ingreso notas formato HashMap que no funcionó------------
	// public static HashMap <String, ArrayList<Double>> inNotaAlumno(){
	// 	int cantAlumnos = intInMinMax ("¿Cuántos alumnos hay en el curso?", 1, 50, 1212);
	// 	HashMap <String, ArrayList<Double>> nombreYNotas = new HashMap <String, ArrayList<Double>>();
	// 	int cantNotas = intInMinMax("Ingrese la cantidad de notas por alumnos.",1,50,1212);
	// 	for (int i = 0 ; i < cantAlumnos ; i++){
	// 		ArrayList <Double> arrayNotas = new ArrayList<Double>();
	// 		String nombreAlumno = strIn("Ingresa nombre alumno "+(i+1)+": ");
	// 		for (int x = 1; x <= cantNotas ; x++){
	// 			Double nota = doubleIn("Ingresa nota "+x+" de "+nombreAlumno+": ");
	// 			arrayNotas.add(nota);
	// 		}
	// 		nombreYNotas.put(nombreAlumno,arrayNotas);
	// 	}
	// 	return nombreYNotas;
	// }

	//-------POSIBLE FUNCIÓN QUE RELACIONE PROFESOR CON MATERIA QUE NO ALCANCÉ A DESARROLLAR--------
	// public static HashMap <Profesor, Materia> inProfMateria (int cantMateria){
	// 	HashMap <Profesor, Materia> profMateria = new HashMap<>(); 
	// 	for (int i = 0; i < cantMateria ; i++){
	// 		String nomMateria = strIn("Ingrese el nombre de la materia "+(i+1));
	// 		String nomProf = strIn("Ingrese el nombre del profesor de "+ nomMateria);
	// 		Profesor profesor = new Profesor(nomProf); 
	// 		Materia materia = new Materia(nomMateria, nomProf);
	// 		profMateria.put(profesor,materia);
	// 	}
	// 	return profMateria;
	// }
	//----------------------------------------------------------------------------
		
	
	//-----------------Funciones Para Escoger-------------------------

	public static Curso escogerCurso (ArrayList <Curso> arrayCursos){
		System.out.println("Escoja el curso al desea acceder");
		for (int i = 0; i < arrayCursos.size() ; i++){
			System.out.println((i+1)+") "+arrayCursos.get(i).getNombre());
		}
		int accesCurso = (intInMinMax("Ingresa número de opcion ", 1, arrayCursos.size(), 1234))-1;
		Curso cursoEscogido = arrayCursos.get(accesCurso);
		return cursoEscogido;
	}

	public static Alumno escogerAlumno(Curso curso) {
		System.out.println("Escoja el alumno al que desea acceder");
		for (int i = 0; i < curso.getAlumnos().size(); i++){
			System.out.println((i+1)+") "+curso.getAlumnos().get(i).getNombre());
		}
		int accesAlum = (intInMinMax("Ingresa número de opcion ", 1, curso.getAlumnos().size(), 1234))-1;
		Alumno alumnoEscogido = curso.getAlumnos().get(accesAlum);
		return alumnoEscogido;
	}

	public static Materia escogerMateria(ArrayList <Materia> arrayMateria){
		System.out.println("Escoja la materia a la que desea acceder");
		for (int i = 0; i < arrayMateria.size(); i++){
			System.out.println((i+1)+") "+arrayMateria.get(i).getNombre());
		}
		int accesMateria = (intInMinMax("Ingresa número de opcion ", 1, arrayMateria.size(), 1234))-1;
		Materia materiaEscogida = arrayMateria.get(accesMateria);
		return materiaEscogida;
	} 
	//-------------------------------------------------------------------
	

	//------------Funciones Menú---------------------------------------

	

	public static double promedio (ArrayList <Double> notas){
		Double sumaNotas = 0.0;
		for (int i = 0 ; i < notas.size() ; i++){
			sumaNotas = sumaNotas + notas.get(i);
		}
		return  sumaNotas / notas.size();
	}
	public static void notaMenorCurso(HashMap <Alumno, Double> alumnoYPromedio, Curso curso) {
		Double notaMenor = alumnoYPromedio.get(curso.getAlumnos().get(0));
		String alumnoMenor = curso.getAlumnos().get(0).getNombre();
		for (Alumno i : alumnoYPromedio.keySet()){
			if (alumnoYPromedio.get(i) < notaMenor){
				notaMenor = alumnoYPromedio.get(i);
				alumnoMenor = i.getNombre();
			}
		}
		System.out.println("La nota menor del curso es de "+alumnoMenor+" ("+notaMenor+")");
	}
	public static void notaMayorCurso(HashMap <Alumno, Double> alumnoYPromedio, Curso curso) {
		Double notaMayor = alumnoYPromedio.get(curso.getAlumnos().get(0));
		String alumnoMayor = curso.getAlumnos().get(0).getNombre();
		for (Alumno i : alumnoYPromedio.keySet()){
			if (alumnoYPromedio.get(i) > notaMayor){
				notaMayor = alumnoYPromedio.get(i);
				alumnoMayor = i.getNombre();
			}
		}
		System.out.println("La nota mayor del curso es de "+alumnoMayor+" ("+notaMayor+")");
	}
	
	//----------------------------------------------------------------

	/*Estas funciones servirían para obtener la nota menor de un array de notas,
	 * cómo podría haber sido sacar la menor nota de un ramo de un alumno.
	 * Lamentablemente al intentar implementarlo a veces funcionaba y a veces no.
	 * Si el tiempo lo permite intentaré mejorarlo en el futuro.
	*/
	// public static Double notaMenor (ArrayList <Double> notasArray){
	// 	Double notaMenor = notasArray.get(0);
	// 	for (int i = 0; i < notasArray.size() ; i++){
	// 		if (notasArray.get(i) < notaMenor){
	// 			notaMenor = notasArray.get(i);
	// 		}
	// 	}
	// 	return notaMenor;
	// }
	// public static Double notaMayor (ArrayList <Double> notasArray){
	// 	Double notaMayor = notasArray.get(0);
	// 	for (int i = 0; i < notasArray.size() ; i++){
	// 		if (notasArray.get(i) < notaMayor){
	// 			notaMayor = notasArray.get(i);
	// 		}
	// 	}
	// 	return notaMayor;
	// }
	//------------------------------------------------------------------


	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		//..................PRESENTACIÓN PROGRAMA...........................
		String logo =    "000000   0000000   00      000000   0000000	00 	 000000\n"
						+"00       00   00   00      00       00		00	 00  00\n"
						+"00       00   00   00      000000   00  0000	00	 00  00\n"
						+"00       00   00   00      00       00    00	00	 00  00\n"
						+"000000   0000000   000000  000000   00000000	00	 000000\n";
		System.out.println(logo);
		System.out.println("_____________________________________________\n");

		//..................CONFIGURACIÓN INICIAL COLEGIO...........................
		// System.out.println("Configuración establecimiento educacional.\n");

		//*********Creación de cursos*********
		int cantCursos = intIn("Ingrese la cantidad de cursos que desea registrar: ");
		ArrayList <Curso> cursosColegio = new ArrayList<>();
		cursosColegio = inCursos(cantCursos);

		//*********Creación de alumnos por curso*********
		for (int i = 0 ; i < cursosColegio.size() ; i++){
			ArrayList <Alumno> alumnos = new ArrayList<>();
			int cantAlum = intIn("¿Cuántos alumnos hay en el curso "+cursosColegio.get(i).getNombre()+"? ");
			for (int j = 0 ; j < cantAlum ; j++){
				HashMap <Materia, ArrayList <Double>> notaMateria = new HashMap<>();
				Alumno alumno = new Alumno(null,cursosColegio.get(i),notaMateria);
				String nomAlum = strIn("Indique nombre de alumno "+(j+1));
				alumno.setNombre(nomAlum);
				alumnos.add(alumno);
			}
			cursosColegio.get(i).setAlumnos(alumnos);
		}
		//*********Creación de materias*********
		int cantMateria = intIn("¿Cuantás materias se imparten en el establecimiento?");
		ArrayList <Materia> materiasColegio = new ArrayList<>();
		materiasColegio = inMateria(cantMateria);
		//---------------------Comentar hasta aquí si NO desea usar terminal----------------------------------

		//----------CODIGO DE PRUEBA PARA NO INGRESAR DATOS POR TERMINAL------
		// ArrayList <Curso> cursosColegio = new ArrayList<>();
		// ArrayList <Alumno> alumnosBasico = new ArrayList<>();
		// ArrayList <Alumno> alumnosAvanzado = new ArrayList<>();
		// Curso Basico = new Curso();
		// Curso Avanzado = new Curso();
		// cursosColegio.add(Basico);
		// cursosColegio.add(Avanzado);
		// Alumno Pedro = new Alumno("Pedro",Basico,null);
		// Alumno Juan = new Alumno("Juan",Basico,null);
		// Alumno Diego = new Alumno("Diego",Basico,null);
		// alumnosBasico.add(Pedro);
		// alumnosBasico.add(Juan);
		// alumnosBasico.add(Diego);
		// Basico.setAlumnos(alumnosBasico);
		// Alumno Maria = new Alumno("Maria",Avanzado,null);
		// Alumno Belen = new Alumno("Belen",Avanzado,null);
		// alumnosAvanzado.add(Maria);
		// alumnosAvanzado.add(Belen);
		// Avanzado.setAlumnos(alumnosAvanzado)
		// ArrayList <Materia> materiasColegio = new ArrayList<>();
		// Materia lenguaje = new Materia();
		// lenguaje.setNombre("Lenguaje");
		// Materia matematica = new Materia();
		// matematica.setNombre("Matematica");
		// materiasColegio.add(lenguaje);
		// materiasColegio.add(matematica);
		//------LAS NOTAS SE REGISTRAN ACTIVANDO EL CODIGO EN OPCION 1---------
		//---------------------------------------------------------------------

		System.out.println("\n_____________________________________________\n");

		//..................MENÚ PRINCIPAL...........................
		System.out.println(logo);
		String textoMenu = "\n¿Que desea realizar?\n"
						  +"\n1) Registrar notas.\n"
						  +"2) Mostrar notas.\n"
						  +"3) Mostrar nota más baja, alta y promedio.\n"
						  +"4) Mostrar alumnos por curso.\n"
						  +"\nIngrese un 0 si desea salir\n";
		int opcion = 1;
		do {
			int subopcion = 1;
			System.out.println(textoMenu);
			opcion = intInMinMax("Ingrese el número de opción:",1, 5, 0);
			System.out.println("_____________________________________________\n");
			if (opcion == 0){
				System.out.println("Hasta pronto!");
				break;
			
			}else if (opcion == 1){
				//..................REGISTRO DE NOTAS...........................
				Curso cursoEscogido = escogerCurso(cursosColegio);
				System.out.println();
				int cantNotas = intIn("¿Cuántas notas desea ingresar por materia?");
				System.out.println();
				HashMap <Materia, ArrayList <Double>> notasPorMateria = new HashMap<>();
				for (int i = 0; i < materiasColegio.size(); i++){
					for (int j = 0; j < cursoEscogido.getAlumnos().size() ; j++){
						ArrayList <Double> notasArray = new ArrayList<>();
						Alumno alumno = cursoEscogido.getAlumnos().get(j);
						for (int x = 0; x < cantNotas ; x++){
							Double nota = doubleIn("Ingrese nota "+(x+1)+"("+alumno.getNombre()+", "+materiasColegio.get(i).getNombre()+")");
							notasArray.add(nota);
						}
						alumno.getNotaMateria().put(materiasColegio.get(i), notasArray);					 
					}
				}
				//---------------Comentar hast aquí para NO usar terminal--------------------------------
				
				
				//-------------INGRESO NOTAS SIN TERMINAL--------------------
				// ArrayList <Double> notasPedroLeng = new ArrayList<Double>(List.of(5.4,6.8));
				// ArrayList <Double> notasPedroMat = new ArrayList<Double>(List.of(3.4,5.0));
				// ArrayList <Double> notasJuanLeng = new ArrayList<Double>(List.of(3.5,4.7));
				// ArrayList <Double> notasJuanMat = new ArrayList<Double>(List.of(7.0,4.1));
				// ArrayList <Double> notasDiegoLeng = new ArrayList<Double>(List.of(2.0,3.2));
				// ArrayList <Double> notasDiegoMat = new ArrayList<Double>(List.of(3.7,4.0));
				// ArrayList <Double> notasMariaLeng = new ArrayList<Double>(List.of(6.4,7.0));
				// ArrayList <Double> notasMariaMat = new ArrayList<Double>(List.of(4.5,7.0));
				// ArrayList <Double> notasBelenLeng = new ArrayList<Double>(List.of(7.0,5.4));
				// ArrayList <Double> notasBelenMat = new ArrayList<Double>(List.of(5.8,6.4));
				// HashMap <Materia, ArrayList <Double>> pedroHMap = new HashMap<>();
				// HashMap <Materia, ArrayList <Double>> juanHMap = new HashMap<>();
				// HashMap <Materia, ArrayList <Double>> diegoHMap = new HashMap<>();
				// HashMap <Materia, ArrayList <Double>> mariaHMap = new HashMap<>();
				// HashMap <Materia, ArrayList <Double>> belenHMap = new HashMap<>();
				// pedroHMap.put(lenguaje, notasPedroLeng);
				// pedroHMap.put(matematica, notasPedroMat);
				// juanHMap.put(lenguaje, notasJuanLeng);
				// juanHMap.put(matematica, notasJuanMat);
				// diegoHMap.put(lenguaje, notasDiegoLeng);
				// diegoHMap.put(matematica, notasDiegoMat);
				// mariaHMap.put(lenguaje, notasMariaLeng);
				// mariaHMap.put(matematica, notasMariaMat);
				// belenHMap.put(lenguaje, notasBelenLeng);
				// belenHMap.put(matematica, notasBelenMat);
				// Pedro.setNotaMateria(pedroHMap);
				// Juan.setNotaMateria(juanHMap);
				// Diego.setNotaMateria(diegoHMap);
				// Maria.setNotaMateria(mariaHMap);
				// Belen.setNotaMateria(belenHMap);
				// Basico.printNotasCurso();
				// Avanzado.printNotasCurso();
				//------------------------------------------------------------
				System.out.println("\n¡Registro completado con éxito!\n");
				
			}else if (opcion == 2){
				//..................OPCION MOSTRAR NOTAS POR CURSO O ALUMNO...........................
				while (subopcion != 0){
					System.out.println("1) Mostrar notas por curso.\n"
					+"2) Mostrar notas por alumno.\n"
					+"Para volver presione 0.");
					subopcion = intInMinMax("Ingrese opción:",1,3,0);
					if (subopcion == 1){
						Curso cursoEscogido = escogerCurso(cursosColegio);
						cursoEscogido.printNotasCurso();
						
					}else if (subopcion == 2){
						Curso cursoEscogido = escogerCurso(cursosColegio);
						Alumno alumnoEscogido = escogerAlumno(cursoEscogido);
						alumnoEscogido.printNotasMateria();
						System.out.println();
					}	
				}
				//---------------Comentar hast aquí para NO usar terminal--------------------------------
				
				//---------------VERSION SIN TERMINAL-------------------
				// Basico.printNotasCurso();
				// Avanzado.printNotasCurso();
				//-----------------------------------------------------


			}else if (opcion == 3){
				//..................OPCION PROMEDIO, NOTA MENOR Y MAYOR POR CURSO...........................
				Curso cursoEscogido = escogerCurso(cursosColegio);
				Double promedioCurso = promedio(cursoEscogido.promediosCurso());
				System.out.println("El promedio del curso es "+promedioCurso);
				notaMenorCurso(cursoEscogido.promediosCursoHashMap(), cursoEscogido);
				notaMayorCurso(cursoEscogido.promediosCursoHashMap(), cursoEscogido);
				//---------------Comentar hast aquí para NO usar terminal--------------------------------
				

				//---------------VERSION SIN TERMINAL-------------------
				// Double promedioCurso = promedio(Basico.promediosCurso());
				// System.out.println("El promedio del curso es "+promedioCurso);
				// notaMenorCurso(Basico.promediosCursoHashMap(), Basico);
				// notaMayorCurso(Basico.promediosCursoHashMap(), Basico);
				// Double promedioCurso = promedio(Avanzado.promediosCurso());
				// System.out.println("El promedio del curso es "+promedioCurso);
				// notaMenorCurso(Avanzado.promediosCursoHashMap(), Avanzado);
				// notaMayorCurso(Avanzado.promediosCursoHashMap(), Avanzado);
				//---------------------------------------------------------

			}else if (opcion == 4){
				//..................OPCION MOSTRAR CANTIDAD DE ALUMNOS POR CURSO...........................
				Curso cursoEscogido = escogerCurso(cursosColegio);
				System.out.println("\nEl curso "+cursoEscogido.getNombre()+" tiene "+cursoEscogido.getAlumnos().size()+" alumnos.");
				cursoEscogido.printAlum();
				//---------------Comentar hast aquí para NO usar terminal--------------------------------

				//---------------SIN TERMINAL------------------------------
				// System.out.println("\nEl curso "+Basico.getNombre()+" tiene "+Basico.getAlumnos().size()+" alumnos.");
				// Basico.printAlum();
				// System.out.println("\nEl curso "+Avanzado.getNombre()+" tiene "+Avanzado.getAlumnos().size()+" alumnos.");
				// Avanzado.printAlum();
				//----------------------------------------------------------
			}
		System.out.println("_____________________________________________\n");
		}while (opcion != 0);

		teclado.close();
	}

}
