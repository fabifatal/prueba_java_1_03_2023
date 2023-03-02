package com.evaluacionjava.fabian_zuniga_evaluacion_java.models;

public class Nombre {
    
    public String nombre;
    public Nombre() {
    }
    public Nombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "Nombre [nombre=" + nombre + "]";
    }

    

}
