package sv.udb.edu.dsm.lab.pruebapractica2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Usuarios extends AppCompatActivity {
    //Referencias a objetos en la actividad
    Button btnAgregarUsuario,btnModificarUsuario,btnEliminarUsuario,btnVerUsuarios;
    EditText etNombreUsuario,etApellidoUsuario,etEmailUsuario,etUserUsuario,etPasswordUsuario;
    Spinner spTipoUsuario;
    RecyclerView rvListadoUsuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);
        //Botones
        btnAgregarUsuario=findViewById(R.id.btnAgregarUsuario);
        btnAgregarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModeloUsuarios modelousuario;
                try {
                     modelousuario = new ModeloUsuarios(-1,etNombreUsuario.getText().toString(),
                            etApellidoUsuario.getText().toString(),etEmailUsuario.getText().toString(),etUserUsuario.getText().toString(),
                            etPasswordUsuario.getText().toString(),spTipoUsuario.getSelectedItem().toString());
                    Toast.makeText(Usuarios.this, modelousuario.toString(), Toast.LENGTH_SHORT).show();
                }catch (Exception e ){
                    Toast.makeText(Usuarios.this, "Error Agregar usuario", Toast.LENGTH_SHORT).show();
                    modelousuario = new ModeloUsuarios(-1,"error",
                            "error","error","error",
                            "error","error")  ;
                }
                AdminSQLiteOpenHelper dbhelper = new AdminSQLiteOpenHelper(Usuarios.this);
                boolean guardado = dbhelper.agregarUsuario(modelousuario);
                Toast.makeText(Usuarios.this, "Usuario agregado = "+guardado, Toast.LENGTH_SHORT).show();
            }
        });
        btnModificarUsuario=findViewById(R.id.btnModificarUsuario);
        btnModificarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Usuarios.this, "Boton Modificar", Toast.LENGTH_SHORT).show();
            }
        });
        btnEliminarUsuario=findViewById(R.id.btnEliminarUsuario);
        btnEliminarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Usuarios.this, "Boton Eliminar", Toast.LENGTH_SHORT).show();
            }
        });
        btnVerUsuarios=findViewById(R.id.btnVerUsuarios);
        btnVerUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Usuarios.this, "Boton Ver Usuarios", Toast.LENGTH_SHORT).show();
            }
        });
        //EditText
        etNombreUsuario=findViewById(R.id.etNombreUsuario);
        etApellidoUsuario=findViewById(R.id.etApellidoUsuario);
        etEmailUsuario=findViewById(R.id.etEmailUsuario);
        etUserUsuario=findViewById(R.id.etUserUsuario);
        etPasswordUsuario=findViewById(R.id.etPasswordUsuario);
        //Spinner
        spTipoUsuario=findViewById(R.id.spTipoUsuario);
        String[] tipou={"ADMIN","CLIENT"};
        spTipoUsuario.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,tipou));
        spTipoUsuario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //RecyclerView
        rvListadoUsuarios=findViewById(R.id.rvListadoUsuarios);

    }
}