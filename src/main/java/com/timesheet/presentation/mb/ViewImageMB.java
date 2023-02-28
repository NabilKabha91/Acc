package com.timesheet.presentation.mb;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.timesheet.datamodel.Office;
import com.timesheet.presentation.service.OfficeService;
import com.timesheet.presentation.web.OfficeMB;
import com.timesheet.utils.JsfUtils;

@ManagedBean
@SessionScoped
public class ViewImageMB implements Serializable {

	private static final long serialVersionUID = -6279901296137239620L;
	@ManagedProperty("#{officeService}")
	private OfficeService officeService;

	private byte[] userImage;

	public StreamedContent getImage() {

		FacesContext context = FacesContext.getCurrentInstance();
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {

			Office office = new Office();
			String p = context.getExternalContext().getRequestParameterMap().get("logo");
			if (StringUtils.isNoneEmpty(p)) {
				Long officeId = Long.parseLong(p);
				office =officeService.findById(officeId);
			} else {

				OfficeMB officeMB=JsfUtils.findBean("officeMB");
				office=officeMB.getOffice();
			}
			if (null != office && null != office.getLogo()) {

				return new DefaultStreamedContent(new ByteArrayInputStream(office.getLogo()));
			}
			return new DefaultStreamedContent();

		}
	}

	public StreamedContent getUserImage() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {

			return new DefaultStreamedContent(new ByteArrayInputStream(userImage));
		}
	}

	public void setBytes(byte[] bytes) {
	}

	/**
	 * @param userImage
	 *            the userImage to set
	 */
	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}

	/**
	 * @return the officeService
	 */
	public OfficeService getOfficeService() {
		return officeService;
	}

	/**
	 * @param officeService
	 *            the officeService to set
	 */
	public void setOfficeService(OfficeService officeService) {
		this.officeService = officeService;
	}

}
