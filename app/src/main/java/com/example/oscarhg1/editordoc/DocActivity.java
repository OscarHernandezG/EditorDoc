package com.example.oscarhg1.editordoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DocActivity extends AppCompatActivity {

    public static final int EDIT_TITLE = 0;
    //Model
    private String title = "Title", doc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec laoreet dui eget interdum lobortis. Aenean semper congue convallis. Phasellus at sapien ac mauris bibendum fermentum et sit amet metus. Aliquam in quam elit. Phasellus in lorem a ipsum finibus commodo a semper ligula. Mauris nec tincidunt erat. Curabitur at ligula nisl. Integer eu leo finibus ipsum faucibus aliquam. Nam aliquet facilisis nunc in laoreet. Pellentesque et finibus nisl. Sed id quam ut diam aliquam efficitur nec sed urna. Praesent et dui ut velit porta consequat. Pellentesque ut ligula semper, feugiat lacus non, laoreet purus. Curabitur aliquam auctor ante eget consectetur. Aenean sit amet tincidunt velit, dictum scelerisque libero.";

    private TextView titleView;
    private TextView docView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);

        titleView = findViewById(R.id.titleView);
        docView = findViewById(R.id.docView);

        titleView.setText(title);
        docView.setText(doc);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.doc_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.optionEditFile:
                Intent intent = new Intent(this, EditActivity.class);
                intent.putExtra("text", title);
                startActivityForResult(intent, EDIT_TITLE);
                break;
        }
    return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch (requestCode)
        {
            case EDIT_TITLE:
                if (resultCode == RESULT_OK) {
                    title = data.getStringExtra("text");
                    titleView.setText(title);
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
