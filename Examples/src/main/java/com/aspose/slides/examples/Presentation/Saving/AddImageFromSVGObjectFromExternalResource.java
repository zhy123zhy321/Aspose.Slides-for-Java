/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.slides.examples.Presentation.Saving;

import com.aspose.slides.ExternalResourceResolver;
import com.aspose.slides.IPPImage;
import com.aspose.slides.ISvgImage;
import com.aspose.slides.Presentation;
import com.aspose.slides.SaveFormat;
import com.aspose.slides.ShapeType;
import com.aspose.slides.SvgImage;
import com.aspose.slides.examples.Utils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author mfazi
 */
public class AddImageFromSVGObjectFromExternalResource {
    
    public static void main(String[] args) throws IOException {
        //ExStart:AddImageFromSVGObjectFromExternalResource
       // The path to the documents directory.
       String dataDir = Utils.getDataDir(AddImageFromSVGObjectFromExternalResource.class);
       String svgPath = dataDir + "image1.svg";
       String outPptxPath = dataDir + "presentation_external.pptx";
       Presentation p = new Presentation();
        try
        {
            String svgContent = new String(Files.readAllBytes(Paths.get(svgPath)));
            ISvgImage svgImage = new SvgImage(svgContent, new ExternalResourceResolver(), dataDir);
            IPPImage ppImage = p.getImages().addImage(svgImage);
            p.getSlides().get_Item(0).getShapes().addPictureFrame(ShapeType.Rectangle, 0, 0, ppImage.getWidth(), ppImage.getHeight(), ppImage);
            p.save(outPptxPath, SaveFormat.Pptx);
        }
        finally {
            p.dispose();
        }
       //ExEnd:AddImageFromSVGObjectFromExternalResource
    }
    
}
