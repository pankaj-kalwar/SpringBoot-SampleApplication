CREATE TABLE USER (  
  username VARCHAR(50) NOT NULL PRIMARY KEY,  
  email VARCHAR(50),  
  PASSWORD VARCHAR(500),  
  activated BOOLEAN DEFAULT FALSE,  
  activationkey VARCHAR(50) DEFAULT NULL,  
  resetpasswordkey VARCHAR(50) DEFAULT NULL  
 );
 
 CREATE TABLE authority (  
  NAME VARCHAR(50) NOT NULL PRIMARY KEY  
 );
 
 CREATE TABLE user_authority (  
   username VARCHAR(50) NOT NULL,  
   authority VARCHAR(50) NOT NULL,  
   FOREIGN KEY (username) REFERENCES USER (username),  
   FOREIGN KEY (authority) REFERENCES authority (NAME),  
   UNIQUE INDEX user_authority_idx_1 (username, authority)  
 );

create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);

create table oauth_client_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

create table oauth_access_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication LONGVARBINARY,
  refresh_token VARCHAR(256)
);

create table oauth_refresh_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication LONGVARBINARY
);

create table oauth_code (
  code VARCHAR(256), authentication LONGVARBINARY
);