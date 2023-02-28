package com.timesheet.datamodel;

import java.io.Serializable;
import java.util.List;

public class AccountDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Account finAccount ;

    private List<AccountDTO> children ;

    public Account getFinAccount() {
        return finAccount;
    }

    public void setAccount(Account finAccount) {
        this.finAccount = finAccount;
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

    public List<AccountDTO> getChildren() {
        return children;
    }

    public void setChildren(List<AccountDTO> children) {
        this.children = children;
    }
}
