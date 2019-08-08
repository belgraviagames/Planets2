package com.example.chq;

public class Questions {

    public String my_questions[] = {
            "В солнечной системе более миллиарда звезд",
            "Земля четвертая планета от солнца",
            "Плутон это планета",
            "В солнечной системе восемь планет",
            "Марс нужно колонизировать",
            "Это хорошая игра"

    };
    public String my_answers[] = {
            "false",
            "false",
            "false",
            "true",
            "true",
            "true"

    };

    public String getQuestions (int number) {
return my_questions[number];
    }
    public String getAnswers (int number) {
        return my_answers[number];
    }


}
