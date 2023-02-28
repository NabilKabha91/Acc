package com.timesheet.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.web.context.annotation.SessionScope;

import com.timesheet.datamodel.Office;
import com.timesheet.datamodel.User;
import com.timesheet.presentation.service.CompanyService;
import com.timesheet.presentation.web.GlobalConfigProperties;
import com.timesheet.datamodel.Company;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.etech.faces.util.SessionUtilities;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@ManagedBean
@SessionScope
public class Utils implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -98052547802680715L;

	private static CompanyService companyService;
	
	public static Map<String, Object> getOptions() {
		int width = 0;
		int height = 0;
		try {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("surveyMB", null);
			width = Integer.parseInt(JsfUtils.getRequestParameterMap("width"));
			height = Integer.parseInt(JsfUtils.getRequestParameterMap("height"));
		} catch (Exception e) {
			width = 700;
			height = 700;
		}
		Map<String, Object> options = new HashMap<>();
		options.put("resizable", true);
		options.put("modal", true);
		options.put("closable", false);
		options.put("maximizable", true);
		options.put("maximizable", true);
		options.put("width", width - 200);
		options.put("dir", "RTL");
		options.put("height", height - 50);
		options.put("contentWidth", width - 235);
		options.put("contentHeight", height - 60);
		return options;

	}

	public static Object[] createArray(int size) {
		return new Object[size];
	}

	public static String uploud(FileUploadEvent event, String path) {
		UploadedFile file = event.getFile();
		String fileName = System.currentTimeMillis() + FilenameUtils.getName(event.getFile().getFileName());
		String fileType = FilenameUtils.getName(event.getFile().getContentType());
		try {
			if (prepareFile(file.getInputstream(), fileName, fileType, path)) {
				return fileName;
			} else {
				return "";
			}

		} catch (IOException e) {
			return "";

		}
	}
	
	public static String uploud1( String path) {
	
		File catalinaBase = new File(System.getProperty("catalina.base")).getAbsoluteFile();

		File rootDir = new File(catalinaBase,
				"webapps" + File.separator + Utils.getValueFromProperties(Constants.FOLDER_PATH));
		File subDir = new File(rootDir.getPath() + File.separator +  File.separator );
		 File uploudFile = new File(subDir.getPath() + File.separator + "Image.png");
		 path = uploudFile.getAbsolutePath();

		return "";
	}
	public static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
				
		Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);

		hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hintMap.put(EncodeHintType.MARGIN, 1); /* default = 4 */
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height,hintMap);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

       
    }
	
	public static String getReportPath() {
		return getValueFromProperties(Constants.FOLDER_PATH);

	}
	public static String getValueFromProperties(String key) {
		try {
			return GlobalConfigProperties.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}
	
	public static String uploudFileWithOrginalName(FileUploadEvent event, String folder) {
		UploadedFile file = event.getFile();
		
		String fileName = FilenameUtils.getName(event.getFile().getFileName());
	
      String fileType = FilenameUtils.getName(event.getFile().getContentType());
	
		
		
		try {
			if (prepareFile(file.getInputstream(), fileName, fileType, folder)) {

				return fileName;

			} else {
				return "";
			}
		} catch (IOException e) {
			return "";

		}
	}

	public static boolean prepareFile(InputStream inputStream2, String fileName, String fileType, String docRef) {

		try {

			File catalinaBase = new File(System.getProperty("catalina.base")).getAbsoluteFile();
			File rootDir = new File(catalinaBase,
					"webapps/" + GlobalConfigProperties.getProperty(Constants.FOLDER_PATH));

			rootDir.mkdirs();
			File subDir = new File(rootDir.getPath() + File.separator + docRef);
			if (!subDir.exists()) {
				subDir.mkdirs();
			}
			File uploudFile = new File(subDir.getPath() + File.separator + fileName);
			uploudFile.createNewFile();
			OutputStream outputStream = new FileOutputStream(uploudFile);
			byte[] buffer = new byte[1024];
			int length = 0;
			while ((length = inputStream2.read(buffer)) != -1) {
				outputStream.write(buffer, 0, length);
			}
			outputStream.flush();
			outputStream.close();
			inputStream2.close();
		//	JsfUtils.addSuccessMessage(MessageBundle.getMsg("success.uploud"));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean renameFile(String oldFileName, String newFileName, String folderIndex, String docRef) {

		File catalinaBase = new File(System.getProperty("catalina.base")).getAbsoluteFile();
		File rootDir = new File(catalinaBase, "webapps/reports");
		// rootDir.mkdirs();
		File oldfile = new File(rootDir.getPath() + File.separator + folderIndex + File.separator + docRef
				+ File.separator + oldFileName);
		File newfile = new File(rootDir.getPath() + File.separator + folderIndex + File.separator + docRef
				+ File.separator + newFileName);

		if (oldfile.renameTo(newfile)) {
			System.out.println("Rename succesful");
			return true;
		} else {
			System.out.println("Rename failed");
			return false;

		}
	}

	public static void deleteFromIO(String folderIndex, String reportName, String fileName) {
		/*
		 * ServletContext servletContext = (ServletContext)
		 * FacesContext.getCurrentInstance().getExternalContext() .getContext();
		 * String path = servletContext.getRealPath("/"); File filePath = new
		 * File(path + "\\resources\\reports\\" + folderIndex + File.separator +
		 * reportName + File.separator + fileName); filePath.delete();
		 */
	}

	public static String convertTime(Date time) {
		if (null == time) {
			return "";
		}

		Format format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(time);
	}

	public static Date convertStringTime(String timeString) {
		if (StringUtils.isEmpty(timeString)) {
			return null;
		}
		try {
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			date = format.parse(timeString);
			return date;
		} catch (ParseException ex) {
			ex.printStackTrace();
			return new Date();
		}

	}

	public static void setCookie(String name, String value, int expiry) {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		Cookie cookie = null;

		Cookie[] userCookies = request.getCookies();
		if (userCookies != null && userCookies.length > 0) {
			for (int i = 0; i < userCookies.length; i++) {
				if (userCookies[i].getName().equals(name)) {
					cookie = userCookies[i];
					break;
				}
			}
		}

		if (cookie != null) {
			cookie.setValue(value);
		} else {
			cookie = new Cookie(name, value);
			cookie.setPath(request.getContextPath());
		}

		cookie.setMaxAge(expiry);

		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		response.addCookie(cookie);
	}

	public static Cookie getCookie(String name) {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		Cookie cookie = null;

		Cookie[] userCookies = request.getCookies();
		if (userCookies != null && userCookies.length > 0) {
			for (int i = 0; i < userCookies.length; i++) {
				if (userCookies[i].getName().equals(name)) {
					cookie = userCookies[i];
					return cookie;
				}
			}
		}
		return null;
	}

	public static String getMsg(String key) {
		if (key != null & !StringUtils.isEmpty(key.trim())) {
			FacesContext context = FacesContext.getCurrentInstance();
			String bundleKey = "#{msg['key']}".replace("key", key);
			String msg = context.getApplication().evaluateExpressionGet(context, bundleKey, String.class);
			if (msg != null) {
				return msg;
			}
		}
		return "";
	}

	public static Locale getLocale() {

		return FacesContext.getCurrentInstance().getViewRoot().getLocale();

	}

	public static boolean isArabic() {
		return getLocale().getLanguage().equals("ar");

	}

	public static String getHost() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		return req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort();
	}

	public static String getAppNampe() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		return req.getContextPath();
	}

	public static User getCurrentUser() {
		User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("currentUser");
		return user;
	}
	
	public static Company getCurrentCompany() {
		Company company = (Company) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("selectCompany");
		return company;
	}
	

	public static Office getCurrentOffice() {
		Office office = (Office) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("currentOffice");
		return office;
	}
	
	public static void setCurrentUser(User user) {
		if (user.getId().equals(getCurrentUser().getId())) {
		HttpSession session = ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false));
		session.setAttribute("currentUser", user);
		}
		
	}

	public static void setCurrentOffice(Office office) {
		if (office.getId().equals(Utils.getCurrentOffice().getId())) {
		HttpSession session = ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false));
		session.setAttribute("currentOffice", office);
		}
		
	}
	public static String getURL(String url) {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String uri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/ACC-"
				+ Utils.getVersion() + "/pages/" + url;
		return uri;
	}

	public static String getVersion() {
		try {
			return GlobalConfigProperties.getProperty("version");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "EGY";
	}

	public static void setCurrentCompany(Company company) {
		if (company.getId().equals(getCurrentCompany().getId())) {
		HttpSession session = ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false));
		session.setAttribute("selectCompany", company);
		}
		
	}
	
	public static String uploud2(FileUploadEvent event, String path) {
		UploadedFile file = event.getFile();
		String fileName = System.currentTimeMillis() + FilenameUtils.getName(event.getFile().getFileName());
		String fileType = FilenameUtils.getName(event.getFile().getContentType());
		try {
			if (prepareFile2(file.getInputstream(), fileName, fileType, path)) {
				return fileName;

			} else {
				return "";
			}
		} catch (IOException e) {
			return "";

		}
	}
	public static String ee() {
		System.out.println(getCurrentUser().getCompany().getCompanyActivityNature());
		String total=getCurrentUser().getCompany().getCompanyActivityNature();
		return total;
		
	}
	public static boolean prepareFile2(InputStream inputStream2, String fileName, String fileType, String docRef) {

		try {
			
			String path = SessionUtilities.getHttpSession(true).getServletContext()
					.getRealPath("resources/logos");

			java.io.File rootDir = new java.io.File(path);

			rootDir.mkdirs();
			File subDir = new File(rootDir.getPath() + File.separator + docRef);
			if (!subDir.exists()) {
				subDir.mkdirs();
			}
			File uploudFile = new File(subDir.getPath() + File.separator + fileName);
			uploudFile.createNewFile();
			OutputStream outputStream = new FileOutputStream(uploudFile);
			byte[] buffer = new byte[1024];
			int length = 0;
			while ((length = inputStream2.read(buffer)) != -1) {
				outputStream.write(buffer, 0, length);
			}
			outputStream.flush();
			outputStream.close();
			inputStream2.close();
			//JsfUtils.addSuccessMessage(MessageBundle.getMsg("success.uploud"));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static boolean isAdmin() {
		return getCurrentUser().isAdmin();
	}

	public static boolean isSuperUser() {
		return getCurrentUser().isSuperUser();
	}
	public static boolean isCustomerPermissions() {
		return getCurrentUser().isCustomerPermissions();
	}
	public static boolean isBankDataPermissions() {
		return getCurrentUser().isBankDataPermissions();
	}
	public static boolean isAccounting() {
		return getCurrentUser().isAccounting();
	}

	public static boolean isFixedAsset() {
		return getCurrentUser().isFixedAsset();
	}
	public static boolean isHr() {
		return getCurrentUser().isHr();
	}
	public static boolean isInventory() {
		return getCurrentUser().isInventory();
	}
	
	
	public static boolean isPatient() {
		return getCurrentUser().isPatient();
	}
	
	
	
	public static boolean isSallon() {
		return getCurrentUser().isSallon();
	}
	public static String getDayName(int day) {
		List<String> days = Arrays.asList("Ø§Ù„Ø£Ø­Ø¯", "Ø§Ù„Ø¥Ø«Ù†ÙŠÙ†", "Ø§Ù„Ø«Ù„Ø§Ø«Ø§Ø¡", "Ø§Ù„Ø£Ø±Ø¨Ø¹Ø§Ø¡", "Ø§Ù„Ø®Ù…ÙŠØ³", "Ø§Ù„Ø¬Ù…Ø¹Ø©", "Ø§Ù„Ø³Ø¨Øª");
		// TODO Auto-generated method stub
		return days.get(day);
	}

	public static String toTimeString(Long time) {
		if (null == time) {
			return "00:00";
		}
		boolean minus = false;
		if (time < 0) {
			time = time * -1;
			minus = true;
		}
		long hours = time / 3600;
		long time2 = time % 3600;
		long min = time2 / 60;
		String minS2=min+"";
		String hS=hours+"";
		if (min<10) {
			minS2="0"+min;
		}
		if (hours<10) {
			hS="0"+hours;
		}
		
		String minS =  ":" + minS2;

		return minus == true ? ("-" + hS + minS) : (hS + minS);

	}


	
}
