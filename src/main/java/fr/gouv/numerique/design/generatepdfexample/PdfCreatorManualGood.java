package fr.gouv.numerique.design.generatepdfexample;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.tagging.StandardRoles;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import fr.gouv.numerique.design.generatepdfexample.FormData;
import java.io.File;
import java.io.IOException;

/**
 * PdfCreatorManualGood
 *
 */
public class PdfCreatorManualGood extends PdfCreatorManual {

  public PdfCreatorManualGood() throws IOException {
    super();
  }

  protected void createPdf(FormData data) throws IOException {
    // Ex: "./dist/formation_creer_un_pdf_accessible_recapitulatif__MANUAL_GOOD.pdf"
    String dest = DEST_PATH + DEST_BASE_FILE_NAME + "__MANUAL_GOOD." + DEST_EXTENSTION;
    Document d = super.createDocument(dest, data);

    // Creating an ImageData object
    String imgPath = "src/main/resources/img/logo-designgouv.png";
    ImageData imgData = ImageDataFactory.create(imgPath);

    // Creating an Image object
    Image image = new Image(imgData);
    image.scaleAbsolute(188, 37);

    // a11y: image alt
    image.getAccessibilityProperties().setAlternateDescription("DesignGouv");

    // Adding image to the document
    d.add(image);

    // Adding a paragraph to the document
    Paragraph p;
    p = new Paragraph(dest);
    d.add(p);

    // Definition list
    List list = new List();
    list.setListSymbol("");

    this.addKeyValueListItem(list, "Prénom", data.firstName);
    this.addKeyValueListItem(list, "Nom", data.lastName);
    this.addKeyValueListItem(list, "E-mail", data.email);
    this.addKeyValueListItem(list, "Ville", data.city);
    this.addKeyValueListItem(list, "Status", data.status);
    this.addKeyValueListItem(list, "Organisme", data.organisation);
    if (!data.observatoryProcedure.isEmpty()) {
      this.addKeyValueListItem(list, "Démarche de l'Observatoire", data.observatoryProcedure);
    }
    this.addKeyValueListItem(list, "Niveau d’expertise", data.level);
    this.addKeyValueListItem(list, "Motivations pour suivre cette formation", data.motivations);
    d.add(list);

    //TODO quote en english!

    d.close();
  }

  protected void addKeyValueListItem(List list, String key, String val) {
    ListItem li = new ListItem();

    // Remove default role "LBODY" from LI element (we want 2 children: LBL + LBODY)
    // see https://kb.itextpdf.com/itext/release-itext-core-7-2-4
    li.setNeutralRole();

    Paragraph keyP = new Paragraph(key);
    keyP.getAccessibilityProperties().setRole(StandardRoles.LBL);
    keyP.add(new Text(" : "));

    Paragraph valP = new Paragraph(val);
    valP.getAccessibilityProperties().setRole(StandardRoles.LBODY);
    valP.setFont(this.fontBold);

    li.add(keyP);
    li.add(valP);

    list.add(li);
  }
}
