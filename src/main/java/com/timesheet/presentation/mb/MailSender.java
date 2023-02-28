package com.timesheet.presentation.mb;


import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.etech.common.exception.CommonException;
import com.etech.common.mail.bean.MailBean;
import com.etech.common.reader.BundelReader;
import com.etech.common.util.EncodeingUtilities;
import com.etech.common.util.StringUtilities;


public class MailSender
{
	
  private static MailSender instance = null;
  private ResourceBundle commonsBundle;
  private ResourceBundle mailsConfigBundle;
  private Properties props;
  private MimeMessage mimeMessage;
  private Session mailSession;
  private InternetAddress senderInternetAddress;
  private Multipart multipart;
  private MimeBodyPart mimeBody;
  private MimeBodyPart mimeAttach;
  private DataSource fileDataSource;
  private String MAIL_SMTP_HOST;
  private String MAIL_DEBUG;
  private String MAIL_SMTP_PORT;
  private String MAIL_SMTP_AUTH;
  private String MAIL_MIME_CHARSET;
  private String MAIL_MIME_HTML_CHARSET;
  private String NICK_NAME_CHARSET;
  private String SUBJECT_CHARSET;
  private String BODY_CHARSET;
  private String SYSTEM_FILE_ENCODING;
  private String MAIL_SMTP_STARTTLS_ENABLE;
  private String MAIL_STMP_QUITWAIT;
  private String MAIL_STMP_SENDPARTIAL;
  private String MAIL_SMTP_SOCKETFACTORY_CLASS;
  
  public MailSender()
  {
    this.commonsBundle = BundelReader.loadResourceBundle("common-config", "en");
    String mailsConfig = this.commonsBundle.getString("MAILS_CONFIG");
    this.mailsConfigBundle = BundelReader.loadResourceBundle(mailsConfig, "en");
    
    this.MAIL_SMTP_HOST = this.mailsConfigBundle.getString("MAIL_SMTP_HOST");
    this.MAIL_DEBUG = this.mailsConfigBundle.getString("MAIL_DEBUG");
    this.MAIL_SMTP_PORT = this.mailsConfigBundle.getString("MAIL_SMTP_PORT");
    this.MAIL_SMTP_AUTH = this.mailsConfigBundle.getString("MAIL_SMTP_AUTH");
    this.MAIL_MIME_CHARSET = this.mailsConfigBundle.getString("MAIL_MIME_CHARSET");
    this.MAIL_MIME_HTML_CHARSET = this.mailsConfigBundle.getString("MAIL_MIME_HTML_CHARSET");
    this.NICK_NAME_CHARSET = this.mailsConfigBundle.getString("NICK_NAME_CHARSET");
    this.SUBJECT_CHARSET = this.mailsConfigBundle.getString("SUBJECT_CHARSET");
    this.BODY_CHARSET = this.mailsConfigBundle.getString("BODY_CHARSET");
    this.SYSTEM_FILE_ENCODING = this.mailsConfigBundle.getString("SYSTEM_FILE_ENCODING");
    
    this.MAIL_SMTP_STARTTLS_ENABLE = this.mailsConfigBundle.getString("MAIL_SMTP_STARTTLS_ENABLE");
    this.MAIL_STMP_QUITWAIT = this.mailsConfigBundle.getString("MAIL_STMP_QUITWAIT");
    this.MAIL_STMP_SENDPARTIAL = this.mailsConfigBundle.getString("MAIL_STMP_SENDPARTIAL");
    this.MAIL_SMTP_SOCKETFACTORY_CLASS = this.mailsConfigBundle.getString("MAIL_SMTP_SOCKETFACTORY_CLASS");
    
    this.props = new Properties();
    this.props.put("mail.smtp.host", this.MAIL_SMTP_HOST);
    this.props.put("mail.smtp.auth", this.MAIL_SMTP_AUTH);
    this.props.put("mail.debug", this.MAIL_DEBUG);
    this.props.put("mail.mime.charset", this.MAIL_MIME_CHARSET);
    this.props.put("mail.mime.html.charset", this.MAIL_MIME_HTML_CHARSET);

    if (StringUtilities.isNotEmpty(this.SYSTEM_FILE_ENCODING)) {
      System.setProperty("file.encoding", this.SYSTEM_FILE_ENCODING);
    }
    this.props.put("mail.smtp.starttls.enable", this.MAIL_SMTP_STARTTLS_ENABLE);
    this.props.put("mail.smtp.quitwait", this.MAIL_STMP_QUITWAIT);
    this.props.put("mail.smtp.sendpartial", this.MAIL_STMP_SENDPARTIAL);
    if (StringUtilities.isNotEmpty(this.MAIL_SMTP_PORT)) {
      this.props.put("mail.smtp.port", this.MAIL_SMTP_PORT);
      props.put("mail.smtp.socketFactory.port", this.MAIL_SMTP_PORT);
    }
    if (StringUtilities.isNotEmpty(this.MAIL_SMTP_SOCKETFACTORY_CLASS)) {
      this.props.put("mail.smtp.socketFactory.class", this.MAIL_SMTP_SOCKETFACTORY_CLASS);
    }
  }
  
