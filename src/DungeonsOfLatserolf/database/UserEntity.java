package DungeonsOfLatserolf.database;

public class UserEntity {
    private String userEmail;
    private String userName;
    private int userScore;

    public UserEntity(String userEmail, String userName) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userScore = 0;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public void reset() {
        this.userEmail = null;
        this.userName = null;
        this.userScore = 0;
    }
}