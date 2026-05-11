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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author pauda
 */
public class ServicioDueñoContacto {
    
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;
    
    
    public static boolean migrarDuenoContacto() {
        
        String sqlDuenos = "SELECT * FROM DUENO"; 
        String sqlContactos = "SELECT * FROM CONTACTO_EMERGENCIA WHERE DUENODOC = ?";

    try (Connection connLocal = DatabaseConnectionOracle.getConnection()) {
        MongoDatabase db = DatabaseConnectionMongo.getDatabase();
        MongoCollection<Document> coleccion = db.getCollection("Dueños");

        if (conn != null && db != null) {
            // Usamos try-with-resources para que los Statements se cierren solos
            try (Statement stmtDuenos = connLocal.createStatement();
                 ResultSet rsDuenos = stmtDuenos.executeQuery(sqlDuenos);
                 PreparedStatement pstmtCont = connLocal.prepareStatement(sqlContactos)) {

                while (rsDuenos.next()) {
                    int idDueño = rsDuenos.getInt("DOC"); // Verifica el nombre de la columna

                    // 1. Buscar contactos para este dueño específico
                    List<Document> contactos = new ArrayList<>();
                    pstmtCont.setInt(1, idDueño); // Pasamos el ID al '?'
                    
                    try (ResultSet rsCont = pstmtCont.executeQuery()) {
                        while (rsCont.next()) {
                            Document docCont = new Document("Doc_contacto", rsCont.getInt("DOC"))
                                    .append("Nombre", rsCont.getString("NOMBRE"))
                                    .append("Parentesco", rsCont.getString("PARENTESCO"))
                                    .append("Celular", rsCont.getString("CELULAR"))
                                    .append("Estado", rsCont.getString("ESTADO"));
                            
                            contactos.add(docCont);
                        }
                    }
                    // 2. Crear el documento del Dueño con la lista embebida
                    Document docDueno = new Document("Doc_dueño", idDueño)
                            .append("Nombre", rsDuenos.getString("NOMBRE"))
                            .append("Celular", rsDuenos.getString("CELULAR"))
                            .append("Correo", rsDuenos.getString("CORREO"))
                            .append("Estado", rsDuenos.getString("ESTADO"))
                            .append("Contactos_Emergencia", contactos); // Aquí ocurre la magia del embebido

                    // 3. Insertar en MongoDB
                    coleccion.insertOne(docDueno);
                }
            }
        }
    } catch (Exception ex) {
            System.out.println("Error! " + ex);
            return false;
    }
    return true;
}
    
    
    public static int contarRegistros(){
        int contador = 0;
        int duenos = 0;
        int contactos = 0;
        
        try {
            conn = DatabaseConnectionOracle.getConnection();
            
            if (conn != null) {
               stmt = conn.createStatement();
                String selectDataSQL = "SELECT (SELECT COUNT(*) FROM DUENO) AS TOTAL_DUENOS,(SELECT COUNT(*) FROM CONTACTO_EMERGENCIA)AS TOTAL_CONTACTOS FROM DUAL"; 
                rs = stmt.executeQuery(selectDataSQL);
                
                if (rs.next()) {
                    duenos = rs.getInt("TOTAL_DUENOS");
                    contactos = rs.getInt("TOTAL_CONTACTOS");
                }
                contador = duenos + contactos;
                conn.close();
            }
        } catch (Exception ex) {
            System.out.println("Error! " + ex);
        }
        return contador;
    }
}
