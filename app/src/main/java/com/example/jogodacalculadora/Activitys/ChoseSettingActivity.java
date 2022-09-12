package com.example.jogodacalculadora.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jogodacalculadora.R;

public class ChoseSettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_setting);

    }

    public void fechar(View View){ finish();}

    public void openSetting(View view) { // abre o xml das confingurações
        Intent intent = new Intent(this, Setting_Activity.class);
        startActivity(intent);
    }


    public void openOpcoesDeLogin(View View){
        Intent i = new Intent(this, OpcoesDeLoginActivity.class);
        startActivity(i);
    }
}