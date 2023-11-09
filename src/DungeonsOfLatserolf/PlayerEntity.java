package DungeonsOfLatserolf;

public class PlayerEntity {
    private int idPlayer;
    private String playerName;
    private int playerScore;

    public PlayerEntity(int idPlayer, String playerName, int playerScore) {
        this.idPlayer = idPlayer;
        this.playerName = playerName;
        this.playerScore = playerScore;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
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