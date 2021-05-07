package net.iessanclemente.pmdm.u6_student_manu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class U6StudentManuActivity2 extends AppCompatActivity {

    private Button botonProvincias;
    private EditText textoProvincia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u6_student_manu2);

        botonProvincias = findViewById(R.id.buttonProvincias);
        textoProvincia = findViewById(R.id.editTextProvincias);

        botonProvincias.setOnClickListener(this::modificarProvincia);

    }

    /**
     * Modificar provincia
     * @param view
     */
    private void modificarProvincia (View view) {
        final String TAG = "modificarProvincia:";

        Log.i(TAG, "Se acaba de teclear la provincia "
                .concat(this.textoProvincia.getText().toString()));

        if (this.textoProvincia.getText() != null &&
                !this.textoProvincia.getText().toString().equals("")) {

            Log.i(TAG, "Provincia - ".concat(this.textoProvincia.getText().toString()));

            Intent datos_vuelta = new Intent();
            datos_vuelta.putExtra(U6StudentManu.PROVINCIA, this.textoProvincia.getText().toString());
            setResult(RESULT_OK, datos_vuelta);
        }

        // Finalizamos la activity secundaria
        super.finish();

    }

}