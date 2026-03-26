package com.ejemplo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Spring Data: "Esto ya no es una simple caja, esto es una TABLA en la BBDD"
public class Perro {
    
    @Id // "Esto es la Clave Primaria de la tabla"
    @GeneratedValue(strategy = GenerationType.IDENTITY) // "El ID lo autoincrementa la BD sola (1, 2, 3...)"
    private Long id;
    private String nombre;
    private String raza;
    private int edad;

    // 2. CONSTRUCTOR (Para crear perros fácilmente)
    public Perro(Long id, String nombre, String raza, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
    }

    public Perro(String nombre, String raza, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
    }

    // Spring Data (Hibernate) necesita SIEMPRE un constructor vacío obligatorio
    // para poder "fabricar" los objetos Perro vacíos al leerlos de la BD
    public Perro() {
    }

    // 3. GETTERS y SETTERS (Métodos públicos para leer y modificar el estado)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
}
