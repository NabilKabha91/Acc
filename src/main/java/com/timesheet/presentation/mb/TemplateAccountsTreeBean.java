package com.timesheet.presentation.mb;

import com.timesheet.datamodel.*;
import com.timesheet.presentation.service.CodelookupService;
import com.timesheet.presentation.service.impl.AccountServiceImp;
import com.timesheet.presentation.service.impl.TemplateAccountServiceImp;
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
 * @author ENAS
 */

@ManagedBean(name = "templateAccountsTreeBean")
@ViewScoped
public class TemplateAccountsTreeBean implements Serializable {

    private static final long serialVersionUID = 1340260644039013801L;
    @ManagedProperty(value = "#{accountServiceImp}")
    private AccountServiceImp accountService;
    @ManagedProperty(value = "#{templateAccountServiceImp}")
    private TemplateAccountServiceImp templateAccountServiceImp;
    @ManagedProperty(value = "#{codelookupService}")
    private CodelookupService codelookupService;
    private Office currentOffice;
    private Company currentCompany;
    private User currentUser;
    private TemplateAccount templateAccount;
    private List<Long> levels  =  new ArrayList<>();

    private TreeNode root;
    private TreeNode selectedNode;
    private Codelookup selecteCompanyType;
    private List<TemplateAccount> templateAccountlist =  new ArrayList<>() ;
    private  List<TemplateAccount> templateAccounts= new ArrayList<TemplateAccount>();
    private  List<TemplateAccount> tempChildren=  new ArrayList<>() ;
    private  List<TemplateAccount> tempRootAccount =  new ArrayList<>() ;
    private  List<TemplateAccount> rootAccount =  new ArrayList<>() ;
    private List<TemplateAccountDTO> children  =  new ArrayList<>() ;
    private List<Codelookup> comTypeList ;
    
    @PostConstruct
    public void init() {
        this.currentOffice = Utils.getCurrentOffice();
        this.currentCompany = Utils.getCurrentCompany();
        this.currentUser = Utils.getCurrentUser();
        selecteCompanyType = new Codelookup ();
        comTypeList = new ArrayList<>();
        comTypeList = codelookupService.getAllCodelookup();
    
     
    }
    
    public void  retrieveTreeOnCompanyType() {
    	System.out.println("selecteCompanyType"+selecteCompanyType);
    rootAccount.addAll(templateAccountServiceImp.findAllByTypeCompany(selecteCompanyType));
    levels.addAll( templateAccountServiceImp.getDistinctLevel(selecteCompanyType).getLevels());
    templateAccounts.addAll(templateAccountServiceImp.findAll(selecteCompanyType));
    root = new DefaultTreeNode("root", "شجرة الحسابات" , null);
    root.setExpanded(false);

    rootAccount.forEach(finAccount1 -> {
        TemplateAccountDTO  rootDTO  = new TemplateAccountDTO();
        rootDTO.setFintTempAccount(finAccount1);
        TreeNode rootData = new DefaultTreeNode( finAccount1.getLevel()+"",rootDTO, root);//بخزن كل حساب في نود
        rootData.setExpanded(false);
        children = getChildren(finAccount1);
        buildTree(rootData , children);

    });

    
    // if no account in database
    if(Objects.isNull(templateAccounts) || templateAccounts.isEmpty()) {
        JsfUtils.redirect("/pages/templateAccount/create-new-templateAccount.html");
    }
    
    }

    private void buildTree(TreeNode parent, List<TemplateAccountDTO> children) {

        if (children == null) return;

        children.forEach(u -> {

            TreeNode moduleNode = new DefaultTreeNode( u.getFintTempAccount()+"",u, parent);
            moduleNode.setExpanded(false);
            List<TemplateAccountDTO> subChildren = getChildren(u.getFintTempAccount()) ;

            if (Objects.nonNull(subChildren) && ! subChildren.isEmpty()) {
                buildTree(moduleNode, subChildren);
            }
        });
    }

    private List<TemplateAccountDTO> getChildren(TemplateAccount account) {

        List<TemplateAccountDTO> children = new ArrayList<>() ;

        templateAccounts.forEach(finAccount1 -> {
            if(finAccount1 != null && finAccount1.getParent() != null && finAccount1.getParent().getId().equals(account.getId())){
                TemplateAccountDTO templateAccountDTO = new TemplateAccountDTO();
                templateAccountDTO.setFintTempAccount(finAccount1);
                children.add(templateAccountDTO) ;
            }
        });
        return  children;
    }


    public String initialize() throws AuditException {
         JsfUtils.redirect("/pages/account/account-tree.html");
         return null;
    }

    public String addAccount() {

        if (selectedNode != null && selectedNode.getData() != null && selectedNode.getData() instanceof TemplateAccountDTO) {
            Faces.setFlashAttribute("parent", ((TemplateAccountDTO) selectedNode.getData()).getFintTempAccount());
        }
        JsfUtils.redirect("/pages/templateAccount/create-new-templateAccount.html");
        return "";
    }

    public String viewAccount() {

        if (selectedNode != null && selectedNode.getData() != null && selectedNode.getData() instanceof TemplateAccountDTO) {
            JsfUtils.redirect("/pages/templateAccount/view-new-templateAccount.html?id="+( (TemplateAccountDTO) selectedNode.getData() ).getFintTempAccount().getId());
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




    public List<TemplateAccount> getRootAccount() {
        return rootAccount;
    }

    public void setRootAccount(List<TemplateAccount> rootAccount) {
        this.rootAccount = rootAccount;
    }

    public List<TemplateAccountDTO> getChildren() {
        return children;
    }

    public void setChildren(List<TemplateAccountDTO> children) {
        this.children = children;
    }

    public TemplateAccount getTemplateAccount() {
        return templateAccount;
    }

    public void setTemplateAccount(TemplateAccount templateAccount) {
        this.templateAccount = templateAccount;
    }

    public List<TemplateAccount> getTemplateAccountlist() {
        return templateAccountlist;
    }

    public void setTemplateAccountlist(List<TemplateAccount> templateAccountlist) {
        this.templateAccountlist = templateAccountlist;
    }

    public List<TemplateAccount> getTempChildren() {
        return tempChildren;
    }

    public void setTempChildren(List<TemplateAccount> tempChildren) {
        this.tempChildren = tempChildren;
    }

    public List<TemplateAccount> getTempRootAccount() {
        return tempRootAccount;
    }

    public void setTempRootAccount(List<TemplateAccount> tempRootAccount) {
        this.tempRootAccount = tempRootAccount;
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

    public List<Codelookup> getComTypeList() {
        return comTypeList;
    }

    public void setComTypeList(List<Codelookup> comTypeList) {
        this.comTypeList = comTypeList;
    }

    public CodelookupService getCodelookupService() {
        return codelookupService;
    }

    public void setCodelookupService(CodelookupService codelookupService) {
        this.codelookupService = codelookupService;
    }

	public Codelookup getSelecteCompanyType() {
		return selecteCompanyType;
	}

	public void setSelecteCompanyType(Codelookup selecteCompanyType) {
		this.selecteCompanyType = selecteCompanyType;
	}


    
    
}
