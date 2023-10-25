package fr.gouv.numerique.design.generatepdfexample;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * PdfCreatorHtmlGood
 *
 */
public class PdfCreatorHtmlGood extends PdfCreator {

  public PdfCreatorHtmlGood() throws IOException {
    super();
  }

  protected void createPdf() throws IOException {
    // Ex: "./formation_creer_un_pdf_accessible_recapitulatif__HTML_GOOD.pdf"
    String dest = DEST_PATH + DEST_BASE_FILE_NAME + "__HTML_GOOD." + DEST_EXTENSTION;

    // HTML source
    String htmlPath = "src/main/resources/html/html_GOOD.html";

    ConverterProperties props = new ConverterProperties();
    props.setBaseUri("src/main/resources");
    HtmlConverter.convertToPdf(new FileInputStream(htmlPath), new FileOutputStream(dest), props);
  }
}
