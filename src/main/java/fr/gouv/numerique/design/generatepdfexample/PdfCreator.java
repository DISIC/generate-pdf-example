package fr.gouv.numerique.design.generatepdfexample;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
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

  protected FormData testFormdata;

  public PdfCreator() throws IOException {}
}
