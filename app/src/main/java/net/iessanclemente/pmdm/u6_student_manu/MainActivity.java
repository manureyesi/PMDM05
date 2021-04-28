package net.iessanclemente.pmdm.u6_student_manu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botonCalc1;
    private Button botonProvincia2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonCalc1 = findViewById(R.id.button_1_calc);
        botonProvincia2 = findViewById(R.id.button_2_prov);

        // Boton para lanzar aplicaciones externas
        botonCalc1.setOnClickListener(this::onClickShortPronv);
        botonCalc1.setOnLongClickListener(this::onClickLongCalc);

        // Boton para ver provincia
        botonProvincia2.setOnClickListener(this::onClickProvinciasToast);

    }

    private void onClickShortPronv (View view) {
        final String TAG = "onClickShortPronv:";
        Log.i(TAG, "Lanzamos la segunda activiti");
    }

    private boolean onClickLongCalc (View view) {
        final String TAG = "onClickLongCalc:";
        Log.i(TAG, "Lanzamos menu para seleccionar app deseada");

        return true;
    }

    private void onClickProvinciasToast (View view) {
        final String TAG = "onClickProvinciasToast:";
        Log.i(TAG, "Toast para ver provincia seleccionada");
    }

}