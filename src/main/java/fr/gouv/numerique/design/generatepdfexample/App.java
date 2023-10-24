package fr.gouv.numerique.design.generatepdfexample;

import fr.gouv.numerique.design.generatepdfexample.PdfCreator;
import fr.gouv.numerique.design.generatepdfexample.PdfCreatorManualBad;
import java.io.File;
import java.io.IOException;

/**
 * Main App
 *
 */
public class App {

  public static void main(String args[]) throws IOException {
    String destTest = PdfCreator.DEST_PATH + PdfCreator.DEST_BASE_FILE_NAME + "." + PdfCreator.DEST_EXTENSTION;
    File file = new File(destTest);
    file.getParentFile().mkdirs();

    new App();
  }

  public App() throws IOException {
    new PdfCreatorManualBad();
    new PdfCreatorManualGood();
    new PdfCreatorHtmlBad();
    new PdfCreatorHtmlGood();
  }
}
