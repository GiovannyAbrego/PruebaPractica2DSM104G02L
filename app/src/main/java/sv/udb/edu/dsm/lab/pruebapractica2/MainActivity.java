package sv.udb.edu.dsm.lab.pruebapractica2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin, btnSignup;
    private EditText etUsuario, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickLogin(View v){

    }
    public void onClickSignUp(View v){
        Intent llamar = new Intent(this,Usuarios.class);
        startActivity(llamar);
    }
}