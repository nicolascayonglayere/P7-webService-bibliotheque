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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import oc.batch.nicolas.model.LivreEmprunt;
import oc.batch.nicolas.model.Utilisateur;

@Component
public class MailHandler {

	private Utilisateur retardataire;
	private LivreEmprunt let;

	public static String starttls;
	public static String host;
	public static String port;
	public static String auth;
	public static String user;
	public static String mdp;

	public MailHandler(Utilisateur pRetardataire, LivreEmprunt pLivreEmprunte) {
		this.retardataire = pRetardataire;
		this.let = pLivreEmprunte;
	}

	public void sendMail() {
		// Setting up configurations for the email connection to the Google SMTP server
		// using TLS
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", MailHandler.starttls);
		props.put("mail.smtp.host", MailHandler.host);
		props.put("mail.smtp.port", MailHandler.port);
		props.put("mail.smtp.auth", MailHandler.auth);

		// Establishing a session with required user details
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MailHandler.user, MailHandler.mdp);
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

	public Utilisateur getRetardataire() {
		return this.retardataire;
	}

	public void setRetardataire(Utilisateur retardataire) {
		this.retardataire = retardataire;
	}

	public LivreEmprunt getLet() {
		return this.let;
	}

	public void setLet(LivreEmprunt let) {
		this.let = let;
	}

	public String getStarttls() {
		return MailHandler.starttls;
	}

	@Value("${mail.smtp.starttls.enable}")
	public void setStarttls(String starttls) {
		MailHandler.starttls = starttls;
	}

	public String getHost() {
		return MailHandler.host;
	}

	@Value("${mail.smtp.host}")
	public void setHost(String host) {
		MailHandler.host = host;
	}

	public String getPort() {
		return MailHandler.port;
	}

	@Value("${mail.smtp.port}")
	public void setPort(String port) {
		MailHandler.port = port;
	}

	public String getAuth() {
		return MailHandler.auth;
	}

	@Value("${mail.smtp.auth}")
	public void setAuth(String auth) {
		MailHandler.auth = auth;
	}

	public String getUser() {
		return MailHandler.user;
	}

	@Value("${mail.adresse}")
	public void setUser(String user) {
		MailHandler.user = user;
	}

	public String getMdp() {
		return MailHandler.mdp;
	}

	@Value("${mail.pass}")
	public void setMdp(String mdp) {
		MailHandler.mdp = mdp;
	}

}
