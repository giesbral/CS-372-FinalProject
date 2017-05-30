/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import static org.hamcrest.CoreMatchers.*;

import org.hamcrest.CoreMatchers;

import junit.framework.TestCase;





/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }
   
   public void testManualTest()
   {
//	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
//	   System.out.println(urlVal.isValid("http://www.amazon.com"));
//	   
//	   //my urls
//	   System.out.println(urlVal.isValid("http://www.google.com"));
//	   
//	   //schemes
//	   //no scheme
//	   System.out.println("no scheme");
//	   System.out.println(urlVal.isValid("www.google.com"));
//	   
//	   //another valid scheme
//	   System.out.println("valid scheme");
//	   System.out.println(urlVal.isValid("ftp://www.google.com"));
//	   
//	   //invalid scheme
//	   System.out.println("Random string scheme");
//	   System.out.println(urlVal.isValid("asdgasdfg://www.google.com"));	//true,  returns true for random string
//	   
//	   //scheme missing char
//	   System.out.println("scheme - start with number");
//	   System.out.println(urlVal.isValid("3htp://www.google.com"));
//	   
//	   System.out.println("scheme - with number");
//	   System.out.println(urlVal.isValid("htt3p://www.google.com"));
//	   
//	   System.out.println("scheme - ://");
//	   System.out.println(urlVal.isValid("://www.google.com"));
//	   
//	   System.out.println("scheme - :/");
//	   System.out.println(urlVal.isValid("http:/www.google.com"));
//	   
//	   System.out.println("scheme - //");
//	   System.out.println(urlVal.isValid("http//www.google.com"));
//	   
//	   System.out.println("scheme - :");
//	   System.out.println(urlVal.isValid("http:www.google.com"));
//	   
//	   //host
//	   //valid host
//	   System.out.println("valid host");
//	   System.out.println(urlVal.isValid("http://www.google.com"));
//	   
//	   //valid numeric host
//	   System.out.println("0.0.0.0");
//	   System.out.println(urlVal.isValid("http://0.0.0.0"));
//	   
//	   //negative numeric host
//	   System.out.println("invalid numeric - negative");
//	   System.out.println(urlVal.isValid("-1.2.3.4"));
//	   
//	   //valid numeric host - max
//	   System.out.println("valid numeric - max");
//	   System.out.println(urlVal.isValid("http://255.255.255.255"));
//	   
//	   //invalid numeric host - exceeds max
//	   System.out.println("invalid numeric - exceeds max (256)");
//	   System.out.println(urlVal.isValid("http://256.256.256.256"));	//bug
//	   
//	   // no host
//	   System.out.println("no host");
//	   System.out.println(urlVal.isValid("http://"));
//	   
//	   //domains - list at https://en.wikipedia.org/wiki/List_of_Internet_top-level_domains
//	   //original top-level domains
//	   System.out.println("top level domains");
//	   System.out.println(urlVal.isValid("http://www.google.com"));
//	   System.out.println(urlVal.isValid("http://www.google.org"));
//	   System.out.println(urlVal.isValid("http://www.google.edu"));
//	   System.out.println(urlVal.isValid("http://www.google.net"));
//	   
//	   //country code top-level domains
//	   System.out.println("Foreign domains");
//	   System.out.println(urlVal.isValid("http://www.google.jp"));	//japan  - bug returned false
//	   System.out.println(urlVal.isValid("http://www.google.au"));	//australia
//	   System.out.println(urlVal.isValid("http://www.google.ca"));	//canada
//	   System.out.println(urlVal.isValid("http://www.google.eu"));	//europe
//	   System.out.println(urlVal.isValid("http://www.google.cn"));	//china
//	   
//	   //ICANN-era generic top-level domains
//	   System.out.println("Various other valid domains");
//	   System.out.println(urlVal.isValid("http://www.google.bike"));
//	   System.out.println(urlVal.isValid("http://www.google.app"));
//	   System.out.println(urlVal.isValid("http://www.google.art"));
//	   System.out.println(urlVal.isValid("http://www.google.cards"));
//	  
//	   //invalid domains
//	   System.out.println("invalid domains");
//	   System.out.println(urlVal.isValid("http://www.google."));
//	   System.out.println(urlVal.isValid("http://www.google.wer"));
//	   System.out.println(urlVal.isValid("http://www.google.1234"));
//	   System.out.println(urlVal.isValid("http://www.google.!!!!"));
//	   
//	   //ports
//	   System.out.println("Valid port - 80");
//	   System.out.println(urlVal.isValid("http://www.google.com:80"));
//	   
//	   System.out.println("Valid port - 0 (min)");
//	   System.out.println(urlVal.isValid("http://www.google.com:0"));
//	   
//	   System.out.println("Valid port - 65535 (max)");
//	   System.out.println(urlVal.isValid("http://www.google.com:65535"));	//bug - returns false
//	   
//	   System.out.println("Invalid port - -1");
//	   System.out.println(urlVal.isValid("http://www.google.com:-1"));
//	   
//	   System.out.println("Invalid port - 65536");
//	   System.out.println(urlVal.isValid("http://www.google.com:65536"));
//	   
//	   System.out.println("Invalid port - none");
//	   System.out.println(urlVal.isValid("http://www.google.com:"));
//	   
//	   System.out.println("Invalid port - letters");
//	   System.out.println(urlVal.isValid("http://www.google.com:abc"));
//	   
//	   //path
//	   System.out.println("Valid path - /path/to/go");
//	   System.out.println(urlVal.isValid("http://www.google.com/path/to/go"));
//	   
//	   System.out.println("Valid path - end with /");
//	   System.out.println(urlVal.isValid("http://www.google.com/path/to/go/"));
//	   
//	   System.out.println("Valid path - no path");
//	   System.out.println(urlVal.isValid("http://www.google.com/"));
//	   
//	   System.out.println("Invalid path - numbers");
//	   System.out.println(urlVal.isValid("http://www.google.com/1/2/3"));
//	   
//	   System.out.println("Invalid path - start with //");
//	   System.out.println(urlVal.isValid("http://www.google.com//path/to/go"));
//	   
//	   System.out.println("Invalid path - // in middle of path");
//	   System.out.println(urlVal.isValid("http://www.google.com/path//to/go"));
//	   
//	   System.out.println("Invalid path - // at end of path");
//	   System.out.println(urlVal.isValid("http://www.google.com/path/to/go//"));
//	   
//	   //query
//	   System.out.println("Valid query - ?key=value");
//	   System.out.println(urlVal.isValid("http://www.google.com/path?key=value"));		//bug - bug with ?
//	   
//	   System.out.println("Valid query - ?abcdefg");
//	   System.out.println(urlVal.isValid("http://www.google.com/path?abcdefg"));
//	   
//	   System.out.println("Valid query - empty");
//	   System.out.println(urlVal.isValid("http://www.google.com/path"));
//	   
//	   System.out.println("Invalid query - key=value (no ? mark)");
//	   System.out.println(urlVal.isValid("http://www.google.com/path/key=value"));	//becomes part of path
//	   
//	   System.out.println("Valid query - ampersand seperator");
//	   System.out.println(urlVal.isValid("http://www.google.com/path?key=value&bob=bill"));
//	   
//	   System.out.println("Valid query - semi colon seperator");
//	   System.out.println(urlVal.isValid("http://www.google.com/path?key=value;bob=bill"));
//	   
//	   //test invalid chars?
   }
   
   @Rule
   public ErrorCollector collector = new ErrorCollector();
   
   @Test
   public void testYourFirstPartition()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   StringBuffer urlBuffer = new StringBuffer();
	   boolean expected = true;
	   
	   collector.addError(new Throwable("The actual is not equal to expected"));
	   
	   for (int i = 0; i < scheme.length; ++i)
	   {   		   
		   for (int j = 0; j < authority.length; ++j)
		   {
			   for (int k = 0; k < path.length; ++k)
			   {
				   urlBuffer.append(scheme[i].item);
				   expected &= scheme[i].valid;
						   
				   urlBuffer.append(authority[j].item);
				   expected &= authority[j].valid;
				   
				   urlBuffer.append(path[k].item);
				   expected &= path[k].valid;
				   
				   String urlString = urlBuffer.toString();
				   boolean actual = urlVal.isValid(urlString);
				   
				   System.out.println(urlString);		   
				   							
				   collector.checkThat(actual, CoreMatchers.equalTo(expected));
				   
//				   if (assertTrue(expected, actual))
//				   {
//					   
//				   };			   				   
			   }
		   }
	   }   
   }
   
   public void testYourSecondPartition(){
	   
   }
   
   
   public void testIsValid()
   {
	   System.out.println(scheme.length);
   }
   
   public void testAnyOtherUnitTest()
   {
	   
   }
   
   private boolean assertTrue(boolean expected, boolean actual)
   {
	   if (expected == actual)
	   {
		   return true;
	   }
	   else
	   {
		   return false;
	   }
   }
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   
   ResultPair[] scheme = {new ResultPair("https://", false),
		   					new ResultPair("http://", true)};
   
   ResultPair[] authority = {new ResultPair("polygon.com", true)};
   
   ResultPair[] path = {new ResultPair("/file", true)};
   
   Object[] urlPartitions = {scheme, authority, path};
   
}
