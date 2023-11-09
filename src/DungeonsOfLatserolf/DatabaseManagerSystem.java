package DungeonsOfLatserolf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

public class DatabaseManagerSystem {
    private static final String url = "jdbc:mysql://localhost:3306/DungeonsOfLatserolf";
    private static final String user = "root";
    private static final String password = "r4@P36~y_buT";
    private static Connection connection;

    private static final String SQL_INSERT_NEW_USER = "INSERT INTO TBPlayer (playerEmail, playerName, playerScore) VALUES (?, ?, ?)";

    public static Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(url, user, password);
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

    public void newUser(PlayerEntity playerEntity) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(SQL_INSERT_NEW_USER);
            preparedStatement.setString(1, playerEntity.getPlayerEmail());
            preparedStatement.setString(2, playerEntity.getPlayerName());
            preparedStatement.setInt(3, playerEntity.getPlayerScore());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
