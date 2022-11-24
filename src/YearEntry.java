public class YearEntry {
    private String month;
    private Integer amount;
    private boolean isExpense;

    public YearEntry(String month, Integer amount, Boolean isExpense){
        setMonth(month);
        setAmount(amount);
        setExpense(isExpense);
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean getIsExpense() {
        return isExpense;
    }

    public void setExpense(boolean expense) {
        isExpense = expense;
    }

    @Override
    public String toString() {
        return "YearEntry{" +
                "month='" + month + '\'' +
                ", amount=" + amount +
                ", isExpense=" + isExpense +
                '}';
    }
}
