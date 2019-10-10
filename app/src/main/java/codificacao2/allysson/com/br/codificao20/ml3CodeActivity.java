package codificacao2.allysson.com.br.codificao20;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class ml3CodeActivity extends AppCompatActivity {

    //DECLARAS AS VARIÁVEIS QUE SERÃO USADAS
    private GraphView graph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ml3_code);
        //SELECIONA OS OBJETOS PELO ID

        //SELECIONA O GRAFICO PELO ID
        graph = findViewById(R.id.graph);

        //CAPTURA OS DADOS ENVIADOS PELA 'MAIN ACTIVITY'
        Bundle extra = getIntent().getExtras();

        //VERIFICA SE OS DADOS CHEGARAM
        if (extra!=null){
            //RECEBE O DADO QUE FOI PASSADO
            String dado = extra.getString("dado");

            //DECLARA AS VARIÁVEIS LOCAIS
            int x = 0;
            int y = 0;
            String dir = "down";
            String binario = dado;

            //LAÇO PARA CRIAR O GRÁFICO
            for (int a = 0;a<binario.length();a++) {
                x = a;

                LineGraphSeries<DataPoint> um = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(x, y),
                        new DataPoint(x,y+1),
                        new DataPoint(x+1,y+1)
                });
                LineGraphSeries<DataPoint> zero = new LineGraphSeries<>(new  DataPoint[]{
                        new DataPoint(x,y),
                        new DataPoint(x+1,y),
                });
                LineGraphSeries<DataPoint> desc = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(x,y),
                        new DataPoint(x,y-1),
                        new DataPoint(x+1,y-1),
                });

                if (binario.charAt(a)=='0'){
                    graph.addSeries(zero);
                }else if (binario.charAt(a)=='1'){
                    if (y<0){
                        dir = "up";
                    }else if (y>0){
                        dir = "down";
                    }
                    if (dir == "up"){
                        graph.addSeries(um);
                        y++;
                    }else if (dir == "down"){
                        graph.addSeries(desc);
                        y--;
                    }
                }

                zero.setColor(Color.RED);
            }
        }


        //DEFINE GRAFICO COMO ESCALÁVEL

        graph.getViewport().setScalable(true);
        graph.getViewport().setScrollable(true);


    }
}
