package fr.gouv.numerique.design.generatepdfexample;

import com.itextpdf.io.font.*;
import com.itextpdf.io.font.*;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.font.PdfFontFactory.EmbeddingStrategy;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfDocumentInfo;
import com.itextpdf.kernel.pdf.PdfOutline;
import com.itextpdf.kernel.pdf.PdfString;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.navigation.PdfDestination;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.font.*;
import fr.gouv.numerique.design.generatepdfexample.FormData;
import java.io.IOException;

/**
 * PdfCreatorManual
 *
 */
public class PdfCreatorManual extends PdfCreator {

  protected PdfFont fontLight;
  protected PdfFont fontLightItalic;
  protected PdfFont fontRegular;
  protected PdfFont fontRegularItalic;
  protected PdfFont fontMedium;
  protected PdfFont fontMediumItalic;
  protected PdfFont fontBold;

  public PdfCreatorManual() throws IOException {
    super();
  }

  protected void createPdf(FormData data) throws IOException {}

  protected Document createDocument(String dest, FormData data) throws IOException {
    // Create a tagged PDF document
    PdfDocument pdfDoc = this.createTaggedPDFDocument(dest);

    // Initialize document
    Document d = new Document(pdfDoc);
    String encoding = PdfEncodings.IDENTITY_H;
    EmbeddingStrategy embed = EmbeddingStrategy.FORCE_EMBEDDED;

    FontProvider fontProvider = new FontProvider("Marianne");
    fontProvider.addFont(FontProgramFactory.createFont(FONT_LIGHT), "UTF-8");
    fontProvider.addFont(FontProgramFactory.createFont(FONT_LIGHT_ITALIC), "UTF-8");
    fontProvider.addFont(FontProgramFactory.createFont(FONT_REGULAR), "UTF-8");
    fontProvider.addFont(FontProgramFactory.createFont(FONT_REGULAR_ITALIC), "UTF-8");
    fontProvider.addFont(FontProgramFactory.createFont(FONT_MEDIUM), "UTF-8");
    fontProvider.addFont(FontProgramFactory.createFont(FONT_MEDIUM_ITALIC), "UTF-8");
    fontProvider.addFont(FontProgramFactory.createFont(FONT_BOLD), "UTF-8");

    this.fontLight = PdfFontFactory.createFont(FontProgramFactory.createFont(FONT_LIGHT), encoding, embed);
    this.fontLightItalic = PdfFontFactory.createFont(FontProgramFactory.createFont(FONT_LIGHT_ITALIC), encoding, embed);
    this.fontRegular = PdfFontFactory.createFont(FontProgramFactory.createFont(FONT_REGULAR), encoding, embed);
    this.fontRegularItalic = PdfFontFactory.createFont(FontProgramFactory.createFont(FONT_REGULAR_ITALIC), encoding, embed);
    this.fontMedium = PdfFontFactory.createFont(FontProgramFactory.createFont(FONT_MEDIUM), encoding, embed);
    this.fontMediumItalic = PdfFontFactory.createFont(FontProgramFactory.createFont(FONT_MEDIUM_ITALIC), encoding, embed);
    this.fontBold = PdfFontFactory.createFont(FontProgramFactory.createFont(FONT_BOLD), encoding, embed);

    d.setFont(this.fontRegular);

    PdfDocumentInfo documentInfo = pdfDoc.getDocumentInfo();
    documentInfo.setTitle("Récapitulatif d’inscription à la formation \"" + data.courseTitle + "\"");

    return d;
  }

  public Paragraph createHeading(String title, String hLevel) {
    Paragraph p = new Paragraph(title);
    p.setFont(this.fontBold).setFontSize(20f).setMarginTop(20f).setMarginBottom(10f).setMultipliedLeading(1);
    p.getAccessibilityProperties().setRole(hLevel);
    return p;
  }

  public PdfOutline createOutline(PdfOutline outline, PdfDocument pdf, String title, String name) {
    if (outline == null) {
      outline = pdf.getOutlines(false);
      outline = outline.addOutline(title);
      outline.addDestination(PdfDestination.makeDestination(new PdfString(name)));
      return outline;
    }
    PdfOutline kid = outline.addOutline(title);
    kid.addDestination(PdfDestination.makeDestination(new PdfString(name)));
    return outline;
  }
}
