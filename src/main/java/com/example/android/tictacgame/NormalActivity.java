package com.example.android.tictacgame;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;
import static android.R.attr.id;
import static com.example.android.tictacgame.R.id.button1;
import static com.example.android.tictacgame.R.id.button3;

public class NormalActivity extends AppCompatActivity {
     int[][] table;
     boolean xMove;
    int x = 0;
    int y = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        table = new int[3][3];
        xMove=true;

    }
    public void makeMove(View v)
    {


        int id = v.getId();
        switch(id)
        {
            case button1: break;
            case R.id.button2: x = 0;
                y = 1;
                break;
            case R.id.button3: x = 0;
                y = 2;
                break;
            case R.id.button4: x = 1;
                y = 0;
                break;
            case R.id.button5: x = 1;
                y = 1;
                break;
            case R.id.button6: x = 1;
                y = 2;
                break;
            case R.id.button7: x = 2;
                y = 0;
                break;
            case R.id.button8: x = 2;
                y = 1;
                break;
            case R.id.button9: x = 2;
                y = 2;
                break;
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
        for (int i = 0; i != 3; ++i)
        {
            for (int j = 0; j != 3; ++j)
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
        for (int i = 0; i != 3; ++i)
        {
            if (table[i][0] == 1 && table[i][1] == 1 && table[i][2] == 1)
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
            if (table[i][0] == 2 && table[i][1] == 2 && table[i][2] == 2)
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
        for (int i = 0; i != 3; ++i)
        {
            if (table[0][i] == 1 && table[1][i] == 1 && table[2][i] == 1)
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
            if (table[0][i] == 2 && table[1][i] == 2 && table[2][i] == 2)
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
        if (table[0][0] == 1 && table[1][1] == 1 && table[2][2] == 1)
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
        if (table[0][0] == 2 && table[1][1] == 2 && table[2][2] == 2)
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
        if (table[0][2] == 1 && table[1][1] == 1 && table[2][0] == 1)
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
        if (table[0][2] == 2 && table[1][1] == 2 && table[2][0] == 2)
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
    setContentView(R.layout.activity_normal);
    table = new int[3][3];
    xMove=true;
}
public void switch1(View v){
    Intent myIntent = new Intent(NormalActivity.this,board2Activity.class);
    NormalActivity.this.startActivity(myIntent);
}

    }
