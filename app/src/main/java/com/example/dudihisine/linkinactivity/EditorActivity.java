package com.example.dudihisine.linkinactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditorActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name;
    private EditText age;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

         name = (EditText) findViewById(R.id.name);
         age = (EditText) findViewById(R.id.age);
         saveButton = (Button) findViewById(R.id.save_button);


        saveButton.setOnClickListener(this);

        }

    @Override
    public void onClick(View view) {
        if(name.getText().toString().equals("")){
            name.setError("nope");
        }
        else if(age.getText().toString().equals("")){
            age.setError("nope");
        }
        else {
            Intent intent = new Intent();
            intent.putExtra("name", name.getText().toString());
            intent.putExtra("age", Integer.parseInt(age.getText().toString()));
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
