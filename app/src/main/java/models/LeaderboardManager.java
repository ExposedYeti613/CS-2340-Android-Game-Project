package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeaderboardManager {
    private static final LeaderboardManager instance = new LeaderboardManager();
    private final List<ScoreEntry> leaderboard;

    private LeaderboardManager() {
        leaderboard = new ArrayList<>();
    }

    public static LeaderboardManager getInstance() {
        return instance;
    }

    private ScoreEntry recentEntry;

    public void addScoreEntry(ScoreEntry entry) {
        leaderboard.add(entry);
        leaderboard.sort(Comparator.comparing(ScoreEntry::getScore).reversed());
        if (leaderboard.size() > 10) {
            leaderboard.remove(10);  // keep only top 10 entries
        }
    }

    public List<ScoreEntry> getLeaderboard() {
        return leaderboard;
    }

    public void clear() {
        leaderboard.clear();
    }

    public void setRecentEntry(ScoreEntry entry) {
        recentEntry = entry;
    }

    public ScoreEntry getRecentEntry() {
        return recentEntry;
    }
}


