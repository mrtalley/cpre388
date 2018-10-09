package netid.iastate.edu.calculatorapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /**
     * The instance of the calculator model for use by this controller.
     */
    private CalculatorModel calculatorModel = new CalculatorModel();

    /*
     * The instance of the calculator display TextView. You can use this to update the calculator display.
     */
    TextView calculatorDisplay;

    Button operatorButton;

    int expressionToDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO - uncomment below after layout has been made.
        // Locate the instace of the calculator display TextView.  Don't forget to set the ID in the layout file.
         calculatorDisplay = findViewById(R.id.CalculatorDisplay);
         expressionToDisplay = 1;

        // TODO - use the data in the calculatorModel to set the text of calculatorDisplay.
        updateDisplay(calculatorModel.getInitialText());
    }

    // TODO - from your layout, hook up these event handlers to the appropriate buttons.
    public void onZeroClicked(View view) {
        calculatorModel.buttonPress("0");
        updateDisplayWithExpression();
    }

    public void onOneClicked(View view) {
        calculatorModel.buttonPress("1");
        updateDisplayWithExpression();
    }

    public void onTwoClicked(View view) {
        calculatorModel.buttonPress("2");
        updateDisplayWithExpression();
    }

    public void onThreeClicked(View view) {
        calculatorModel.buttonPress("3");
        updateDisplayWithExpression();
    }

    public void onFourClicked(View view) {
        calculatorModel.buttonPress("4");
        updateDisplayWithExpression();
    }

    public void onFiveClicked(View view) {
        calculatorModel.buttonPress("5");
        updateDisplayWithExpression();
    }

    public void onSixClicked(View view) {
        calculatorModel.buttonPress("6");
        updateDisplayWithExpression();
    }

    public void onSevenClicked(View view) {
        calculatorModel.buttonPress("7");
        updateDisplayWithExpression();
    }

    public void onEightClicked(View view) {
        calculatorModel.buttonPress("8");
        updateDisplayWithExpression();
    }

    public void onNineClicked(View view) {
        calculatorModel.buttonPress("9");
        updateDisplayWithExpression();
    }

    public void onDecimalClicked(View view) {
        calculatorModel.buttonPress(".");
        updateDisplayWithExpression();
    }

    public void onPlusClicked(View view) {
        calculatorModel.setOperator("+");
        clearDisplay();

        if(calculatorModel.getSelectedExpression() == 1) {
            calculatorModel.setSelectedExpression(2);
            updateDisplay("0");
        }

        else {
            calculatorModel.addNumbers();
            updateDisplayWithTotal();
            calculatorModel.setSelectedExpression(2);
        }
    }

    public void onMinusClicked(View view) {
        calculatorModel.setOperator("-");
        clearDisplay();

        if(calculatorModel.getSelectedExpression() == 1) {
            calculatorModel.setSelectedExpression(2);
            updateDisplay("0");
        }

        else {
            calculatorModel.subtractNumbers();
            updateDisplayWithTotal();
            calculatorModel.setSelectedExpression(2);
        }
    }

    public void onTimesClicked(View view) {
        calculatorModel.setOperator("*");
        clearDisplay();

        if(calculatorModel.getSelectedExpression() == 1) {
            calculatorModel.setSelectedExpression(2);
            updateDisplay("0");
        }

        else {
            calculatorModel.multiplyNumbers();
            updateDisplayWithTotal();
            calculatorModel.setSelectedExpression(2);
        }
    }

    public void onDivideClicked(View view) {
        calculatorModel.setOperator("/");
        clearDisplay();

        if(calculatorModel.getSelectedExpression() == 1) {
            calculatorModel.setSelectedExpression(2);
            updateDisplay("0");
        }

        else {
            calculatorModel.divideNumbers();
            updateDisplayWithTotal();
            calculatorModel.setSelectedExpression(2);
        }
    }

    // TODO: finish calculation when button clicked
    public void onEqualClicked(View view) {
        calculatorModel.calculateTotal();
        updateDisplayWithTotal();
        calculatorModel.setSelectedExpression(1);
    }

    public void onClearClicked(View view) {
        calculatorModel.clear();
        updateDisplay("0");
        calculatorModel.setSelectedExpression(1);
    }

    //TODO - any other methods you want to use related to the UI
    private String totalToString() {
        double total = calculatorModel.getTotal();
        String stringTotal = Double.toString(total);

        return stringTotal;
    }

    private void updateDisplay(String text) {
        calculatorDisplay.setText(text);
    }

    private void updateDisplayWithExpression() {
        if(calculatorModel.getSelectedExpression() == 1) {
            updateDisplay(calculatorModel.getExpression1());
        }

        else {
            updateDisplay(calculatorModel.getExpression2());
        }
    }

    private void updateDisplayWithTotal() {
        updateDisplay(totalToString());
    }

    private void clearDisplay() {
        updateDisplay("");
    }

}
