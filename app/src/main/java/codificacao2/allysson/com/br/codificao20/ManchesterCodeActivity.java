package codificacao2.allysson.com.br.codificao20;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class ManchesterCodeActivity extends Activity {

    private GraphView graph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manchester_code);

        graph = findViewById(R.id.graph);
        Bundle extra = getIntent().getExtras();

        if (extra!=null){
            String dado = extra.getString("dado");
            String binario = dado;
            String ant = "null";

            for (int a = 0;a<binario.length();a++){
                LineGraphSeries<DataPoint> um = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(a,-1),
                        new DataPoint(a+0.5,-1),
                        new DataPoint(a+0.5,1),
                        new DataPoint(a+1,1)
                });
                LineGraphSeries<DataPoint>umUm = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(a,1),
                        new DataPoint(a,-1),
                        new DataPoint(a+0.5,-1),
                        new DataPoint(a+0.5,1),
                        new DataPoint(a+1,1)
                });
                LineGraphSeries<DataPoint> zero = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(a,1),
                        new DataPoint(a+0.5,1),
                        new DataPoint(a+0.5,-1),
                        new DataPoint(a+1,-1)
                });
                LineGraphSeries<DataPoint> zeroZero = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(a,-1),
                        new DataPoint(a,1),
                        new DataPoint(a+0.5,1),
                        new DataPoint(a+0.5,-1),
                        new DataPoint(a+1,-1)
                });

                if ('1' == binario.charAt(a)){
                    if (ant=="null" || ant=="zero"){
                        graph.addSeries(um);
                        ant="um";
                    }else if (ant=="um"){
                        graph.addSeries(umUm);
                        ant="um";
                    }
                }else {
                    if(ant=="null" || ant=="um"){
                        graph.addSeries(zero);
                        ant = "zero";
                    }else if (ant=="zero"){
                        graph.addSeries(zeroZero);
                        ant="zero";
                    }
                }
                zeroZero.setColor(Color.RED);
                zero.setColor(Color.RED);
            }

            graph.getViewport().setScalable(true);

            graph.getViewport().setMinY(3);
        }
    }
}
