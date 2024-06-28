import java.util.Scanner;

public class ComplexNumberCalculator {
    private double real;
    private double imaginary;

    public ComplexNumberCalculator(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumberCalculator add(ComplexNumberCalculator other) {
        return new ComplexNumberCalculator(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumberCalculator multiply(ComplexNumberCalculator other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumberCalculator(newReal, newImaginary);
    }

    public ComplexNumberCalculator divide(ComplexNumberCalculator other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        if (denominator == 0) {
            throw new ArithmeticException("Деление на ноль.");
        }
        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumberCalculator(newReal, newImaginary);
    }

    @Override
    public String toString() {
        return "(" + real + " + " + imaginary + "i)";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите действительную часть первого комплексного числа: ");
        double real1 = scanner.nextDouble();
        System.out.print("Введите мнимую часть первого комплексного числа: ");
        double imaginary1 = scanner.nextDouble();
        ComplexNumberCalculator first = new ComplexNumberCalculator(real1, imaginary1);

        System.out.print("Введите действительную часть второго комплексного числа: ");
        double real2 = scanner.nextDouble();
        System.out.print("Введите мнимую часть второго комплексного числа: ");
        double imaginary2 = scanner.nextDouble();
        ComplexNumberCalculator second = new ComplexNumberCalculator(real2, imaginary2);

        ComplexNumberCalculator sum = first.add(second);
        ComplexNumberCalculator product = first.multiply(second);
        ComplexNumberCalculator quotient = first.divide(second);

        System.out.println("Сумма: " + sum);
        System.out.println("Произведение: " + product);
        System.out.println("Частное: " + quotient);

        scanner.close();
    }
}