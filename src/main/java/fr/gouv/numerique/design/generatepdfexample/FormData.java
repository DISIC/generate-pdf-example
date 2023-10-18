package fr.gouv.numerique.design.generatepdfexample;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

class FormData
{
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
        this.firstName = "Jean";
        this.lastName = "Dupond";
        this.email = "jean.dupond@test.com";
        this.city = "Marseille";
        this.function = "Développeur";
        this.status = "Agent public de l'État";
        this.organisation = "DGFIP";
        this.observatoryProcedure = "Achat de timbre fiscal";
        this.level = "Intermédiaire";
        this.motivations = "Une refonte du service est prévue cette année, et nous aurons des PDFs à générer !";
        this.registrationDate = new Date();
    }

    public String getFormatedDateAndTime() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRENCH);
        DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.FRENCH);
        return "le " + df.format(this.registrationDate) + " à " + tf.format(this.registrationDate);
    }
 };
