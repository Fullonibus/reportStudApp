import java.util.ArrayList;

public class FinanceHandler {
    private ArrayList<MonthData> monthDataArrayList;
    private ArrayList<YearData> yearDataArrayList;
    int errorCounter = 0;

    public FinanceHandler(ArrayList<YearData> yearDataArrayList, ArrayList<MonthData> monthDataArrayList){
        setYearDataArrayList(yearDataArrayList);
        setMonthDataArrayList(monthDataArrayList);
    }

    public void setMonthDataArrayList(ArrayList<MonthData> monthDataArrayList) {
        this.monthDataArrayList = monthDataArrayList;
    }

    public void setYearDataArrayList(ArrayList<YearData> yearDataArrayList) {
        this.yearDataArrayList = yearDataArrayList;
    }

    public void compareYearAndMonth(){
        for (YearData yearData: yearDataArrayList){
            for (MonthData monthData: monthDataArrayList){
                for (YearEntry yearEntry: yearData.getYearEntries()){
                    if (yearEntry.getMonth().equals(monthData.getMonthName())){
                        if (yearEntry.getIsExpense()){
                            expenseComparator(yearEntry, monthData);
                        }
                        else{
                            incomeComparator(yearEntry, monthData);
                        }
                    }

                }
            }
        }
        if (errorCounter == 0){
            System.out.println(FinalVariables.ANSI_GREEN + "Успешное завершение операции" + FinalVariables.ANSI_RESET);
        }
    }

    private void expenseComparator(YearEntry yearEntry, MonthData monthData){
        if (yearEntry.getAmount() > monthData.getExpense()){
            System.out.println("Обнаружено несоответствие: в месяце " + monthData.getMonthName() + " " +monthData.getYearName() +
                    " года значение расходов в годовом отчете больше чем в месячном " + yearEntry.getAmount() + " vs " + monthData.getExpense());
            errorCounter += 1;
        }
        else if(yearEntry.getAmount() < monthData.getExpense()){
            System.out.println("Обнаружено несоответствие: в месяце " + monthData.getMonthName() + " " +monthData.getYearName() +
                    " года значение расходов в годовом отчете меньше чем в месячном " + yearEntry.getAmount() + " vs " + monthData.getExpense());
            errorCounter +=1;
        }
    }

    private void incomeComparator(YearEntry yearEntry, MonthData monthData){
        if (yearEntry.getAmount() > monthData.getIncome()){
            System.out.println("Обнаружено несоответствие: в месяце " + monthData.getMonthName() + " " + monthData.getYearName() +
                    " года значение доходов в годовом отчете больше чем в месячном " + yearEntry.getAmount() + " vs " + monthData.getIncome());
            errorCounter += 1;
        }
        else if(yearEntry.getAmount() < monthData.getIncome()){
            System.out.println("Обнаружено несоответствие: в месяце " + monthData.getMonthName() +  " " + monthData.getYearName() +
                    " года значение доходов в годовом отчете меньше чем в месячном " + yearEntry.getAmount() + " vs " + monthData.getIncome());
        }
    }

    public void showMonthExpenses(){
        for (MonthData month: monthDataArrayList){
            System.out.println(FinalVariables.ANSI_BLUE + "Год: " + month.getYearName() +" Месяц: " + month.getActualMonthName() + FinalVariables.ANSI_RESET);
            System.out.println(FinalVariables.ANSI_GREEN +"\tДоходы: "+ month.getIncome() + FinalVariables.ANSI_RED +"\n\tРасходы: " + month.getExpense() + FinalVariables.ANSI_RESET);
            month.showMaxExpenseAndIncome();
        }
    }
    public void showYearData(){
        double expenseSum = 0;
        double incomeSum = 0;
        int monthCounter = 0;
        for (YearData yearData: yearDataArrayList){
            System.out.println(FinalVariables.ANSI_BLUE + "Информация за " + yearData.getYearName() + " год:" + FinalVariables.ANSI_RESET);
            for (MonthData monthData: monthDataArrayList){
                if (yearData.getYearName().equals(monthData.getYearName())){
                    System.out.println("\tПрибыль за " + monthData.getActualMonthName() + " составила " + (monthData.getIncome() - monthData.getExpense()));
                    expenseSum +=  monthData.getExpense();
                    incomeSum +=  monthData.getIncome();
                    monthCounter += 1;
                }
            }
            System.out.println( FinalVariables.ANSI_RED + "\t\tСредний расход за все месяцы в году: " + (expenseSum/monthCounter) + FinalVariables.ANSI_RESET);
            System.out.println(FinalVariables.ANSI_GREEN + "\t\tСредний доход за все месяцы в году: " + (incomeSum/monthCounter) + FinalVariables.ANSI_RESET);
            expenseSum = 0;
            incomeSum = 0;
            monthCounter = 0;
        }
    }

}
