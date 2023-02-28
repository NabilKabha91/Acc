package com.timesheet.datamodel;

public class AcctStatementDTO {

    private String name;

    private String number;

    private DefinitionOfCurrencies definitionOfCurrencies;

    private Float credit;

    private Float debit;

    private String notes;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public Float getDebit() {
        return debit;
    }

    public void setDebit(Float debit) {
        this.debit = debit;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public DefinitionOfCurrencies getDefinitionOfCurrencies() {
        return definitionOfCurrencies;
    }

    public void setDefinitionOfCurrencies(DefinitionOfCurrencies definitionOfCurrencies) {
        this.definitionOfCurrencies = definitionOfCurrencies;
    }
}
