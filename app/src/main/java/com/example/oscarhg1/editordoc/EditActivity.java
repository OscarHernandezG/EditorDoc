package com.example.oscarhg1.editordoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity
{

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState)    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editText = findViewById(R.id.editText);

        Intent intent = getIntent();
        if (intent != null)
        {
            String text = intent.getStringExtra("text");
            if (text != null)
            {
                editText.setText(text);
            }
        }
    }

    public void onSave(View view)
    {
        String newText = editText.getText().toString();
        Intent data = new Intent();
        data.putExtra("text", newText);
        setResult(RESULT_OK, data);
        finish();
    }
}
