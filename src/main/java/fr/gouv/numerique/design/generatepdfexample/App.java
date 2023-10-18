package fr.gouv.numerique.design.generatepdfexample;

import fr.gouv.numerique.design.generatepdfexample.FormData;

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
        Document document = new Document(pdf);

        // Create a test form data object
        FormData testFormData = new FormData();
        testFormData.fillTestData();

        // Creating an ImageData object
        String imFile = "src/main/resources/img/logo-designgouv.png";
        ImageData data = ImageDataFactory.create(imFile);

        // Creating an Image object
        Image image = new Image(data);

        // Adding image to the document
        document.add(image);

        // Add paragraphs to the document
        Paragraph p = new Paragraph("Récapitulatif d’inscription à la formation « Créer un PDF (vraiment) accessible »");
        document.add(p.setFontSize(28));
        document.add(new Paragraph("Prénom : " + testFormData.firstName));
        document.add(new Paragraph("Nom : " + testFormData.lastName));
        document.add(new Paragraph("E-mail : " + testFormData.email));
        document.add(new Paragraph("Ville : " + testFormData.city));
        document.add(new Paragraph("Fonction : " + testFormData.function));
        document.add(new Paragraph("Status : " + testFormData.status));
        document.add(new Paragraph("Organisme : " + testFormData.organisation));
        if (!testFormData.observatoryProcedure.isEmpty()) {
            document.add(new Paragraph("Démarche de l'Observatoire : " + testFormData.observatoryProcedure));
        }
        document.add(new Paragraph("Niveau d’expertise : " + testFormData.level));
        document.add(new Paragraph("Motivations pour suivre cette formation : " + testFormData.motivations));
        document.add(new Paragraph("Formulaire d’inscription envoyé : " + testFormData.getFormatedDateAndTime()));

        // Close document
        document.close();
    }
}
