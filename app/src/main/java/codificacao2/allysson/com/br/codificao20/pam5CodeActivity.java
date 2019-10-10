package codificacao2.allysson.com.br.codificao20;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class pam5CodeActivity extends AppCompatActivity {

    private GraphView graph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pam5_code);

        graph = findViewById(R.id.graph);

        String ant = "null";
        //CAPTURA OS DADOS ENVIADOS PELA 'MAIN ACTIVITY'
        Bundle extra = getIntent().getExtras();

        if (extra!=null){

            String dado = extra.getString("dado");
            String binario = dado;

            int x = 0;
            for (int p=0;p<binario.length();p+=2){

                //UM ZERO
                LineGraphSeries<DataPoint> umZero = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(x,-1),
                        new DataPoint(x+1,-1),
                });

                // ZERO UM
                LineGraphSeries<DataPoint> zeroUm = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(x,2),
                        new DataPoint(x+1,2),
                });

                //ZERO ZERO
                LineGraphSeries<DataPoint> zeroZero = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(x,1),
                        new DataPoint(x+1,1),
                });

                //UM UM
                LineGraphSeries<DataPoint> umUm = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(x,-2),
                        new DataPoint(x+1,-2),
                });
                /*
                *
                * */
                //LINHAS RETAS

                //ZERO ZERO - UM ZERO 00-10
                LineGraphSeries<DataPoint> zzUZ = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(x,1),
                        new DataPoint(x,-1),
                });
                //ZERO ZERO - ZERO UM 00-01
                LineGraphSeries<DataPoint> zzZU = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(x,1),
                        new DataPoint(x,2),
                });
                //ZERO ZERO - UM UM 00-11
                LineGraphSeries<DataPoint> zzUU = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(x,1),
                        new DataPoint(x,-2)
                });
                /*
                *
                * */
                //UM ZERO - ZERO ZERO 10-00
                LineGraphSeries<DataPoint>uzZZ = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(x,-1),
                        new DataPoint(x,1)
                });
                //UM ZERO - ZERO UM 10-01
                LineGraphSeries<DataPoint>uzZU = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(x,-1),
                        new DataPoint(x,2)
                });
                //UM ZERO - UM UM 10-11
                LineGraphSeries<DataPoint>uzUU = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(x,-1),
                        new DataPoint(x,-2)
                });
                /*

                 */
                //ZERO UM - ZERO ZERO 01-00
                LineGraphSeries<DataPoint>zuZZ = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(x,2),
                        new DataPoint(x,1)
                });
                //ZERO UM - UM ZERO
                LineGraphSeries<DataPoint>zuUZ = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(x,2),
                        new DataPoint(x,-1)
                });
                //ZERO UM - UM UM
                LineGraphSeries<DataPoint>zuUU = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(x,2),
                        new DataPoint(x,-2)
                });
                /*
                *
                * */
                //UM UM - ZERO ZERO
                LineGraphSeries<DataPoint>uuZZ = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(x,-2),
                        new DataPoint(x,1)
                });
                //UM UM - ZERO UM
                LineGraphSeries<DataPoint>uuZU = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(x,-2),
                        new DataPoint(x,2)
                });
                //UM UM - UM ZERO
                LineGraphSeries<DataPoint>uuUZ = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(x,-2),
                        new DataPoint(x,-1)
                });


                if (binario.charAt(p)=='1' && binario.charAt(p+1)=='1'){
                    //UM UM
                    if (ant=="null"){
                        graph.addSeries(umUm);
                        ant="umUm";
                    }else if (ant=="zeroZero"){
                        graph.addSeries(umUm);
                        graph.addSeries(zzUU);
                        ant="umUm";
                    }else if (ant=="umZero"){
                        graph.addSeries(umUm);
                        graph.addSeries(uzUU);
                        ant="umUm";
                    }else if (ant=="umUm"){
                        graph.addSeries(umUm);
                        ant="umUm";
                    }else if (ant=="zeroUm"){
                        graph.addSeries(umUm);
                        graph.addSeries(zuUU);
                        ant="umUm";
                    }
                    x+=1;
                }else if (binario.charAt(p)=='1' && binario.charAt(p+1)=='0'){
                    //UM ZERO
                    if (ant=="null"){
                        graph.addSeries(umZero);
                        ant="umZero";
                    }else if (ant=="zeroZero"){
                        graph.addSeries(umZero);
                        graph.addSeries(zzUZ);
                        ant = "umZero";
                    }else if (ant=="umZero"){
                        graph.addSeries(umZero);
                        ant="umZero";
                    }else if (ant=="umUm"){
                        graph.addSeries(umZero);
                        graph.addSeries(uuUZ);
                        ant = "umZero";
                    }else if (ant=="zeroUm"){
                        graph.addSeries(umZero);
                        graph.addSeries(zuUZ);
                        ant = "umZero";
                    }
                    x+=1;
                }else if (binario.charAt(p)=='0' && binario.charAt(p+1)=='0'){
                    //ZERO ZERO
                    if (ant=="null"){
                        graph.addSeries(zeroZero);
                        ant="zeroZero";
                    }else if (ant=="umZero"){
                        //10-00
                        graph.addSeries(zeroZero);
                        graph.addSeries(uzZZ);
                        ant="zeroZero";
                    }else if (ant=="umUm"){
                        graph.addSeries(zeroZero);
                        graph.addSeries(uuZZ);
                        ant="zeroZero";
                    }else if (ant=="zeroZero"){
                        graph.addSeries(zeroZero);
                        ant="zeroZero";
                    }else if (ant=="zeroUm"){
                        graph.addSeries(zeroZero);
                        graph.addSeries(zuZZ);
                        ant = "zeroZero";
                    }
                    x+=1;///
                }else if (binario.charAt(p)=='0' && binario.charAt(p+1)=='1'){
                    //ZERO UM
                    if (ant=="null"){
                        graph.addSeries(zeroUm);
                        ant="zeroUm";
                    }else if (ant=="zeroZero"){
                        graph.addSeries(zeroUm);
                        graph.addSeries(zzZU);
                        ant="zeroUm";
                    }else if (ant=="umZero"){
                        graph.addSeries(zeroUm);
                        graph.addSeries(uzZU);
                        ant="zeroUm";
                    }else if (ant=="zeroUm"){
                        graph.addSeries(zeroUm);
                        ant="zeroUm";
                    }else if (ant=="umUm"){
                        graph.addSeries(zeroUm);
                        graph.addSeries(uuZU);
                        ant="zeroUm";
                    }
                    x+=1;
                }

            }


        }
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalable(true);
        graph.getViewport().setMinY(-2);
    }
}
