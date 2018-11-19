package com.example.chayan.quesgame;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button ans1,ans2,ans3,ans4;
    TextView score,question;

    ImageView imgview;
    //private int current_image;
    //int[] images={R.drawable.th,R.drawable.th1,R.drawable.th2,R.drawable.th4};



    private Questions mQuestions = new Questions();

    private String mAnswer;
    private  int mScore=0;
    private  int mQuestionLength= mQuestions.mQuestions.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        r = new Random();

        ans1 = (Button) findViewById(R.id.answer1);
        ans2 = (Button)findViewById(R.id.answer2);
        ans3 =(Button) findViewById(R.id.answer3);
        ans4 = (Button)findViewById(R.id.answer4);

        score = (TextView)findViewById(R.id.textscore);
        question = (TextView)findViewById(R.id.textquestion);

        imgview = (ImageView)findViewById(R.id.img2);

        score.setText("Score:"+mScore);

        updateQuestion(r.nextInt(mQuestionLength));

        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans1.getText()==mAnswer){
                    mScore++;
                    score.setText("Score:"+mScore);
                    updateQuestion(r.nextInt(mQuestionLength));

                    //current_image++;
                   // current_image=current_image%images.length;
                   // imgview.setImageResource(images[current_image]);
                }
                else
                {
                    gameOver();
                }

            }
        });

        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans2.getText()==mAnswer){
                    mScore++;
                    score.setText("Score:"+mScore);
                    updateQuestion(r.nextInt(mQuestionLength));
                }
                else
                {
                    gameOver();
                }

            }
        });
        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans3.getText()==mAnswer){
                    mScore++;
                    score.setText("Score:"+mScore);
                    updateQuestion(r.nextInt(mQuestionLength));
                }
                else
                {
                    gameOver();
                }

            }
        });

        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans4.getText()==mAnswer){
                    mScore++;
                    score.setText("Score:"+mScore);
                    updateQuestion(r.nextInt(mQuestionLength));
                }
                else
                {
                    gameOver();
                }

            }
        });

    }



    private void updateQuestion(int num) {
        question.setText(mQuestions.getQuestions(num));
        ans1.setText(mQuestions.getChoice1(num));
        ans2.setText(mQuestions.getChoice2(num));
        ans3.setText(mQuestions.getChoice3(num));
        ans4.setText(mQuestions.getChoice4(num));

        mAnswer=mQuestions.getCorrectAnswer(num);
    }

    private void gameOver() {
        AlertDialog.Builder alertDiaglogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDiaglogBuilder
                .setMessage("Game over! Your score is"+mScore+"points")
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();

                            }
                        })
                .setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                //imgview.setImageResource(R.drawable.th4);
                               finish();
                            }
                        });
        AlertDialog alertDialog = alertDiaglogBuilder.create();
        alertDialog.show();

    }
}
