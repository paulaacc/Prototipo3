/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipotres.servicios;

/**
 *
 * @author pauda
 */
public class Veterinaria {
    private int id_vet;
    private String nombre;
    private String direccion;
    private String telefono;
    private String repres_legal;

    public Veterinaria(int id_vet, String nombre, String direccion, String telefono, String repres_legal) {
        this.id_vet = id_vet;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.repres_legal = repres_legal;
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

    public String getRepres_legal() {
        return repres_legal;
    }

    public void setRepres_legal(String repres_legal) {
        this.repres_legal = repres_legal;
    }
    
}
