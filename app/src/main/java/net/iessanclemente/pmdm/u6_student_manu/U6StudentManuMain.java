package net.iessanclemente.pmdm.u6_student_manu;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class U6StudentManuMain extends AppCompatActivity {

    private Button botonCalc1;
    private Button botonProvincia2;

    public final static String PROVINCIA = "PROVINCIA";
    private final int COD_PETICION = 33;

    private ArrayAdapter<String> adaptador1;
    private ArrayList<String> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u6_student_manu_main);

        botonCalc1 = findViewById(R.id.button_1_calc);
        botonProvincia2 = findViewById(R.id.button_2_prov);

        // Boton para lanzar aplicaciones externas
        botonCalc1.setOnClickListener(this::onClickShortPronv);

        registerForContextMenu(botonCalc1);

        // Boton para ver provincia
        botonProvincia2.setOnClickListener(this::onClickProvinciasToast);

        adaptador1=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, datos);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_boton_provincias, menu);
    }

    @Override
    public boolean onContextItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_boton_calculadora:
                lanzarCalculadora();
                break;

            case R.id.menu_boton_email:
                lanzarCorreo();
                break;
        }
        return super.onContextItemSelected(item);
    }

    /**
     * Lanzar activiti calculadora
     */
    private void lanzarCalculadora () {
        final String TAG = "lanzarCalculadora:";
        try {
            Intent intent = new Intent();
            intent.setClassName(
                    "com.android.calculator2",
                    "com.android.calculator2.Calculator");
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.e(TAG, "Error al lanzar calculadora");
        }
    }

    /**
     * Lanzar activiti Correo
     */
    private void lanzarCorreo () {
        final String TAG = "lanzarCorreo:";
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        String[] TO = {"manureyesi@outlook.es"}; //Direcciones email  a enviar.
        String[] CC = {""}; //Direcciones email con copia.

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.text_email_asunto));
        emailIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.text_email_texto));

        try {
            startActivity(Intent.createChooser(emailIntent, "Enviar email."));
            Log.i(TAG, "Enviando email...");
        } catch (android.content.ActivityNotFoundException e) {
            Log.e(TAG, "Error al lanzar aplicación de correos");
        }
    }

    /**
     * Abrir activity 2
     * @param view
     */
    private void onClickShortPronv (View view) {
        final String TAG = "onClickShortPronv:";
        Log.i(TAG, "Lanzamos la segunda activity");
        Intent intentActivity2 = new Intent(getApplicationContext(), U6StudentManuActivity2.class);
        startActivityForResult(intentActivity2, COD_PETICION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        final String TAG = "onActivityResult:";
        Log.i(TAG, "RequestCode - ".concat(String.valueOf(requestCode))
                .concat(" ResultCode - ").concat(String.valueOf(resultCode)));
        if(resultCode != 0){
                String result = data.getStringExtra(PROVINCIA);
                Log.i(TAG, "Provincia - ".concat(result));
                // Añadir datos a la lista
                datos = new ArrayList<>();
                datos.add(result);
                adaptador1.notifyDataSetChanged();
        } else {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.text_toast_provincia_salir), Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Mostrar toast con provincia
     * @param view
     */
    private void onClickProvinciasToast (View view) {
        final String TAG = "onClickProvinciasToast:";
        Log.i(TAG, "Toast para ver provincia seleccionada");

        Toast provincias;
        String provinciaUsuario = datos == null ? null : datos.size() == 1 ? datos.get(0) : null;
        if (provinciaUsuario == null) {
            provincias = Toast.makeText(getApplicationContext(),
                    getString(R.string.text_toast_provincia_no_seleccionada), Toast.LENGTH_SHORT);
        } else {
            provincias = Toast.makeText(getApplicationContext(),
                    getString(R.string.text_toast_provincia_seleccionada)
                            .replace("{}", provinciaUsuario), Toast.LENGTH_LONG);
        }
        provincias.show();

    }

}