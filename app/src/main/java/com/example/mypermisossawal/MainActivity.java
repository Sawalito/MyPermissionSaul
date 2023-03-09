package com.example.mypermisossawal;

import static android.Manifest.permission.BLUETOOTH;
import static android.Manifest.permission.BODY_SENSORS;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.INTERNET;
import static android.Manifest.permission.SEND_SMS;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String[] Permisos = { INTERNET,WRITE_EXTERNAL_STORAGE,CAMERA,BODY_SENSORS,SEND_SMS};
    private static final int PERMISSION_REQUEST_CODE = 200;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById( R.id.etiqueta );
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        validatePermission();
    }

    private void validatePermission( )
    {
        int permisoInter= ContextCompat.checkSelfPermission(getApplicationContext(),Permisos[0]);
        int permisoWrite=ContextCompat.checkSelfPermission(getApplicationContext(),Permisos[1]);
        int permisoCamera =ContextCompat.checkSelfPermission(getApplicationContext(),Permisos[2]);
        int permisoBody = ContextCompat.checkSelfPermission(getApplicationContext(),Permisos[3]);
        int permisoSMS = ContextCompat.checkSelfPermission(getApplicationContext(),Permisos[4]);
        if(permisoInter == PackageManager.PERMISSION_GRANTED && permisoWrite ==PackageManager.PERMISSION_GRANTED && permisoCamera==PackageManager.PERMISSION_GRANTED && permisoBody==PackageManager.PERMISSION_GRANTED && permisoSMS==PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getApplicationContext(),"Tiene permiso",Toast.LENGTH_LONG).show();
        }else{
            requestPermissions(Permisos,200);
        }
    }
}