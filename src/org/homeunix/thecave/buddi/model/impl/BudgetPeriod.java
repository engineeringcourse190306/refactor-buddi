package org.homeunix.thecave.buddi.model.impl;

import org.homeunix.thecave.buddi.model.BudgetCategoryType;

import java.util.Date;

public class BudgetPeriod {
    private final Date startDate;
    private final BudgetCategoryType type;
    private final Date endDate;

    public BudgetPeriod(BudgetCategoryType type, Date date) {
        this.type = type;
        this.startDate = type.getStartOfBudgetPeriod(date);
        endDate = type.getEndOfBudgetPeriod(date);
    }

    public boolean equals(Object another) {
        return startDate.equals(((BudgetPeriod) another).startDate);
    }

    public BudgetPeriod nextBudgetPeriod() {
        return new BudgetPeriod(type, type.getStartOfNextBudgetPeriod(startDate));
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public BudgetPeriod previousBudgetPeriod() {
        return new BudgetPeriod(type, type.getStartOfPreviousBudgetPeriod(startDate));
    }
}
