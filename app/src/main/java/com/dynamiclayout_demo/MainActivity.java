package com.dynamiclayout_demo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static Button vertical, horizontal, customHorizontal;
    private static LinearLayout layoutHolder;

    //Array for holding refrences
    private static Button[] buttonHolder;
    private static TextView[] textHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setListeners();
    }

    //Init all Views
    private void initViews() {
        vertical = (Button) findViewById(R.id.verticalLayout);
        horizontal = (Button) findViewById(R.id.horizontalLayout);
        customHorizontal = (Button) findViewById(R.id.customHorizontalLayout);
        layoutHolder = (LinearLayout) findViewById(R.id.layoutHolder);
    }

    //Set click listeners over all buttons
    private void setListeners() {
        vertical.setOnClickListener(this);
        horizontal.setOnClickListener(this);
        customHorizontal.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.verticalLayout:
                showVerticalLayout();
                break;
            case R.id.horizontalLayout:
                showHorizontalLayout();
                break;
            case R.id.customHorizontalLayout:
                showCustomHorizontalLayout();
                break;

            //Cases for dynamic added Button and TextViews
            //In this we are changing text of view
            case 0:
                ((TextView) view).setText("Text Changed");
                break;
            case 1:
                ((TextView) view).setText("Text Changed");
                break;
            case 2:
                ((TextView) view).setText("Text Changed");
                break;
            case 3:
                ((TextView) view).setText("Text Changed");
                break;
            case 4:
                ((TextView) view).setText("Text Changed");
                break;


        }

    }

    //Show vertical layout method
    private void showVerticalLayout() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); //Layout params for Button
        layoutHolder.removeAllViews();//Remove all views from Layout before placing new view
        buttonHolder = new Button[5];//Setting size of Button Array

        //Loop for 5 items
        for (int i = 0; i < 5; i++) {
            Button button = new Button(this);//Creating Button
            button.setId(i);//Setting Id for using in future
            button.setText("Item " + i);//Setting text
            button.setTextSize(15);//Text Size
            button.setPadding(5, 5, 5, 5);//paading
            button.setLayoutParams(params);//Setting Layout Params
            button.setTextColor(Color.parseColor("#000000"));//Text Colort
            button.setGravity(Gravity.CENTER);//Gravity of Text
            button.setOnClickListener(this);//Setting click listener
            buttonHolder[i] = button;//Setting button reference in array for future use
            layoutHolder.setOrientation(LinearLayout.VERTICAL);//Setting Layout orientation
            layoutHolder.addView(button);//Finally adding view
        }
    }

    //Show Horizontal Layout Method
    private void showHorizontalLayout() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT); //Layout params for Button
        layoutHolder.removeAllViews();//Remove all views from Layout before placing new view
        buttonHolder = new Button[3];//Setting size of Button Array

        //Loop for 3 items
        for (int i = 0; i < 3; i++) {
            Button button = new Button(this);//Creating Button
            button.setId(i);//Setting Id for using in future
            button.setText("Item " + i);//Setting text
            button.setTextSize(15);//Text Size
            button.setPadding(5, 5, 5, 5);//paading
            button.setLayoutParams(params);//Setting Layout Params
            button.setTextColor(Color.parseColor("#000000"));//Text Colort
            button.setGravity(Gravity.CENTER);//Gravity of Text
            button.setOnClickListener(this);//Setting click listener
            buttonHolder[i] = button;//Setting button reference in array for future use
            layoutHolder.setOrientation(LinearLayout.HORIZONTAL);//Setting Layout orientation
            layoutHolder.addView(button);//Finally adding view
        }
    }

    //Adding xml view to Layout Method
    private void showCustomHorizontalLayout() {
        layoutHolder.removeAllViews();//Remove all View from layout
        textHolder = new TextView[3];//init size of TextView array
        LayoutInflater in = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);//Layout inflater for inflating layout views

        //Loop for 3 items
        for (int i = 0; i < 3; i++) {
            View v = in.inflate(R.layout.customlayout, null);//Getting xml view
            TextView text = (TextView) v.findViewById(R.id.customTextView);//Finding Id of textView
            text.setId(i);//Setting id of textview
            text.setText("Text " + i);//setting text
            text.setOnClickListener(this);//implementing click listener
            textHolder[i] = text;//Setting text reference for future use
            layoutHolder.setOrientation(LinearLayout.HORIZONTAL);//Setting layout orientation
            layoutHolder.addView(v);
        }
    }
}
