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
