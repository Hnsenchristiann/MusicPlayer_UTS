package umn.ac.utsfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button btnlogin2;
    private EditText editTextU, editTextpas;
    Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin2 = findViewById(R.id.btnlogin2);
        editTextU = findViewById(R.id.editTextU);
        editTextpas = findViewById(R.id.editTextpas);
        mDialog = new Dialog(this);

        btnlogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextU.getText().toString().equals("uasmobile")&&
                        editTextpas.getText().toString().equals("uasmobilegenap")){
                    Intent intent = new Intent(Login.this, halamanUtama.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Password/Username",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}