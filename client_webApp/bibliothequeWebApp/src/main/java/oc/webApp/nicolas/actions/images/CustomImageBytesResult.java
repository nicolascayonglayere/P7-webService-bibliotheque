package oc.webApp.nicolas.actions.images;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

@Service
public class CustomImageBytesResult implements Result {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void execute(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ImageAction action = (ImageAction) invocation.getAction();
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setContentType(action.getCustomContentType());
		response.getOutputStream().write(action.getCustomImageInBytes());
		response.getOutputStream().flush();
		// System.out.println("resultat image "+response.toString());
	}

}
