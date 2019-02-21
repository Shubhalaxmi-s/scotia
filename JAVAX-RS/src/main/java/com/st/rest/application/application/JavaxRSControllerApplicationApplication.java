package com.st.rest.application.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author SS00572568
 */
@ApplicationPath("/user")
@Component(immediate = true, service = Application.class)
public class JavaxRSControllerApplicationApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}
	
	
	
	@GET
	@Path("/get-data")
	@Produces("application/json")
	public String viewData() {
		
		 JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		 
		 
		 ArrayList<String> values = new ArrayList<String>();
		 values.add("job1");
		 values.add("job2");
		 values.add("job3");
		 values.add("job4");
		 values.add("job5");
		 values.add("job6");
		 
		 for(int i = 0 ; i < values.size() ; i++){
			 JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			   jsonObject.put("nameCurrentValue", values.get(i)); 
			   jsonArray.put(jsonObject);
		 }
		 
		 System.out.println("JSON ARRAY DISPALY..............." + jsonArray);
		return jsonArray.toJSONString();
	}

	@GET
	@Path("/morning/{name}")
	@Produces("text/plain")
	public String morning(
		@PathParam("name") String name,
		@QueryParam("drink") String drink) {

		String greeting = "Good Morning " + name;

		if (drink != null) {
			greeting += ". Would you like some " + drink + "?";
		}

		return greeting;
	}
	
	
	@GET
	 @Path("/user-info/{userId}")
	 @Produces("application/json")
	 public String getUserInfo(@PathParam("userId")String userId) {
	  JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			
	  User user = null;
	  if(Validator.isNotNull(userId)) {
	   try {
	    user = UserLocalServiceUtil.getUser(Long.parseLong(userId));
	   } catch (NumberFormatException e) {
	    jsonObject.put("ERROR", "Please pass valid User ID");
	   } catch (PortalException e) {
	    jsonObject.put("ERROR", "No User Found !");
	   }
	  }

	  if(Validator.isNotNull(user)) {
	   jsonObject.put("emailId", user.getEmailAddress());
	   jsonObject.put("Name", user.getFullName());
	   jsonObject.put("nameCurrentValue", "Aland Islands");
	  }
	  
	  
	  JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
	  jsonArray.put(jsonObject);
	  
	  return jsonArray.toJSONString();
	  //return jsonObject.toJSONString();

	 }
	
	
}