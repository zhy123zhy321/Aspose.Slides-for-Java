package com.aspose.slides.examples.Slides.Table;

import static com.aspose.slides.EffectSubtype.Right;

import com.aspose.slides.IAutoShape;
import com.aspose.slides.IParagraph;
import com.aspose.slides.IPortion;
import com.aspose.slides.ISlide;
import com.aspose.slides.ITable;
import com.aspose.slides.ITextFrame;
import com.aspose.slides.ParagraphFormat;
import com.aspose.slides.PortionFormat;
import com.aspose.slides.Presentation;
import com.aspose.slides.SaveFormat;
import com.aspose.slides.ShapeType;
import com.aspose.slides.TextAlignment;
import com.aspose.slides.TextFrameFormat;
import com.aspose.slides.TextVerticalType;

import static com.aspose.slides.TextVerticalType.Vertical;

import com.aspose.slides.examples.Utils;
import com.aspose.slides.internal.ba.as;

public class SettingTextFormattingInsideTableColumn {

    public static void main(String[] args) {

        // The path to the documents directory.
        String dataDir = Utils.getDataDir(SettingTextFormattingInsideTableColumn.class);

        //ExStart:SettingTextFormattingInsideTableColumn
        //Instantiate Presentation class object
        Presentation presentation = new Presentation(dataDir + "presWithTable.pptx");
        try {
            ISlide sld = presentation.getSlides().get_Item(0);
            ITable someTable = (ITable) sld.getShapes().get_Item(0);

            // setting first column cells' font height
            PortionFormat portionFormat = new PortionFormat();
            portionFormat.setFontHeight(25f);

            someTable.getColumns().get_Item(0).setTextFormat(portionFormat);
            // setting first column cells' text alignment and right margin in one call
            ParagraphFormat paragraphFormat = new ParagraphFormat();
            paragraphFormat.setAlignment(Right);

            paragraphFormat.setMarginRight(20);
            someTable.getColumns().get_Item(0).setTextFormat(paragraphFormat);

            // setting second column cells' text vertical type
            TextFrameFormat textFrameFormat = new TextFrameFormat();
            textFrameFormat.setTextVerticalType(Vertical);

            someTable.getColumns().get_Item(0).setTextFormat(textFrameFormat);

            // Save the PPTX to Disk
            presentation.save(dataDir + "Textbox.pptx", SaveFormat.Pptx);
        } finally {
            if (presentation != null) presentation.dispose();
        }
        //ExEnd:SettingTextFormattingInsideTableColumn
    }

}
