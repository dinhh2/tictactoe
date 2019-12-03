package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button[][] buttons = new Button[3][3];

    int round;

    private boolean playerTurn = true;

    TextView text;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons[0][0] = (Button) findViewById(R.id.button0);
        buttons[0][1] = (Button) findViewById(R.id.button1);
        buttons[0][2] = (Button) findViewById(R.id.button2);
        buttons[1][0] = (Button) findViewById(R.id.button3);
        buttons[1][1] = (Button) findViewById(R.id.button4);
        buttons[1][2] = (Button) findViewById(R.id.button5);
        buttons[2][0] = (Button) findViewById(R.id.button6);
        buttons[2][1] = (Button) findViewById(R.id.button7);
        buttons[2][2] = (Button) findViewById(R.id.button8);
        text = (TextView) findViewById(R.id.status);
        button = (Button) findViewById(R.id.button11);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        buttons[i][j].setText("");
                        buttons[i][j].setClickable(true);
                    }
                }
                round = 0;
                playerTurn = true;
                text.setText("Player's Turn");
            }
        });

        buttons[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!buttons[0][0].getText().toString().equals(""))
                    return;
                if (playerTurn){
                    buttons[0][0].setText("X");
                    buttons[0][0].setTextColor(Color.RED);
                    playerTurn = false;
                    if (checkWin())
                        stopGame();
                    else
                        compTurn();
                }
            }
        });

        buttons[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!buttons[0][1].getText().toString().equals(""))
                    return;
                if (playerTurn){
                    buttons[0][1].setText("X");
                    buttons[0][1].setTextColor(Color.RED);
                    playerTurn = false;
                    if (checkWin())
                        stopGame();
                    else
                        compTurn();
                }
            }
        });

        buttons[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!buttons[0][2].getText().toString().equals(""))
                    return;
                if (playerTurn){
                    buttons[0][2].setText("X");
                    buttons[0][2].setTextColor(Color.RED);
                    playerTurn = false;
                    if (checkWin())
                        stopGame();
                    else
                        compTurn();
                }
            }
        });

        buttons[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!buttons[1][0].getText().toString().equals(""))
                    return;
                if (playerTurn){
                    buttons[1][0].setText("X");
                    buttons[1][0].setTextColor(Color.RED);
                    playerTurn = false;
                    if (checkWin())
                        stopGame();
                    else
                        compTurn();
                }
            }
        });

        buttons[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!buttons[1][1].getText().toString().equals(""))
                    return;
                if (playerTurn){
                    buttons[1][1].setText("X");
                    buttons[1][1].setTextColor(Color.RED);
                    playerTurn = false;
                    if (checkWin())
                        stopGame();
                    else
                        compTurn();
                }
            }
        });

        buttons[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!buttons[1][2].getText().toString().equals(""))
                    return;
                if (playerTurn){
                    buttons[1][2].setText("X");
                    buttons[1][2].setTextColor(Color.RED);
                    playerTurn = false;
                    if (checkWin())
                        stopGame();
                    else
                        compTurn();
                }
            }
        });

        buttons[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!buttons[2][0].getText().toString().equals(""))
                    return;
                if (playerTurn){
                    buttons[2][0].setText("X");
                    buttons[2][0].setTextColor(Color.RED);
                    playerTurn = false;
                    if (checkWin())
                        stopGame();
                    else
                        compTurn();
                }
            }
        });

        buttons[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!buttons[2][1].getText().toString().equals(""))
                    return;
                if (playerTurn){
                    buttons[2][1].setText("X");
                    buttons[2][1].setTextColor(Color.RED);
                    playerTurn = false;
                    if (checkWin())
                        stopGame();
                    else
                        compTurn();
                }
            }
        });

        buttons[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!buttons[2][2].getText().toString().equals(""))
                    return;
                if (playerTurn){
                    buttons[2][2].setText("X");
                    buttons[2][2].setTextColor(Color.RED);
                    playerTurn = false;
                    if (checkWin())
                        stopGame();
                    else
                        compTurn();
                }
            }
        });

    }

    private void compTurn() {
        round++;
        int r = new Random().nextInt(3);
        int r2 = new Random().nextInt(3);
        if (round != 5) {
            while (!buttons[r][r2].getText().toString().equals("")) {
                r = new Random().nextInt(3);
                r2 = new Random().nextInt(3);
            }
            buttons[r][r2].setText("O");
            buttons[r][r2].setTextColor(Color.BLUE);
            checkWin();
            if (checkWin())
                stopGame();
            else
                playerTurn = true;
        }
        if (round == 5)
            text.setText("Draw!");
    }

    private boolean checkWin() {
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && !board[i][0].equals("")) {
                whoWon(board[i][0]);
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && !board[0][i].equals("")) {
                whoWon(board[0][i]);
                return true;
            }
        }

        if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].equals("")) {
            whoWon(board[0][0]);
            return true;
        }

        if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].equals("")) {
            whoWon(board[0][2]);
            return true;
        }
        return false;
    }

    private void whoWon(String s) {
        if (s.equals("X")) {
            text.setText("Player wins!");
        }
        else {
            text.setText("Comp wins!");
        }
    }

    private void stopGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setClickable(false);
            }
        }
    }
}
