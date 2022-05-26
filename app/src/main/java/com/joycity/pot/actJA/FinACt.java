package com.joycity.pot.actJA;






import static com.joycity.pot.actJA.MainActivity.viewJA;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.joycity.pot.R;

public class FinACt extends AppCompatActivity {

    Button button,button5;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        button5 = findViewById(R.id.button5);
        textView.setText(getIntent().getStringExtra("c"));
        int ii = Integer.parseInt(getIntent().getStringExtra("c"));
        int nn = Integer.parseInt(viewJA.saveAJ());
        viewJA.saveJA(getIntent().getStringExtra("c"));


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finishAffinity();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SBJA.class));
                finishAffinity();
            }
        });
    }
}