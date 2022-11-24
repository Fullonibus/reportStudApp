public class MonthEntry {
    private String itemName ;
    private Boolean isExpense;
    private Integer quantity ;
    private Integer sumOfOne;
    private Integer localExpense = 0;
    private Integer localIncome = 0;

    public MonthEntry(String itemName, Boolean isExpense, Integer quantity, Integer sumOfOne){
        setItemName(itemName);
        setExpense(isExpense);
        setQuantity(quantity);
        setSumOfOne(sumOfOne);
        calculateMaxIncomeOrExpense(quantity,sumOfOne,isExpense);
    }

    private void calculateMaxIncomeOrExpense(Integer quantity, Integer sumOfOne, Boolean isExpense){
        if (isExpense){
            setExpense(quantity * sumOfOne);
        }
        else {
            setLocalIncome(quantity * sumOfOne);
        }
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Boolean getExpense() {
        return isExpense;
    }

    public void setExpense(Boolean localExpense) {
        isExpense = localExpense;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSumOfOne() {
        return sumOfOne;
    }

    public void setSumOfOne(Integer sumOfOne) {
        this.sumOfOne = sumOfOne;
    }

    public Integer getLocalExpense() {
        return localExpense;
    }

    public void setExpense(Integer expense) {
        this.localExpense = expense;
    }

    public Integer getLocalIncome() {
        return localIncome;
    }

    public void setLocalIncome(Integer localIncome) {
        this.localIncome = localIncome;
    }

    @Override
    public String toString() {
        return "MonthEntry{" +
                "itemName='" + itemName + '\'' +
                ", isExpense=" + isExpense +
                ", quantity=" + quantity +
                ", sumOfOne=" + sumOfOne +
                '}';
    }
}
