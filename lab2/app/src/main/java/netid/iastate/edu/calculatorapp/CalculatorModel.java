package netid.iastate.edu.calculatorapp;

public class CalculatorModel {
    /**
     * A string builder to represent the first number entered in the series of entries
     */
    private StringBuilder expression1;

    /**
     * A string builder to represent the second number entered in the series of entries
     */
    private StringBuilder expression2;

    /**
     * A string to represent the last operator performed
     */
    private String operator;

    private String initialText;

    private int selectedExpression;

    CalculatorModel() {
        // Main Strings to represent the expressions
        expression1 = new StringBuilder();
        expression2 = new StringBuilder();
        operator = new String();
        initialText = new String("0");
        selectedExpression = 1;
    }

    /**
     * This method appends to string builders the buttons that are pressed
     * @param button that was pressed as a string
     */
    public void buttonPress(String button) {
        if(selectedExpression == 1 && expression1.length() < 9) {
            expression1.append(button);
        }

        else if(selectedExpression == 2 && expression2.length() < 9) {
            expression2.append(button);
        }
    }

    //TODO - add other calculator logic methods you want to use in this calculator model class
    public double getTotal() {
        return Double.parseDouble(expression1.toString());
    }

    public void addNumbers() {
        double firstExpression = Double.parseDouble(expression1.toString());
        double secondExpression = Double.parseDouble(expression2.toString());
        double total;

        total = firstExpression + secondExpression;

        total = roundTotal(total);

        expression1 = new StringBuilder(Double.toString(total));
        expression2 = new StringBuilder();
    }

    public void subtractNumbers() {
        double firstExpression = Double.parseDouble(expression1.toString());
        double secondExpression = Double.parseDouble(expression2.toString());
        double total;

        total = firstExpression - secondExpression;

        total = roundTotal(total);

        expression1 = new StringBuilder(Double.toString(total));
        expression2 = new StringBuilder();
    }

    public void multiplyNumbers() {
        double firstExpression = Double.parseDouble(expression1.toString());
        double secondExpression = Double.parseDouble(expression2.toString());
        double total;

        total = firstExpression * secondExpression;

        total = roundTotal(total);

        expression1 = new StringBuilder(Double.toString(total));
        expression2 = new StringBuilder();
    }

    public void divideNumbers() {
        double firstExpression = Double.parseDouble(expression1.toString());
        double secondExpression = Double.parseDouble(expression2.toString());
        double total;

        total = firstExpression / secondExpression;

        total = roundTotal(total);

        expression1 = new StringBuilder(Double.toString(total));
        expression2 = new StringBuilder();
    }

    public void clear() {
        expression1 = new StringBuilder();
        expression2 = new StringBuilder();
        operator = "";
        selectedExpression = 1;
    }

    public void calculateTotal() {
        if(expression1.toString() == "" || expression2.toString() == "") {
            return;
        }

        if(operator == "+") {
            addNumbers();
        }

        else if(operator == "-") {
            subtractNumbers();
        }

        else if(operator == "*") {
            multiplyNumbers();
        }

        else if(operator == "/") {
            divideNumbers();
        }

        expression2 = new StringBuilder();
    }

    private double roundTotal(double total) {
        double whole = Math.round(total);
        int places = Double.toString(whole).length();

        return roundNumber(total, 11 - places);
    }

    private double roundNumber(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public String getInitialText() {
        return initialText;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getSelectedExpression() {
        return selectedExpression;
    }

    public void setSelectedExpression(int value) {
        selectedExpression = value;
    }

    public String getExpression1() {
        return expression1.toString();
    }

    public String getExpression2() {
        return expression2.toString();
    }
}
