/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipotres.model;

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
    private int id_veterinaria;
    private int doc_dueño;
    private String estado;

    public Mascota(int id_mascota, String nombre, String raza, int edad, double peso, int id_veterinaria, int doc_dueño, String estado) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.id_veterinaria = id_veterinaria;
        this.doc_dueño = doc_dueño;
        this.estado = estado;
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

    public int getId_veterinaria() {
        return id_veterinaria;
    }

    public void setId_veterinaria(int id_veterinaria) {
        this.id_veterinaria = id_veterinaria;
    }

    public int getDoc_dueño() {
        return doc_dueño;
    }

    public void setDoc_dueño(int doc_dueño) {
        this.doc_dueño = doc_dueño;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
