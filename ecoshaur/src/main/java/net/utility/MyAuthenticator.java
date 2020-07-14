package net.utility;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {
  //메일서버(POP3/SMTP)에서
  //인증받은 계정+비번
  
  private PasswordAuthentication pa;

  public MyAuthenticator() {
    pa=new PasswordAuthentication("soldesk@pretyimo.cafe24.com", "soldesk6901");
  }

  @Override
  protected PasswordAuthentication getPasswordAuthentication() {
    return pa;
  }  
  
}//class end
