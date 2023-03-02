package com.evaluacionjava.fabian_zuniga_evaluacion_java.models;

public class Materia extends Nombre {
    
    public Profesor profesor;

    public Materia() {
        super();
    }
    public Materia(String nombre, Profesor profesor) {
        super(nombre);
        this.profesor = profesor;
    }
    public Profesor getProfesor() {
        return profesor;
    }
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return super.toString() + "Materia [nombreProfesor=" + profesor + "]";
    }

}
