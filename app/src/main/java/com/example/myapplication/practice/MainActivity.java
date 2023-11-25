package com.example.myapplication.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    boolean game = true;
    int activePlayer = 0;
    int gameTurn[] = {9, 9, 9, 9, 9, 9, 9, 9, 9}; // null array

    // array of possible win positions
    int winningPositions[][] = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {2, 4, 6}, {0, 4, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}};

    public void aa(View view) {
        if (game != true) {
            gameReset(view);
        }
        ImageView img = (ImageView) view;
        int tapped = Integer.parseInt(img.getTag().toString());
        if (gameTurn[tapped] == 9) {
            gameTurn[tapped] = activePlayer;
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.a);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("square's turn, Tap to play");
            } else {
                img.setImageResource(R.drawable.g);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("hussain's turn, Tap to play");
            }

        }

        // check for winning positions
        for (int[] winningPosition : winningPositions) {
                if (gameTurn[winningPosition[0]] == gameTurn[winningPosition[1]] &&
                        gameTurn[winningPosition[1]] == gameTurn[winningPosition[2]] &&
                        gameTurn[winningPosition[0]] != 9) {

                    //announce a winner
                    String winner;
                    game = false; //reset the game after someone has won it
                    if (gameTurn[winningPosition[0]] == 0) {
                        winner = "hussain has won!";
                    } else {
                        winner = "square has won!";
                    }
                    TextView status = findViewById(R.id.status);
                    status.setText(winner);
                    return;
                }

            }

        }
        public void gameReset (View view)
        {
            activePlayer = 0;
            game = true;
            // Reset all grid cells to their initial empty state
            for (int i = 0; i < gameTurn.length; i++) {
                gameTurn[i] = 9; // 9 represents an empty cell
            }

            ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);

            TextView status = findViewById(R.id.status);
            status.setText("Tap to play");

        }

    }