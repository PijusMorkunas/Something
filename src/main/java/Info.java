

import java.sql.*;
import java.util.Scanner;

public class Info {
    String url = "jdbc:mysql://localhost:3306/e_bank";
    String user = "McPj";
    String password = "dratan2874";
    Scanner scanner = new Scanner(System.in);

    public void info() {


        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            Statement newStatement = connection.createStatement();
            String contact = "SELECT * FROM contact";
            String client = "SELECT * FROM client";
            ResultSet rsClient = statement.executeQuery(client);
            ResultSet rsContact = newStatement.executeQuery(contact);
            ;
            while (rsContact.next() & rsClient.next()) {
                System.out.print(rsContact.getString("name") + " " + rsContact.getString("surname") + " " + rsClient.getString("balance") + "\n");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error in query execution");
        }
    }

    public void infoOnePerson() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            Statement newStatement = connection.createStatement();
            System.out.println("Enter password");
            String password = scanner.nextLine();
            String client = "SELECT * FROM client WHERE password = ";
            String clientPassword = client + "'" + password + "'";
            ResultSet rsClient = statement.executeQuery(clientPassword);
            while (rsClient.next()) {
                System.out.println("balance = "+rsClient.getInt("balance")+" | id = "+rsClient.getInt("client_id"));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}