package codificacao2.allysson.com.br.codificao20;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends Activity {

    //DECLARA AS VARIÁVEIS QUE SERÃO USADAS
    private CheckBox manchesterCheckBox;
    private CheckBox ml3CheckBox;
    private CheckBox pam5CheckBox;
    private Button botaoGerar;
    private EditText entradaDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CAPTURA OS OBJETOS PELO ID
        entradaDados = findViewById(R.id.entradaDados_id);
        botaoGerar = findViewById(R.id.botaoGerar_id);
        manchesterCheckBox = findViewById(R.id.manchesterCheckBox_id);
        ml3CheckBox = findViewById(R.id.ml3CheckBox_id);
        pam5CheckBox = findViewById(R.id.pam5CheckBox_id);

        //VERIFICA SE O CHECKBOX 'MANCHESTER' FOI SELECIONADO
        manchesterCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ml3CheckBox.setChecked(false);
                    pam5CheckBox.setChecked(false);
                }
            }
        });

        //VERIFICA SE O CHECKBOX 'ML3' FOI SELECIONADO
        ml3CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    manchesterCheckBox.setChecked(false);
                    pam5CheckBox.setChecked(false);
                }
            }
        });

        //VERIFICA SE O CHECKBOX 'PAM5' FOI SELECIONADO
        pam5CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    manchesterCheckBox.setChecked(false);
                    ml3CheckBox.setChecked(false);
                }
            }
        });

        //VERIFICA SE O BOTAO 'GERAR GRAFICO' FOI PRESSIONADO
        botaoGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(entradaDados.length()%2==0) {
                    if (manchesterCheckBox.isChecked()) {
                        Intent intent = new Intent(MainActivity.this, ManchesterCodeActivity.class);
                        intent.putExtra("dado", entradaDados.getText().toString());
                        startActivity(intent);
                    } else if (ml3CheckBox.isChecked()) {
                        Intent intent = new Intent(MainActivity.this, ml3CodeActivity.class);
                        intent.putExtra("dado", entradaDados.getText().toString());
                        startActivity(intent);
                    } else if (pam5CheckBox.isChecked()) {
                        Intent intent = new Intent(MainActivity.this, pam5CodeActivity.class);
                        intent.putExtra("dado", entradaDados.getText().toString());
                        startActivity(intent);
                    }
                }else {

                }
            }
        });
    }
}
