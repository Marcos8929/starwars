package org.example;

public class Personaje {
    private String nombre;
    private String anoNacimiento;

    // Constructor
    public Personaje(String nombre, String anoNacimiento) {  // Cambié 'personaje' por 'Personaje'
        this.nombre = nombre;
        this.anoNacimiento = anoNacimiento;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getAnoNacimiento() {
        return anoNacimiento;
    }

    @Override
    public String toString() {
        return nombre + " Año de nacimiento: " + anoNacimiento;  // Corregí la cadena de texto
    }
}
