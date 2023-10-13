package com.qa.testRailManager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;

public class testRailManager 
{
  public static String test_run_id= "1";
  
  public static String test_rail_username="suraj.g@3ktechnologies.com";
  public static String test_rail_password="Suraj@9792";
  
  public static String test_rail_engine_url="https://suraj007.testrail.io/";
  
  public static int test_case_pass_status=1;
  public static int test_case_fail_status=5;
  
  public static void addResultsForTestcase(String testcaseid, int status, String error)
  {
	  String testrunid=test_run_id;
	  
	  APIClient client= new APIClient(test_rail_engine_url);
	  client.setUser(test_rail_username);
	  client.setPassword(test_rail_password);
	  
	  Map<String, Object> data=new HashMap<String, Object>();
	  data.put("status_id", status);
	  data.put("comment", "this test executed"+error);
	  
	  try {
		client.sendPost("add_result_for_case/", testrunid+"/"+testcaseid);
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (APIException e) {
		e.printStackTrace();
	}
  }
}
