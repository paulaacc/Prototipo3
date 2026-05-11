/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipotres.servicios;

/**
 *
 * @author pauda
 */
public class Dueño {
    private int doc_dueño;
    private String nombre;
    private String telefono;
    private String correo;

    public Dueño(int doc_dueño, String nombre, String telefono, String correo) {
        this.doc_dueño = doc_dueño;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getDoc_dueño() {
        return doc_dueño;
    }

    public void setDoc_dueño(int doc_dueño) {
        this.doc_dueño = doc_dueño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}