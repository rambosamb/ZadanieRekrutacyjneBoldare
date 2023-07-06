import java.util.Scanner;

public class ZadanieRekrutacyjne {
    public static void main(String[] args) {
        System.out.println("Podaj liczbę w zł, np. 1,3");
       mainMethod();
    }

    public static void mainMethod (){
        int[] availableMoney = {1,3,5,10,20,200,100,100,10000};
        Scanner scanner = new Scanner(System.in);

        int numberOfRest = 0;
        double wantContinue = 0;
        while (numberOfRest < Integer.MAX_VALUE && wantContinue != 2) {
            System.out.println("Podaj wartość reszty (w zł, liczba musi być większa od 0): ");
            double rest = scanner.nextDouble();

            while (rest < 0){
                System.out.println("Napisz liczbę większą od 0!)");
                rest = scanner.nextDouble();
            }
            int restInGr = (int) (rest * 100);

            String[] money = {"5 zł", "2 zł", "1 zł", "50 gr", "20 gr", "10 gr", "5 gr", "2 gr", "1 gr"};

            for (int i = 0; i < money.length; i++) {
                int valueOfMoney = getValue(money[i]);

                if (restInGr >= valueOfMoney && availableMoney[i] > 0) {
                    int numberOfGivenMonet = restInGr / valueOfMoney;
                    int availavleNumberOfMoney = Math.min(numberOfGivenMonet, availableMoney[i]);

                    restInGr -= availavleNumberOfMoney * valueOfMoney;
                    availableMoney[i] -= availavleNumberOfMoney;

                    if (availavleNumberOfMoney > 0) {
                        System.out.println("Wydaj " + availavleNumberOfMoney + " monet " + money[i]);
                    }
                }
            }

            System.out.println("Czy chcesz kontynuować? 1 - tak, 2 - nie");
            wantContinue = scanner.nextDouble();
            while ((int) wantContinue != wantContinue || wantContinue < 1 || wantContinue > 2){
                System.out.println("Liczba musi wynosić 1 lub 2!");
                wantContinue = scanner.nextDouble();
            }
            numberOfRest++;
        }
    }


    public static int getValue(String moneta) {
        if (moneta.contains("gr")) {
            return Integer.parseInt(moneta.split(" ")[0]);
        } else {
            return Integer.parseInt(moneta.split(" ")[0]) * 100;
        }
    }
}
