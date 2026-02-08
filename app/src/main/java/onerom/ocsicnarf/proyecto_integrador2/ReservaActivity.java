package onerom.ocsicnarf.proyecto_integrador2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ReservaActivity extends AppCompatActivity {

    EditText etNombre, etMatricula;
    DatePicker datePicker;
    TimePicker timePicker;
    Button btnReservar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        etNombre = findViewById(R.id.etNombre);
        etMatricula = findViewById(R.id.etMatricula);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        btnReservar = findViewById(R.id.btnReservar);

        btnReservar.setOnClickListener(v -> {

            String nombre = etNombre.getText().toString().trim();
            String matricula = etMatricula.getText().toString().trim();

            if (nombre.isEmpty() || matricula.isEmpty()) {
                mostrarAlerta("Error", "Completa todos los campos");
                return;
            }

            int dia = datePicker.getDayOfMonth();
            int mes = datePicker.getMonth() + 1;
            int anio = datePicker.getYear();

            int hora = timePicker.getHour();
            int minuto = timePicker.getMinute();

            String mensaje =
                    "Reserva Confirmada\n\n" +
                            "Alumno: " + nombre +
                            "\nMatrícula: " + matricula +
                            "\nFecha: " + dia + "/" + mes + "/" + anio +
                            "\nHora: " + String.format("%02d:%02d", hora, minuto);

            mostrarAlerta("GIMNASIO UPT", mensaje);
        });
    }


}

