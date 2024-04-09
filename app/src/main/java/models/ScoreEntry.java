package models;

public class ScoreEntry {
    private final String playerName;
    private final int score;
    private final String timestamp;

    public ScoreEntry(String playerName, int score, String timestamp) {
        this.playerName = playerName;
        this.score = score;
        this.timestamp = timestamp;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public static boolean checkNegativeScore(int score) {
        if (score >= 0) {
            return true;
        }
        return false;
    }

}
