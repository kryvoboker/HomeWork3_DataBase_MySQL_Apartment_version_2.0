package ru.live.kamaz_cs;

import java.sql.*;
import java.util.Scanner;

public class MySQLDatabase {

    private static final String DB_CONNECTION = "jdbc:mysql://localhost/HomeWork3?useUnicode=true&serverTimezone=UTC&" +
            "useSSL=true&verifyServerCertificate=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    private static Connection conn;
    private static PreparedStatement ps;

    public void start() throws SQLException {
        try {
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable() throws SQLException {
        Statement st = conn.createStatement();
        try {
            st.execute("drop table if exists Flats");
            st.execute("create table Flats (id int not null auto_increment primary key, district varchar(30) not null, " +
                    "adress varchar(100) not null, area double not null, rooms int not null, price int not null)");
        } finally {
            st.close();
        }
    }

    public void addFlat(Flat flat) throws SQLException {
        conn.setAutoCommit(false);
        try {
            ps = conn.prepareStatement("insert into Flats (district, adress, area, rooms, price) " +
                    "values (?, ?, ?, ?, ?)");
            try {
                ps.setString(1, flat.getDistrict());
                ps.setString(2, flat.getAdress());
                ps.setDouble(3, flat.getArea());
                ps.setInt(4, flat.getRooms());
                ps.setInt(5, flat.getPrice());
                ps.executeUpdate();
                conn.commit();
            } finally {
                ps.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            conn.rollback();
        }
    }

    public void closeConnection() throws SQLException {
        if (conn != null) conn.close();
    }

    public void chooseParametr() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter parametr");
        System.out.println("Please enter value");
        String parametr = sc.nextLine();
        String value = sc.nextLine();
        if (parametr.equals("id")) {
            int id = Integer.parseInt(value);
            ps = conn.prepareStatement("select * from Flats where id = ?");
            ps.setInt(1, id);
        } else if (parametr.equals("district")) {
            ps = conn.prepareStatement("select * from Flats where district = ?");
            ps.setString(1, value);
        } else if (parametr.equals("adress")) {
            ps = conn.prepareStatement("select * from Flats where adress = ?");
            ps.setString(1, value);
        } else if (parametr.equals("area")) {
            double area = Double.parseDouble(value);
            ps = conn.prepareStatement("select * from Flats where area = ?");
            ps.setDouble(1, area);
        } else if (parametr.equals("rooms")) {
            int rooms = Integer.parseInt(value);
            ps = conn.prepareStatement("select * from Flats where rooms = ?");
            ps.setInt(1, rooms);
        } else if (parametr.equals("price")) {
            int price = Integer.parseInt(value);
            ps = conn.prepareStatement("select * from Flats where price = ?");
            ps.setInt(1, price);
        }
        try {
            ResultSet rs = ps.executeQuery();
            try {
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.print(md.getColumnName(i) + "\t\t");
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }
                    System.out.println();
                }
            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
    }

}
