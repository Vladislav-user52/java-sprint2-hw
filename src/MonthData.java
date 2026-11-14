public class MonthData {
    int [] days= new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println("День " + (i+1) + " - " + days[i] + " шагов");
        }
    }

    int sumStepsFromMonth() {
        int sumSteps=0;
        for (int i = 0; i < days.length; i++) {
            sumSteps += days[i];
        }
        return sumSteps ;
    }

    int maxSteps() {
        int maxStep = 0;
        for (int i = 0; i < days.length; i++) {
           if (days[i] > maxStep){
             maxStep = days[i];
           }
        }
        return maxStep;
    }

    int bestSeries(int goalByStepsPerDay) {
        int seriesCount = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                seriesCount ++;
                if (seriesCount > finalSeries) {
                    finalSeries = seriesCount;
                }

            } else {
                seriesCount = 0;
            }

        }
        return finalSeries;
    }

}
