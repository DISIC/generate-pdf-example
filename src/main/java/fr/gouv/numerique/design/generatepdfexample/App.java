package fr.gouv.numerique.design.generatepdfexample;

import fr.gouv.numerique.design.generatepdfexample.FormData;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import java.io.File;
import java.io.IOException;

/**
 * Main App
 *
 */
public class App
{
    public static final String DEST = "./formation_creer_un_pdf_accessible__recapitulatif.pdf";

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new App().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {
        // Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        // Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document d = new Document(pdf);

        // Create a test form data object
        FormData testFormData = new FormData();
        testFormData.fillTestData();

        // Creating an ImageData object
        String imFile = "src/main/resources/img/logo-designgouv.png";
        ImageData data = ImageDataFactory.create(imFile);

        // Creating an Image object
        Image image = new Image(data);
		image.scaleAbsolute(188, 37);

        // Adding image to the document
        d.add(image);

        // Add paragraphs to the document
        Paragraph p = new Paragraph();
		p.add(new Text("Récapitulatif d’inscription à la formation "));
		p.add(new Text("« " + testFormData.courseTitle + " »").setBold());
        d.add(p.setFontSize(28).setMarginBottom(10f));

		p = new Paragraph(testFormData.courseDate);
        d.add(p.setFontSize(18).setMarginBottom(20f));

        p = new Paragraph("Formulaire d’inscription envoyé : " + testFormData.getFormatedDateAndTime() + ".");
        p.setMarginBottom(35f).setItalic();
        d.add(p);

        this.addKeyValueParagraph(d, p, "Prénom", testFormData.firstName);
        this.addKeyValueParagraph(d, p, "Nom", testFormData.lastName);
        this.addKeyValueParagraph(d, p, "E-mail", testFormData.email);
        this.addKeyValueParagraph(d, p, "Ville", testFormData.city);
        this.addKeyValueParagraph(d, p, "Status", testFormData.status);
        this.addKeyValueParagraph(d, p, "Organisme", testFormData.organisation);
        if (!testFormData.observatoryProcedure.isEmpty()) {
            this.addKeyValueParagraph(d, p, "Démarche de l'Observatoire", testFormData.observatoryProcedure);
        }
        this.addKeyValueParagraph(d, p, "Niveau d’expertise", testFormData.level);
        this.addKeyValueParagraph(d, p, "Motivations pour suivre cette formation", testFormData.motivations);

        // Close document
        d.close();
    }

    private void addKeyValueParagraph(Document d, Paragraph p, String key, String val) {
        p = new Paragraph(new Text(key + " :\n"));
        p.add(new Text(val).setBold());
        d.add(p);
    }
}
