package com.timesheet.utils;

import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.timesheet.datamodel.ServiceType;
import com.timesheet.presentation.service.ServiceTypeService;

/**
 * @author Malek Yaseen
 * @Date Oct 7, 2017
 * @Class ServiceTypeConverter
 */
@ManagedBean
@RequestScoped
@FacesConverter(value = "serviceTypeConverter")
public class ServiceTypeConverter implements Converter {

	@ManagedProperty(value = "#{serviceTypeService}")
	private ServiceTypeService serviceTypeService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		if (Objects.isNull(value) || value.isEmpty()) {
			return null;
		}

		if (Objects.isNull(serviceTypeService)) {
			return null;
		}
		long id = Long.parseLong(value);
		return serviceTypeService.findById(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (Objects.isNull(value)) {
			return "";
		}

		if (value instanceof ServiceType) {
			return String.valueOf(((ServiceType) value).getId());
		} else {
			return "";
		}

	}

	/**
	 * @return the serviceTypeService
	 */
	public ServiceTypeService getServiceTypeService() {
		return serviceTypeService;
	}

	/**
	 * @param serviceTypeService
	 *            the serviceTypeService to set
	 */
	public void setServiceTypeService(ServiceTypeService serviceTypeService) {
		this.serviceTypeService = serviceTypeService;
	}

}
