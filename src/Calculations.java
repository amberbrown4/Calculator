import java.util.Scanner;

public class Calculations {
private int finalAnswer = 0;
    public Calculations(String get) {
       // Scanner scanner = new Scanner(System.in);
        String string = get;

        String[] answer = string.split("(?=[+-])");
        int[] answerInt = new int[answer.length];

        for (int i = 0; i < answer.length; i++) {
            answerInt[i] = Integer.parseInt(answer[i]);
        }

        for (int i = 0; i < answerInt.length; i++) {
            finalAnswer += answerInt[i];
        }
        System.out.println(finalAnswer);

    }
    public int getFinalAnswer(){
        return finalAnswer;
    }
}