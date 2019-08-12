package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start2);
    }

    public void onClickIndoor (View view) {
        Intent i = new Intent(this, MainActivity.class);

        startActivity(i);
    }

    public void onClickOutdoor (View view) {
        Intent i = new Intent(this, MapsActivity.class);

        startActivity(i);
    }

    public void onClickQr (View view) {
        IntentIntegrator intentIntegrator = new IntentIntegrator(StartActivity.this);
        intentIntegrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if ( result != null ){
            if(result.getContents()!=null){
                Toast.makeText(this,"Scanned", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this,"Cancelled", Toast.LENGTH_LONG).show();
            }
        }

    }
}
