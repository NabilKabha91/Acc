package com.timesheet.presentation.mb;

import com.timesheet.datamodel.*;
import com.timesheet.presentation.service.impl.AccountServiceImp;
import com.timesheet.utils.JsfUtils;
import com.timesheet.utils.Utils;
import org.omnifaces.cdi.Param;
import org.omnifaces.util.Faces;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

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
 * @author Nabil
 */

@ManagedBean(name = "accountsMBean")
@ViewScoped
public class AccountsMBean implements Serializable {

    private static final long serialVersionUID = 1340260644039013801L;
    @ManagedProperty(value = "#{accountServiceImp}")
    private AccountServiceImp accountService;
    private Account finAccount;
    private Account parent;
     private List<String> levels;

    private Office currentOffice;
    private Company currentCompany;
    private User currentUser;
    @Param(name = "id")
    private String id;
    private List<AccType> accTypes;

    @PostConstruct
    public void init() {

        finAccount = new Account();
        this.id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");


        this.currentOffice = Utils.getCurrentOffice();
        this.currentCompany = Utils.getCurrentCompany();
        this.currentUser = Utils.getCurrentUser();
        if (Objects.nonNull(id) && id.trim().length() > 0) {
            finAccount = accountService.findOne(Long.valueOf(id));


        }else if (Objects.nonNull(Faces.getFlashAttribute("parent"))) {
            parent = Faces.getFlashAttribute("parent");
            long number = accountService.getMaxAccLevelNumberByParentId(
                    parent.getId());

            if (number == 0l) {
                finAccount.setAccountNumber(Long.valueOf(parent.getAccountNumber() + "" + (number + 1)));
            } else {
                finAccount.setAccountNumber(number + 1);
            }

            finAccount.setCompanyId(currentCompany.getId());
            finAccount.setGrpOfficeId(currentOffice.getId());
            finAccount.setLevel(parent.getLevel() + 1);
            finAccount.setParent(parent);
        } else {
            parent = new Account();
            long number = accountService.getMaxAccLevelNumber(1l);
                finAccount.setAccountNumber(Long.valueOf("100" + (number + 1)));
            finAccount.setLevel(1l);
            finAccount.setParent(null);
            finAccount.setCompanyId(currentCompany.getId());
            finAccount.setGrpOfficeId(currentOffice.getId());
        }


         accTypes= Arrays.stream(AccType.values()).collect(Collectors.toList());
    }

    public void addnewAccount() {

        finAccount.setCredit(0.0);
        finAccount.setDebit(0.0);

        Account _Account = accountService.create(finAccount);
         Faces.setFlashAttribute("payload", _Account);
        JsfUtils.redirect("/pages/account/account-tree.html");

    }


    public String cancel() {
        JsfUtils.redirect("/pages/account/account-tree.html");
        return "";

    }

    public List<String> getLevels() {
        return levels;
    }

    public void setLevels(List<String> levels) {
        this.levels = levels;
    }

    public Account getFinAccount() {
        return finAccount;
    }

    public void setFinAccount(Account finAccount) {
        this.finAccount = finAccount;
    }

    public void setAccount(Account finAccount) {
        this.finAccount = finAccount;
    }

    public AccountServiceImp getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountServiceImp accountService) {
        this.accountService = accountService;
    }

    public Account getParent() {
        return parent;
    }

    public void setParent(Account parent) {
        this.parent = parent;
    }

    public Office getCurrentOffice() {
        return currentOffice;
    }

    public void setCurrentOffice(Office currentOffice) {
        this.currentOffice = currentOffice;
    }

    public Company getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(Company currentCompany) {
        this.currentCompany = currentCompany;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public List<AccType> getAccTypes() {
        return accTypes;
    }

    public void setAccTypes(List<AccType> accTypes) {
        this.accTypes = accTypes;
    }
}
