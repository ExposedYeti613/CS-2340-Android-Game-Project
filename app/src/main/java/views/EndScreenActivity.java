package views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import models.Player;
import models.ScoreEntry;
import models.LeaderboardManager;

public class EndScreenActivity extends AppCompatActivity {

    private Button restartButton;

    private TextView recentAttemptText;

    private Player player;
    public boolean hasValidButton() {
        if (restartButton != null) {
            return true;
        }
        return false;
    }

    public boolean validLeaderBoard() {
        if (recentAttemptText != null) {
            return true;
        }
        return false;
    }

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endingscreen);

        player = Player.getPlayerInstance();
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                Locale.getDefault()).format(new Date());
        ScoreEntry newEntry = new ScoreEntry(player.getName(), player.getScore(), timestamp);
        LeaderboardManager.getInstance().addScoreEntry(newEntry);
        LeaderboardManager.getInstance().setRecentEntry(newEntry);


        // Display text depending if Player wins or not
        boolean playerWon = getIntent().getBooleanExtra("playerWon", false);
        TextView winLoseTextView = findViewById(R.id.Win_Lose_Text);
        if (playerWon) {
            winLoseTextView.setText("You Win!!!");
        } else {
            winLoseTextView.setText("You Lose!!!");
        }



        // Fetch the leaderboard data
        List<ScoreEntry> leaderboard = LeaderboardManager.
                getInstance().getLeaderboard();

        StringBuilder leaderboardText = new StringBuilder();
        int rank = 1;
        String headerFormat = "%-10s %-20s %-20s %-20s%n";
        String rowFormat = "%-15d %-25s %-20d %-20s%n";
        leaderboardText.append(String.format(headerFormat, "Rank",
                "Player Name", "Score", "Date"));

        for (ScoreEntry entry : leaderboard) {
            leaderboardText.append(String.format(rowFormat,
                    rank,
                    entry.getPlayerName(),
                    entry.getScore(),
                    entry.getTimestamp()));
            rank++;
        }

        // Set the TextView's text to the formatted leaderboard data
        TextView scoreTextView = findViewById(R.id.Score);
        scoreTextView.setText(leaderboardText.toString());
        restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restart = new Intent(EndScreenActivity.this,
                        MainActivity.class);
                startActivity(restart);
            }
        });

        // Recent Attempt Text
        recentAttemptText = findViewById(R.id.recentAttemptText);
        ScoreEntry recentEntry = LeaderboardManager.getInstance().getRecentEntry();
        recentAttemptText.setText("Recent Attempt: \n " + recentEntry.getPlayerName()
                + "\n Score: " + recentEntry.getScore() + "\n Date: " + recentEntry.getTimestamp());
    }

    public String determineWinLoseText(boolean playerWon) {
        return playerWon ? "You Win!!!" : "You Lose!!!";
    }

}
