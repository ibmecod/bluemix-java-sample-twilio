package com.ibm.demo;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.json.JSONArray;
import org.apache.commons.json.JSONObject;


public class TwilioDemoContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
		

	}

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		// Find database service - assumes only one
		Map<String, String> env;
		String vcap, accountSID = null, authToken = null;
		JSONObject jsonProperties, credentials;

		env = System.getenv();
		vcap = env.get("VCAP_SERVICES");
		try {
			JSONObject vcap_services = new JSONObject(vcap);
			Iterator iter = vcap_services.keys();
			
			if (vcap == null) {
				System.err
						.println("TwilioDemoContextListener: No VCAP_SERVICES found!");
				return;
			}

			while (iter.hasNext()) {
				String key = (String) iter.next();
			
				if (key.startsWith("user-provided")) {
					JSONArray array = vcap_services.getJSONArray(key);
					JSONObject obj = array.getJSONObject(0);
					if (obj.getString("name").startsWith("Twilio")) {
					
						credentials = obj.getJSONObject("credentials");
					
						accountSID =  credentials.getString("accountSID");				
						authToken = credentials.getString("authToken");
						
						break;
					}
				}
			

			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		if (accountSID == null || authToken == null) {
			System.err.println("TwilioDemoContextListener: Fatal error no Twilio service found !");
			return;
		}
		
		System.out.println("TwilioDemoContextListener: Twilio service found");
	
		contextEvent.getServletContext().setAttribute("accountSID", accountSID);
		contextEvent.getServletContext().setAttribute("authToken", authToken);

	}

}
