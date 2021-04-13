package com.example.test00;

import android.app.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ClsLaundry  {

    public Button Btn_Run;
    public Button Btn_Back;

    public TextView Txv_Result01;
    public TextView Txv_Result11;
    public TextView Txv_Result21;

    public EditText Edn_Price;
    public EditText Edn_Capacity;
    public EditText Edn_AmountToUse;

    public CheckBox Cbx_Tax;

    public MainActivity cls_mainA;

    //**********************************************************************************************
    //コンストラクタ
    //クラス生成時に親クラスを指定する。
    ClsLaundry(MainActivity m){
        cls_mainA = m;
    }


    //**********************************************************************************************
    //洗濯洗剤部のイニシャライズ
    public void LaundryDetergentInit(){
        cls_mainA.setContentView(R.layout.laundry);

        //コンポーネント設定
        Btn_Run = cls_mainA.findViewById(R.id.BTN_Run);
        Btn_Back = cls_mainA.findViewById(R.id.BTN_Back);

        Txv_Result01 = cls_mainA.findViewById(R.id.TXV_Result01);
        Txv_Result11 = cls_mainA.findViewById(R.id.TXV_Result11);
        Txv_Result21 = cls_mainA.findViewById(R.id.TXV_Result21);

        Edn_Price = cls_mainA.findViewById(R.id.EDN_Price);
        Edn_Capacity = cls_mainA.findViewById(R.id.EDN_Capacity);
        Edn_AmountToUse = cls_mainA.findViewById(R.id.EDN_AmountToUse);

        Cbx_Tax = cls_mainA.findViewById(R.id.CBX_Tax);
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
                cls_mainA.MessageShow("未入力項目があります。", Toast.LENGTH_SHORT);
                return;
            }

            double price = Integer.parseInt(strPrice);
            if (!Cbx_Tax.isChecked())
                price *= 1.1;
            double cap = Integer.parseInt(strCap);
            double use = Integer.parseInt(strUse);

            double OneTimePrice = ((double) Math.round((price / cap * use) * 100)) / 100;
            double NumResult = ((double) Math.round(cap / use * 100) / 100);
            double MonthPrice = ((double) Math.round(OneTimePrice * 30 * 100) / 100);
            Txv_Result01.setText(String.valueOf(OneTimePrice));
            Txv_Result11.setText(String.valueOf(NumResult));
            Txv_Result21.setText(String.valueOf(MonthPrice));

            cls_mainA.MessageShow("結果を更新しました。", Toast.LENGTH_SHORT);
        }
    }
        //**********************************************************************************************
    class Back_Click implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            cls_mainA.setContentView(R.layout.activity_main);
            cls_mainA.MainInit();
        }
    }
}

