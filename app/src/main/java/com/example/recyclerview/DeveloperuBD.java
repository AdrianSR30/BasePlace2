package com.example.recyclerview;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DeveloperuBD extends SQLiteOpenHelper {
    private static final String NOMBRE_BD="developeru.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_USUARIOS = "CREATE TABLE USUARIOS (USUARIO VARCHAR, CORREO VARCHAR, CONTRASEÑA VARCHAR, TELEFONO VARCHAR, UNIDAD VARCHAR)";

    public DeveloperuBD(Context context){
        super(context,NOMBRE_BD,null,VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(TABLA_USUARIOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int viejo, int nuevo) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USUARIOS");
        onCreate(sqLiteDatabase);
    }

    //AGREGAR USUARIOS
    public void agregarUsuarios(String username, String email, String password, String telefono, String unidad){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("INSERT INTO USUARIOS VALUES('"+username+"','"+email+"','"+password+"','"+telefono+"','"+unidad+"')");
            bd.close();
        }
    }

    //BUSCAR USUARIOS
    public boolean buscarUsuario(String username, String password) {
        SQLiteDatabase bd = getReadableDatabase();
        if (bd != null) {
            String[] args = new String[]{username, password};
            Cursor cursor = bd.rawQuery("SELECT * FROM USUARIOS WHERE USUARIO = ? AND CONTRASEÑA = ?", args);

            if (cursor.getCount() > 0) {
                cursor.close();
                return true; // Usuario y contraseña coinciden
            } else {
                cursor.close();
                return false; // Usuario o contraseña incorrecta
            }
        }
        return false;
    }
}
