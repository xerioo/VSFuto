package GDE.futo;

import static GDE.futo.CsvImporter.*;
import static GDE.futo.FutoApplication.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class DatabaseConnection {
    
      public static void runnersIntoMemory(String sql) {
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            Runner runn = new Runner();
            while (rs.next()) {
                runn.setId(rs.getInt("ID"));
                runn.setName(rs.getString("NAME"));
                runn.setAge(rs.getInt("AGE"));
                runn.setGender(rs.getInt("GENDER"));
                runners.add(runn);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void compsIntoMemory(String sql) {
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            Competition comp = new Competition();
            while (rs.next()) {
                comp.setId(rs.getInt("ID"));
                comp.setName(rs.getString("NAME"));
                comp.setLength(rs.getInt("LENGTH"));
                competitions.add(comp);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void resultsIntoMemory(String sql) {
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            Result res = new Result();
            while (rs.next()) {
                res.setRunner(rs.getInt("RUNNER"));
                res.setCompetition(rs.getInt("COMPETITION"));
                res.setResultInMillisec(rs.getLong("TIME"));
                results.add(res);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getQuery(String sql) {
        //Map<String, Object> query = new HashMap<>();
        runners.clear();
        results.clear();
        Runner runn = new Runner();
        Result res = new Result();
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            java.sql.ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object columnValue = rs.getObject(i);
                    switch (columnName) {
                        case "ID" : runn.setId((int) columnValue);                            
                            break;
                        case "NAME" : runn.setName((String) columnValue);
                            break;
                        case "AGE" : runn.setAge((int) columnValue);
                            break;
                        case "GENDER" : runn.setGender((int) columnValue);
                            break;
                        case "RUNNER" : res.setRunner((int) columnValue);
                            break;
                        case "COMPETITION" : res.setCompetition((int) columnValue);
                            break;
                        case "TIME" : res.setResultInMillisec((long) columnValue);
                            break;
                    }                    
                }
                runners.add(runn);
                results.add(res);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}