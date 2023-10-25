package fr.gouv.numerique.design.generatepdfexample;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * PdfCreatorHtmlBad
 *
 */
public class PdfCreatorHtmlBad extends PdfCreator {

  public String HTML = "<h1>Test</h1><p>Hello World</p>";

  public PdfCreatorHtmlBad() throws IOException {
    super();
  }

  protected void createPdf() throws IOException {
    // Ex: "./formation_creer_un_pdf_accessible_recapitulatif__HTML_BAD.pdf"
    String dest = DEST_PATH + DEST_BASE_FILE_NAME + "__HTML_BAD." + DEST_EXTENSTION;

    // HTML source
    String htmlPath = "src/main/resources/html/html_BAD.html";

    ConverterProperties props = new ConverterProperties();
    props.setBaseUri("src/main/resources");

    HtmlConverter.convertToPdf(new FileInputStream(htmlPath), new FileOutputStream(dest), props);
  }
}
