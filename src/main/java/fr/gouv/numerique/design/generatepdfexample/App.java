package fr.gouv.numerique.design.generatepdfexample;

import fr.gouv.numerique.design.generatepdfexample.FormData;
import fr.gouv.numerique.design.generatepdfexample.PdfCreator;
import fr.gouv.numerique.design.generatepdfexample.PdfCreatorManualBad;
import freemarker.template.*;
import java.io.*;
import java.util.*;

/**
 * Main App
 *
 */
public class App {

  /**
   * FreeMarker Templating configuration
   *
   * @see https://freemarker.apache.org/docs/pgui_config.html
   */
  private Configuration tplConfig;

  public static void main(String args[]) throws Exception {
    String destTest = PdfCreator.DEST_PATH + PdfCreator.DEST_BASE_FILE_NAME + "." + PdfCreator.DEST_EXTENSTION;
    File file = new File(destTest);
    file.getParentFile().mkdirs();

    new App();
  }

  public App() throws Exception {
    // Create a test form data object
    FormData testFormdata = new FormData();
    testFormdata.fillTestData();

    /* Create and adjust the FreeMarker configuration singleton */
    Configuration cfg = this.tplConfig;
    cfg = new Configuration(Configuration.VERSION_2_3_32);
    cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
    cfg.setDefaultEncoding("UTF-8");
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    cfg.setLogTemplateExceptions(false);
    cfg.setWrapUncheckedExceptions(true);
    cfg.setFallbackOnNullLoopVariable(false);
    cfg.setSQLDateAndTimeTimeZone(TimeZone.getDefault());

    /* Create a data-model */
    HashMap dataModel = new HashMap();
    dataModel.put("testFormdata", testFormdata);

    new PdfCreatorManualBad().createPdf(testFormdata);
    new PdfCreatorManualGood().createPdf(testFormdata);

    PdfCreatorHtml pdfCreatorHtml = new PdfCreatorHtml();
    pdfCreatorHtml.createPdfFromHtml(cfg, dataModel, "BAD");
    pdfCreatorHtml.createPdfFromHtml(cfg, dataModel, "GOOD");
  }
}
