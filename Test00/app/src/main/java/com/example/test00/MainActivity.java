package com.example.test00;

import android.app.Activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//**********************************************************************************************

public class MainActivity extends Activity {
    //-------------------------------------------
    private Button Btn_Laundry;
    private Button Btn_Tissue;

    ClsLaundry clsLaundry=  new ClsLaundry(this);

    //**********************************************************************************************
    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainInit();
    }
    //**********************************************************************************************
    //**********************************************************************************************


    //**********************************************************************************************
    //メッセージダイアログを表示する
    void MessageShow(String str_message, int i_len) {
        Toast tstMessage;
        tstMessage = Toast.makeText(this, str_message, i_len);
        tstMessage.setGravity(Gravity.TOP, 0, 400);
        tstMessage.show();
    }

    //**********************************************************************************************
    //メイン画面のイニシャライズ
    public void MainInit() {
        Btn_Laundry = this.findViewById(R.id.BTN_Laundry);
        Btn_Tissue = this.findViewById(R.id.BTN_Tissue);

        Btn_Laundry.setOnClickListener(new LandryClick());
        Btn_Tissue.setOnClickListener(new TissueClick());
    }

    //**********************************************************************************************
    //洗濯洗剤をクリックした時の処理
    class LandryClick implements View.OnClickListener{
        @Override
        public void onClick(View v){
            clsLaundry.LaundryDetergentInit();
        }
    }

    //**********************************************************************************************
    //ティッシュをクリックした時の処理
    class TissueClick implements View.OnClickListener{
        @Override
        public void onClick(View v){
            //Btn_Laundry.performClick();
            MessageShow("未実装", Toast.LENGTH_SHORT);
        }
    }
}