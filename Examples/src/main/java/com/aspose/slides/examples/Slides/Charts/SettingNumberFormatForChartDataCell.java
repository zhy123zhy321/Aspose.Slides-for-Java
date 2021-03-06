package com.aspose.slides.examples.Slides.Charts;

import com.aspose.slides.ChartType;
import com.aspose.slides.IChart;
import com.aspose.slides.IChartDataPoint;
import com.aspose.slides.IChartSeries;
import com.aspose.slides.IChartSeriesCollection;
import com.aspose.slides.ISlide;
import com.aspose.slides.Presentation;
import com.aspose.slides.SaveFormat;
import com.aspose.slides.examples.Utils;

public class SettingNumberFormatForChartDataCell {

    public static void main(String[] args) {

        // The path to the documents directory.
        String dataDir = Utils.getDataDir(SettingNumberFormatForChartDataCell.class);

        //ExStart:SettingNumberFormatForChartDataCell
        // Instantiate the presentation
        Presentation pres = new Presentation();
        try {
            // Access the first presentation slide
            ISlide slide = pres.getSlides().get_Item(0);

            // Adding a default clustered column chart
            IChart chart = slide.getShapes().addChart(ChartType.ClusteredColumn, 50, 50, 500, 400);

            // Accessing the chart series collection
            IChartSeriesCollection series = chart.getChartData().getSeries();

            // Setting the preset number format
            // Traverse through every chart series
            for (IChartSeries ser : series) {
                // Traverse through every data cell in series
                for (IChartDataPoint cell : ser.getDataPoints()) {
                    // Setting the number format
                    cell.getValue().getAsCell().setPresetNumberFormat((byte) 10); // 0.00%
                }
            }

            // Saving presentation
            pres.save(dataDir + "PresetNumberFormat.pptx", SaveFormat.Pptx);
        } finally {
            if (pres != null) pres.dispose();
        }
        //ExEnd:SettingNumberFormatForChartDataCell
    }

}
