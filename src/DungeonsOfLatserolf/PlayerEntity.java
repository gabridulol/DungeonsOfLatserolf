package DungeonsOfLatserolf;

public class PlayerEntity {
    private int idPlayer;
    private String playerEmail;
    private String playerName;
    private int playerScore;

    public PlayerEntity(String playerEmail, String playerName, int playerScore) {
        this.playerEmail = playerEmail;
        this.playerName = playerName;
        this.playerScore = playerScore;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getPlayerEmail() {
        return playerEmail;
    }

    public void setPlayerEmail(String playerEmail) {
        this.playerEmail = playerEmail;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }    
}