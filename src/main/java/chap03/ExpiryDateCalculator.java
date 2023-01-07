package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData){
        int addedMonths = checkAddedMonths(payData.getPayAmount());
        if(payData.getFirstBillingDate() != null){
            return expiryDateUsingFirstBillingDate(payData,addedMonths);
        }else {
            return payData.getBillingDate().plusMonths(addedMonths);
        }
    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths){
        LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
        if (isSameDayOfMonth(payData.getFirstBillingDate(), candidateExp)){
            final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
            final int dayLenOfCandiMon = lastDayOfMonth(candidateExp);
            if (dayLenOfCandiMon < payData.getFirstBillingDate().getDayOfMonth()){
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(dayOfFirstBilling);
        } else {
            return candidateExp;
        }
    }

    private boolean isSameDayOfMonth(LocalDate date1, LocalDate date2){
        return date1.getDayOfMonth() != date2.getDayOfMonth() ? true : false;
    }

    private int lastDayOfMonth(LocalDate date){
        return YearMonth.from(date).lengthOfMonth();
    }

    private int checkAddedMonths(int payAmount){
        final int addMonthBigStandard = 100_000;
        final int addMonthStandard = 10_000;

        return payAmount >= addMonthBigStandard ?
                ((payAmount / addMonthBigStandard) * 12) + ((payAmount % addMonthBigStandard)/ addMonthStandard)
                : payAmount / addMonthStandard;
    }
}
