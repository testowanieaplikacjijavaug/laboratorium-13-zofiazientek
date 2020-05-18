package zad1.testJBehave;

public class FizzBuzz {
    private int n;
    public void setNumber(int number) {
        n = number;
    }
    public String check(int number) {
        if (number == 0) throw new IllegalArgumentException("Number must not be 0");
        else if (number % 15 == 0) return "FizzBuzz";
        else if (number % 3 == 0) return "Fizz";
        else if (number % 5 == 0) return "Buzz";
        return String.valueOf(number);
    }
}