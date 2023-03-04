package com.timesheet.datamodel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "ACCOUNTS")
public class Account implements Serializable {

    private static final long serialVersionUID = 8455061850556612696L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "grp_name")
    private String grpName;

    @Column(name = "grp_header")
    private Long grpHeader;

    @Column(name = "office_id")
    private Long grpOfficeId;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "grp_Desc")
    private String grpDesc;

    @Column(name = "grp_desc_en")
    private String grpDescEn;


    @ManyToOne(optional = true)
    private Account children;

    @ManyToOne(optional = true)
    private Account parent;

    @Column(name = "account_level", nullable = true)
    private Long level;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "ACC_TYPE", nullable = false)
    private AccType accType;

    @NotNull
    @Column(name = "open_credit", nullable = false)
    private Double openingCreditBalance;

    @NotNull
    @Column(name = "open_debit", nullable = false)
    private Double openingDebitBalance;

    @NotNull
    @Column(name = "credit", nullable = false)
    private Double credit;

    @NotNull
    @Column(name = "debit", nullable = false)
    private Double debit;

    @Column(name = "grp_type")
    private Long grpType;

    @Column(name = "orginal_index")
    private Long orginalIndex;

    @Column(name = "current")
    private int current;

    @Column(name = "type1")
    private Long type1;

    @Column(name = "type2")
    private Long type2;

    @Column(name = "type3")
    private Long type3;

    @Column(name = "type4")
    private Long type4;

    @Column(name = "type5")
    private Long type5;

    @Column(name = "type6")
    private Long type6;

    @Column(name = "type7")
    private Long type7;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getGrpName() {
        return grpName;
    }

    public void setGrpName(String grpName) {
        this.grpName = grpName;
    }

    public Long getGrpHeader() {
        return grpHeader;
    }

    public void setGrpHeader(Long grpHeader) {
        this.grpHeader = grpHeader;
    }

    public Long getGrpOfficeId() {
        return grpOfficeId;
    }

    public void setGrpOfficeId(Long grpOfficeId) {
        this.grpOfficeId = grpOfficeId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getGrpDesc() {
        return grpDesc;
    }

    public void setGrpDesc(String grpDesc) {
        this.grpDesc = grpDesc;
    }

    public String getGrpDescEn() {
        return grpDescEn;
    }

    public void setGrpDescEn(String grpDescEn) {
        this.grpDescEn = grpDescEn;
    }

    public Account getChildren() {
        return children;
    }

    public void setChildren(Account children) {
        this.children = children;
    }

    public Account getParent() {
        return parent;
    }

    public void setParent(Account parent) {
        this.parent = parent;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public AccType getAccType() {
        return accType;
    }

    public void setAccType(AccType accType) {
        this.accType = accType;
    }

    public Double getOpeningCreditBalance() {
        return openingCreditBalance;
    }

    public void setOpeningCreditBalance(Double openingCreditBalance) {
        this.openingCreditBalance = openingCreditBalance;
    }

    public Double getOpeningDebitBalance() {
        return openingDebitBalance;
    }

    public void setOpeningDebitBalance(Double openingDebitBalance) {
        this.openingDebitBalance = openingDebitBalance;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public Long getGrpType() {
        return grpType;
    }

    public void setGrpType(Long grpType) {
        this.grpType = grpType;
    }

    public Long getOrginalIndex() {
        return orginalIndex;
    }

    public void setOrginalIndex(Long orginalIndex) {
        this.orginalIndex = orginalIndex;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public Long getType1() {
        return type1;
    }

    public void setType1(Long type1) {
        this.type1 = type1;
    }

    public Long getType2() {
        return type2;
    }

    public void setType2(Long type2) {
        this.type2 = type2;
    }

    public Long getType3() {
        return type3;
    }

    public void setType3(Long type3) {
        this.type3 = type3;
    }

    public Long getType4() {
        return type4;
    }

    public void setType4(Long type4) {
        this.type4 = type4;
    }

    public Long getType5() {
        return type5;
    }

    public void setType5(Long type5) {
        this.type5 = type5;
    }

    public Long getType6() {
        return type6;
    }

    public void setType6(Long type6) {
        this.type6 = type6;
    }

    public Long getType7() {
        return type7;
    }

    public void setType7(Long type7) {
        this.type7 = type7;
    }


//    @Column(name = "name")
//
//    private   List<Integer> groupNatList = new ArrayList<Integer>();
//
//    @Column(name = "name")
//    private   List<Integer> groupTypelist = new ArrayList<Integer>();


}
