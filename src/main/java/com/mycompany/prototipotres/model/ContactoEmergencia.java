/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipotres.model;

/**
 *
 * @author pauda
 */
public class ContactoEmergencia {
    private int doc_contacto;
    private String nombre;
    private String parentesco;
    private String celular;
    private int doc_dueño;
    private String estado;

    public ContactoEmergencia(int doc_contacto, String nombre, String parentesco, String celular, int doc_dueño, String estado) {
        this.doc_contacto = doc_contacto;
        this.nombre = nombre;
        this.parentesco = parentesco;
        this.celular = celular;
        this.doc_dueño = doc_dueño;
        this.estado = estado;
    }

    public int getDoc_contacto() {
        return doc_contacto;
    }

    public void setDoc_contacto(int doc_contacto) {
        this.doc_contacto = doc_contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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
