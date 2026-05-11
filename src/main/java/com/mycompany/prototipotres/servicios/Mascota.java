/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipotres.servicios;

/**
 *
 * @author pauda
 */
public class Mascota {
    private int id_mascota;
    private String nombre;
    private String raza;
    private int edad;
    private double peso;
    private String procedimiento;
    private int id_veterinaria;
    private String dueño;

    public Mascota(int id_mascota, String nombre, String raza, int edad, double peso, String procedimiento, int id_veterinaria, String dueño) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.procedimiento = procedimiento;
        this.id_veterinaria = id_veterinaria;
        this.dueño = dueño;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public int getId_veterinaria() {
        return id_veterinaria;
    }

    public void setId_veterinaria(int id_veterinaria) {
        this.id_veterinaria = id_veterinaria;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }
    
    
    
}
