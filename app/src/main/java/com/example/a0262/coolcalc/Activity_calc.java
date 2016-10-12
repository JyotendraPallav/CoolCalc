package com.example.a0262.coolcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Activity_calc extends Activity {

    String Final_number="";
    int K;
    TextView Result;

    class Number_Buttons{
        private Integer Position;
        private Button Btn;

        public Number_Buttons(final Integer Position, Button Btn){
            this.Btn=Btn;
            this.Position=Position;
            Btn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    printnumber(Position);
                }
            });

        }
        public Integer getPosition(){return Position;}
        public Button getBtn(){return Btn;}
    };

    Map<String,Number_Buttons> Get_N_Buttons = new HashMap<String,Number_Buttons>();

    class Operator_Buttons{
        private String Operator;
        private ImageButton Btn;

        public Operator_Buttons(final String Operator, ImageButton Btn){
            this.Btn=Btn;
            this.Operator=Operator;
            Btn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    printOperator(Operator);
                }
            });

        }
        public String getOperator(){return Operator;}
        public ImageButton getBtn(){return Btn;}
    };
    Map<String,Operator_Buttons> Get_O_Buttons = new HashMap<String,Operator_Buttons>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button Clear = (Button)findViewById(R.id.Clear);
        Result =(TextView)findViewById(R.id.Result);
        Result.setText("");

        for(K=0;K<=9;K++){
            final int X=getResources().getIdentifier("button"+K,"id",getPackageName());
            Get_N_Buttons.put("Button"+K,new Number_Buttons(K,(Button)findViewById(X)));
        }

        Get_O_Buttons.put("Add",new Operator_Buttons("+",(ImageButton)findViewById(R.id.Plus)));
        Get_O_Buttons.put("Substract",new Operator_Buttons("-",(ImageButton)findViewById(R.id.Subtract)));
        Get_O_Buttons.put("Multiply",new Operator_Buttons("*",(ImageButton)findViewById(R.id.Multiply)));
        Get_O_Buttons.put("Divide",new Operator_Buttons("/",(ImageButton)findViewById(R.id.Divide)));

        Clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Result.setText("");
            }
        });

    }


    void printnumber(int n){
        Final_number+=String.valueOf(n);
        Result.setText(Final_number);
    }
    void printOperator(String Op){
        Final_number+=Op;
        Result.setText(Final_number);
    }
}
