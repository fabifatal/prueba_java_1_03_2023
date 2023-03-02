package com.evaluacionjava.fabian_zuniga_evaluacion_java.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Alumno extends Nombre {

    public Curso curso;
    public HashMap <Materia, ArrayList<Double>> notaMateria;
    public Alumno() {
        super();
    }
    public Alumno(String nombre, Curso curso, HashMap<Materia, ArrayList<Double>> notaMateria) {
        super(nombre);
        this.curso = curso;
        this.notaMateria = notaMateria;
    }
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    public HashMap<Materia, ArrayList<Double>> getNotaMateria() {
        return notaMateria;
    }
    public void setNotaMateria(HashMap<Materia, ArrayList<Double>> notaMateria) {
        this.notaMateria = notaMateria;
    }
 
    //Métodos

    //Imprime notas por materia indicando previamente el nombre del alumno.
    public void printNotasMateria (){
        for (Materia i : notaMateria.keySet()){
            System.out.print(nombre+" ("+i.getNombre()+"): ");
            for (int j = 0; j < notaMateria.get(i).size(); j++){
                System.out.print(notaMateria.get(i).get(j)+", ");
            }
            System.out.println();
        }
    }

    //Obtiene el promedio de la materia escogida
    public Double promedioMateria(Materia materia){
        ArrayList <Double> notas = new ArrayList<>();
        notas = notaMateria.get(materia);
        Double sumaNotas = 0.0;
		for (int i = 0 ; i < notas.size() ; i++){
			sumaNotas = sumaNotas + notas.get(i);
		}
		return  sumaNotas / notas.size();
    }

    //Obtiene el promedio global del alumno, promediando las notas de todas las Materias.
    public Double promedioAlumno(){
        Double promedio = 0.0;
        for (Materia j : notaMateria.keySet()){
            promedio = promedio + promedioMateria(j);
        }
        return promedio/notaMateria.size();
    }

    @Override
    public String toString() {
        return super.toString() + "Alumno [curso=" + curso + ", notaMateria=" + notaMateria + "]";
    }
    
    
    
}
