import java.util.Scanner;
public class StepTracker {
    Converter converter = new Converter();
    MonthData[] monthToData= new MonthData[12];
    Scanner scanner;
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner=scan;
        for (int i = 0; i < monthToData.length; i++){
            monthToData[i]=new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца (от 1 до 12):");
        if (!scanner.hasNextInt()) {
            System.out.println("Нужно ввести целое число");
            scanner.next();
            return;
        }
        int month = scanner.nextInt();

        if (month > 12 || month < 1) {
            System.out.println("Неверный номер месяца, должно быть число от 1 до 12");
            return;
        }

        System.out.println("Введите номер дня (от 1 до 30):");
        if (!scanner.hasNextInt()) {
            System.out.println("Нужно ввести целое число");
            scanner.next();
            return;
        }
        int day = scanner.nextInt();
        if (day > 30 || day < 1) {
            System.out.println("Неверный номер дня, должно быть число от 1 до 30");
            return;
        }

        System.out.println("Введите количество шагов:");

        if (!scanner.hasNextInt()) {
            System.out.println("Нужно ввести целое число");
            scanner.next();
            return;
        }
        int step = scanner.nextInt();

        if (step <= 0) {
            System.out.println("Неверное количество шагов");
            return;
        }

        MonthData monthData=monthToData[month-1];
        monthData.days[day-1]=step;
    }

    void changeStepGoal() {
        System.out.println("Введите цель по количеству шагов:");

        if (!scanner.hasNextInt()) {
            System.out.println("Нужно ввести целое число");
            scanner.next();
            return;
        }
        int newGoal = scanner.nextInt();

        if (newGoal <= 0) {
            System.out.println("Неверное целевое количество шагов");
            return;
        }

        goalByStepsPerDay = newGoal;
    }

    void printStatistic() {
        System.out.println("Введите номер месяца (от 1 до 12):");
        if (!scanner.hasNextInt()) {
            System.out.println("Нужно ввести целое число");
            scanner.next();
            return;
        }
        int month = scanner.nextInt();

        if (month >= 1 && month <= 12) {
            MonthData monthData = monthToData[month - 1];
            monthData.printDaysAndStepsFromMonth();
            System.out.println("общее количество шагов за месяц - " + monthData.sumStepsFromMonth());
            System.out.println("максимальное пройденное количество шагов в месяце - " + monthData.maxSteps());
            System.out.println("среднее количество шагов - " + monthData.sumStepsFromMonth() / monthData.days.length);
            System.out.println("пройденная дистанция - " + converter.convertToKm(monthData.sumStepsFromMonth()) + "км");
            System.out.println("количество сожжённых килокалорий - "
                    + converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()));
            System.out.println("лучшая серия дней - " + monthData.bestSeries(goalByStepsPerDay));
            System.out.println(" ");
        } else {
            System.out.println("Неверный номер месяца");
        }
    }
}
