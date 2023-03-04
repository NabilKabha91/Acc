package com.timesheet.datamodel;

import java.io.Serializable;
import java.util.List;

public class TemplateAccountDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private TemplateAccount fintTempAccount ;

    private List<TemplateAccountDTO> children ;

    public TemplateAccount getFintTempAccount() {
        return fintTempAccount;
    }

    public void setFintTempAccount(TemplateAccount fintTempAccount) {
        this.fintTempAccount = fintTempAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TemplateAccountDTO> getChildren() {
        return children;
    }

    public void setChildren(List<TemplateAccountDTO> children) {
        this.children = children;
    }
}
