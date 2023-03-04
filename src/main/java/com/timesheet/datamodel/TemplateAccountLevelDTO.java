package com.timesheet.datamodel;

import java.io.Serializable;
import java.util.List;

public class TemplateAccountLevelDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private List<Long> levels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getLevels() {
        return levels;
    }

    public void setLevels(List<Long> levels) {
        this.levels = levels;
    }
}
