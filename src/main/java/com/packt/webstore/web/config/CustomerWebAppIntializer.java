package com.packt.webstore.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.packt.webstore.app.config.DatabaseConfig;

public class CustomerWebAppIntializer implements WebApplicationInitializer {
	  public void onStartup(ServletContext container) throws ServletException {
	      AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
	       webContext.register(DatabaseConfig.class);
	  }
	}