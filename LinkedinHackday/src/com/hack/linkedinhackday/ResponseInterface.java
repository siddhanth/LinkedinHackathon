/* ############################################################################
* Copyright 2013 Hewlett-Packard Co. All Rights Reserved.
* An unpublished and CONFIDENTIAL work. Reproduction,
* adaptation, or translation without prior written permission
* is prohibited except as allowed under the copyright laws.
*-----------------------------------------------------------------------------
* Project: AL Deal-Maker
* Module: Common
* Source: ResponseInterface.java
* Author: HP
* Organization: HP BAS India
* Revision: 0.1
* Date: 08-22-2013
* Contents:
*-----------------------------------------------------------------------------
* Revision History:
*     who                                  when                                    what
*  	Roopa Shree							08-22-2013								Initial functionality
* #############################################################################
*/
package com.hack.linkedinhackday;

public interface ResponseInterface {
	
	public void didReceiveData(Object data);
	public void didReceiveError(String message, int statusCode);
	
}
