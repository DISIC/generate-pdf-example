package fr.gouv.numerique.design.generatepdfexample;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import fr.gouv.numerique.design.generatepdfexample.FormData;
import freemarker.template.*;
import java.io.*;
import java.util.*;

/**
 * PdfCreatorHtml
 *
 */
public class PdfCreatorHtml extends PdfCreator {

  public PdfCreatorHtml() throws IOException {
    super();
  }

  /**
   * Creates a PDF file from HTML content.
   * HTML content is produced from a templarte + data
   *
   * @param Configuration config FreeMarker configuration object
   * @param HashMap data Data object used to hydrate HTML template
   * @param String suffix "GOOD" or "BAD"
   */
  protected void createPdfFromHtml(Configuration config, HashMap data, String suffix) throws Exception {
    // Source
    // Get the template (uses cache internally)
    Template tpl = config.getTemplate("html_" + suffix + ".ftlh");

    // Merge data-model with template
    StringWriter writer = new StringWriter();
    tpl.process(data, writer);
    String htmlStr = writer.toString();

    // Write the computed HTML to file for testing purpose
    String destHtml = DEST_PATH + DEST_BASE_FILE_NAME + "__HTML_" + suffix + ".html";
    FileOutputStream fout = new FileOutputStream(destHtml);
    fout.write(htmlStr.getBytes());

    ConverterProperties props = new ConverterProperties();
    props.setBaseUri("./src/main/resources/");

    // Destination. Ex: "./dist/formation_creer_un_pdf_accessible_recapitulatif__HTML_BAD.pdf"
    String dest = DEST_PATH + DEST_BASE_FILE_NAME + "__HTML_" + suffix + "." + DEST_EXTENSTION;

    HtmlConverter.convertToPdf(htmlStr, new FileOutputStream(dest), props);
  }
}
