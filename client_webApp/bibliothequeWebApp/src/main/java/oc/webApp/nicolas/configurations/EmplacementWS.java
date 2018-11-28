package oc.webApp.nicolas.configurations;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmplacementWS {

	private String url_ws;
	private URL monUrl;

	public EmplacementWS() {

	}

	public String getUrl_ws() {
		return this.url_ws;
	}

	@Value("${biblio.ws.endpoint.url}")
	public void setUrl_ws(String url_ws) {
		this.url_ws = url_ws;
		System.out.println("SETTER : " + this.url_ws);
	}

	public URL getMonUrl() {
		System.out.println(this.getUrl_ws());
		try {
			this.monUrl = new URL(this.getUrl_ws());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.monUrl.toString());
		return this.monUrl;
	}

	public void setMonUrl(URL monUrl) {
		this.monUrl = monUrl;
	}
}
