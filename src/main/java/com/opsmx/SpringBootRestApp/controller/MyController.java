package com.opsmx.SpringBootiRestApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.boot.web.servlet.error.ErrorController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.management.*;

@RestController
public class MyController implements ErrorController {

        private static final Logger LOG = LoggerFactory.getLogger(MyController.class);	
	private static final String PATH = "/error";

	@RequestMapping(value = "/error")
	public String myerror() {
		return "<center><h1>Something went wrong</h1></center>";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

	@GetMapping(path = "/welcome")
	public String welcome() {
		return "Welcome to Opsmx SpringBootAPP ...";
	}


	@RequestMapping("/")
        public String mainbanner() {
           LOG.info("Hello Inside banner API");
           String querys;
           StringBuffer bn = new StringBuffer();
           ClassLoader mbc = MyController.class.getClassLoader();
   
        try{
             BufferedReader br = new BufferedReader(new InputStreamReader(mbc.getResource("opsmxpage.html").openStream()));
              while((querys=br.readLine())!=null)
               bn.append(querys);
               br.close();
           }
           catch(Exception e){
             e.printStackTrace();
             LOG.error("Error: " + e);
           }
           String bannerResponse = bn.length()>0 ? bn.toString() : " No page found";
           return bannerResponse;
       }

}
