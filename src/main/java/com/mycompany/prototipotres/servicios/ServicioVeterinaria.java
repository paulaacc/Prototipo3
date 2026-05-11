/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipotres.servicios;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mycompany.prototipotres.data.DatabaseConnectionMongo;
import com.mycompany.prototipotres.data.DatabaseConnectionOracle;
import com.mycompany.prototipotres.model.Veterinaria;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author pauda
 */
public class ServicioVeterinaria {
    
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;
    
    public static boolean migrarVeterinarias (){
        
        try {
            conn = DatabaseConnectionOracle.getConnection();
            MongoDatabase db = DatabaseConnectionMongo.getDatabase();
            MongoCollection<Document> coleccion = db.getCollection("Veterinarias");
            
            if (conn != null && db != null) {
               stmt = conn.createStatement();
                String selectDataSQL = "SELECT * FROM VETERINARIA"; 
                rs = stmt.executeQuery(selectDataSQL);
                
                while (rs.next()) {
                    Document doc = new Document("Id_veterinaria", rs.getInt("ID"))
                        .append("Nombre", rs.getString("NOMBRE"))
                        .append("Direccion", rs.getString("DIRECCION"))
                        .append("Telefono", rs.getString("TELEFONO"))
                        .append("Repre_legal", rs.getString("REPRE_LEGAL"))
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
                String selectDataSQL = "SELECT COUNT(*) AS TOTAL FROM VETERINARIA"; 
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
