package com.example.android.tictacgame;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.android.tictacgame.R.id.button1;

public class board2Activity extends AppCompatActivity {
    int[][] table;
    boolean xMove;
    int x = 0;
    int y = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board2);
        table = new int[5][5];
        xMove=true;
    }
    public void makeMove(View v) {


        int id = v.getId();
        switch (id) {
            case R.id.button1:
                x = 0;
                y = 0;
                break;
            case R.id.button2:
                x = 0;
                y = 1;
                break;
            case R.id.button3:
                x = 0;
                y = 2;
                break;
            case R.id.button4:
                x = 0;
                y = 3;
                break;
            case R.id.button5:
                x = 0;
                y = 4;
                break;
            case R.id.button6:
                x = 1;
                y = 0;
                break;
            case R.id.button7:
                x = 1;
                y = 1;
                break;
            case R.id.button8:
                x = 1;
                y = 2;
                break;
            case R.id.button9:
                x = 1;
                y = 3;
                break;
            case R.id.button10:
                x = 1;
                y = 4;
                break;
            case R.id.button11:
                x = 2;
                y = 0;
                break;
            case R.id.button12:
                x = 2;
                y = 1;
                break;
            case R.id.button13:
                x = 2;
                y = 2;
                break;
            case R.id.button14:
                x = 2;
                y = 3;
            case R.id.button15:
                x = 2;
                y = 4;
                break;
            case R.id.button16:
                x = 3;
                y = 0;
                break;
            case R.id.button17:
                x = 3;
                y = 1;
                break;
            case R.id.button18:
                x = 3;
                y = 2;
                break;
            case R.id.button19:
                x = 3;
                y = 3;
            case R.id.button20:
                x = 3;
                y = 4;
                break;
            case R.id.button21:
                x = 4;
                y = 0;
                break;
            case R.id.button22:
                x = 4;
                y = 1;
                break;
            case R.id.button23:
                x = 4;
                y = 2;
                break;
            case R.id.button24:
                x = 4;
                y = 3;
            case R.id.button25:
                x = 4;
                y = 4;
        }

        if(table[x][y] != 0)
        {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

            dlgAlert.setMessage("This cell is not empty!");
            dlgAlert.setTitle("Error");
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
            return;
        }

        Button btn = (Button) findViewById(id);
        TextView label = (TextView) findViewById(R.id.moveTextView);
        if(xMove)
        {
            btn.setText("X");
            table[x][y] = 2;
            label.setText("O move");
            xMove = false;
        }

        else
        {
            btn.setText("O");
            table[x][y] = 1;
            xMove = true;

            label.setText("X move");
        }
        checkResult();
    }

    private void checkResult() {
        boolean empty = false;
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        for (int i = 0; i != 5; ++i)
        {
            for (int j = 0; j != 5; ++j)
            {
                if (table[i][j]==0)
                {
                    empty = true;
                    break;
                }
            }
        }
        if (!empty)
        {
            dlgAlert.setMessage("Draw!");
            dlgAlert.setTitle("Draw");
            dlgAlert.setCancelable(true);
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();

                        }
                    });
            dlgAlert.create().show();

        }
        //check horizontal lines
        for (int i = 0; i != 5; ++i)
        {
            if (table[i][0] == 1 && table[i][1] == 1 && table[i][2] == 1 && table[i][3] == 1 && table[i][4]== 1 )
            {
                dlgAlert.setMessage("O Player wins!");
                dlgAlert.setTitle("congratulations");
                dlgAlert.setCancelable(true);
                dlgAlert.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                dlgAlert.create().show();

            }
            if (table[i][0] == 2 && table[i][1] == 2 && table[i][2] == 2  && table[i][3] == 2 && table[i][4]== 2 )
            {
                dlgAlert.setMessage("X Player wins!");
                dlgAlert.setTitle("congratulations");
                dlgAlert.setCancelable(true);
                dlgAlert.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                dlgAlert.create().show();

            }
        }
        //check vertical lines
        for (int i = 0; i != 5; ++i)
        {
            if (table[0][i] == 1 && table[1][i] == 1 && table[2][i] == 1 && table[3][i] == 1 && table[4][i] == 1)
            {
                dlgAlert.setMessage("O Player wins!");
                dlgAlert.setTitle("congratulations");
                dlgAlert.setCancelable(true);
                dlgAlert.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                dlgAlert.create().show();

            }
            if (table[0][i] == 2 && table[1][i] == 2 && table[2][i] == 2 && table[3][i] == 2 && table[4][i] == 2)
            {
                dlgAlert.setMessage("X Player wins!");
                dlgAlert.setTitle("congratulations");
                dlgAlert.setCancelable(true);
                dlgAlert.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                dlgAlert.create().show();

            }
        }
        //check diagonals
        if (table[0][0] == 1 && table[1][1] == 1 && table[2][2] == 1 && table[3][3] == 1 && table[4][4] == 1)
        {
            dlgAlert.setMessage("O Player wins!");
            dlgAlert.setTitle("congratulations");
            dlgAlert.setCancelable(true);
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            dlgAlert.create().show();

        }
        if (table[0][0] == 2 && table[1][1] == 2 && table[2][2] == 2 && table[3][3] == 2 && table[4][4] == 2)
        {
            dlgAlert.setMessage("X Player wins!");
            dlgAlert.setTitle("congratulations");
            dlgAlert.setCancelable(true);
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            dlgAlert.create().show();

        }
        if (table[0][4] == 1 && table[1][3] == 1 && table[2][2] == 1 && table[3][1] == 1 && table[4][0] == 1)
        {
            dlgAlert.setMessage("O Player wins!");
            dlgAlert.setTitle("congratulations");
            dlgAlert.setCancelable(true);
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            dlgAlert.create().show();

        }
        if (table[0][4] == 2 && table[1][3] == 2 && table[2][2] == 2 && table[3][1] == 2 && table[4][0] == 2)
        {
            dlgAlert.setMessage("X Player wins!");
            dlgAlert.setTitle("congratulations");
            dlgAlert.setCancelable(true);
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            dlgAlert.create().show();

        }
    }
    public void reset(View v){
        setContentView(R.layout.activity_board2);
        table = new int[5][5];
        xMove=true;
    }
}
