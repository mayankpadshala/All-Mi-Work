/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

//        //Find the view that shows the number category
//        TextView numbers = (TextView) findViewById(R.id.numbers);
//        //Implement the setOnClickListner method on the numbers object
//        if (numbers != null) {
//            numbers.setOnClickListener(new View.OnClickListener() {
//                @Override
//                    public void onClick(View v) {
//                    //Creating an intent for the NumbersActivity
//                    Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
//                    //Start the NumbersActivity
//                    startActivity(intent);
////                    Toast.makeText(v.getContext() , "Open the List of Numbers", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
    }

    public void openNumbersList(View view) {
//        Intent intent = new Intent(this, NumbersActivity.class);
//        startActivity(intent);

        //Find the view that shows the number category
        TextView numbers = (TextView) findViewById(R.id.numbers);
        //Implement the setOnClickListner method on the numbers object
        if (numbers != null) {
            numbers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Creating an intent for the NumbersActivity
                    Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
                    //Start the NumbersActivity
                    startActivity(intent);
//                    Toast.makeText(v.getContext() , "Open the List of Numbers", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    public void openFamilyMembersList(View view) {
//        Intent intent = new Intent(this, FamilyMembersActivity.class);
//        startActivity(intent);

        //Find the view that shows the number category
        TextView family = (TextView) findViewById(R.id.family);
        //Implement the setOnClickListner method on the numbers object
        if (family != null) {
            family.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Creating an intent for the NumbersActivity
                    Intent intent = new Intent(MainActivity.this, FamilyMembersActivity.class);
                    //Start the NumbersActivity
                    startActivity(intent);
//                    Toast.makeText(v.getContext() , "Open the List of Numbers", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void openColorsList(View view) {
//        Intent intent = new Intent(this, ColorsActivity.class);
//        startActivity(intent);

        //Find the view that shows the number category
        TextView colors = (TextView) findViewById(R.id.colors);
        //Implement the setOnClickListner method on the numbers object
        if (colors != null) {
            colors.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Creating an intent for the NumbersActivity
                    Intent intent = new Intent(MainActivity.this, ColorsActivity.class);
                    //Start the NumbersActivity
                    startActivity(intent);
//                    Toast.makeText(v.getContext() , "Open the List of Numbers", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    public void openPhrasesList(View view) {
//        Intent intent = new Intent(this, PhrasesActivity.class);
//        startActivity(intent);

        //Find the view that shows the number category
        TextView phrases = (TextView) findViewById(R.id.phrases);
        //Implement the setOnClickListner method on the numbers object
        if (phrases != null) {
            phrases.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Creating an intent for the NumbersActivity
                    Intent intent = new Intent(MainActivity.this, PhrasesActivity.class);
                    //Start the NumbersActivity
                    startActivity(intent);
//                    Toast.makeText(v.getContext() , "Open the List of Numbers", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }


}
