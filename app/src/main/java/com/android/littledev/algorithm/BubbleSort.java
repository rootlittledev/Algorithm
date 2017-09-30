package com.android.littledev.algorithm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;


public class BubbleSort extends AppCompatActivity {

    Button elementValue1;
    Button elementValue2;

    TextView element1;
    TextView element2;

    TextView loopAmount;
    TextView stepsAmount;

    Animation fadeIn;
    Animation fadeOut;

    HashMap<Integer, Integer> first;
    HashMap<Integer, Integer> second;

    int index;
    int originalPlace;
    int endPlace;
    int originalValue;
    int endValue;

    Integer[] keys;
    int[] values;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_sort);

        fadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_out);

        loopAmount = (TextView) findViewById(R.id.loop_amount);
        stepsAmount = (TextView) findViewById(R.id.steps_amount);

        values = new int[10];

        Random random = new Random();

        for (int index = 0; index < values.length; index++){
            values[index] = random.nextInt(10);
            initElements(index,index);
            elementValue1.setText("" + values[index]);
        }

        first = new HashMap<>();
        second = new HashMap<>();
    }

    void animationManager(){
        index = 0;
        originalPlace = 0;
        endPlace = 0;
        originalValue = 0;
        endValue = 0;

        sort();

        Set<Integer> keySet = first.keySet();
        keys  =  keySet.toArray(new Integer[keySet.size()]);

        if (index<keys.length) {
            initElements(first.get(index), second.get(index));
            initElementsValues(first.get(index), second.get(index));

            element1.startAnimation(fadeOut);
            element2.startAnimation(fadeOut);
            elementValue1.startAnimation(fadeOut);
            elementValue2.startAnimation(fadeOut);

            originalPlace = Integer.parseInt(element1.getText().toString());
            endPlace = Integer.parseInt(element2.getText().toString());
            originalValue = Integer.parseInt(elementValue1.getText().toString());
            endValue = Integer.parseInt(elementValue2.getText().toString());

            stepsAmount.setText("Steps: " + index);
        }
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                element1.startAnimation(fadeIn);
                element2.startAnimation(fadeIn);

                element1.setText("" + endPlace);
                element2.setText("" + originalPlace);

                elementValue1.startAnimation(fadeIn);
                elementValue2.startAnimation(fadeIn);

                elementValue1.setText("" + endValue);
                elementValue2.setText("" + originalValue);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ++index;
                if (index<keys.length) {
                    initElements(first.get(index), second.get(index));
                    initElementsValues(first.get(index), second.get(index));

                    element1.startAnimation(fadeOut);
                    element2.startAnimation(fadeOut);

                    elementValue1.startAnimation(fadeOut);
                    elementValue2.startAnimation(fadeOut);

                    originalPlace = Integer.parseInt(element1.getText().toString());
                    endPlace = Integer.parseInt(element2.getText().toString());
                    originalValue = Integer.parseInt(elementValue1.getText().toString());
                    endValue = Integer.parseInt(elementValue2.getText().toString());

                    stepsAmount.setText("Steps: " + index);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    public void onSort(View view){
        animationManager();
    }
   
    void initElements(int from, int to){
        switch (from){
            case 0:{
                elementValue1 = (Button) findViewById(R.id.element_1);
                break;
            }
            case 1:{
                elementValue1 = (Button) findViewById(R.id.element_2);
                break;
            }
            case 2:{
                elementValue1 = (Button) findViewById(R.id.element_3);
                break;
            }
            case 3:{
                elementValue1 = (Button) findViewById(R.id.element_4);
                break;
            }
            case 4:{
                elementValue1 = (Button) findViewById(R.id.element_5);
                break;
            }
            case 5:{
                elementValue1 = (Button) findViewById(R.id.element_6);
                break;
            }
            case 6:{
                elementValue1 = (Button) findViewById(R.id.element_7);
                break;
            }
            case 7:{
                elementValue1 = (Button) findViewById(R.id.element_8);
                break;
            }
            case 8:{
                elementValue1 = (Button) findViewById(R.id.element_9);
                break;
            }
            case 9:{
                elementValue1 = (Button) findViewById(R.id.element_10);
                break;
            }
            default:{
                elementValue1 = null;
                break;
            }
        }

        switch (to){
            case 0:{
                elementValue2 = (Button) findViewById(R.id.element_1);
                break;
            }
            case 1:{
                elementValue2 = (Button) findViewById(R.id.element_2);
                break;
            }
            case 2:{
                elementValue2 = (Button) findViewById(R.id.element_3);
                break;
            }
            case 3:{
                elementValue2 = (Button) findViewById(R.id.element_4);
                break;
            }
            case 4:{
                elementValue2 = (Button) findViewById(R.id.element_5);
                break;
            }
            case 5:{
                elementValue2 = (Button) findViewById(R.id.element_6);
                break;
            }
            case 6:{
                elementValue2 = (Button) findViewById(R.id.element_7);
                break;
            }
            case 7:{
                elementValue2 = (Button) findViewById(R.id.element_8);
                break;
            }
            case 8:{
                elementValue2 = (Button) findViewById(R.id.element_9);
                break;
            }
            case 9:{
                elementValue2 = (Button) findViewById(R.id.element_10);
                break;
            }
            default:{
                elementValue2 = null;
                break;
            }
        }
    }

    void initElementsValues(int from, int to){
        switch (from){
            case 0:{
                element1 = (TextView) findViewById(R.id.element_value_1);
                break;
            }
            case 1:{
                element1 = (TextView) findViewById(R.id.element_value_2);
                break;
            }
            case 2:{
                element1 = (TextView) findViewById(R.id.element_value_3);
                break;
            }
            case 3:{
                element1 = (TextView) findViewById(R.id.element_value_4);
                break;
            }
            case 4:{
                element1 = (TextView) findViewById(R.id.element_value_5);
                break;
            }
            case 5:{
                element1 = (TextView) findViewById(R.id.element_value_6);
                break;
            }
            case 6:{
                element1 = (TextView) findViewById(R.id.element_value_7);
                break;
            }
            case 7:{
                element1 = (TextView) findViewById(R.id.element_value_8);
                break;
            }
            case 8:{
                element1 = (TextView) findViewById(R.id.element_value_9);
                break;
            }
            case 9:{
                element1 = (TextView) findViewById(R.id.element_value_10);
                break;
            }
            default:{
                element1 = null;
                break;
            }
        }

        switch (to){
            case 0:{
                element2 = (TextView) findViewById(R.id.element_value_1);
                break;
            }
            case 1:{
                element2 = (TextView) findViewById(R.id.element_value_2);
                break;
            }
            case 2:{
                element2 = (TextView) findViewById(R.id.element_value_3);
                break;
            }
            case 3:{
                element2 = (TextView) findViewById(R.id.element_value_4);
                break;
            }
            case 4:{
                element2 = (TextView) findViewById(R.id.element_value_5);
                break;
            }
            case 5:{
                element2 = (TextView) findViewById(R.id.element_value_6);
                break;
            }
            case 6:{
                element2 = (TextView) findViewById(R.id.element_value_7);
                break;
            }
            case 7:{
                element2 = (TextView) findViewById(R.id.element_value_8);
                break;
            }
            case 8:{
                element2 = (TextView) findViewById(R.id.element_value_9);
                break;
            }
            case 9:{
                element2 = (TextView) findViewById(R.id.element_value_10);
                break;
            }
            default:{
                element2 = null;
                break;
            }

        }
    }

    void sort(){
        boolean sorting = true;
        int loop = 1;
        int counter = 0;
        int offset = 0;

        System.out.println("To sort");
        for (int value : values) {
            System.out.print(" " + value);
        }
        System.out.println();

        while (sorting){
            sorting = false;

            for (int index = 0; index < values.length - 1 - offset; index++) {
                if (values[index] > values[index + 1]) {
                    int temp = values[index];

                    values[index] = values[index + 1];
                    values[index + 1] = temp;

                    sorting = true;

                    first.put(counter,index);
                    second.put(counter, index + 1);

                    counter++;
                }
            }

            System.out.println("Loop: " + loop);
            loopAmount.setText("Loops: " + loop);
            for (int element : values)
                System.out.print(" " + element);
            System.out.println();

            loop++;
            offset++;
        }
    }
}
