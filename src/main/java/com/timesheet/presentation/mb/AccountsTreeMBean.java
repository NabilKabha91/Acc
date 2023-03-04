package com.timesheet.presentation.mb;

import com.timesheet.datamodel.*;
import com.timesheet.presentation.service.impl.AccountServiceImp;
import com.timesheet.presentation.web.AuditException;
import com.timesheet.utils.JsfUtils;
import com.timesheet.utils.Utils;
import org.omnifaces.util.Faces;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @author Nabil
 */

@ManagedBean(name = "accountsTreeMBean")
@ViewScoped
public class AccountsTreeMBean implements Serializable {

    private static final long serialVersionUID = 1340260644039013801L;
    @ManagedProperty(value = "#{accountServiceImp}")
    private AccountServiceImp accountService;


    private Office currentOffice;
    private Company currentCompany;
    private User currentUser;

    private List<Long> levels  =  new ArrayList<>();

    private TreeNode root;
    private TreeNode selectedNode;
    private List< Account> finAccounts =  new ArrayList<>() ;

    private   Account finAccount ;

    private  List< Account> rootAccount =  new ArrayList<>() ;

    private List<AccountDTO> children  =  new ArrayList<>() ;

    @PostConstruct
    public void init() {

        this.currentOffice = Utils.getCurrentOffice();
        this.currentCompany = Utils.getCurrentCompany();
        this.currentUser = Utils.getCurrentUser();


        root = new DefaultTreeNode("root", "شجرة الحسابات" , null);
        root.setExpanded(false);

        levels = accountService.getDistinctLevel(currentCompany.getId()).getLevels();
        finAccounts =accountService.findAll();
        rootAccount = accountService.findAllByCompanyID(currentCompany.getId());

        rootAccount.forEach(finAccount1 -> {

            AccountDTO rootDTO  = new AccountDTO();
            rootDTO.setAccount(finAccount1);

            TreeNode rootData = new DefaultTreeNode( finAccount1.getLevel()+"",rootDTO, root);
            rootData.setExpanded(false);
            children = getChildren(finAccount1);

            buildTree(rootData , children);

        });


        // if no account in database
        if(Objects.isNull(finAccounts) || finAccounts.isEmpty()) {

            JsfUtils.redirect("/pages/account/create-new-account.html");
        }
    }

    private void buildTree(TreeNode parent, List<AccountDTO> children) {

        if (children == null) return;

        children.forEach(u -> {

            TreeNode moduleNode = new DefaultTreeNode( u.getFinAccount().getLevel()+"",u, parent);
            moduleNode.setExpanded(false);
            List<AccountDTO> subChildren = getChildren(u.getFinAccount()) ;

            if (Objects.nonNull(subChildren) && ! subChildren.isEmpty()) {
                buildTree(moduleNode, subChildren);
            }
        });
    }

    private List<AccountDTO> getChildren(Account account) {

        List<AccountDTO> children = new ArrayList<>() ;

        finAccounts.forEach(finAccount1 -> {

            if(finAccount1 != null && finAccount1.getParent() != null && finAccount1.getParent().getId().equals(account.getId())){
                AccountDTO accountDTO = new AccountDTO();
                accountDTO.setAccount(finAccount1);
                children.add(accountDTO) ;
            }
        });
        return  children;
    }


    public String initialize() throws AuditException {
         JsfUtils.redirect("/pages/account/account-tree.html");
         return null;
    }

    public String addAccount() {

        if (selectedNode != null && selectedNode.getData() != null && selectedNode.getData() instanceof AccountDTO) {
            Faces.setFlashAttribute("parent", ((AccountDTO) selectedNode.getData()).getFinAccount());
        }
        JsfUtils.redirect("/pages/account/create-new-account.html");
        return "";
    }

    public String viewAccount() {

        if (selectedNode != null && selectedNode.getData() != null && selectedNode.getData() instanceof AccountDTO) {
            JsfUtils.redirect("/pages/account/view-new-account.html?id="+( (AccountDTO) selectedNode.getData() ).getFinAccount().getId());
        }
        return null;
    }

    public AccountServiceImp getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountServiceImp accountService) {
        this.accountService = accountService;
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

    public List<Long> getLevels() {
        return levels;
    }

    public void setLevels(List<Long> levels) {
        this.levels = levels;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public List<Account> getFinAccounts() {
        return finAccounts;
    }

    public void setFinAccounts(List<Account> finAccounts) {
        this.finAccounts = finAccounts;
    }

    public Account getFinAccount() {
        return finAccount;
    }

    public void setFinAccount(Account finAccount) {
        this.finAccount = finAccount;
    }

    public List<Account> getRootAccount() {
        return rootAccount;
    }

    public void setRootAccount(List<Account> rootAccount) {
        this.rootAccount = rootAccount;
    }

    public List<AccountDTO> getChildren() {
        return children;
    }

    public void setChildren(List<AccountDTO> children) {
        this.children = children;
    }
}
