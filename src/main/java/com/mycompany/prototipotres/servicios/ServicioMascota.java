/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipotres.servicios;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mycompany.prototipotres.data.DatabaseConnectionMongo;
import com.mycompany.prototipotres.data.DatabaseConnectionOracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.bson.Document;

/**
 *
 * @author pauda
 */
public class ServicioMascota {
    
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;
    
    public static boolean migrarMascotas (){
        
        try {
            conn = DatabaseConnectionOracle.getConnection();
            MongoDatabase db = DatabaseConnectionMongo.getDatabase();
            
            /* Verificar que existe la coleccion 
            boolean existe = false;
            for (String nombreColeccion : db.listCollectionNames()) {
                if (nombreColeccion.equals("Mascotas")) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                db.createCollection("Mascotas");
                System.out.println("Colección Mascotas creada.");
            } */
        
            MongoCollection<Document> coleccion = db.getCollection("Mascotas");

            if (conn != null && db != null) {
               stmt = conn.createStatement();
                String selectDataSQL = "SELECT * FROM MASCOTA"; 
                rs = stmt.executeQuery(selectDataSQL);
                
                while (rs.next()) {
                    Document doc = new Document("Id_mascota", rs.getInt("ID"))
                        .append("Nombre", rs.getString("NOMBRE"))
                        .append("Raza", rs.getString("RAZA"))
                        .append("Edad", rs.getInt("EDAD"))
                        .append("Peso", rs.getDouble("PESO"))
                        .append("Id_veterinaria", rs.getInt("VETERINARIAID"))
                        .append("Doc_dueño", rs.getInt("DUENODOC"))
                        .append("Estado", rs.getString("ESTADO"));

                    coleccion.insertOne(doc);
                }
                conn.close(); 
            }
        } catch (Exception ex) {
            System.out.println("Error! " + ex);
            return false;
        }
        return true;
    }
    
    
    public static int contarRegistros(){
        int contador = 0;
        
        try {
            conn = DatabaseConnectionOracle.getConnection();
            
            if (conn != null) {
               stmt = conn.createStatement();
                String selectDataSQL = "SELECT COUNT(*) AS TOTAL FROM MASCOTA"; 
                rs = stmt.executeQuery(selectDataSQL);
                
                if (rs.next()) {
                    contador = rs.getInt("TOTAL");
                }
                conn.close();
            }
        } catch (Exception ex) {
            System.out.println("Error! " + ex);
        }
        return contador;
    }
}

