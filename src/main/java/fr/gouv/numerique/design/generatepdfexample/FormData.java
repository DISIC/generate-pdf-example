package fr.gouv.numerique.design.generatepdfexample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class FormData {

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
  public Date courseStartDate;
  public Date courseEndDate;

  public void fillTestData() {
    this.courseTitle = "Créer un PDF (vraiment) accessible";
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
    this.courseStartDate = new GregorianCalendar(2023, Calendar.DECEMBER, 14, 9, 30).getTime();
    this.courseEndDate = new GregorianCalendar(2023, Calendar.DECEMBER, 14, 12, 30).getTime();
    this.registrationDate = new Date();
  }

  /**********
   * Getters
   **********/

  public String getCourseTitle() {
    return this.courseTitle;
  }

  public String getQuoteText() {
    return this.quoteText;
  }

  public String getQuoteBook() {
    return this.quoteBook;
  }

  public String getQuoteAuthor() {
    return this.quoteAuthor;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getEmail() {
    return this.email;
  }

  public String getCity() {
    return this.city;
  }

  public String getFunction() {
    return this.function;
  }

  public String getStatus() {
    return this.status;
  }

  public String getOrganisation() {
    return this.organisation;
  }

  public String getLevel() {
    return this.level;
  }

  public String getObservatoryProcedure() {
    return this.observatoryProcedure;
  }

  public String getMotivations() {
    return this.motivations;
  }

  /**
   * @return String Formatted course start date (ex: "jeudi 14 décembre 2023")
   */
  public String getFormattedCourseStartDate() {
    return this.getFormattedDate(this.courseStartDate);
  }

  /**
   * @return String Formatted course start time (ex: "09 h 30")
   */
  public String getFormattedCourseStartTime() {
    return this.getFormattedTime(this.courseStartDate);
  }

  /**
   * @return String Formatted course end date (ex: "jeudi 14 décembre 2023")
   */
  public String getFormattedCourseEndDate() {
    return this.getFormattedDate(this.courseEndDate);
  }

  /**
   * @return String Formatted course end time (ex: "12 h 30")
   */
  public String getFormattedCourseEndTime() {
    return this.getFormattedTime(this.courseEndDate);
  }

  /**
   * Gets the course date.
   * @return String A string with date and time (format: 'yyyy-MM-ddTHH:mm')
   */
  public String getCourseDate() {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    return df.format(this.courseStartDate);
  }

  /**
   * Gets the course start time.
   * @return String A string with time (format: 'HH:mm')
   */
  public String getCourseStartTime() {
    SimpleDateFormat tf = new SimpleDateFormat("hh:mm");
    return tf.format(this.courseStartDate);
  }

  /**
   * Gets the course end time.
   * @return String A string with time (format: 'HH:mm')
   */
  public String getCourseEndTime() {
    SimpleDateFormat tf = new SimpleDateFormat("hh:mm");
    return tf.format(this.courseEndDate);
  }

  /**
   * @return String Formatted registration date (ex: "vendredi 13 octobre 2023")
   */
  public String getFormattedRegistrationDate() {
    return this.getFormattedDate(this.registrationDate);
  }

  /**
   * @return String Formatted registration time (ex: "15 h 53")
   */
  public String getFormattedRegistrationTime() {
    return this.getFormattedTime(this.registrationDate);
  }

  /**
   * Gets the registration date and time.
   * @return String A string with date and time (format: 'yyyy-MM-ddTHH:mm')
   */
  public String getRegistrationDateTime() {
    return this.formatDataTime(this.registrationDate);
  }

  /**
   * Gets a formatted date string given a Date object
   * @param Date date A Date object
   * @return String Formatted date (ex: "13 octobre 2023")
   */
  private String getFormattedDate(Date date) {
    DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRENCH);
    return df.format(date);
  }

  /**
   * Gets a formatted time string given a Date object
   * @param Date date A Date object
   * @return String Formatted time (ex: "15 h 53")
   */
  private String getFormattedTime(Date date) {
    SimpleDateFormat tf = new SimpleDateFormat("HH 'h' mm");
    return tf.format(date);
  }

  /**
   * Gets a "date and time" string given a Date object
   * Ex: '2023-10-13T15:53'
   * Useful for [<time>](https://developer.mozilla.org/docs/Web/HTML/Element/time)
   *
   * @param Date date A Date object
   *
   * @return String A string with date and time (format: 'yyyy-MM-ddTHH:mm')
   */
  private String formatDataTime(Date date) {
    SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
    return dtf.format(date);
  }
}
