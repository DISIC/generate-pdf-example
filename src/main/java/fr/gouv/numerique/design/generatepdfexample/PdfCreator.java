package fr.gouv.numerique.design.generatepdfexample;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import fr.gouv.numerique.design.generatepdfexample.FormData;
import java.io.File;
import java.io.IOException;

/**
 * PdfCreator
 *
 */
public class PdfCreator {

  public static final String DEST_PATH = "./dist/";
  public static final String DEST_BASE_FILE_NAME = "formation_creer_un_pdf_accessible_recapitulatif";
  public static final String DEST_EXTENSTION = "pdf";

  public static final String FONT_LIGHT = "src/main/resources/fonts/Marianne-Light.woff2";
  public static final String FONT_LIGHT_ITALIC = "src/main/resources/fonts/Marianne-Light_Italic.woff2";
  public static final String FONT_REGULAR = "src/main/resources/fonts/Marianne-Regular.woff2";
  public static final String FONT_REGULAR_ITALIC = "src/main/resources/fonts/Marianne-Regular_Italic.woff2";
  public static final String FONT_MEDIUM = "src/main/resources/fonts/Marianne-Medium.woff2";
  public static final String FONT_MEDIUM_ITALIC = "src/main/resources/fonts/Marianne-Medium_Italic.woff2";
  public static final String FONT_BOLD = "src/main/resources/fonts/Marianne-Bold.woff2";

  protected FormData testFormdata;

  public PdfCreator() throws IOException {}

  /**
   * Creates a tagged PDF Document with proper accessibility properties and french language.
   *
   * @param String dest Destination path. Ex: "./dist/formation_creer_un_pdf_accessible_recapitulatif__HTML.pdf"
   *
   * @return PdfDocument A new tagged PdfDocument
   */

  protected PdfDocument createTaggedPDFDocument(String dest) throws IOException {
    // a11y: PDF version
    WriterProperties writerProperties = new WriterProperties();
    writerProperties.addUAXmpMetadata().setPdfVersion(PdfVersion.PDF_2_0);

    PdfWriter pdfWriter = new PdfWriter(dest, writerProperties);
    PdfDocument pdfDoc = new PdfDocument(pdfWriter);

    // a11y: language
    pdfDoc.getCatalog().setLang(new PdfString("fr-FR"));
    // a11y: tagged
    pdfDoc.setTagged();
    // a11y: display doc title
    pdfDoc.getCatalog().setViewerPreferences(new PdfViewerPreferences().setDisplayDocTitle(true));

    return pdfDoc;
  }
}
