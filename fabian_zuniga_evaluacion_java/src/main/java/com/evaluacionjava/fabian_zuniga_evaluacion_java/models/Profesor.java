package com.evaluacionjava.fabian_zuniga_evaluacion_java.models;

import java.util.ArrayList;

public class Profesor extends Nombre {

    public ArrayList <Curso> cursosArray;
    public ArrayList <Materia> materiasArray;

    public Profesor() {
        super();
    }


    public Profesor(String nombre, ArrayList<Curso> cursosArray, ArrayList<Materia> materiasArray) {
        super(nombre);
        this.cursosArray = cursosArray;
        this.materiasArray = materiasArray;
    }


    public ArrayList<Curso> getCursosArray() {
        return cursosArray;
    }


    public void setCursosArray(ArrayList<Curso> cursosArray) {
        this.cursosArray = cursosArray;
    }


    public ArrayList<Materia> getMateriasArray() {
        return materiasArray;
    }


    public void setMateriasArray(ArrayList<Materia> materiasArray) {
        this.materiasArray = materiasArray;
    }


    
}
