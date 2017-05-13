package com.example;

import java.util.ArrayList;
import java.util.Random;

public class Joking {

    public String myJoke = "";

    public Joking() {

        myjokes.add("A snail walks into a bar and the barman tells him there's a strict policy about having snails in the bar and so kicks him out. A year later the same snail re-enters the bar and asks the barman \"What did you do that for?\" ");
        myjokes.add("Mother: \"Did you enjoy your first day at school?\" \n" +
                "Girl: \"First day? Do you mean I have to go back tomorrow? ");
        myjokes.add("A: Hey, man! Please call me a taxi. \n" +
                "B: Yes, sir. You are a taxi. ");
        myjokes.add("\"You look very funny wearing that belt.\" \n" +
                "\"I would look even funnier if I didn't wear it.\"");
        myjokes.add("\"I was born in California.\" \n" +
                "\"Which part?\" \n" +
                "\"All of me.\"");


        myJoke = tellMeJoke();
    }


    static ArrayList<String> myjokes = new ArrayList<String>();

    public static String tellMeJoke() {


        Random rand = new Random();

        return myjokes.get(rand.nextInt(4));
    }


}
