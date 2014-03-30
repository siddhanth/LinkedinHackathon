/* ############################################################################
 * Copyright 2013 Hewlett-Packard Co. All Rights Reserved.
 * An unpublished and CONFIDENTIAL work. Reproduction,
 * adaptation, or translation without prior written permission
 * is prohibited except as allowed under the copyright laws.
 *-----------------------------------------------------------------------------
 * Project: AL Deal-Maker
 * Module: Common
 * Source: PostRequest.java
 * Author: HP
 * Organization: HP BAS India
 * Revision: 0.1
 * Date: 08-22-2013
 * Contents:
 *-----------------------------------------------------------------------------
 * Revision History:
 *     who                                  when                                    what
 *  										08-22-2013								Initial functionality
 * #############################################################################
 */
package com.hack.linkedinhackday;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class PostRequest extends AsyncTask<HttpPost, Void, Object> {

	public ResponseInterface responseObject;
	public Object responseType;
	public static final String success = "success";
	public static final String error = "error";
	public static final String status = "status";

	public PostRequest() {
	}

	@Override
	protected Object doInBackground(HttpPost... params) {
		HttpClient httpclient = new DefaultHttpClient();

		String localStatus = null;
		HttpResponse response;
		for (HttpPost httpPost : params)
			try {
				response = httpclient.execute(httpPost);
				System.out.println("************ Response is " + response.toString());
				int httpStatus = response.getStatusLine().getStatusCode();
				if (httpStatus == HttpStatus.SC_OK) {
					System.out.println("status is success");
					localStatus = success;
				} else {
					System.out.println("status is error");
					localStatus = error;
				}
			} catch (Exception e) {
				System.out.println("status is serror");
				localStatus = error;
			}

		return localStatus;
	}

	@Override
	protected void onPostExecute(Object result) {
		System.out.println("result in onPostExecute  " + result.toString());
		if(result.equals(success)){
			this.responseObject.didReceiveData(result);
		} else{
			this.responseObject.didReceiveError("Error in booking table", 404);
		}
	}

}