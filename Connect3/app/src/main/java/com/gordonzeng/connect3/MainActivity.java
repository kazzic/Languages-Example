package com.gordonzeng.connect3;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    //0 = yellow, 1 = red
    int activePlayer = 0;
    int [] gameState = {2, 2, 2,
                        2, 2, 2,
                        2, 2, 2};
    String player1Win = "Yellow has won!";
    String player2Win = "Red has won!";

    public boolean hasWon() {

        //check columns
        for (int i = 0; i < 3; i++) {
            if (gameState[i] == activePlayer
                    && gameState[i + 3] == activePlayer
                    && gameState[i + 6] == activePlayer)
                return true;
        }
        //check rows
        for (int i = 0; i < 9; i += 3) {
            if (gameState[i] == activePlayer
                    && gameState[i+1] == activePlayer
                    && gameState[i+2] == activePlayer)
                return true;

        }
        //check diagonals
        if (gameState[0] == activePlayer
                && gameState[4] == activePlayer
                && gameState[8] == activePlayer)
            return true;
        if (gameState[2] == activePlayer
                && gameState[4] == activePlayer
                && gameState[6] == activePlayer)
            return true;

        return false;
    }

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;
        int id = Integer.parseInt(counter.getTag().toString());
        if (gameState[id-1] != 2) return;
        counter.setTranslationY(-1000f);
        if (activePlayer == 0) {
            counter.setImageResource(R.drawable.yellow);
            gameState[id-1] = 0;
            if(hasWon()) {
                //Make the victory layout appear
                LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                winnerMessage.setText(player1Win);
                layout.setVisibility(View.VISIBLE);
                //Toast.makeText(getApplicationContext(), player1Win, Toast.LENGTH_LONG).show();
            }
            if(drawGame()) {
                LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                winnerMessage.setText("It's a draw!");
                layout.setVisibility(View.VISIBLE);
            }
            activePlayer = 1;

        }
        else {
            counter.setImageResource(R.drawable.red);
            gameState[id-1] = 1;
            if(hasWon()) {
                //Toast.makeText(getApplicationContext(), player2Win, Toast.LENGTH_LONG).show();
                LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                winnerMessage.setText(player2Win);
                layout.setVisibility(View.VISIBLE);
            }
            if(drawGame()) {
                LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                winnerMessage.setText("It's a draw!");
                layout.setVisibility(View.VISIBLE);
            }
            activePlayer = 0;
        }
        if(!hasWon())
            counter.animate().translationYBy(1000f).rotation(36000).setDuration(300);

    }

    public void playAgain(View view) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++)
            gameState[i] = 2;
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for (int i = 0; i < gridLayout.getChildCount(); i++)
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
    }

    public boolean drawGame() {
        if (!hasWon()) {
            for (int i = 0; i < gameState.length; i++)
                if (gameState[i] == 2) return false;
        }
        else return false;
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
