package com.timesheet.presentation.mb;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LocaleMB {

	private Locale locale;
	private String lang;
	private String dir;
	private boolean orientationRTL;

	@PostConstruct
	public void init() {
		setLanguage("ar");
		setLang("ar");
	}
	
	public Locale getLocale() {
		return locale;
	}
	
	public void changeLang(){
		setLanguage(getLang());
	}

	public String getDir() {
		dir = locale.getLanguage().equalsIgnoreCase("ar") ? "RTL" : "LTR";
		return dir;
	}

	public String getLanguage() {
		return locale.getLanguage();
	}

	public void setLanguage(String language) {
		//locale = new Locale(language);
		locale = new Locale(language,Locale.ROOT.getLanguage());

		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);

	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public boolean isOrientationRTL() {
		orientationRTL = locale.getLanguage().equalsIgnoreCase("ar");
		return orientationRTL;
	}

	public void setOrientationRTL(boolean orientationRTL) {
		this.orientationRTL = orientationRTL;
	}


	public String getLang() {
		return lang;
	}


	public void setLang(String lang) {
		this.lang = lang;
	}


}
