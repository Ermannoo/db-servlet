package it.ermanno;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import it.ermanno.ArticoloSrv;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Server web java
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);

        Context ctx = tomcat.addContext("/GestioneMagazzino", new File(".").getAbsolutePath());
        
        ArticoloSrv articoloSrv = new ArticoloSrv();
        
        Tomcat.addServlet(ctx, "GestioneMagazzino", articoloSrv);

        ctx.addServletMapping("/*", "GestioneMagazzino");

        try {
			tomcat.start();
		} catch (LifecycleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        tomcat.getServer().await();

	}

}
