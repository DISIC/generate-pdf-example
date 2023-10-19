package fr.gouv.numerique.design.generatepdfexample;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.IOException;

/**
 * PdfCreatorManualGood
 *
 */
public class PdfCreatorManualGood extends PdfCreator
{
    public PdfCreatorManualGood() throws IOException {
			super();
		}

    protected void createPdf() throws IOException {

				// Ex: "./formation_creer_un_pdf_accessible_recapitulatif__MANUAL_GOOD.pdf"
        String dest = DEST_PATH + DEST_BASE_FILE_NAME + "__MANUAL_GOOD." + DEST_EXTENSTION;
        Document d = super.createDocument(dest);

        // Create a test form data object
        FormData data = this.testFormdata;

        // Creating an ImageData object
        String imgPath = "src/main/resources/img/logo-designgouv.png";
        ImageData imgData = ImageDataFactory.create(imgPath);

        // Creating an Image object
        Image image = new Image(imgData);
        image.scaleAbsolute(188, 37);

        // Adding image to the document
        d.add(image);

        // Temporary
        Paragraph p;
        p = new Paragraph(dest);
        d.add(p);

        // Close document
        d.close();
    }
}
