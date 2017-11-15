package jaom.org;

import javax.servlet.ServletException;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class Main {

	public static void main(String[] args) throws LifecycleException {
		// TODO Auto-generated method stub
		Tomcat tomcat = new Tomcat();
		Integer port = 9000;
		String web_app = "www";
		tomcat.setPort(port);		
		Context ctx = null;
		Connector connector = tomcat.getConnector();
		connector.setURIEncoding("UTF-8");
		try {
			ctx = tomcat.addWebapp("/", System.getProperty("user.dir") + "\\"+web_app);
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Tomcat.addServlet(ctx, "ServletMaster", new ServletMaster());
		ctx.addServletMappingDecoded("/test", "ServletMaster");

	    tomcat.start();
	    tomcat.getServer().await();

	}

}
