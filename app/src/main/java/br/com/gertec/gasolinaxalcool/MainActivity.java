package br.com.gertec.gasolinaxalcool;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editGasolina, editAlcool;
    private TextView resultado;
    private Button calcular;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editGasolina = findViewById(R.id.edtGasolina);
        editAlcool = findViewById(R.id.editAlcoll);
        resultado = findViewById(R.id.resultado);
        calcular = findViewById(R.id.calcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularVantagem();
            }
        });
    }

    private void calcularVantagem() {

        String gasolinaText = editGasolina.getText().toString();
        String alcoolText = editAlcool.getText().toString();

        if (gasolinaText.isEmpty() || alcoolText.isEmpty()) {
            resultado.setText("Por favor, preencha ambos os campos.");
            return;
        }

        double precoGasolina = Double.parseDouble(gasolinaText);
        double precoAlcool = Double.parseDouble(alcoolText);

        double resultadoCalculo = precoAlcool / precoGasolina;

        if (resultadoCalculo <= 0.7) {
            resultado.setText("Abasteça com Álcool");
        } else {
            resultado.setText("Abasteça com Gasolina");
        }
    }
}