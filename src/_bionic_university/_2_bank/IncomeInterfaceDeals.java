package _bionic_university._2_bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IncomeInterfaceDeals {
    ArrayList<IncomeInterface> list = new ArrayList<>();

    public ArrayList initList() {
        list.add(new Depo(LocalDate.of(2012, 9, 8), 20, 1000.0, 15.0));
        list.add(new Depo(LocalDate.of(2012, 9, 8), 180, 1000.0, 15.0));
        list.add(new Depo(LocalDate.of(2014, 9, 8), 20, 1000.0, 15.0));
        list.add(new Depo(LocalDate.of(2014, 9, 8), 180, 1000.0, 15.0));
        list.add(new TBill(1000.0, 975.0, 1000, LocalDate.of(2015, 10, 31)));
        list.add(new TBill(1000.0, 920.0, 500, LocalDate.of(2015, 10, 31)));
        return list;
    }

    public double getPrincipalSum(List<? extends IncomeInterface> deals) {
        double sum = 0.0;
        for (IncomeInterface d : deals) {
            sum += d.getSum();
        }
        return sum;
    }

    public double getIncomeSum(List<? extends IncomeInterface> deals) {
        double sum = 0.0;
        for (IncomeInterface d : deals) {
            sum += d.getIncome();
        }
        return sum;
    }

}
