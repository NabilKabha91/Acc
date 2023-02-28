/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timesheet.presentation.mb;

import java.io.Serializable;
import java.security.GeneralSecurityException;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.etech.common.mail.bean.MailBean;
import com.timesheet.datamodel.Session;
import com.timesheet.datamodel.User;
import com.timesheet.presentation.repository.SessionRepo;
import com.timesheet.presentation.repository.UserRepo;
import com.timesheet.presentation.web.GlobalConfigProperties;
import com.timesheet.utils.JsfUtils;

/**
 *
 * 
 */
@ManagedBean
@ViewScoped
public class LoginMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1666421942307307078L;
	private String userName;
	private String password;
	@ManagedProperty("#{userRepo}")
	private UserRepo userRepo;
	@ManagedProperty("#{sessionRepo}")
	private SessionRepo sessionRepo;
	private boolean foundEmail;
	private String userCode;
	private String email;
	String code = null;
	private String newPassword;

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/pages/login.xhtml?faces-redirect=true";
	}

	public String login() {
		User user = userRepo.findByUserNameAndPassword(userName, password);
		if (null == user) {
			JsfUtils.addErrorMessage("اسم المستخدم او كلمة المرور غير صحصيحة");
			return null;
		}
		HttpSession session = ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false));
		session.setAttribute("currentUser", user);
		session.setAttribute("currentOffice", user.getOffice());

		session.setAttribute("sessionRepo", sessionRepo);
		Session session2 = sessionRepo.findByUser(user);
		
		int noOfDays = 1; //i.e two weeks
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(user.getExpire());            
		calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
		Date date = calendar.getTime();
		if (new Date().after(date)) {
			JsfUtils.addErrorMessage("انتهت فترة الإشتراك");
			return null;
		}
		
		if (session2 == null)
			session2 = new Session();
		session2.setUser(user);
		session2.setSessionId(session.getId());
		session2.setDate(new Date());
		session2 = sessionRepo.save(session2);
		if (null != user.getPassworExpire()) {
			Date date1 = new Date();
			if (date1.after(user.getPassworExpire())) {
				//return "/pages/changePassword.xhtml";
			}
		}
		
		return "/pages/timeSheet.xhtml?faces-redirect=true";

	}

	public void forgetPass() throws Exception {
		User user = userRepo.findByEmail(email);

		if (null != user) {
			foundEmail = true;
			MailSender m = MailSender.getInstance();
			MailBean mailBM = new MailBean();
			mailBM.setSenderMail("systemasa2018@gmail.com");
			mailBM.setSenderPassword("48109806");

			try {
				code = PasswordUtil.generateCurrentNumberString(PasswordUtil.generateBase32Secret());
			} catch (GeneralSecurityException e) {
				e.printStackTrace();
				return;

			}
			mailBM.setToMails(email);
			mailBM.setSubject("رمزالتحقق‚   Time Sheet");
			String html = GlobalConfigProperties.getProperty("AUTH_EMAIL_HTML");
			html = html.replace("${fullName}", user.getNameAr());
			html = html.replace("${code}", code);

			mailBM.setBody(html);
			m.sendMailHtml(mailBM);
		} else {
			JsfUtils.addErrorMessage(" لايوجد حساب مرتبط بهذا الإيميل");
		}
	}
	
	public String validateCode() {

		if (code.equalsIgnoreCase(userCode)) {
			User user = userRepo.findByEmail(email);
			user.setPassworExpire(new Date());
			userRepo.save(user);
			userName = user.getUserName();
			password = user.getPassword();
			return login();
		} else {
			JsfUtils.addErrorMessage("رمز التحقق غير صحيح");
			return null;

		}
	}
	
	public String changePassword() {
		try {
			User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("currentUser");
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, 3);
			user.setPassworExpire(c.getTime());
			user.setPassword(newPassword);
			userRepo.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return "/pages/timeSheet.xhtml?faces-redirect=true";
	}
	
	public void redirectToCompanyAddition() {
		JsfUtils.redirect("/pages/company/add-company.html");
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userRepo
	 */
	public UserRepo getUserRepo() {
		return userRepo;
	}

	/**
	 * @param userRepo
	 *            the userRepo to set
	 */
	public void setUserRepo(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public SessionRepo getSessionRepo() {
		return sessionRepo;
	}

	public void setSessionRepo(SessionRepo sessionRepo) {
		this.sessionRepo = sessionRepo;
	}

	/**
	 * @return the foundEmail
	 */
	public boolean isFoundEmail() {
		return foundEmail;
	}

	/**
	 * @param foundEmail the foundEmail to set
	 */
	public void setFoundEmail(boolean foundEmail) {
		this.foundEmail = foundEmail;
	}

	/**
	 * @return the userCode
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * @param userCode the userCode to set
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
