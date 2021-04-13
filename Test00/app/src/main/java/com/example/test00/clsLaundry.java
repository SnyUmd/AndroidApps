package com.example.test00;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class clsLaundry extends MainActivity {

    public Button Btn_Run;
    public Button Btn_Back;

    public TextView Txv_Result01;
    public TextView Txv_Result11;

    public EditText Edn_Price;
    public EditText Edn_Capacity;
    public EditText Edn_AmountToUse;

    public CheckBox Cbx_Tax;

    //**********************************************************************************************
    //洗濯洗剤部のイニシャライズ
    public void LaundryDetergentInit(){
        setContentView(R.layout.laundry);

        //コンポーネント設定
        Btn_Run = this.findViewById(R.id.BTN_Run);
        Btn_Back = this.findViewById(R.id.BTN_Back);

        Txv_Result01 = this.findViewById(R.id.TXV_Result01);
        Txv_Result11 = this.findViewById(R.id.TXV_Result11);

        Edn_Price = this.findViewById(R.id.EDN_Price);
        Edn_Capacity = this.findViewById(R.id.EDN_Capacity);
        Edn_AmountToUse = this.findViewById(R.id.EDN_AmountToUse);

        Cbx_Tax = this.findViewById(R.id.CBX_Tax);
        Cbx_Tax.setChecked(true);

        //ボタンイベント組込
        Btn_Run.setOnClickListener(new LandryCalc_Click());
        Btn_Back.setOnClickListener(new Back_Click());
    }

    //**********************************************************************************************
    class LandryCalc_Click implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            String strPrice = Edn_Price.getText().toString();
            String strCap = Edn_Capacity.getText().toString();
            String strUse = Edn_AmountToUse.getText().toString();

            if (strPrice.length() == 0 || strCap.length() == 0 || strUse.length() == 0) {
//                MessageShow("未入力項目があります。", Toast.LENGTH_SHORT);
                return;
            }

            double price = Integer.parseInt(strPrice);
            if (!Cbx_Tax.isChecked())
                price *= 1.1;
            double cap = Integer.parseInt(strCap);
            double use = Integer.parseInt(strUse);

            double OneTimePrice = ((double) Math.round((price / cap * use) * 10000)) / 10000;
            double NumResult = ((double) Math.round(cap / use * 10) / 10);
            Txv_Result01.setText(String.valueOf(OneTimePrice));
            Txv_Result11.setText(String.valueOf(NumResult));

            MessageShow("結果を更新しました。", Toast.LENGTH_SHORT);
        }
    }
        //**********************************************************************************************
    class Back_Click implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            setContentView(R.layout.activity_main);
            MainInit();
        }
    }
}

