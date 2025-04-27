public interface Calculator {
    double add(Double a, Double b) throws NullParameterException, OverflowException, UnderflowException;
    double divide(Double a, Double b) throws NullParameterException, MyArithmeticException;
    double average(Double[] numbers) throws NullParameterException, OverflowException, UnderflowException, MyArithmeticException;
}
