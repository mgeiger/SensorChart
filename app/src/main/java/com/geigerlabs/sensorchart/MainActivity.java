package com.geigerlabs.sensorchart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.achartengine.GraphicalView;

public class MainActivity extends AppCompatActivity {

    private GraphicalView graphView;
    private LineGraph lineGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lineGraph = new LineGraph();
        graphView = lineGraph.getView(this);
        setContentView(graphView);
    }

    @Override
    protected void onResume() {
        super.onResume();

        /*
        // here add just 40 values
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    final int x = i;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            lineGraph.addNewPoints(Point.randomPoint(x));
                            graphView.repaint();
                        }
                    });

                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        // manage error....
                    }
                }
            }
        }).start();
        */
    }
}
