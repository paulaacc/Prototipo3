/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipotres.model;

/**
 *
 * @author pauda
 */
public class Veterinaria {
    private int id_vet;
    private String nombre;
    private String direccion;
    private String telefono;
    private String repre_legal;
    private String estado;

    public Veterinaria(int id_vet, String nombre, String direccion, String telefono, String repre_legal, String estado) {
        this.id_vet = id_vet;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.repre_legal = repre_legal;
        this.estado = estado;
    }

    public int getId_vet() {
        return id_vet;
    }

    public void setId_vet(int id_vet) {
        this.id_vet = id_vet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRepre_legal() {
        return repre_legal;
    }

    public void setRepre_legal(String repre_legal) {
        this.repre_legal = repre_legal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
