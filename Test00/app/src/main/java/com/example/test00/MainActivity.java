package com.example.test00;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaTimestamp;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//**********************************************************************************************

public class MainActivity extends AppCompatActivity {

    private Button Btn_Run;

    private TextView Txv_Result01;
    private TextView Txv_Result11;

    private EditText Edn_Price;
    private EditText Edn_Capacity;
    private EditText Edn_AmountToUse;

    private CheckBox Cbx_Tax;

    //**********************************************************************************************
    void MessageShow(String str_message, int i_len) {
        Toast tstMessage;
        tstMessage = Toast.makeText(this, str_message, i_len);
        tstMessage.setGravity(Gravity.CENTER, 0, 0);
        tstMessage.show();
    }

    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.test);

        //コンポーネント設定
        Btn_Run = this.findViewById(R.id.BTN_Run);

        Txv_Result01 = this.findViewById(R.id.TXV_Result01);
        Txv_Result11 = this.findViewById(R.id.TXV_Result11);

        Edn_Price = this.findViewById(R.id.EDN_Price);
        Edn_Capacity = this.findViewById(R.id.EDN_Capacity);
        Edn_AmountToUse = this.findViewById(R.id.EDN_AmountToUse);

        Cbx_Tax = this.findViewById(R.id.CBX_Tax);
        Cbx_Tax.setChecked(true);

        //ボタンイベント組込
        Btn_Run.setOnClickListener(new MyClickAdapter());
    }

    //**********************************************************************************************
    class MyClickAdapter implements View.OnClickListener{
        @Override
        public void onClick(View v){

            String strPrice = Edn_Price.getText().toString();
            String strCap = Edn_Capacity.getText().toString();
            String strUse = Edn_AmountToUse.getText().toString();

            if(strPrice.length() == 0 || strCap.length() == 0 || strUse.length() ==0) {
                MessageShow("未入力項目があります。", Toast.LENGTH_SHORT);
                return;
            }

            double price = Integer.parseInt(strPrice);
            if(!Cbx_Tax.isChecked())
                price *= 1.1;
            double cap = Integer.parseInt(strCap);
            double use = Integer.parseInt(strUse);

            double OneTimePrice = ((double)Math.round((price / cap * use) * 10000))/10000;
            double NumResult = ((double)Math.round(cap / use * 10) / 10);
            Txv_Result01.setText(String.valueOf(OneTimePrice));
            Txv_Result11.setText(String.valueOf(NumResult));

            MessageShow("結果を更新しました。", Toast.LENGTH_SHORT);
        }
    }
}