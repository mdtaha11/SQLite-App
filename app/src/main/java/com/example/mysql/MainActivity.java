package com.example.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText edit_country,edit_capital;
    Button add_btn;
    DbHandler mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb=new DbHandler(this);

       edit_country=(EditText)findViewById(R.id.edit_country);
       edit_capital=(EditText)findViewById(R.id.edit_capital);
       add_btn =(Button)findViewById(R.id.add_btn);
       addItem();


    }

    public void addItem()
    {
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean b=mydb.inputData(edit_country.getText().toString(),edit_capital.getText().toString());

            if(b) {
                Toast t= Toast.makeText(MainActivity.this, "Text Inserted", Toast.LENGTH_LONG);
                t.show();
            }
                else {
                Toast p = Toast.makeText(MainActivity.this, "Text Not Inserted", Toast.LENGTH_LONG);
                p.show();
            }
            }

        });



    }
}
