package com.example.dudihisine.linkinactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int GO_TO_ADD = 1;

    private Button add ;
    private LinearLayout input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button) findViewById(R.id.add_button);
        input = (LinearLayout) findViewById(R.id.input_layout);

        add.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, EditorActivity.class);
        startActivityForResult(intent,GO_TO_ADD);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == GO_TO_ADD) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                int age = data.getIntExtra("age",-1);
                addOne(name,age);
            }
            else if(resultCode == RESULT_CANCELED){
            }
        }
    }

    private void addOne(String str,int age){
        TextView tata = new TextView(this);
        tata.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        tata.setText(str+", "+age);
        input.addView(tata);
        tata.setTextSize(70);
    }
}
