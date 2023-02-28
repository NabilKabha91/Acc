package com.timesheet.utils;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.FileUploadEvent;
import com.timesheet.datamodel.Document;
import com.timesheet.presentation.service.DocumentService;

import com.timesheet.utils.JsfUtils;
import com.timesheet.utils.Utils;

@ManagedBean
@ViewScoped

public class UploadFiles  {

	@ManagedProperty("#{documentService}")
	private DocumentService documentService;
	private Document document;
	private List<Document> documentList;



	@PostConstruct
	public void init() {

		documentList=documentService.findAllByCompany(Utils.getCurrentCompany());

	}

	public void uploadDocument(FileUploadEvent event) throws Exception {
		this.document= new Document();

	
		 Long documentTypeId = new Long(1);
		 document.setDocumentType(documentTypeId);
		document.setOffice(Utils.getCurrentOffice());
		document.setCompany(Utils.getCurrentCompany());
	//	CompanyMB companyMB=JsfUtils.findBean("companyMB");

		
		String fileName = Utils.uploudFileWithOrginalName(event, document.getOffice().getId() +""+document.getCompany().getId());
		document.setDocumentName(fileName);
		if (StringUtils.isNoneEmpty(fileName)) {

//				ManageDocumentsBusiness manageDocumentsBusiness = new ManageDocumentsBusiness();
//				manageDocumentsBusiness.addDocToFolder(selectedCompanyBean.getFolderIndex(), selectedDoc,
//						event.getFile().getFileName(), "uplouded");
//
//				initDocAction();
			documentService.saveDocument(document);

		} else {
			JsfUtils.addErrorMessage("يوجد ملف بنفس الإسم");

		}
		reload();

	}
	public void reload() throws IOException {
	    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}
	

	public DocumentService getDocumentService() {
		return documentService;
	}

	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public List<Document> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<Document> documentList) {
		this.documentList = documentList;
	}
	
}
