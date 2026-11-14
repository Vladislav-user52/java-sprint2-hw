import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {

            // сделать switch
            printMenu();
            if (!scanner.hasNextInt()) { //проверка на целое число
                System.out.println("Нужно ввести целое число");
                scanner.next();
                return;
            }
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case 2:
                    stepTracker.changeStepGoal();
                    break;
                case 3:
                    stepTracker.printStatistic();
                    break;
                case 4:
                    System.out.println("Программа завершена!");
                    return;
                default:
                    System.out.println("Введена неверная команда");
            }

        }
    }

    static void printMenu() {
        System.out.println("Введите команду: ");
        System.out.println("ввести количество шагов за день - 1");
        System.out.println("изменить цель по количеству шагов в день - 2");
        System.out.println("напечатать статистику за месяц - 3");
        System.out.println("выйти из приложения - 4");
    }
}