  public static MailSender getInstance()
  {
    if (instance == null) {
      instance = new MailSender();
    }
    return instance;
  }
  
  public void sendMail(MailBean mailBean)
    throws Exception
  {
    try
    {
      this.mailSession = Session.getDefaultInstance(this.props, new SamaAuthenticator(mailBean.getSenderMail(), mailBean.getSenderPassword()));
      
      this.mimeMessage = new MimeMessage(this.mailSession);
      this.multipart = new MimeMultipart();
      
      this.senderInternetAddress = new InternetAddress(mailBean.getSenderMail(), mailBean.getSenderNickName());
      this.mimeMessage.setFrom(this.senderInternetAddress);
      this.mimeMessage.addRecipients(RecipientType.TO, mailBean.getToMails());
      this.mimeMessage.addRecipients(RecipientType.TO, populateMails(mailBean.getToMailsList()));
      
      this.mimeMessage.addRecipients(RecipientType.CC, mailBean.getCcMails());
      this.mimeMessage.addRecipients(RecipientType.CC, populateMails(mailBean.getCcMailsList()));
      
      this.mimeMessage.addRecipients(RecipientType.BCC, mailBean.getBccMails());
      this.mimeMessage.addRecipients(RecipientType.BCC, populateMails(mailBean.getBccMailsList()));
      
      this.mimeMessage.setSubject(mailBean.getSubject());
      
      String body = new String(mailBean.getBody());
      this.mimeBody = new MimeBodyPart();
      String contentType = "text/plain;";
      if (StringUtilities.isNotEmpty(this.MAIL_MIME_CHARSET)) {
        contentType = contentType + " charset=" + this.MAIL_MIME_CHARSET;
      }
      this.mimeBody.setDataHandler(new DataHandler(body, contentType));
      this.multipart.addBodyPart(this.mimeBody);
      
      attachFiles(mailBean.getAttachmentFiles());
      
      this.mimeMessage.setContent(this.multipart);
      
      Transport.send(this.mimeMessage);
    }
    catch (UnsupportedEncodingException e)
    {
      throw e;
    }
    catch (MessagingException e)
    {
      throw e;
    }
    catch (IllegalStateException e)
    {
      throw e;
    }
  }
  
  public void sendMailHtml(MailBean mailBean)
    throws Exception
  {
    try
    {
      this.mailSession = Session.getDefaultInstance(this.props, new SamaAuthenticator(mailBean.getSenderMail(), mailBean.getSenderPassword()));
      
      this.mimeMessage = new MimeMessage(this.mailSession);
      this.multipart = new MimeMultipart();
      
      this.senderInternetAddress = new InternetAddress(mailBean.getSenderMail(), mailBean.getSenderNickName());
      this.mimeMessage.setFrom(this.senderInternetAddress);
      
      this.mimeMessage.addRecipients(RecipientType.TO, mailBean.getToMails());
      this.mimeMessage.addRecipients(RecipientType.TO, populateMails(mailBean.getToMailsList()));
      
      this.mimeMessage.addRecipients(RecipientType.CC, mailBean.getCcMails());
      this.mimeMessage.addRecipients(RecipientType.CC, populateMails(mailBean.getCcMailsList()));
      
      this.mimeMessage.addRecipients(RecipientType.BCC, mailBean.getBccMails());
      this.mimeMessage.addRecipients(RecipientType.BCC, populateMails(mailBean.getBccMailsList()));
      
      this.mimeMessage.setSubject(mailBean.getSubject());
      
      String body = new String(mailBean.getBody());
      this.mimeBody = new MimeBodyPart();
      String contentType = "text/html;";
      if (StringUtilities.isNotEmpty(this.MAIL_MIME_CHARSET)) {
        contentType = contentType + " charset=" + this.MAIL_MIME_HTML_CHARSET;
      }
      this.mimeBody.setDataHandler(new DataHandler(body, contentType));
      this.multipart.addBodyPart(this.mimeBody);
      
      attachFiles(mailBean.getAttachmentFiles());
      
      this.mimeMessage.setContent(this.multipart);
      
      Transport.send(this.mimeMessage);
    }
    catch (UnsupportedEncodingException e)
    {
      throw e;
    }
    catch (MessagingException e)
    {
      throw e;
    }
    catch (IllegalStateException e)
    {
      throw e;
    }
  }
  
