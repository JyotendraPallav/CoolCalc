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
    int left_number=0;
    int right_number=0;
    String Operator_in_use="";
    int K;
    TextView Result;
    TextView Final_Num;

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
        Button Equal = (Button)findViewById(R.id.Equal);
        Result =(TextView)findViewById(R.id.Result);
        Final_Num=(TextView)findViewById(R.id.Final_Num);
        Result.setText("");
        Final_Num.setText("");

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
                Final_number="";
            }
        });

        Equal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculate();
                left_number=0;
                right_number=0;
                Operator_in_use="";
            }
        });

    }


    void printnumber(int n){
        Final_number+=String.valueOf(n);
        Result.setText(Final_number);
        Storing_numbers(Final_number,1);

    }
    void printOperator(String Op){
        Final_number+=Op;
        Result.setText(Final_number);
        Storing_numbers(Op,2);
    }

    void Storing_numbers(String printed, int flag){
        if(flag !=1){
            Operator_in_use=printed;
        }else{
            if(Operator_in_use==""){
                left_number=Integer.valueOf(printed);
            }else{
                right_number=Integer.valueOf(printed);
            }
        }
    };

    void calculate(){
        switch (Operator_in_use){
            case "+":
                Final_Num.setText(String.valueOf(left_number+right_number));
                break;
            default:
                Final_Num.setText("");
                break;
        }
    }
}
