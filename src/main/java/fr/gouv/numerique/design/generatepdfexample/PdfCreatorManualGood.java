package fr.gouv.numerique.design.generatepdfexample;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfName;
import com.itextpdf.kernel.pdf.PdfOutline;
import com.itextpdf.kernel.pdf.PdfString;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.navigation.PdfDestination;
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

  protected PdfOutline outline = null;
  protected int outlineCounter = 0;

  public PdfCreatorManualGood() throws IOException {
    super();
  }

  protected void createPdf(FormData data) throws IOException {
    // Ex: "./dist/formation_creer_un_pdf_accessible_recapitulatif__MANUAL_GOOD.pdf"
    String dest = DEST_PATH + DEST_BASE_FILE_NAME + "__MANUAL_GOOD." + DEST_EXTENSTION;
    Document d = super.createDocument(dest, data);

    PdfDocument pdf = d.getPdfDocument();
    pdf.getCatalog().setPageMode(PdfName.UseOutlines);

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

    // H1 Main heading
    d.add(this.createHeading(pdf, "Récapitulatif d’inscription à la formation « " + data.courseTitle + " »", StandardRoles.H1));

    // H2 "general info"
    d.add(this.createHeading(pdf, "Informations générales", StandardRoles.H2));

    // Adding a paragraph to the document
    Paragraph p;
    p =
      new Paragraph(
        "Le " + data.getFormattedCourseStartDate() + " de " + data.getFormattedCourseStartTime() + " à " + data.getFormattedCourseEndTime()
      );
    d.add(p);
    p =
      new Paragraph(
        "Formulaire d’inscription envoyé : le " + data.getFormattedRegistrationDate() + " à " + data.getFormattedRegistrationTime() + "."
      );
    d.add(p);

    // H2 "detailed info"
    d.add(this.createHeading(pdf, "Informations détaillées", StandardRoles.H2, 1));

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

  protected Paragraph createHeading(PdfDocument pdf, String title, String hLevel) {
    return this.createHeading(pdf, title, hLevel, 0);
  }

  protected Paragraph createHeading(PdfDocument pdf, String title, String hLevel, int nAncestorsUp) {
    Paragraph p = new Paragraph(title);

    float fontSize;
    switch (hLevel) {
      case StandardRoles.H1:
        fontSize = 26f;
        break;
      case StandardRoles.H2:
        fontSize = 22f;
        break;
      case StandardRoles.H3:
        fontSize = 20f;
        break;
      case StandardRoles.H4:
        fontSize = 18f;
        break;
      case StandardRoles.H5:
        fontSize = 16f;
        break;
      case StandardRoles.H6:
      default:
        fontSize = 14f;
        break;
    }
    p.setFont(this.fontBold).setFontSize(fontSize).setMarginTop(20f).setMarginBottom(10f).setMultipliedLeading(1);
    // a11y: heading level
    p.getAccessibilityProperties().setRole(hLevel);

    String name = String.format("title%02d", this.outlineCounter++);
    // a11y: outline (= bookmark)
    this.createOutline(pdf, title, name, nAncestorsUp);
    p.setDestination(name);
    return p;
  }

  protected void createOutline(PdfDocument pdf, String title, String name, int nAncestorsUp) {
    PdfOutline lastOutline = this.outline;
    PdfOutline parentOutline = lastOutline;
    if (lastOutline == null) {
      parentOutline = lastOutline = pdf.getOutlines(false);
    } else {
      int i = 0;
      while ((i++ < nAncestorsUp) || parentOutline == null) {
        parentOutline = parentOutline.getParent();
      }
    }
    lastOutline = parentOutline.addOutline(title);
    // a11y: link outline to heading
    lastOutline.addDestination(PdfDestination.makeDestination(new PdfString(name)));
    this.outline = lastOutline;
  }

  protected void addKeyValueListItem(List list, String key, String val) {
    ListItem li = new ListItem();

    // a11y: cancel default role
    // Remove default role "LBODY" from LI element (we want 2 children: LBL + LBODY)
    // see https://kb.itextpdf.com/itext/release-itext-core-7-2-4
    li.setNeutralRole();

    Paragraph p = new Paragraph();
    // a11y: cancel default role
    p.setNeutralRole();

    Text keyT = new Text(key);
    // a11y: role LBL
    keyT.getAccessibilityProperties().setRole(StandardRoles.LBL);

    Text valT = new Text(" : " + val);
    // a11y: role LBODY
    valT.getAccessibilityProperties().setRole(StandardRoles.LBODY);
    valT.setFont(this.fontBold);

    p.add(keyT);
    p.add(valT);

    li.add(p);

    list.add(li);
  }
}
