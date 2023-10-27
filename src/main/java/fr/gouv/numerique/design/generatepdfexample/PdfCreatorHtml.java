package fr.gouv.numerique.design.generatepdfexample;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.*;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.font.*;
import fr.gouv.numerique.design.generatepdfexample.FormData;
import freemarker.template.*;
import java.io.*;
import java.util.*;

/**
 * PdfCreatorHtml
 *
 */
public class PdfCreatorHtml extends PdfCreator {

  public static final String FONT_LIGHT = "src/main/resources/fonts/Marianne-Light.woff2";
  public static final String FONT_LIGHT_ITALIC = "src/main/resources/fonts/Marianne-Light_Italic.woff2";
  public static final String FONT_REGULAR = "src/main/resources/fonts/Marianne-Regular.woff2";
  public static final String FONT_REGULAR_ITALIC = "src/main/resources/fonts/Marianne-Regular_Italic.woff2";
  public static final String FONT_MEDIUM = "src/main/resources/fonts/Marianne-Medium.woff2";
  public static final String FONT_MEDIUM_ITALIC = "src/main/resources/fonts/Marianne-Medium_Italic.woff2";
  public static final String FONT_BOLD = "src/main/resources/fonts/Marianne-Bold.woff2";

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

    // Destination. Ex: "./dist/formation_creer_un_pdf_accessible_recapitulatif__HTML_BAD.pdf"
    String dest = DEST_PATH + DEST_BASE_FILE_NAME + "__HTML_" + suffix + "." + DEST_EXTENSTION;
    fout = new FileOutputStream(dest);

    // ACCESSIBILITY
    WriterProperties writerProperties = new WriterProperties();
    // writerProperties.addXmpMetadata();
    writerProperties.addUAXmpMetadata().setPdfVersion(PdfVersion.PDF_2_0);

    PdfWriter pdfWriter = new PdfWriter(fout, writerProperties);
    PdfDocument pdfDoc = new PdfDocument(pdfWriter);
    pdfDoc.getCatalog().setLang(new PdfString("fr-FR"));

    pdfDoc.setTagged();
    pdfDoc.getCatalog().setViewerPreferences(new PdfViewerPreferences().setDisplayDocTitle(true));

    // Embed font
    ConverterProperties props = new ConverterProperties();
    FontProvider fontProvider = new DefaultFontProvider(true, false, false);
    fontProvider.addFont(FontProgramFactory.createFont(FONT_LIGHT), "UTF-8");
    fontProvider.addFont(FontProgramFactory.createFont(FONT_LIGHT_ITALIC), "UTF-8");
    fontProvider.addFont(FontProgramFactory.createFont(FONT_REGULAR), "UTF-8");
    fontProvider.addFont(FontProgramFactory.createFont(FONT_REGULAR_ITALIC), "UTF-8");
    fontProvider.addFont(FontProgramFactory.createFont(FONT_MEDIUM), "UTF-8");
    fontProvider.addFont(FontProgramFactory.createFont(FONT_MEDIUM_ITALIC), "UTF-8");
    fontProvider.addFont(FontProgramFactory.createFont(FONT_BOLD), "UTF-8");
    props.setFontProvider(fontProvider);

    props.setBaseUri("./src/main/resources/");

    HtmlConverter.convertToPdf(htmlStr, pdfDoc, props);
  }
}
