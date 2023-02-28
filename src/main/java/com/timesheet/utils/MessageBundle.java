package com.timesheet.utils;

import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;

public class MessageBundle {
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

}
