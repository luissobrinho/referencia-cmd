package br.com.ddsw.app.sssixtyfour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class NovaActitvity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FloatingActionButton fab_sobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_sobre);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab_sobre = (FloatingActionButton) findViewById(R.id.fab_sobre);
        fab_sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aviso = getString(R.string.aviso);
                Toast toast = Toast.makeText(NovaActitvity.this, aviso, Toast.LENGTH_LONG);
                toast.show();
                EditText nome = (EditText) findViewById(R.id.edt_nome);
                EditText msg = (EditText) findViewById(R.id.edt_msg);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("mailto:luis.eduardo@ddsw.com.br?subject=" + nome.getText().toString() + "&body=" + msg.getText().toString() + ""));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });


    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }
}
