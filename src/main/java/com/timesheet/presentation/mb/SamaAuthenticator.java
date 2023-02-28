package com.timesheet.presentation.mb;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

class SamaAuthenticator
  extends Authenticator
{
  private String SENDER_USERNAME = "";
  private String SENDER_PASSWORD = "";
  
  SamaAuthenticator(String userName, String password)
  {
    this.SENDER_USERNAME = userName;
    this.SENDER_PASSWORD = password;
  }
  
  protected PasswordAuthentication getPasswordAuthentication()
  {
    return new PasswordAuthentication(this.SENDER_USERNAME, this.SENDER_PASSWORD);
  }
}