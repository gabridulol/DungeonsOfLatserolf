package DungeonsOfLatserolf.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManagerSystem {
    private static final String URL = "jdbc:mysql://localhost:3306/DungeonsOfLatserolf";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static final String SQL_INSERT_NEW_USER = "INSERT INTO TBUser (userEmail, userName, userScore) VALUES (?, ?, ?)";
    private static final String SQL_SELECT_USER_BY_EMAIL = "SELECT * FROM TBUser WHERE userEmail = ?";
    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM TBUser WHERE idUser IS NOT NULL ORDER BY userScore DESC";
    private static final String SQL_UPDATE_USER_SCORE = "UPDATE TBUser SET userScore = ? WHERE userEmail = ? AND userName = ? AND userScore < ?";
    private static final String SQL_DELETE_DATABASE = "DELETE FROM TBUser";

    private UserEntity currentUser;

    private Connection connection;

    public Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                return connection;
            } else {
                return connection;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void insertNewUser(UserEntity currentUser) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(SQL_INSERT_NEW_USER);
            preparedStatement.setString(1, currentUser.getUserEmail());
            preparedStatement.setString(2, currentUser.getUserName());
            preparedStatement.setInt(3, currentUser.getUserScore());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public UserEntity userLogin(String userEmail) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = getConnection().prepareStatement(SQL_SELECT_USER_BY_EMAIL);
            preparedStatement.setString(1, userEmail);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                this.currentUser = new UserEntity(
                        resultSet.getString("userEmail"),
                        resultSet.getString("userName"));
                this.currentUser.setUserScore(resultSet.getInt("userScore"));
                System.out.println("Login realizar com sucesso!");
                resultSet.close();
                preparedStatement.close();
                return this.currentUser;
            } else {
                System.out.println("Não foi possível realizar o login!");
                resultSet.close();
                preparedStatement.close();
                return null;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public void selectAllUsers() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String result = "\nSCOREBOARD\n";
        try {
            preparedStatement = getConnection().prepareStatement(SQL_SELECT_ALL_USERS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result += resultSet.getString("userName") + " " + resultSet.getInt("userScore") + "\n";
            }
            resultSet.close();
            preparedStatement.close();
            System.out.println(result);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void updateUserScore(UserEntity currentUser, int newUserScore) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(SQL_UPDATE_USER_SCORE);
            preparedStatement.setInt(1, newUserScore);
            preparedStatement.setString(2, currentUser.getUserEmail());
            preparedStatement.setString(3, currentUser.getUserName());
            preparedStatement.setInt(4, newUserScore);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deleteAllUsers() {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(SQL_DELETE_DATABASE);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public UserEntity getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserEntity currentUser) {
        this.currentUser = currentUser;
    }
}