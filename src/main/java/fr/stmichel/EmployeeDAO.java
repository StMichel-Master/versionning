package stmichel;


import java.sql.*;
import java.util.*;

import fr.stmichel.Employee;

public class EmployeeDAO extends DAOcontext{

    private static final String INSERT = "INSERT INTO Employee (name, lastname, address, salary) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Employee SET name = ?, lastname = ?, address = ?, salary = ? WHERE idEmployee = ?";
    private static final String DELETE = "DELETE FROM Employee WHERE idEmployee = ?";
    private static final String SELECT_ALL = "SELECT * FROM Employee";
    private static final String SELECT_BY_ID = "SELECT * FROM Employee WHERE idEmployee = ?";
    
    // Méthode pour insérer un employé dans la table Employee
    public boolean insertEmployee(Employee employee) {
        boolean result = false;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();

            statement = connection.prepareStatement(INSERT);
            statement.setString(1, employee.getPrenom());
            statement.setString(2, employee.getNom());
            statement.setString(3, employee.getAdresse());
            statement.setInt(4, employee.getSalaire());
 
            int rows = statement.executeUpdate();
            if (rows > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    // Méthode pour mettre à jour un employé dans la table Employee
    public boolean updateEmployee(Employee employee) {
        boolean result = false;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();

            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, employee.getPrenom());
            statement.setString(2, employee.getNom());
            statement.setString(3, employee.getAdresse());
            statement.setInt(4, employee.getSalaire());
            statement.setInt(5, employee.getId());

            int rows = statement.executeUpdate();
            if (rows > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    // Méthode pour supprimer un employé dans la table Employee
    public boolean deleteEmployee(int idEmployee) {
        boolean result = false;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, idEmployee);
            
            int rows = statement.executeUpdate();
            if (rows > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    // Méthode pour récupérer tous les employés de la table Employee
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();

            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("i"));
                employee.setPrenom(resultSet.getString("prenom"));
                employee.setNom(resultSet.getString("nom"));
                employee.setAdresse(resultSet.getString("adresse"));
                employee.setSalaire(resultSet.getInt("salaire"));

                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return employees;
    }

    // Méthode pour récupérer un employé par son id de la table Employee
    public Employee getEmployeeById(int idEmployee) {
        Employee employee = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();

            statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setInt(1, idEmployee);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                employee = new Employee();
                employee.setId(resultSet.getInt("i"));
                employee.setPrenom(resultSet.getString("prenom"));
                employee.setNom(resultSet.getString("nom"));
                employee.setAdresse(resultSet.getString("adresse"));
                employee.setSalaire(resultSet.getInt("salaire"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return employee;
    }
}

