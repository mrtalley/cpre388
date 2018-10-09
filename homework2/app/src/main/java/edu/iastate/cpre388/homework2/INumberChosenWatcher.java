package edu.iastate.cpre388.homework2;

/**
 * An interface for a class that wants to monitor a number chooser fragment.
 */
interface INumberChosenWatcher {
    // define a callback function to receive a number chosen event.  Use it to pass the number.
    void numberChosen(int chosenNumber);

}
