package oc.batch.nicolas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import fr.yogj.bibliows.BiblioWS_Service;
import fr.yogj.bibliows.ListRetardatairesResponse;
import fr.yogj.bibliows.types.LivreEmpruntType;
import fr.yogj.bibliows.types.UtilisateurType;

public class EnvoiMailRetardataires implements Tasklet {

	private List<UtilisateurType> retardataires = new ArrayList<UtilisateurType>();
	private BiblioWS_Service biblioWS = new BiblioWS_Service();
	private MailHandler mh;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyTaskOne start.. recuperation des retardataires");
		// --calcul date retard
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -28);
		ListRetardatairesResponse lrr = this.biblioWS.getBiblioWSSOAP().listRetardataires("");
		this.retardataires = lrr.getUtilisateur();
		for (UtilisateurType u : this.retardataires) {
			for (LivreEmpruntType et : u.getEmprunt()) {
				if ((et.getDateEmprunt().toGregorianCalendar().getTime()).before(cal.getTime())) {
					// --envoi de mail
					this.mh = new MailHandler(u, et);
					this.mh.sendMail();
				}
			}

		}

		return RepeatStatus.FINISHED;
	}

	public List<UtilisateurType> getRetardataires() {
		return this.retardataires;
	}

	public void setRetardataires(List<UtilisateurType> retardataires) {
		this.retardataires = retardataires;
	}

	public MailHandler getMh() {
		return this.mh;
	}

	public void setMh(MailHandler mh) {
		this.mh = mh;
	}

}