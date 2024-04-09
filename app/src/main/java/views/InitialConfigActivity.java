package views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.R;

import models.Player;

public class InitialConfigActivity extends AppCompatActivity {
    private Button startGameButton;
    private TextView nameText;
    private Player player;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initialconfigurationscreen);

        nameText = findViewById(R.id.editText);

        RadioButton easy = findViewById(R.id.radioButton);
        RadioButton medium = findViewById(R.id.radioButton2);
        RadioButton hard = findViewById(R.id.radioButton3);

        RadioButton elf = findViewById(R.id.elfButton);
        RadioButton wizard = findViewById(R.id.wizardButton);
        RadioButton paladin = findViewById(R.id.paladinButton);

        error = findViewById(R.id.errorMsg);

        startGameButton = findViewById(R.id.startGameButton);
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startGame = new Intent(InitialConfigActivity.this,
                        GameActivity1.class);

                //name logic
                if (nameText.getText().toString().trim().equals("")) {
                    TextView error = findViewById(R.id.errorMsg);
                    error.setText("Please enter a valid name.");
                    return;
                }

                //difficulty logic
                String difficulty;
                if (easy.isChecked()) {
                    difficulty = "Easy";
                } else if (medium.isChecked()) {
                    difficulty = "Medium";
                } else if (hard.isChecked()) {
                    difficulty = "Hard";
                } else {
                    error.setText("Please select a difficulty.");
                    return;
                }

                //health logic
                int health;
                if (difficulty.equals("Easy")) {
                    health = 100;
                } else if (difficulty.equals("Medium")) {
                    health = 75;
                } else {
                    health = 50;
                }

                //sprite logic
                String sprite;
                if (elf.isChecked()) {
                    sprite = "Elf";
                } else if (wizard.isChecked()) {
                    sprite = "Wizard";
                } else if (paladin.isChecked()) {
                    sprite = "Paladin";
                } else {
                    error.setText("Please select a sprite.");
                    return;
                }

                // pass on data
                player = Player.getPlayerInstance();
                player.setName(nameText.getText().toString());
                player.setDifficulty(difficulty);
                player.setHealth(health);
                player.setSprite(sprite);

                startActivity(startGame);
            }
        });
    }
}
