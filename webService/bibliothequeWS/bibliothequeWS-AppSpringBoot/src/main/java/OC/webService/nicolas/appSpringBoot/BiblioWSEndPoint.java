package OC.webService.nicolas.appSpringBoot;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;

import fr.yogj.bibliows.BiblioWS;
import fr.yogj.bibliows.Deconnexion;
import fr.yogj.bibliows.DeconnexionFault_Exception;
import fr.yogj.bibliows.DeconnexionResponse;
import fr.yogj.bibliows.DetailsOuvrage;
import fr.yogj.bibliows.DetailsOuvrageFault_Exception;
import fr.yogj.bibliows.DetailsOuvrageResponse;
import fr.yogj.bibliows.EmpruntOuvrage;
import fr.yogj.bibliows.EmpruntOuvrageFault_Exception;
import fr.yogj.bibliows.EmpruntOuvrageResponse;
import fr.yogj.bibliows.ListNouveautes;
import fr.yogj.bibliows.ListNouveautesResponse;
import fr.yogj.bibliows.LoginFault_Exception;
import fr.yogj.bibliows.ProlongationOuvrage;
import fr.yogj.bibliows.ProlongationOuvrageFault1_Exception;
import fr.yogj.bibliows.ProlongationOuvrageFault_Exception;
import fr.yogj.bibliows.ProlongationOuvrageResponse;
import fr.yogj.bibliows.RetourOuvrage;
import fr.yogj.bibliows.RetourOuvrageFault1_Exception;
import fr.yogj.bibliows.RetourOuvrageFault_Exception;
import fr.yogj.bibliows.RetourOuvrageResponse;
import fr.yogj.bibliows.types.CoordonneeUtilisateurType;
import fr.yogj.bibliows.types.UtilisateurType;

public class BiblioWSEndPoint implements BiblioWS {

	@Override
	public void listRetardataires(XMLGregorianCalendar dateDuJour, Holder<List<UtilisateurType>> utilisateur,
			Holder<CoordonneeUtilisateurType> coordonnee) {
		// TODO Auto-generated method stub

	}

	@Override
	public ListNouveautesResponse listNouveautes(ListNouveautes parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeconnexionResponse deconnexion(Deconnexion parameters) throws DeconnexionFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpruntOuvrageResponse empruntOuvrage(EmpruntOuvrage parameters) throws EmpruntOuvrageFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RetourOuvrageResponse retourOuvrage(RetourOuvrage parameters)
			throws RetourOuvrageFault_Exception, RetourOuvrageFault1_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProlongationOuvrageResponse prolongationOuvrage(ProlongationOuvrage parameters)
			throws ProlongationOuvrageFault_Exception, ProlongationOuvrageFault1_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UtilisateurType login(String pseudo, String motDePasse) throws LoginFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetailsOuvrageResponse detailsOuvrage(DetailsOuvrage parameters) throws DetailsOuvrageFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
