Steps To Execute the URLs TO Test
--------------------------------------

For Grant Type = Authorization Code
---------------------------------------


Step 1 :
------------------ 
http://localhost:8085/oauth/authorize?response_type=code&client_id=my-trusted-client4&redirect_uri=http://localhost:8085/test&scope=read&state=97538


================================

Step 2: By Using Postman
-----------------------------

localhost:8085/oauth/token?grant_type=authorization_code&client_id=my-trusted-client4&redirect_uri=http://localhost:8085/test&code=bd8eu5&scope=read

on authorization tab -> select basic auth -> username = client_id & password = secretkey in ur code

in response u'll get acces token and refresh token
---------------------
{"access_token":"9b3b3e5d-1f09-47fa-adf9-bffddcc71d23","token_type":"bearer","refresh_token":"495f8a6e-802e-4692-8f5f-7bf041d56eb6","expires_in":59,"scope":"read"}

=======================================

step 3 : check ur url
--------------------------

http://localhost:8085/test

or

on curl
------

curl http://localhost:8085/test -H "Authorization:Bearer 9b3b3e5d-1f09-47fa-adf9-bffddcc71d23"

curl

curl http://localhost:8085/test -H Authorization:Bearer 57464c3f-fcca-4a86-8f30-e179c2d84109



=======================================

For Grant Type = Password
---------------------------

Step 1 :
-------
By Using postman
	
	http://localhost:8085/oauth/token?username=admin&password=admin123&grant_type=password
	
	On Authorization tab , select "Basic Auth" and give credentials 
	UserName = <client_id>
	Password = <secret>
	
	
	Output:
	--------
	
	{"access_token":"82908f6e-56f4-44e0-9c93-5a9fe0521b9b","token_type":"bearer","refresh_token":"c3497c27-4ac2-4e1e-9e9b-870fec3e4550","expires_in":199,"scope":"read trust write"}
	
Step 2 : by Using refresh token
--------------
By Using Postman - Use refresh token generated using Step 1

	http://localhost:8085/oauth/token?grant_type=refresh_token&refresh_token=c3497c27-4ac2-4e1e-9e9b-870fec3e4550
	
	On Authorization tab , select "Basic Auth" and give credentials 
	UserName = <client_id>
	Password = <secret>
	
	output:
	--------------
	{"access_token":"680f6cfe-1e52-40ee-bff6-988de0391181","token_type":"bearer","refresh_token":"c3497c27-4ac2-4e1e-9e9b-870fec3e4550","expires_in":199,"scope":"read trust write"}
		
	
Step 3 : By Using Access token
-------------------

By Using Postman - Use access token generated on Step 2

	http://localhost:8085/test
	
	On Authorization tab , select "No Auth"
	
	On Headers Tab, add key and value 
	
	key = Authorization
	value = Bearer <Access_Token> e.g. Bearer 680f6cfe-1e52-40ee-bff6-988de0391181