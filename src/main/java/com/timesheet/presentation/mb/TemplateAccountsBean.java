package com.timesheet.presentation.mb;

import com.timesheet.datamodel.*;
import com.timesheet.presentation.service.CodelookupService;

import com.timesheet.presentation.service.impl.TemplateAccountServiceImp;
import com.timesheet.utils.JsfUtils;
import com.timesheet.utils.Utils;
import org.omnifaces.cdi.Param;
import org.omnifaces.util.Faces;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * @author Enas
 */

@ManagedBean(name = "templateAccountsBean")
@ViewScoped
public class TemplateAccountsBean implements Serializable {

    private static final long serialVersionUID = 1340260644039013801L;
    @ManagedProperty(value = "#{templateAccountServiceImp}")
    private TemplateAccountServiceImp templateAccountServiceImp;
    @ManagedProperty(value = "#{codelookupService}")
    private CodelookupService codelookupService;
    private TemplateAccount templateAccount;
    private  List<TemplateAccount> templateAccounts= new ArrayList<TemplateAccount>();
    private TemplateAccount parent;
     private List<String> levels;

    private List<Codelookup> comTypeList = new ArrayList<Codelookup>();
    private Office currentOffice;
    private Company currentCompany;
    private User currentUser;
    @Param(name = "id")
    private String id;
    private List<CompanyForm> companyForm;
    private List<AccType> accTypes;
    @PostConstruct
    public void init() {

        templateAccount = new TemplateAccount();
        comTypeList = new ArrayList<Codelookup>();
        comTypeList = codelookupService.findByParentCode(Long.valueOf(1));
        this.id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        this.currentOffice = Utils.getCurrentOffice();
        this.currentCompany = Utils.getCurrentCompany();
        this.currentUser = Utils.getCurrentUser();

        if (Objects.nonNull(id) && id.trim().length() > 0) {
            templateAccount = templateAccountServiceImp.findOne(Long.valueOf(id));


        }else if (Objects.nonNull(Faces.getFlashAttribute("parent"))) {
            parent = Faces.getFlashAttribute("parent");
            long number = templateAccountServiceImp.getMaxAccLevelNumberByParentId(
                    parent.getId());

            if (number == 0L) {
                templateAccount.setAccountNumber(Long.valueOf(parent.getAccountNumber() + "" + (number + 1)));
            } else {
                templateAccount.setAccountNumber(number + 1);
            }

//            templateAccount.setCompanyId(currentCompany.getId());
//            templateAccount.setGrpOfficeId(currentOffice.getId());
            templateAccount.setLevel(parent.getLevel() + 1);
            templateAccount.setParent(parent);
        } else {
            parent = new TemplateAccount();
            long number = templateAccountServiceImp.getMaxAccLevelNumber(1L);
                templateAccount.setAccountNumber(Long.valueOf("100" + (number + 1)));
            templateAccount.setLevel(1L);
            templateAccount.setParent(null);

        }


        companyForm = Arrays.stream(CompanyForm.values()).collect(Collectors.toList());
        accTypes= Arrays.stream(AccType.values()).collect(Collectors.toList());
    }

    public void addtempAccount() {

        TemplateAccount _Account = templateAccountServiceImp.create(templateAccount);
        Faces.setFlashAttribute("payload", _Account);
        JsfUtils.redirect("/pages/templateAccount/templateAccount-tree.html");

    }


    public String cancel() {
        JsfUtils.redirect("/pages/templateAccount/templateAccount-tree.html");
        return "";

    }

    public List<String> getLevels() {
        return levels;
    }

    public void setLevels(List<String> levels) {
        this.levels = levels;
    }


    public Office getCurrentOffice() {
        return currentOffice;
    }


    public Company getCurrentCompany() {
        return currentCompany;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentOffice(Office currentOffice) {
        this.currentOffice = currentOffice;
    }

    public void setCurrentCompany(Company currentCompany) {
        this.currentCompany = currentCompany;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }


    public List<CompanyForm> getCompanyForm() {
        return companyForm;
    }

    public void setCompanyForm(List<CompanyForm> companyForm) {
        this.companyForm = companyForm;
    }

    public List<Codelookup> getComTypeList() {
        return comTypeList;
    }

    public CodelookupService getCodelookupService() {
        return codelookupService;
    }

    public void setCodelookupService(CodelookupService codelookupService) {
        this.codelookupService = codelookupService;
    }

    public void setComTypeList(List<Codelookup> comTypeList) {
        this.comTypeList = comTypeList;
    }

    public TemplateAccount getTemplateAccount() {
        return templateAccount;
    }

    public void setTemplateAccount(TemplateAccount templateAccount) {
        this.templateAccount = templateAccount;
    }


    public List<TemplateAccount> getTemplateAccounts() {
        return templateAccounts;
    }

    public void setTemplateAccounts(List<TemplateAccount> templateAccounts) {
        this.templateAccounts = templateAccounts;
    }

    public TemplateAccountServiceImp getTemplateAccountServiceImp() {
        return templateAccountServiceImp;
    }

    public void setTemplateAccountServiceImp(TemplateAccountServiceImp templateAccountServiceImp) {
        this.templateAccountServiceImp = templateAccountServiceImp;
    }

    public TemplateAccount getParent() {
        return parent;
    }

    public void setParent(TemplateAccount parent) {
        this.parent = parent;
    }

	public List<AccType> getAccTypes() {
		return accTypes;
	}

	public void setAccTypes(List<AccType> accTypes) {
		this.accTypes = accTypes;
	}
    
    
}
