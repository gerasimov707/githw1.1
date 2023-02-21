import java.util.Scanner;

public class Main {
    public static String[] products = new String[]{"Хлеб", "Пачка гречки", "Упаковка яиц", "Мороженка"};
    public static int[] prices = new int[]{50, 135, 65, 53};
    public static int MIN_COST_FOR_BONUS = 1000;

    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в магазин!");
        System.out.println("Наш ассортимент:");

        for(int i = 0; i < products.length; ++i) {
            System.out.println("\t" + (i + 1) + ". " + products[i] + " за " + prices[i] + " за шт. ");
        }

        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int[] counts = new int[products.length];

        while(true) {
            System.out.print("Введите номер товара и количество через пробел или end: ");
            String line = scanner.nextLine();
            int i;
            if ("end".equals(line)) {
                System.out.println("Ваша корзина покупок:");
                int sum = 0;

                for(i = 0; i < products.length; ++i) {
                    sum += prices[i] * counts[i];
                }

                boolean doBonus = sum >= MIN_COST_FOR_BONUS;

                for(i = 0; i < products.length; ++i) {
                    if (counts[i] != 0) {
                        String var10001 = products[i];
                        System.out.println("\t" + var10001 + " " + (doBonus ? counts[i] + 1 : counts[i]) + " шт. за " + prices[i] * counts[i] + " руб.");
                    }
                }

                System.out.println("Итого: " + sum + " руб.");
                return;
            }

            String[] parts = line.split(" ");
            i = Integer.parseInt(parts[0]) - 1;
            int productCount = Integer.parseInt(parts[1]);
            counts[i] += productCount;
        }
    }
}
