package com.geigerlabs.sensorchart;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/**
 * Created by mgeiger on 1/25/17.
 */

public class LineGraph {

    private TimeSeries data = new TimeSeries("Temperature");
    private XYMultipleSeriesDataset multiData = new XYMultipleSeriesDataset();
    private XYSeriesRenderer renderer = new XYSeriesRenderer();
    private XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
    private GraphicalView view;

    public LineGraph() {
        // add data
        multiData.addSeries(data);

        // customize
        renderer.setColor(Color.BLACK);
        renderer.setPointStyle(PointStyle.CIRCLE);
        renderer.setFillPoints(Boolean.TRUE);

        // Enable Zoom
        multiRenderer.setZoomButtonsVisible(Boolean.TRUE);
        multiRenderer.setXTitle("Day #");
        multiRenderer.setYTitle("Temperature");
        multiRenderer.setXLabelsColor(Color.RED);
        multiRenderer.setYLabelsColor(0, Color.RED);
        multiRenderer.setTextTypeface(Typeface.DEFAULT_BOLD);
        multiRenderer.setAxisTitleTextSize(16);

        // add single renderer to multiple
        multiRenderer.addSeriesRenderer(renderer);
    }

    public GraphicalView getView(Context context) {
        view = ChartFactory.getLineChartView(context, multiData, multiRenderer);
        return view;
    }

    public void addNewPoints(Point p) {
        data.add(p.x, p.y);
    }
}
