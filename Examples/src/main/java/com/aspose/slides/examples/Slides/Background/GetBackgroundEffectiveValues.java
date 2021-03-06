/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.slides.examples.Slides.Background;

import com.aspose.slides.FillType;
import com.aspose.slides.IBackgroundEffectiveData;
import com.aspose.slides.Presentation;
import com.aspose.slides.examples.Utils;


public class GetBackgroundEffectiveValues {


    public static void main(String[] args) {

        // The path to the documents directory.
        String dataDir = Utils.getDataDir(GetBackgroundEffectiveValues.class);

        //ExStart:GetBackgroundEffectiveValues
        // Instantiate the Presentation class that represents the presentation
        Presentation pres = new Presentation(dataDir + "SamplePresentation.pptx");
        try {
            IBackgroundEffectiveData effBackground = pres.getSlides().get_Item(0).createBackgroundEffective();
            if (effBackground.getFillFormat().getFillType() == FillType.Solid)
                System.out.println("Fill color: " + effBackground.getFillFormat().getSolidFillColor());
            else
                System.out.println("Fill type: " + effBackground.getFillFormat().getFillType());
        } finally {
            if (pres != null) pres.dispose();
        }
        //ExEnd:GetBackgroundEffectiveValues
    }
}
