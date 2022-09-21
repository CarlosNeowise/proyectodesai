package com.isil.sesion01;

import java.sql.*;

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
        //Statement stmt = con.createStatement();
        //Haremos un select, almacenaremos en un result
        //ResultSet result = stmt.executeQuery("select * from USERS");

        //Ejemplo del profesor con Update
         //int resultUpdate = stmt.executeUpdate("update Users set phone= '444444554' where name = 'Messi'");

         //ResultSet result = stmt.executeQuery("Select * from Users");

        //Realizamos una iteración
        /*while (result.next()){
            if(result.getString("name").equals("Ronaldo")) {
                System.out.println(result.getString("idUser"));
                System.out.println(result.getString("name"));
                System.out.println(result.getString("phone"));
                System.out.println(result.getString("city"));
                }

        }
         Recorrer resultados
        while (result.next()){
            System.out.println(result.getString(2));
        }

        Statement stmt2 = con.createStatement();
        ResultSet resultSet = stmt2.executeQuery("Select * from Users where name='Ronaldo'");

        while (resultSet.next()){
            System.out.println(resultSet.getString("name") + "\n" +
                    resultSet.getString("phone") + "\n" +
                    resultSet.getString("city"));
        }*/

        //SELECT
        //Crearemos un preparedStatement //Sesion02
        //Una forma mas adecuada de manejar parametros
        //PreparedStatement preparedStatement =
        //        con.prepareStatement("Select * from Users where name=? and city=?");

        //Reduciendo el scope
        //preparedStatement.setString(1, "Cueva");
        //preparedStatement.setString(2, "Lima");


        //ResultSet resultSet2 = preparedStatement.executeQuery();

        //Mantenimiento en BD
        Statement stCreate = con.createStatement();
        int filasAfectadas = //Retorna cuantas filas fuerona afectadas
            //stCreate.executeUpdate("INSERT INTO Users VALUES (6, 'Maria','987876798','Quito')");
              stCreate.executeUpdate("UPDATE Users Set Name='JUAN' where IdUser=1");
                System.out.println("Filas Afectadas: " + filasAfectadas);

        //Consulta
        PreparedStatement preparedStatement = con.prepareStatement("Select * from Users where idUser=?");

        preparedStatement.setInt(1,1);

        ResultSet resultSet2 = preparedStatement.executeQuery();

        //Recorrer resultado
        while (resultSet2.next()){
            System.out.println(resultSet2.getString("name") + "\n" +
            resultSet2.getString("phone") + "\n" +
            resultSet2.getString("city"));
        }



        //Cerrar conexión
        con.close();


    }

}
