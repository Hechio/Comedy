package com.example.note;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
   private Switch mySwitch;
   private  ConstraintLayout myLayout;
   private Button myBack,myNext;
   private TextSwitcher mySwitcher;
   private  int mPosition=0;
   private static final String[] quotes = {"Boyfriends wengine ni kama bangi, unampenda lakini huwezi mpeleka kwa wazazi","A portfolio(kitambi) without a corresponding" +
           " bank account is an illegal structure","Most probably, girlfriend wako yuko nawe because hakupata mtoto wa Bill Gates"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBack = (Button)findViewById(R.id.jalango_prev);
        myNext = (Button) findViewById(R.id.jalango_next);
        mySwitcher = (TextSwitcher)findViewById(R.id.jalango_switcher);
        mySwitch = (Switch)findViewById(R.id.switch1);
        myLayout = (ConstraintLayout)findViewById(R.id.layout);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    myLayout.setBackgroundColor(Color.GREEN);

                }
                else {
                    myLayout.setBackgroundColor(Color.WHITE);

                }

            }
        });
        mySwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getApplicationContext());
                textView.setTextSize(20);
                textView.setText(quotes[mPosition]);
                return textView;
            }
        });
        myNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPosition<quotes.length-1){
                    mPosition++;
                    mySwitcher.setText(quotes[mPosition]);
                }
            }
        });
        myBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPosition<=quotes.length-1 && mPosition!=0){
                    mPosition--;
                    mySwitcher.setText(quotes[mPosition]);

                }
            }
        });

    }
}