  private void attachFiles(List attachmentFiles)
    throws MessagingException
  {
    for (int i = 0; i < attachmentFiles.size(); i++)
    {
      this.fileDataSource = new FileDataSource(String.valueOf(attachmentFiles.get(i)));
      this.mimeAttach = new MimeBodyPart();
      this.mimeAttach.setDataHandler(new DataHandler(this.fileDataSource));
      this.mimeAttach.setFileName(this.fileDataSource.getName());
      this.multipart.addBodyPart(this.mimeAttach);
    }
  }
  
  private InternetAddress[] populateMails(List mailsList)
    throws AddressException
  {
    InternetAddress[] toList = new InternetAddress[mailsList.size()];
    for (int i = 0; i < mailsList.size(); i++)
    {
      InternetAddress toAddress = new InternetAddress(String.valueOf(mailsList.get(i)));
      toList[i] = toAddress;
    }
    return toList;
  }
  
  public MailBean populateMailFromMailsConfig(String mailKey)
    throws CommonException
  {
    MailBean mailBean = new MailBean();
    
    mailBean.setSenderMail(this.mailsConfigBundle.getString(mailKey + ".SENDER_MAIL"));
    mailBean.setSenderPassword(EncodeingUtilities.desDecrypt(this.mailsConfigBundle.getString(mailKey + ".SENDER_PASSWORD")));
    
    mailBean.setToMails(this.mailsConfigBundle.getString(mailKey + ".TO_MAILS"));
    mailBean.setCcMails(this.mailsConfigBundle.getString(mailKey + ".CC_MAILS"));
    mailBean.setBccMails(this.mailsConfigBundle.getString(mailKey + ".BCC_MAILS"));
    if (StringUtilities.isNotEmpty(this.NICK_NAME_CHARSET)) {
      mailBean.setSenderNickName(EncodeingUtilities.convertCharset(this.mailsConfigBundle.getString(mailKey + ".SENDER_NICK_NAME"), this.NICK_NAME_CHARSET));
    } else {
      mailBean.setSenderNickName(this.mailsConfigBundle.getString(mailKey + ".SENDER_NICK_NAME"));
    }
    if (StringUtilities.isNotEmpty(this.SUBJECT_CHARSET)) {
      mailBean.setSubject(EncodeingUtilities.convertCharset(this.mailsConfigBundle.getString(mailKey + ".MAIL_SUBJECT"), this.SUBJECT_CHARSET));
    } else {
      mailBean.setSubject(this.mailsConfigBundle.getString(mailKey + ".MAIL_SUBJECT"));
    }
    if (StringUtilities.isNotEmpty(this.BODY_CHARSET)) {
      mailBean.setBody(EncodeingUtilities.convertCharset(this.mailsConfigBundle.getString(mailKey + ".MAIL_BODY"), this.BODY_CHARSET));
    } else {
      mailBean.setBody(this.mailsConfigBundle.getString(mailKey + ".MAIL_BODY"));
    }
    return mailBean;
  }
  
  public static void main(String[] args)
  {
    try
    {
      MailSender mailServer = new MailSender();
      MailBean mailBean = mailServer.populateMailFromMailsConfig("ZAGEL");
      
      mailServer.sendMail(mailBean);
    }
    catch (Exception e)
    {
    }
  }
  
  public void setNICK_NAME_CHARSET(String nICK_NAME_CHARSET)
  {
    this.NICK_NAME_CHARSET = nICK_NAME_CHARSET;
  }
  
  public String getNICK_NAME_CHARSET()
  {
    return this.NICK_NAME_CHARSET;
  }
  
  public void setSUBJECT_CHARSET(String sUBJECT_CHARSET)
  {
    this.SUBJECT_CHARSET = sUBJECT_CHARSET;
  }
  
  public String getSUBJECT_CHARSET()
  {
    return this.SUBJECT_CHARSET;
  }
  
  public void setBODY_CHARSET(String bODY_CHARSET)
  {
    this.BODY_CHARSET = bODY_CHARSET;
  }
  
  public String getBODY_CHARSET()
  {
    return this.BODY_CHARSET;
  }
}
