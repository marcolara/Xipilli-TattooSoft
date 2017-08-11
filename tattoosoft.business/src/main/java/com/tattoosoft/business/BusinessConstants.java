/***
 **  @(#) ecomzero.com
 **
 **  Copyright (c) 2010 ecomzero, LLC.  All Rights Reserved.
 **
 **
 **  THIS COMPUTER SOFTWARE IS THE PROPERTY OF ecomzero, LLC.
 **
 **  Permission is granted to use this software as specified by the ecomzero
 **  COMMERCIAL LICENSE AGREEMENT.  You may use this software only for
 **  commercial purposes, as specified in the details of the license.
 **  ecomzero SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY THE LICENSEE
 **  AS A RESULT OF USING OR MODIFYING THIS SOFTWARE IN ANY WAY.
 **
 **  YOU MAY NOT DISTRIBUTE ANY SOURCE CODE OR OBJECT CODE FROM THE
 **  ecomzero.com TOOLKIT AT ANY TIME. VIOLATORS WILL BE PROSECUTED TO THE
 **  FULLEST EXTENT OF UNITED STATES LAW.
 **
 **  @version 1.0
 **  @author Copyright (c) 2010 ecomzero, LLC. All Rights Reserved.
 **
 **/
package com.tattoosoft.business;

import org.springframework.validation.Validator;


/**
 *
 */
public interface BusinessConstants {

    //state
    public static final boolean IS_DEBUG = true;

    //type constants
    public static final String FORM_TYPE_SUFFIX = "Form";
    public static final String CLASS_VALIDATOR_TYPE_SUFFIX = Validator.class.getSimpleName();

    // misc
    public static final String UTF_8 = "UTF-8";

    // date formats
    public static final String DB_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATETIME_LONG_FORMAT = "EEEEEEEEE, MMMM dd yyyy HH:mm:ss z";
    public static final String DATETIME_MEDIUM_FORMAT = "EE, MM/dd/yyyy HH:mm";
    public static final String DATETIMESHORT_FORMAT = "MM/dd/yyyy HH:mm";
    public static final String DATE_SHORT_FORMAT = "MM/dd/yyyy";

    // user constants
    public static final String USERNAME_DELIMITER_REGEX = "\\:";
}