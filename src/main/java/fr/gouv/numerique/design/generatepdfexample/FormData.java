package fr.gouv.numerique.design.generatepdfexample;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

class FormData
{
    public String courseTitle;
    public String courseDate;
    public String quoteText;
    public String quoteBook;
    public String quoteAuthor;
    public String firstName;
    public String lastName;
    public String email;
    public String city;
    public String function;
    public String status;
    public String organisation;
    public String observatoryProcedure;
    public String level;
    public String motivations;
    public Date registrationDate;

    public void fillTestData() {
        this.courseTitle = "Créer un PDF (vraiment) accessible";
        this.courseDate = "Jeudi 14 décembre 2023 de 9h30 à 12h30";
		this.quoteText = "PDF is used wherever the exact presentation of the content is important […]";
		this.quoteBook = "PDF Explained";
		this.quoteAuthor = "John Whitington";
        this.firstName = "Jean";
        this.lastName = "Dupond";
        this.email = "jean.dupond@test.com";
        this.city = "Marseille";
        this.function = "Développeur";
        this.status = "Agent public de l'État";
        this.organisation = "DGFiP";
        this.observatoryProcedure = "Achat de timbre fiscal";
        this.level = "Intermédiaire";
        this.motivations = "Une refonte du service est prévue cette année et nous aurons des PDFs à générer !";
        this.registrationDate = new Date();
    }

    public String getFormatedDateAndTime() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRENCH);
        DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.FRENCH);
        return "le " + df.format(this.registrationDate) + " à " + tf.format(this.registrationDate);
    }
 };
