<!doctype html>
<html lang="fr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>
      Récapitulatif d’inscription à la formation "${testFormdata.courseTitle}"
    </title>
    <link rel="stylesheet" type="text/css" href="css/style_GOOD.css" />
  </head>
  <body>
    <header>
      <img
        src="img/logo-designgouv.png"
        width="250.6"
        height="49.3"
        alt="DesignGouv"
      />
      <h1>
        Récapitulatif d’inscription à la formation<br />
        <strong>${testFormdata.courseTitle}</strong>
      </h1>
      <p class="subtitle">
        Le
        <time datetime="${testFormdata.courseDate}"
          >${testFormdata.formattedCourseStartDate}</time
        >
        de
        <time datetime="${testFormdata.courseStartTime}"
          >${testFormdata.formattedCourseStartTime}</time
        >
        à
        <time datetime="${testFormdata.courseEndTime}"
          >${testFormdata.formattedCourseEndTime}</time
        >
      </p>
    </header>
    <main class="stack-xl">
      <p class="sent-date">
        Formulaire d’inscription envoyé :
        <time datetime="${testFormdata.registrationDateTime}"
          >le ${testFormdata.formattedRegistrationDate} à
          ${testFormdata.formattedRegistrationTime}</time
        >.
      </p>
      <dl class="stack">
        <div>
          <dt>Prénom</dt>
          <dd>${testFormdata.firstName}</dd>
        </div>
        <div>
          <dt>Nom</dt>
          <dd>${testFormdata.lastName}</dd>
        </div>
        <div>
          <dt>E-mail</dt>
          <dd>${testFormdata.email}</dd>
        </div>
        <div>
          <dt>Ville</dt>
          <dd>${testFormdata.city}</dd>
        </div>
        <div>
          <dt>Status</dt>
          <dd>${testFormdata.status}</dd>
        </div>
        <div>
          <dt>Organisme</dt>
          <dd>${testFormdata.organisation}</dd>
        </div>
        <div>
          <dt>Démarche de l'Observatoire</dt>
          <dd>${testFormdata.observatoryProcedure}</dd>
        </div>
        <div>
          <dt>Niveau d’expertise</dt>
          <dd>${testFormdata.level}</dd>
        </div>
        <div>
          <dt>Motivations pour suivre cette formation</dt>
          <dd>${testFormdata.motivations}</dd>
        </div>
      </dl>
      <blockquote
        cite="https://www.oreilly.com/library/view/pdf-explained/9781449321581/ch01.html"
        lang="en"
      >
        <p>
          PDF is used wherever the exact presentation of the content is
          important [...]
        </p>
        <footer>— John Whitington, <cite>PDF Explained</cite></footer>
      </blockquote>
    </main>
  </body>
</html>
