/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipotres.data;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author pauda
 */
public class DatabaseConnectionMongo {
     private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "PER2026";

    private static MongoClient mongoClient = null;
    private static MongoDatabase database = null;

    // Constructor privado para evitar instanciación externa (Singleton)
    private DatabaseConnectionMongo() {}

    /**
     * Obtiene la instancia de la base de datos.
     * Si no existe, crea la conexión al cliente.
     */
    public static MongoDatabase getDatabase() {
        if (database == null) {
            try {
                // 1. Crear el cliente de MongoDB
                mongoClient = MongoClients.create(CONNECTION_STRING);
                
                // 2. Acceder a la base de datos específica
                database = mongoClient.getDatabase(DATABASE_NAME);
                
                System.out.println("Conexión exitosa a MongoDB: " + DATABASE_NAME);
            } catch (MongoException e) {
                System.err.println("Error al conectar a MongoDB: " + e.getMessage());
            }
        }
        return database;
    }

    /**
     * Cierra la conexión del cliente de forma segura.
     */
    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Conexión a MongoDB cerrada.");
        }
    }
}
