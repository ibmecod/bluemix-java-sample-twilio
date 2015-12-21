package com.ibm.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Sms;


/**
 * Servlet implementation class TwilioSMS
 */
public class TwilioSMS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwilioSMS() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sms message = null;
		String authToken = (String) getServletContext().getAttribute("authToken");
		String accountSID = (String) getServletContext().getAttribute("accountSID");
		PrintWriter out = response.getWriter();
	    TwilioRestClient client = new TwilioRestClient(accountSID, authToken);
		
	    // Build a filter for the SmsList
		Map<String, String> params = new HashMap<String, String>();
		
		// Update with your Twilio number 
		params.put("From", "+1xxxxxxxxxx");
		params.put("Body", request.getParameter("body"));
		params.put("To", request.getParameter("to"));
	
		SmsFactory messageFactory = client.getAccount().getSmsFactory();
		try {
		message = messageFactory.create(params);
		}
		catch (TwilioRestException e) {
			throw new ServletException(e);
		}
		out.println("Sent message id: " + message.getSid());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
