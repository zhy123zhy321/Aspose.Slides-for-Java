from asposeslides import Settings
from com.aspose.slides import Presentation
from com.aspose.slides import SaveFormat
from com.aspose.slides import TextAnchorType
from com.aspose.slides import FillType
from com.aspose.slides import TextVerticalType

from Javax.imageio import ImageIO

from java.awt import Color

class AlignText:

    def __init__(self):
        
        dataDir = Settings.dataDir + 'WorkingWithTables/AlignText/'    
        
        pres = Presentation()

        # Get the first slide
        slide = pres.getSlides().get_Item(0)

        # Define columns with widths and rows with heights
        dbl_cols = [120, 120, 120, 120]
        dbl_rows = [100, 100, 100, 100]

        # Add table shape to slide
        tbl = slide.getShapes().addTable(100, 50, dbl_cols, dbl_rows)

        # Add text to the merged cell
        tbl.getRows().get_Item(0).get_Item(1).getTextFrame().setText("10")
        tbl.getRows().get_Item(0).get_Item(2).getTextFrame().setText("20")
        tbl.getRows().get_Item(0).get_Item(3).getTextFrame().setText("30")

        # Accessing the text frame
        txt_frame = tbl.getRows().get_Item(0).get_Item(0).getTextFrame()

        # Create the Paragraph object for text frame
        para = txt_frame.getParagraphs().get_Item(0)

        # Create Portion object for paragraph

        fillType=FillType()
        color=Color()

        portion = para.getPortions().get_Item(0)
        portion.setText("Text here")
        portion.getPortionFormat().getFillFormat().setFillType(fillType.Solid)
        portion.getPortionFormat().getFillFormat().getSolidFillColor().setColor(color.BLACK)

        # Aligning the text vertically
        textVerticalType=TextVerticalType()
        cell = tbl.getRows().get_Item(0).get_Item(0)
        textAnchorType=TextAnchorType()
        cell.setTextAnchorType(textAnchorType.Center)
        cell.setTextVerticalType(textVerticalType.Vertical270)

        # Write the presentation as a PPTX file
        save_format = SaveFormat()
        pres.save(dataDir + "AlignText.pptx", save_format.Pptx)

        print "Aligned Text, please check the output file."


if __name__ == '__main__':        
    AlignText()