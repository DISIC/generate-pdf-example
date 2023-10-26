package fr.gouv.numerique.design.generatepdfexample;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.TextAlignment;
import fr.gouv.numerique.design.generatepdfexample.FormData;
import java.io.File;
import java.io.IOException;

/**
 * PdfCreatorManualBad
 *
 */
public class PdfCreatorManualBad extends PdfCreatorManual {

  public PdfCreatorManualBad() throws IOException {
    super();
  }

  protected void createPdf(FormData data) throws IOException {
    // Ex: "./dist/formation_creer_un_pdf_accessible_recapitulatif__MANUAL_BAD.pdf"
    String dest = DEST_PATH + DEST_BASE_FILE_NAME + "__MANUAL_BAD." + DEST_EXTENSTION;
    Document d = super.createDocument(dest);

    // Creating an ImageData object
    String imgPath = "src/main/resources/img/logo-designgouv.png";
    ImageData imgData = ImageDataFactory.create(imgPath);

    // Creating an Image object
    Image image = new Image(imgData);
    image.scaleAbsolute(188, 37);

    // Adding image to the document
    d.add(image);

    // A Paragraph object that will be used for all paragraphs coming next
    Paragraph p;

    // Add title as paragraph
    p = new Paragraph();
    p.add(new Text("Récapitulatif d’inscription à la formation "));
    p.add(new Text(data.courseTitle).setBold());
    d.add(p.setFontSize(28).setMarginBottom(10f));

    // Add course date as paragraph
    p =
      new Paragraph(
        "Le " + data.getFormattedCourseStartDate() + " de " + data.getFormattedCourseStartTime() + " à " + data.getFormattedCourseEndTime()
      );
    d.add(p.setFontSize(18).setMarginBottom(20f));

    // Add form submission date as paragraph
    p =
      new Paragraph(
        "Formulaire d’inscription envoyé : le " + data.getFormattedRegistrationDate() + " à " + data.getFormattedRegistrationTime() + "."
      );
    p.setMarginBottom(35f).setItalic();
    d.add(p);

    // Add form key/values paragraphs
    this.addKeyValueParagraph(d, p, "Prénom", data.firstName);
    this.addKeyValueParagraph(d, p, "Nom", data.lastName);
    this.addKeyValueParagraph(d, p, "E-mail", data.email);
    this.addKeyValueParagraph(d, p, "Ville", data.city);
    this.addKeyValueParagraph(d, p, "Status", data.status);
    this.addKeyValueParagraph(d, p, "Organisme", data.organisation);
    if (!data.observatoryProcedure.isEmpty()) {
      this.addKeyValueParagraph(d, p, "Démarche de l'Observatoire", data.observatoryProcedure);
    }
    this.addKeyValueParagraph(d, p, "Niveau d’expertise", data.level);
    this.addKeyValueParagraph(d, p, "Motivations pour suivre cette formation", data.motivations);

    // Add quote + book + author as 2 paragraphs
    p = new Paragraph("« " + data.quoteText + " »");
    p.setItalic().setMarginTop(40f).setTextAlignment(TextAlignment.CENTER);
    d.add(p);
    p = new Paragraph();
    p.add(new Text(" — " + data.quoteBook).setItalic());
    p.add(new Text(" de " + data.quoteAuthor));
    p.setTextAlignment(TextAlignment.CENTER);
    d.add(p);

    // Close document
    d.close();
  }
}
