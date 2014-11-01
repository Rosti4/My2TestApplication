package com.example.stephan.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class HomeActivity extends Activity {

    //meine Oberflächenelemente
    private TextView textViewIntro;
    private EditText editText;
    private Button buttonOk;

    private RelativeLayout rLayout;

    private Button buttonToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Layout mit den Variablen verknüpfen
        textViewIntro = (TextView) findViewById(R.id.textViewIntro);
        editText = (EditText) findViewById(R.id.editText);
        buttonOk = (Button) findViewById(R.id.buttonOk);
        buttonToast = (Button) findViewById(R.id.buttonToast);

        rLayout = (RelativeLayout) findViewById(R.id.rLayout);
    }
    public void onButtonClick(View v)
    {
        //text aus dem Eingabefeld nehmen und in die Überschrift schreiben
        textViewIntro.setText(editText.getText());
        editText.setText("");

        //Tastatur Ausblenden
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(rLayout.getWindowToken(),0);
    }

    public void showToast(View v)
    {

        AlertDialog.Builder msgBox = new AlertDialog.Builder(this);

        msgBox.setMessage("Achten jetzt kommt der Toast");
        /*
        msgBox.setNeutralButton("Okay!",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //wenn der neutrale Button gedrückt wurdedann soll der Toast angezeigt werden
                Toast.makeText(getApplicationContext(),"Du wurdest getoastet",Toast.LENGTH_LONG).show();
            }
        }); */

        //Ja Button
        msgBox.setPositiveButton("Ja auf jeden Fall", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"du hast den Positiven gedrückt",Toast.LENGTH_LONG).show();
            }
        });

        //Nein Button
        msgBox.setNegativeButton("Niemals", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"du hast den Negativen gedrückt",Toast.LENGTH_LONG).show();
            }
        });
        msgBox.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
