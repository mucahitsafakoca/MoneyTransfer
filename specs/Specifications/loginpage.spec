LoginPage Scenarios
=====================

LoginHappyPath
----------------
Tags:Smoke-Regression
* Verify that catchylabs login page is open
* Fill the username input area with the e-mail address
* Fill the password input area with the correct password
* Click login button on login page
* Verify that open money transfer button is visible

Login with incorrect e-mail address
---------------------------------
Tags:Smoke
* Verify that catchylabs login page is open
* Fill the username input area with a wrong e-mail address
* Fill the password input area with the correct password
* Click login button on login page
* Verify that an error message is displayed after entering wrong credentials

Login with incorrect password
-----------------------------
Tags:Smoke-Regression
* Verify that catchylabs login page is open
* Fill the username input area with the e-mail address
* Fill the password input area with a wrong password
* Click login button on login page
* Verify that an error message is displayed after entering wrong credentials

Login with incorrect password and incorrect email address
-----------------------------
Tags:Regression
* Verify that catchylabs login page is open
* Fill the username input area with a wrong e-mail address
* Fill the password input area with a wrong password
* Click login button on login page
* Verify that an error message is displayed after entering wrong credentials

