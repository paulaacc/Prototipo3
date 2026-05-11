/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipotres.model;

/**
 *
 * @author pauda
 */
public class Dueño {
    private int doc_dueño;
    private String nombre;
    private String celular;
    private String correo;
    private String estado;

    public Dueño(int doc_dueño, String nombre, String celular, String correo, String estado) {
        this.doc_dueño = doc_dueño;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
        this.estado = estado;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}