package oc.batch.nicolas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import fr.yogj.bibliows.types.LivreEmpruntType;
import fr.yogj.bibliows.types.UtilisateurType;

public class MailHandler {

	private UtilisateurType retardataire;
	private LivreEmpruntType let;

	public MailHandler(UtilisateurType pRetardataire, LivreEmpruntType pLivreEmprunte) {
		this.retardataire = pRetardataire;
		this.let = pLivreEmprunte;
	}

	public void sendMail() {
		// Setting up configurations for the email connection to the Google SMTP server
		// using TLS
		Properties props = new Properties();
		props.put("mail.smtp.host", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		// Establishing a session with required user details
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("nicolas.cayon.glayere@gmail.com", "8p8tyFD4");
			}
		});

		try {
			// Creating a Message object to set the email content
			MimeMessage msg = new MimeMessage(session);
			// Storing the comma seperated values to email addresses
			String to = this.retardataire.getCoordonnee().get(0).getEmail();

			/*
			 * Parsing the String with defualt delimiter as a comma by marking the boolean
			 * as true and storing the email
			 * 
			 * addresses in an array of InternetAddress objects
			 */
			InternetAddress[] address = InternetAddress.parse(to, true);
			// Setting the recepients from the address variable
			msg.setRecipients(Message.RecipientType.TO, address);
			String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
			msg.setSubject("Retour en retard : " + timeStamp);
			msg.setSentDate(new Date());
			msg.setText("Sampel System Generated mail\n Votre emprunt n° " + this.let.getId() + " titre : "
					+ this.let.getOuvrage().getTitre() + " n'a pas été rendu à temps.\n Date d'emprunt : "
					+ this.let.getDateEmprunt().toGregorianCalendar().getTime()
					+ " ! \n Merci de le rendre au plus tôt.\n Cordialement \n Bibliotheque OC");
			msg.setHeader("XPriority", "1");

			Transport.send(msg);

			System.out.println("Mail has been successfully send");

		} catch (MessagingException mex) {

			System.out.println("Unable to send an email" + mex);

		}
	}

	public UtilisateurType getRetardataire() {
		return this.retardataire;
	}

	public void setRetardataire(UtilisateurType retardataire) {
		this.retardataire = retardataire;
	}

	public LivreEmpruntType getLet() {
		return this.let;
	}

	public void setLet(LivreEmpruntType let) {
		this.let = let;
	}
}
