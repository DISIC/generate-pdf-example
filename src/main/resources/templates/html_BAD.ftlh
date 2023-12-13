<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/style_BAD.css" />
  </head>
  <body>
    <img src="img/logo-designgouv.png" width="250.6" height="49.3" />
    <p style="font-size: 37.33px; line-height: normal; margin-bottom: 24px">
      Récapitulatif d’inscription à la formation<br />
      <b>${testFormdata.courseTitle}</b>
    </p>
    <p style="font-size: 24px; margin-bottom: 38px">
      Le ${testFormdata.formattedCourseStartDate} de
      ${testFormdata.formattedCourseStartTime} à
      ${testFormdata.formattedCourseEndTime}
    </p>
    <p style="margin-bottom: 52.5px">
      <i
        >Formulaire d’inscription envoyé :
        ${testFormdata.formattedRegistrationDate} à
        ${testFormdata.formattedRegistrationTime}.</i
      >
    </p>
    <p>Prénom :<br /><b>${testFormdata.firstName}</b></p>
    <p>Nom :<br /><b>${testFormdata.lastName}</b></p>
    <p>E-mail :<br /><b>${testFormdata.email}</b></p>
    <p>Ville :<br /><b>${testFormdata.city}</b></p>
    <p>Status :<br /><b>${testFormdata.function}</b></p>
    <p>Organisme :<br /><b>${testFormdata.organisation}</b></p>
    <p>
      Démarche de l'Observatoire :<br /><b
        >${testFormdata.observatoryProcedure}</b
      >
    </p>
    <p>Niveau d’expertise :<br /><b>${testFormdata.level}</b></p>
    <p>
      Motivations pour suivre cette formation :<br /><b
        >${testFormdata.motivations}</b
      >
    </p>
    <center style="margin-top: 53.33px">
      <p>
        <i
          >« PDF is used wherever the exact presentation of the content is
          important [...] »</i
        >
      </p>
      <p>— PDF Explained de John Whitington</p>
    </center>
  </body>
</html>
