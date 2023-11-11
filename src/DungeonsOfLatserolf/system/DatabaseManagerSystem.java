package DungeonsOfLatserolf.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DungeonsOfLatserolf.entity.PlayerEntity;

public class DatabaseManagerSystem {
    private static final String URL = "jdbc:mysql://localhost:3306/DungeonsOfLatserolf";
    private static final String USER = "root";
    private static final String PASSWORD = "r4@P36~y_buT";

    private PlayerEntity playerEntity;

    private static Connection connection;

    private static final String SQL_INSERT_NEW_USER = "INSERT INTO TBPlayer (playerEmail, playerName, playerScore) VALUES (?, ?, ?)";
    private static final String SQL_SELECT_USER_BY_EMAIL = "SELECT * FROM TBPlayer WHERE playerEmail = ?";
    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM TBPlayer WHERE idPlayer IS NOT NULL ORDER BY playerScore DESC";
    private static final String SQL_UPDATE_USER_SCORE = "UPDATE TBPlayer SET playerScore = ? WHERE playerEmail = ? AND playerName = ? AND playerScore < ?";
    private static final String SQL_DELETE_DATABASE = "DELETE FROM TBPlayer";

    public static Connection getConnection() {
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

    public void insertNewUser(PlayerEntity playerEntity) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(SQL_INSERT_NEW_USER);
            preparedStatement.setString(1, playerEntity.getPlayerEmail());
            preparedStatement.setString(2, playerEntity.getPlayerName());
            preparedStatement.setInt(3, playerEntity.getPlayerScore());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public boolean userLogin(String playerEmail) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = getConnection().prepareStatement(SQL_SELECT_USER_BY_EMAIL);
            preparedStatement.setString(1, playerEmail);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                this.playerEntity = new PlayerEntity(
                    resultSet.getString("playerEmail"),
                    resultSet.getString("playerName"),
                    resultSet.getInt("playerScore")
                    );
                System.out.println("Login realizar com sucesso!");
                resultSet.close();
                preparedStatement.close();
                return true;
            } else {
                System.out.println("Não foi possível realizar o login!");
                resultSet.close();
                preparedStatement.close();
                return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
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
                result += resultSet.getString("playerName") + " " + resultSet.getInt("playerScore") + "\n";
            }
            resultSet.close();
            preparedStatement.close();
            System.out.println(result);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void updateUserScore(PlayerEntity playerEntity, int newPlayerScore) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(SQL_UPDATE_USER_SCORE);
            preparedStatement.setInt(1, newPlayerScore);
            preparedStatement.setString(2, playerEntity.getPlayerEmail());
            preparedStatement.setString(3, playerEntity.getPlayerName());
            preparedStatement.setInt(4, newPlayerScore);
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
}