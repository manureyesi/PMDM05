package net.iessanclemente.pmdm.u6_student_manu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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

        if (this.textoProvincia.getText() != null) {
            ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(
                    this, android.R.layout.simple_list_item_1);

            itemsAdapter.add(this.textoProvincia.getText().toString());
        }

    }

}