package com.example.a0262.coolcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Iterator;

public class Activity_calc extends Activity {

    String Final_number;
    int K;
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button Clear = (Button)findViewById(R.id.Clear);
        Result =(TextView)findViewById(R.id.Result);
        Final_number="";
        Result.setText("");

        Button ButtonList[]=new Button[9];
        for(K=0;K<=9;K++){
            final int X=getResources().getIdentifier("button"+K,"id",getPackageName());
            /*Final_number+=String.valueOf(X);
            Result.setText(Final_number);*/
            Button Generic=(Button)findViewById(X);
            /*ButtonList[K].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    printnumber(K);
                }
            });*/
            Generic.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    printnumber(K);
                }
            });
        }

/*
        int[] Imgindex=new int[]{R.id.add,R.id.Subtract,R.id.Multiply,R.id.Divide,R.id.Equal};
        ImageButton ImgList[]=new ImageButton[5];
        for(int i=0;i<5;i++){
            ImgList[i]=(ImageButton)findViewById(Imgindex[i]);
        }
*/
    }


    void printnumber(int n){
        Final_number+=String.valueOf(n);
        Result.setText(Final_number);
    }
}
