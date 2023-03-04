package com.timesheet.utils;

import java.io.IOException;
import java.util.*;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.FactoryFinder;
import javax.faces.application.Application;
import javax.faces.application.ApplicationFactory;
import javax.faces.application.FacesMessage;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.primefaces.context.RequestContext;

public class JsfUtils {

	private static final String APPLICATION_FACTORY_KEY = "javax.faces.application.ApplicationFactory";

	public JsfUtils() {
	}

	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	@SuppressWarnings({"unchecked", "el-syntax"})
	public static <T> T findBean(String beanName) {
		FacesContext context = FacesContext.getCurrentInstance();
		return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
	}

	
	/**
	 * Defined as static because it is used in getInstance()
	 *
	 * @return
	 */
	public static Application getApplication() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context != null) {
			return FacesContext.getCurrentInstance().getApplication();
		} else {
			ApplicationFactory afactory = (ApplicationFactory) FactoryFinder.getFactory(APPLICATION_FACTORY_KEY);
			return afactory.getApplication();
		}
	}

	/**
	 * Evaluates JSF EL expression and returns the value. If the expression does
	 * not start with "#{" it is assumed to be a literal value, and the value
	 * returned will be the same as passed in.
	 * <p>
	 * Defined as static because it is used in getInstance()
	 *
	 * @param jsfExpression
	 * @return
	 */
	@SuppressWarnings("el-syntax")
	public static Object getExpressionValue(String jsfExpression) {
		// when specifying EL expression in managed bean as "literal" value
		// so t can be evaluated later, the # is replaced with $, quite strange
		if (jsfExpression == null) {
			return jsfExpression;
		}
		if (jsfExpression.startsWith("${")) {
			jsfExpression = "#{" + jsfExpression.substring(2);
		}
		if (!jsfExpression.startsWith("#{")) {
			if (jsfExpression.equalsIgnoreCase("true")) {
				return Boolean.TRUE;
			} else if (jsfExpression.equalsIgnoreCase("false")) {
				return Boolean.FALSE;
			} // there can be literal text preceding the expression...
			else if (jsfExpression.indexOf("#{") < 0) {
				return jsfExpression;
			}
		}
		ValueExpression ve = getApplication().getExpressionFactory()
				.createValueExpression(getFacesContext().getELContext(), jsfExpression, Object.class);
		return ve.getValue(getFacesContext().getELContext());
	}

	/**
	 * Searches a component relative to a base component. If not found, we take
	 * the parent of the base component and search again. We continue until a
	 * component is found or the parent is null
	 *
	 * @param base
	 * @param id
	 * @return
	 */
	public static UIComponent findRelativeComponentAndMoveUpIfNotFound(UIComponent base, String id) {
		UIComponent comp = null;
		UIComponent parent = base;
		while (comp == null && parent != null) {
			comp = findComponent(parent, id);
			parent = parent.getParent();
		}
		return comp;
	}

	/**
	 * <p>
	 * Return the {@link UIComponent} (if any) with the specified
	 * <code>id</code>, searching recursively starting at the specified
	 * <code>base</code>, and examining the base component itself, followed by
	 * examining all the base component's facets and children. Unlike
	 * findComponent method of {@link javax.faces.component.UIComponentBase},
	 * which skips recursive scan each time it finds a {@link NamingContainer},
	 * this method examines all components, regardless of their namespace
	 * (assuming IDs are unique).
	 *
	 * @param base
	 *            Base {@link UIComponent} from which to search
	 * @param id
	 *            Component identifier to be matched
	 */
	@SuppressWarnings("rawtypes")
	public static UIComponent findComponent(UIComponent base, String id) {
		if (id == null || "".equals(id)) {
			return null;
		}
		// Is the "base" component itself the match we are looking for?
		if (id.equals(base.getId())) {
			return base;
		}
		// check for direct child
		UIComponent result = base.findComponent(id);
		if (result != null) {
			return result;
		}

		// Search through our facets and children
		UIComponent kid = null;
		Iterator kids = base.getFacetsAndChildren();
		while (kids.hasNext() && (result == null)) {
			kid = (UIComponent) kids.next();
			if (id.equals(kid.getId())) {
				result = kid;
				break;
			}
			result = findComponent(kid, id);
			if (result != null) {
				break;
			}
		}
		return result;
	}

	public static void resetEditableValueHolder(EditableValueHolder evh) {
		evh.setValue(null);
		evh.setSubmittedValue(null);
		evh.setLocalValueSet(false);
		evh.setValid(true);
	}

	public static void resetComponent(UIComponent comp) {
		if (comp instanceof EditableValueHolder) {
			resetEditableValueHolder((EditableValueHolder) comp);
		}
	}

	public static UIViewRoot getViewRoot() {
		if (getFacesContext() != null) {
			return getFacesContext().getViewRoot();
		}
		return null;
	}

	/**
	 * Convenience method for setting Session variables.
	 *
	 * @param key
	 *            object key
	 * @param object
	 *            value to store
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void storeOnSession(String key, Object object) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map session = ctx.getExternalContext().getSessionMap();
		session.put(key, object);
	}

	/**
	 * Convenience method for getting Session variables.
	 *
	 * @param key
	 *            object key
	 */
	@SuppressWarnings("rawtypes")
	public static Object getFromSession(String key) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map session = ctx.getExternalContext().getSessionMap();
		return session.get(key);
	}

	/**
	 * Convenience method for setting Request attributes.
	 *
	 * @param key
	 *            object key
	 * @param object
	 *            value to store
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void storeOnRequest(String key, Object object) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map request = ctx.getExternalContext().getRequestMap();
		request.put(key, object);
	}

	/**
	 * Convenience method for getting Request attributes.
	 *
	 * @param key
	 *            object key
	 */
	@SuppressWarnings("rawtypes")
	public static Object getFromRequest(String key) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map request = ctx.getExternalContext().getRequestMap();
		if (null != request) {
			if (request.containsKey(key)) {
				return request.get(key);
			}
		}
		return null;

	}

	public static String getRequestParameterMap(String key) {
		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);

		return value;
	}

	public static Object getObjectRequestParameterMap(String key) {
		Object value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
		return value;
	}

	public static String getUrlParameter(String key) {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		if (request.getParameterMap().containsKey(key) && StringUtils.isNotEmpty(request.getParameter(key))) {
			return request.getParameter(key);
		}
		return null;

	}

	public static void redirect(String redirectUrl) {
		try {
			ExternalContext ext = FacesContext.getCurrentInstance().getExternalContext();
			if (redirectUrl.contains("?faces-redirect=true")) {
			} else {
				if (redirectUrl.contains("?")) {
					redirectUrl = redirectUrl + "&faces-redirect=true";
				} else {
					redirectUrl = redirectUrl + "?faces-redirect=true";
				}
			}
			ext.redirect(ext.getRequestContextPath() + redirectUrl);
		} catch (IOException e) {
			System.out.println("Error redirecting to " + redirectUrl + ": " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static boolean isValidExpression(String expression) {
		boolean valid = true;
		try {
			getExpressionValue(expression);
		} catch (Exception ex) {
			valid = false;
		}
		return valid;
	}

	/**
	 * Programmatic invocation of a method that an EL evaluates to. The method
	 * must not take any parameters.
	 *
	 * @param methodExpression
	 *            EL of the method to invoke
	 * @return Object that the method returns
	 */
	public static Object invokeELMethod(String methodExpression) {
		return invokeELMethod(methodExpression, new Class[0], new Object[0]);
	}

	/**
	 * Programmatic invocation of a method that an EL evaluates to.
	 *
	 * @param methodExpression
	 *            EL of the method to invoke
	 * @param paramTypes
	 *            Array of Class defining the types of the parameters
	 * @param params
	 *            Array of Object defining the values of the parametrs
	 * @return Object that the method returns
	 */
	@SuppressWarnings("rawtypes")
	public static Object invokeELMethod(String methodExpression, Class[] paramTypes, Object[] params) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ELContext elContext = facesContext.getELContext();
		MethodExpression exp = getMethodExpression(methodExpression, null, paramTypes);
		return exp.invoke(elContext, params);
	}

	@SuppressWarnings("rawtypes")
	public static MethodExpression getMethodExpression(String methodExpression, Class returnType, Class[] paramTypes) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ELContext elContext = facesContext.getELContext();
		ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
		MethodExpression exp = expressionFactory.createMethodExpression(elContext, methodExpression, returnType,
				paramTypes);
		return exp;
	}

	public static UIComponent findComponentInRoot(String id) {
		UIComponent ret = null;

		FacesContext context = FacesContext.getCurrentInstance();
		if (context != null) {
			UIComponent root = context.getViewRoot();
			ret = findComponent(root, id);
		}

		return ret;
	}

	public static UIComponent findComponentMatchingClientId(String clientCompId) {
		FacesContext context = FacesContext.getCurrentInstance();
		UIComponent root = context.getViewRoot();
		return findComponentMatchingClientId(root, clientCompId);
	}

	/**
	 * Method to parse the active component clientId to identify the UIComponent
	 * instance. Code based on sample from Frank Nimphius on ADF Code Corner
	 *
	 * @param startComp
	 *            The top-level component where we start finding.
	 * @param clientCompId
	 *            clientId or ClientLocatorId. A clientId contains all the
	 *            naming comntainers between the document root and the UI
	 *            component. A client locator also contains a row indes if the
	 *            component is part of a table rendering
	 * @return
	 */
	public static UIComponent findComponentMatchingClientId(UIComponent startComp, String clientCompId) {

		String components[] = {};
		if (clientCompId != null) {
			components = clientCompId.split(":");
		}
		UIComponent component = null;

		// get the component
		if (components.length > 0) {
			String componentId = components[0];
			component = startComp.findComponent(componentId);

			if (component != null) {
				for (int i = 1; i < components.length; ++i) {
					// if the component is in a table, then the clientId
					// contains an integer vaue that indicates the row index
					// to parse this out, we use a try/catch block
					try {
						Integer.parseInt(components[i]);
					} catch (NumberFormatException nf) {
						// the id is not a number, so lets try a get the
						// component
						if (component != null) {
							component = findComponent(component, components[i]);
						}
					}
				}
			}
		}

		// if we are here then we have a component or null
		return component;
	}

	public static void openReport(String url, Map<String, Object> options) {

		if (null == options || options.isEmpty()) {
			int width = Integer.parseInt(JsfUtils.getRequestParameterMap("width"));
			int height = Integer.parseInt(JsfUtils.getRequestParameterMap("height"));
			options = new HashMap<>();
			options.put("resizable", true);
			options.put("maximizable", true);
			options.put("width", width - 200);
			options.put("height", height - 50);
			options.put("contentWidth", width - 250);
			options.put("contentHeight", height - 120);
		}
		RequestContext.getCurrentInstance().openDialog(url, options, null);

	}

	public static void addError(String clientId, String message) {
		FacesMessage fm = new FacesMessage(message);
		fm.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(clientId, fm);
	}

	/**
	 * Extracts and returns the parameters from the given URL string.
	 *
	 * @param url
	 *            the URL from which to extract parameters.
	 * @return the Map of parameters.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, Object> extractParameters(final String url) {
		final Map<String, Object> parameterMap = new LinkedHashMap<String, Object>();
		if (url != null && url.contains("?")) {
			final String parameterString = url.replaceAll(".*\\?", "");
			if (parameterString.trim().length() > 0) {
				final String[] parametersAndValues = parameterString.split("\\s*&\\s*");
				for (final String parameterAndValue : parametersAndValues) {
					final String[] parameters = parameterAndValue.split("\\s*=\\s*");
					final String parameter = parameters[0];
					Object existingValue = parameterMap.get(parameter);
					String value = null;
					if (parameters.length > 1) {
						value = parameters[1];
					}
					if (existingValue != null) {
						if (existingValue instanceof Collection) {
							((Collection) existingValue).add(value);
						} else {
							final Collection<Object> values = new ArrayList<Object>();
							values.add(existingValue);
							values.add(value);
							parameterMap.put(parameter, values);
						}
					} else {
						parameterMap.put(parameter, value);
					}
				}
			}
		}
		return parameterMap;
	}

	/**
	 * Returns the converter identified by converterId
	 *
	 * @param converterId
	 *            the id of the converter to be used
	 * @return the Converter instance
	 */
	public static Converter getConverter(final String converterId) {
		if (StringUtils.isBlank(converterId)) {
			return null;
		}
		final FacesContext facesContext = FacesContext.getCurrentInstance();
		return facesContext.getApplication().createConverter(converterId);
	}

	/**
	 * Uses the converter identified by converterId to convert the value to a
	 * String.
	 *
	 * @param value
	 *            the value to be converted
	 * @param converterId
	 *            the id of the converter to be used
	 * @param componentId
	 *            the id of the component being rendered
	 * @return the String representation of the value.
	 */
	public static String valueFromConverter(final Object value, final String converterId, final String componentId) {
		final FacesContext facesContext = FacesContext.getCurrentInstance();
		final Converter converter = facesContext.getApplication().createConverter(converterId);
		return converter.getAsString(facesContext,
				StringUtils.isBlank(componentId) ? null : facesContext.getViewRoot().findComponent(componentId), value);
	}

	/**
	 * Uses the converter identified by converterId to convert the value to a
	 * String.
	 *
	 * @param value
	 *            the value to be converted
	 * @param converterId
	 *            the id of the converter to be used
	 * @return the String representation of the value.
	 */
	public static String valueFromConverter(final Object value, final String converterId) {
		final FacesContext facesContext = FacesContext.getCurrentInstance();
		final Converter converter = facesContext.getApplication().createConverter(converterId);
		return converter.getAsString(facesContext, null, value);
	}

	/**
	 * Guarantees the partial triggers is a String[].
	 *
	 * @param partialTriggers
	 *            the partialTriggers attribute.
	 * @return the original partialTriggers if it is a String[] or the
	 *         partialTriggers splitted if it was a String.
	 */
	public static String[] splitPartialTriggers(Object partialTriggers) {
		if (partialTriggers instanceof String) {
			final String thePartialTriggers = partialTriggers.toString().trim();
			if (thePartialTriggers.length() > 0) {
				return thePartialTriggers.split(" ");
			}
			return null;
		} else if (partialTriggers instanceof String[]) {
			return (String[]) partialTriggers;
		}
		return null;
	}

	/**
	 * Returns an ActionEvent parameter value, from its name
	 *
	 * @param parameterName
	 *            the parameter name
	 * @param event
	 *            ActionEvent containing the parameter
	 * @return the parameter value.
	 */
	public static Object getParameterValue(String parameterName, ActionEvent event) {
		for (Object uiObject : event.getComponent().getChildren()) {
			if (uiObject instanceof UIParameter) {
				final UIParameter param = (UIParameter) uiObject;
				if (param.getName().equals(parameterName)) {
					return param.getValue();
				}
			}
		}
		throw new RuntimeException("Parameter " + parameterName + " not found");
	}

	/**
	 * Returns the array without the entries with zero (using to avoid the null
	 * to zero issue of EL)
	 *
	 * @param intArray
	 *            an array filled with Integer
	 * @return the array with the entries with zero and null removed
	 */
	public static Integer[] removeZeros(Integer[] intArray) {
		if (intArray == null) {
			return null;
		}
		final Collection<Integer> result = new ArrayList<Integer>(intArray.length);
		for (Integer intValue : intArray) {
			if (intValue != null && intValue.intValue() != 0) {
				result.add(intValue);
			}
		}
		return result.toArray(new Integer[0]);
	}

	/**
	 * Returns the array without the entries with zero (using to avoid the null
	 * to zero issue of EL)
	 *
	 * @param longArray
	 *            an array filled with Integer
	 * @return the array with the entries with zero and null removed
	 */
	public static Long[] removeZeros(Long[] longArray) {
		if (longArray == null) {
			return null;
		}
		final Collection<Long> result = new ArrayList<Long>(longArray.length);
		for (Long longValue : longArray) {
			if (longValue != null && longValue.longValue() != 0) {
				result.add(longValue);
			}
		}
		return result.toArray(new Long[0]);
	}

	public static boolean stringToBoolean(String v, boolean strict) {
		if (v == null) {
			return false;
		}
		v = v.toUpperCase();
		if (v.equals("YES") || v.equals("Y") || v.equals("1") || v.equals("TRUE") || v.equals("T") || v.equals("ON")
				|| v.equals("CHECKED") || v.equals("CHECK") || v.equals("SELECTED") || v.equals("SELECT")) {
			return true;
		}

		if (v.equals("NO") || v.equals("N") || v.equals("0") || v.equals("FALSE") || v.equals("F") || v.equals("OFF")
				|| v.equals("UNCHECKED") || v.equals("UNCHECK") || v.equals("UNSELECTED") || v.equals("UNSELECT")) {
			return false;
		}
		if (!strict) {
			return false;
		}
		throw new RuntimeException("String is not a boolean value");
	}

	public static boolean isPartialRequest() {
		if (isAjaxRequest()) {
			return true;
		}
		return "partial/process".equals(
				FacesContext.getCurrentInstance().getExternalContext().getRequestHeaderMap().get("Faces-Request"));

	}

	/**
	 *
	 * @return whether current request is ajax call. JSF provides this but you
	 *         need to create PartialViewContext.
	 */
	public static boolean isAjaxRequest() {

		return "partial/ajax".equals(
				FacesContext.getCurrentInstance().getExternalContext().getRequestHeaderMap().get("Faces-Request"));

	}

	public static Object getSession() {
		return FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	}

	public static void postMessageToFacesContext(FacesMessage.Severity severity, String summary, String detail) {
		postMessage(null, severity, summary, detail);
	}

	public static void postMessage(String componentId, FacesMessage.Severity severity, String summary, String detail) {
		getFacesContext().addMessage(componentId, new FacesMessage(severity, summary, detail));
	}

	public static final String ACTION_SUCCESS = "actionSuccess";

	public static SelectItem[] getSelectItems(List<?> entities, boolean selectOne) {
		int size = selectOne ? entities.size() + 1 : entities.size();
		SelectItem[] items = new SelectItem[size];
		int i = 0;
		if (selectOne) {
			items[0] = new SelectItem("", "---");
			i++;
		}
		for (Object x : entities) {
			items[i++] = new SelectItem(x, x.toString());
		}
		return items;
	}

	public static void addErrorMessage(Exception ex, String defaultMsg) {
		ex.getStackTrace();
		String msg = ex.getLocalizedMessage();
		if (msg != null && msg.length() > 0) {
			addErrorMessage(msg);
		} else {
			addErrorMessage(defaultMsg);
		}
	}

	public static void addErrorMessages(List<String> messages) {
		for (String message : messages) {
			addErrorMessage(message);
		}
	}

	public static void addErrorMessage(String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	public static void addSuccessMessage(String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	public static ValueExpression getExpression(String expression) {
		FacesContext fc = FacesContext.getCurrentInstance();
		ELContext ctx = fc.getELContext();
		ExpressionFactory factory = fc.getApplication().getExpressionFactory();
		return factory.createValueExpression(ctx, expression, Object.class);
	}

	public static ValueExpression getExpression(String expression, Class<?> type) {
		FacesContext fc = FacesContext.getCurrentInstance();
		ELContext ctx = fc.getELContext();
		ExpressionFactory factory = fc.getApplication().getExpressionFactory();
		return factory.createValueExpression(ctx, expression, type);
	}

	/**
	 * Function sets success flag callback parameter. This flag could be used
	 * from javascript function on application client side through the
	 * <b>args</b> function argument.
	 *
	 * @param successFlag
	 *            - flag
	 */
	public static void setSuccessFlag(boolean successFlag) {
		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam(ACTION_SUCCESS, successFlag);
	}

	/**
	 * Fucnion sets callback parameter to allow use this value from javascript
	 * on application client side through the <b>args</b> function argument.
	 *
	 * @param paramName
	 *            - parameter name
	 * @param value
	 *            - parameter value
	 */
	public static void setCallbackParameter(String paramName, Object value) {
		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam(paramName, value);
	}

	public static void excuteJavascriptAfterAjaxRequest(String script) {
		RequestContext.getCurrentInstance().execute(script);
	}

	public static void showDialog(String dialogId) {
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('" + dialogId + "').show();");
	}

	public static void hideDialog(String dialogId) {
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('" + dialogId + "').hide();");
	}

	public static String getClientId(UIComponent uiComponent) {
		return (uiComponent == null) ? "" : uiComponent.getClientId();

	}

	public static void updateComponent(String componentId) {
		if (null != componentId && !componentId.isEmpty()) {
			RequestContext.getCurrentInstance().update(componentId);
		}

	}

	public static void updateComponent(UIComponent component) {
		if (null != component) {
			RequestContext.getCurrentInstance().update(getClientId(component));
		}

	}

	public static void updateComponents(String... componentIds) {
		if (null != componentIds) {
			List<String> list = new ArrayList<String>();
			for (String string : componentIds) {
				list.add(string);
			}
			RequestContext.getCurrentInstance().update(list);
		}

	}

	public static void updateComponents(UIComponent... components) {
		if (null != components) {
			List<String> list = new ArrayList<String>();
			for (UIComponent component : components) {
				list.add(getClientId(component));
			}
			RequestContext.getCurrentInstance().update(list);
		}

	}

	public static void findComponentInRootAndUpdate(String... componentIds) {
		if (null != componentIds) {
			List<String> list = new ArrayList<String>();
			for (String component : componentIds) {
				String clientId = getClientId(findComponentInRoot(component));
				if (StringUtils.isNotEmpty(clientId)) {
					list.add(clientId);
				}
			}
			RequestContext.getCurrentInstance().update(list);
		}

	}

	public static void findComponentInRootAndUpdate(UIComponent baseComponent, String... componentIds) {
		if (null != componentIds) {
			List<String> list = new ArrayList<String>();
			for (String component : componentIds) {
				list.add(getClientId(findComponent(baseComponent, component)));
			}
			RequestContext.getCurrentInstance().update(list);
		}

	}

	
	
	

}
