package com.isil.sesion01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainApp {
    /*
     Nuestro primer Hola Mundo
     Primer metodo

        public static void main(String[] args) {
        System.out.println("Hello World!");
    }*/

    //Conexión a BD
    // Metodo forName es para cargar los drivers
    // Al principio cuando implementas el forname se necesita colocar una exepción (throws Exception)
    public static void main(String[] args) throws Exception {
        //com.mysql.jdbc.Driver comando obsoleto
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Siguiente paso crear la conexión
        Connection  con = DriverManager.getConnection(
         //Este metodo recive el URL,password,usuario
                "jdbc:mysql://localhost:3306/TEST",
                "root",
                "S0p0rt3"
        );
        // Una vez que tenemos la conexión debemos de crear el STATEMENT (ayuda a la conexión)
        Statement stmt = con.createStatement();
        //Haremos un select, almacenaremos en un result
        //ResultSet result = stmt.executeQuery("select * from USERS");

        //Ejemplo del profesor con Update
         //int resultUpdate = stmt.executeUpdate("update Users set phone= '444444554' where name = 'Messi'");

         ResultSet result = stmt.executeQuery("Select * from Users");

        //Realizamos una iteración
        while (result.next()){
            if(result.getString("name").equals("Ronaldo")) {
                System.out.println(result.getString("idUser"));
                System.out.println(result.getString("name"));
                System.out.println(result.getString("phone"));
                System.out.println(result.getString("city"));
                }

        }
    }

}
