package com.aspose.slides.examples.Slides.Shapes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.aspose.slides.ISmartArt;
import com.aspose.slides.ISmartArtNode;
import com.aspose.slides.Presentation;
import com.aspose.slides.SmartArtLayoutType;
import com.aspose.slides.examples.Utils;

public class GeneratingAThumbnailOfSmartArtChildNode {

    public static void main(String[] args) throws IOException {

        // The path to the documents directory.
        String dataDir = Utils.getDataDir(GeneratingAThumbnailOfSmartArtChildNode.class);

        //ExStart:GeneratingAThumbnailOfSmartArtChildNode
        // Instantiate Presentation class that represents the PPTX file
        Presentation pres = new Presentation();
        try {
            // Add SmartArt
            ISmartArt smart = pres.getSlides().get_Item(0).getShapes().addSmartArt(10, 10, 400, 300, SmartArtLayoutType.BasicCycle);

            // Obtain the reference of a node by using its Index
            ISmartArtNode node = smart.getNodes().get_Item(1);

            // Generating SmartArt node thumbnail
            BufferedImage image = node.getShapes().get_Item(0).getThumbnail();

            // Save the image to disk in PNG format
            ImageIO.write(image, "png", new File(dataDir + "NodeImage.png"));
        } finally {
            if (pres != null) pres.dispose();
        }
        //ExEnd:GeneratingAThumbnailOfSmartArtChildNode
    }

}
