package com.evaluacionjava.fabian_zuniga_evaluacion_java.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Curso extends Nombre {
    
    public ArrayList <Alumno> alumnos;

    public Curso() {
        super();
    }

    public Curso(String nombre, ArrayList<Alumno> alumnos) {
        super(nombre);
        this.alumnos = alumnos;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    //Métodos

    //Imprime los alumnos del curso.
    public void printAlum (){
        for (int i = 0; i < alumnos.size(); i++){
			System.out.println(alumnos.get(i).getNombre());
		}
    }

    //Imprime las notas de cada alumno por materia dada
    public void printNotasAlumnoMateria (Materia materia){
        
        for (int i = 0; i < alumnos.size(); i++){
			Alumno alumno = alumnos.get(i);
            System.out.println(alumno.getNombre()+alumno.getNotaMateria().get(materia));
		}
    }

    //Obtiene un HashMap que relaciona a cada Alumno con su promedio Global.
    public HashMap <Alumno, Double> promediosCursoHashMap (){
        HashMap <Alumno, Double> alumnoYPromedio = new HashMap<>();
        for (int i = 0; i < alumnos.size(); i++){
            alumnoYPromedio.put(alumnos.get(i), alumnos.get(i).promedioAlumno());
        }
        return alumnoYPromedio;
    }

    //Obtiene el promedio general del curso.
    public ArrayList <Double> promediosCurso (){
        ArrayList <Double> promediosCurso = new ArrayList<>();
        for (int i = 0; i < alumnos.size() ; i++){
            promediosCurso.add(alumnos.get(i).promedioAlumno());
        }
        return promediosCurso;
    }

    //Imprime todas las notas del curso especificando.
    public void printNotasCurso (){
		for (int i = 0; i < alumnos.size(); i++){
			Alumno alumno = alumnos.get(i);
			alumno.printNotasMateria();
			System.out.println();
		}
	} 

    @Override
    public String toString() {
        return super.toString() + "Curso [alumnos=" + alumnos + "]";
    }
    
    
}
