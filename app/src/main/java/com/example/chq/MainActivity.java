package com.example.chq;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    TextView question;
    Button bt_true, bt_false;

    Questions my_questions;
    int question_length;

    ArrayList<Item> question_list;

    int qurrent_question = 0;

    boolean winner = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = (TextView) findViewById(R.id.question);
        bt_true = (Button) findViewById(R.id.bt_true);
        bt_false = (Button) findViewById(R.id.bt_false);

        my_questions = new Questions();
        question_length = my_questions.my_questions.length;

        question_list = new ArrayList<>();

        for (int i=0; i<question_length; i++){
            question_list.add(new Item(my_questions.getQuestions(i), my_questions.getAnswers(i)));
        }

        Collections.shuffle(question_list);
        setQuestion(qurrent_question);




        bt_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check_question(qurrent_question)) {
                    qurrent_question++;
                    if (qurrent_question<question_length) {
                    setQuestion(qurrent_question);
                    }else {
                    winner = true;
                    end_game();
                    }

                }else {
                end_game();
                }

            }
        });
        bt_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!check_question(qurrent_question)) {
                    qurrent_question++;
                    if (qurrent_question<question_length) {
                        setQuestion(qurrent_question);
                    }else {
                        winner = true;
                        end_game();
                    }

                }else {
                    end_game();
                }

            }
        });

    }
private void setQuestion (int number){
        question.setText(question_list.get(number).getQuestion());

}
private boolean check_question (int number){
        String answer = question_list.get(number).getAnswer();
        return answer.equals("true");
}

private void end_game(){
        if (winner) {
        Toast.makeText(this, "Ты победил!", Toast.LENGTH_SHORT).show();
        finish();}
        else {
        Toast.makeText(this, "Ты проиграл :(", Toast.LENGTH_SHORT).show();
        finish();
    }
    }
}

