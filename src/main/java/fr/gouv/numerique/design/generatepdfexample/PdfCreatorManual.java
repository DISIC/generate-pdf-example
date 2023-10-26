package fr.gouv.numerique.design.generatepdfexample;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import fr.gouv.numerique.design.generatepdfexample.FormData;
import java.io.IOException;

/**
 * PdfCreatorManual
 *
 */
public class PdfCreatorManual extends PdfCreator {

  public PdfCreatorManual() throws IOException {
    super();
  }

  protected void createPdf(FormData data) throws IOException {}

  protected Document createDocument(String dest) throws IOException {
    // Initialize PDF writer
    PdfWriter writer = new PdfWriter(dest);

    // Initialize PDF document
    PdfDocument pdf = new PdfDocument(writer);

    // Initialize document
    Document d = new Document(pdf);

    return d;
  }

  protected void addKeyValueParagraph(Document d, Paragraph p, String key, String val) {
    p = new Paragraph(new Text(key + " :\n"));
    p.add(new Text(val).setBold());
    d.add(p);
  }
}
