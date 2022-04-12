package sv.udb.edu.dsm.lab.pruebapractica2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context) {
        super(context, "carsmotors.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crearTablaUsuario = "CREATE TABLE usuario (idusuario INTEGER PRIMARY KEY AUTOINCREMENT, nombres VARCHAR (45), apellidos VARCHAR (45), email VARCHAR (45), user VARCHAR (45) UNIQUE, password VARCHAR (45), tipo VARCHAR (45));";
        db.execSQL(crearTablaUsuario);
        String crearTablaMarcas = "CREATE TABLE marcas (idmarcas INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR (45));";
        db.execSQL(crearTablaMarcas);
        String crearTablaTipoAuto="CREATE TABLE tipo_automovil (idtipoautomovil INTEGER PRIMARY KEY AUTOINCREMENT, descripcion VARCHAR (45));";
        db.execSQL(crearTablaTipoAuto);
        String crearTablaColores="CREATE TABLE colores (idcolores INTEGER PRIMARY KEY AUTOINCREMENT, descripcion VARCHAR (45));";
        db.execSQL(crearTablaColores);
        String crearTablaFavoritosAuto="CREATE TABLE favoritos_automovil (idfavoritosautomovil INTEGER PRIMARY KEY AUTOINCREMENT, idusuario INT CONSTRAINT fk_favoritos_automovil_usuario1_idx REFERENCES usuario (idusuario), idfavoritoautomovil INT CONSTRAINT fk_favoritos_automovil_automovil1_idx REFERENCES automovil (idautomovil), fecha_agregado TIMESTAMP);";
        db.execSQL(crearTablaFavoritosAuto);
        String crearTablaAutomovil="CREATE TABLE automovil (idautomovil INTEGER PRIMARY KEY AUTOINCREMENT, modelo VARCHAR (45), numero_vin VARCHAR (45), numero_chasis VARCHAR (45), numero_motor VARCHAR (45), numero_asientos INTEGER, anio YEAR, capacidad_asientos INT, precio DECIMAL (10, 2), URI_IMG VARCHAR (45), descripcion VARCHAR (45), idmarcas INT CONSTRAINT fk_automovil_marcas_idx REFERENCES marcas (idmarcas), idtipoautomovil INT CONSTRAINT fk_automovil_tipo_automovi1l_idx REFERENCES tipo_automovil (idtipoautomovil), idcolores INT CONSTRAINT fk_automovil_colores1_idx REFERENCES colores (idcolores));";
        db.execSQL(crearTablaAutomovil);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean agregarUsuario(ModeloUsuarios usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nombres", usuario.getNombres());
        cv.put("apellidos", usuario.getApellidos());
        cv.put("email", usuario.getEmail());
        cv.put("user", usuario.getUsuario());
        cv.put("password", usuario.getPassword());
        cv.put("tipo", usuario.getTipo());
        long insert = db.insert("usuario", null, cv);
        if (insert == -1)
            return false;
        else
            return true;
    }
}
