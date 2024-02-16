import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        generatorStr();
    }

    public static void generatorStr() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> card = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            card.add(random.nextInt(9) + 1);
        }
        for (int i = 0; i < card.size(); i++) {
            stringBuilder.append(card.get(i));
        }
        String strCard = stringBuilder.toString();
        int temp = 0;
        System.out.println("Generated Card Number: " + strCard);

        for (int i = 0; i < strCard.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(strCard.charAt(i)));
            int tmp1 = (i % 2 == strCard.length() % 2) ? digit * 2 : digit;

            if (tmp1 > 9) {
                temp += tmp1 - 9;
            } else {
                temp += tmp1;
            }
        }

        if (temp % 10 == 0) {
            System.out.println("Card number is valid    ");
        } else {
            System.out.println("Card number is NOT valid");
        }
    }
}
