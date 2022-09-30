public record complexNumber(double real, double imaginary) {

    public complexNumber complex_conjugate() {
        return new complexNumber(this.real, (this.imaginary) * -1);
    }

    public String toString() {
        return real + " + " + imaginary + "i";
    }

    public double modulus() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
    }

    public double argument() {
        if (this.imaginary == 0.0d && this.real == 0.0d) {
            return 0.0d;
        } else if (this.real == 0.0d) {
            if (this.imaginary > 0) {
                return Math.PI / 2;
            } else {
                return 1.5 * Math.PI;
            }
        } else if (this.imaginary == 0.0d) {
            if (this.real > 0) {
                return 0;
            } else {
                return Math.PI;
            }
        }
        return Math.atan(imaginary / real);
    }

    public String polar_form() {
        return this.modulus() + "e^i" + this.argument();
    }

    public String trigonometric_form() {
        return this.modulus() + "( cos( " + this.argument() + " ) + i sin( " + this.argument() + " )";
    }

    static complexNumber addition(complexNumber z, complexNumber w) {
        double a, b, c, d;
        a = z.real();
        b = z.imaginary();
        c = w.real();
        d = w.imaginary();

        return new complexNumber((a + c), (b + d));
    }

    static complexNumber subtraction(complexNumber z, complexNumber w) {
        double a, b;
        a = w.real() * -1;
        b = w.imaginary() * -1;
        complexNumber v = new complexNumber(a, b);

        return addition(z, v);
    }

    static complexNumber multiplication(complexNumber z, double lambda) {
        return new complexNumber(lambda * (z.real()), lambda * (z.imaginary()));
    }

    static complexNumber multiplication(complexNumber z, complexNumber w) {
        double a, b, c, d, x, y;
        a = z.real();
        b = z.imaginary();
        c = w.real();
        d = w.imaginary();

        x = a * c - b * d;
        y = a * d - b * c;

        return new complexNumber(x, y);
    }

    static complexNumber square(complexNumber z) {
        return multiplication(z, z);
    }

    static complexNumber division(complexNumber z, double lambda) {
        double divisor = 1 / lambda;
        return multiplication(z, divisor);
    }

    static complexNumber division(complexNumber z, complexNumber w) {
        double a, b, c, d, x, y;
        a = z.real();
        b = z.imaginary();
        c = w.real();
        d = w.imaginary();

        double v = Math.pow(c, 2.0) + Math.pow(d, 2.0);
        x = (a * c + b * d) / v;
        y = (b * c - a * d) / v;

        return new complexNumber(x, y);
    }
}
