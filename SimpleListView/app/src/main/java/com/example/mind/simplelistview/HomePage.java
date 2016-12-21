package com.example.mind.simplelistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        TextView simpleA = (TextView)findViewById(R.id.tvSimpleA);
        if (simpleA != null) {
            simpleA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(HomePage.this, MainActivity.class);

                    startActivity(in);
                }
            });
        }

        TextView customA = (TextView)findViewById(R.id.tvCustomA);

        if (customA != null) {
            customA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(HomePage.this, CustomArrayAdapterInplementation.class);

                    startActivity(i);
                }
            });
        }
    }
}
