package oc.webApp.nicolas.actions.images;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

/**
 * Classe Result pour l'execution de l'action avec image
 * 
 * @author nicolas
 *
 */
@Service
public class CustomImageBytesResult implements Result {

	private static final long serialVersionUID = 1L;

	/**
	 * Méthode pour executer l'action avec image
	 */
	@Override
	public void execute(ActionInvocation invocation) throws Exception {
		ImageAction action = (ImageAction) invocation.getAction();
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setContentType(action.getCustomContentType());
		response.getOutputStream().write(action.getCustomImageInBytes());
		response.getOutputStream().flush();
	}

}
