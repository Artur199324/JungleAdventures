package com.joycity.pot.actJA;

import static com.joycity.pot.modJA.SaveJA.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.joycity.pot.R;
import com.joycity.pot.viewModJA.ViewJA;

public class SBJA extends AppCompatActivity {

    TextView textView3;
    Button button2,button3,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sbja);
        textView3 = findViewById(R.id.textView3);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        activity = this;
        textView3.setText("Last time you won "+getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).getString("oo","0") + " points");
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finishAffinity();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RRRja.class));
                finishAffinity();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }
}