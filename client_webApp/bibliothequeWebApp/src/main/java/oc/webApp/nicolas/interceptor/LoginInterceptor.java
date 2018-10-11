package oc.webApp.nicolas.interceptor;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import fr.yogj.bibliows.types.UtilisateurType;

/**
 * Classe Interceptor qui agit dans le package /utilisateur et empeche les
 * {@link UtilisateurType} non connectés d'effectuer des actions
 * 
 * @author nicolas
 *
 */
public class LoginInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> sessionAttributes = invocation.getInvocationContext().getSession();
		logger.debug("interceptor Login " + sessionAttributes.get("utilisateur"));
		if (sessionAttributes == null || sessionAttributes.get("utilisateur") == null) {

			return "login";
		} else {
			if (!(sessionAttributes.get("utilisateur") == null)) {
				return invocation.invoke();
			} else {
				return "login";
			}
		}

	}

}
