import javax.swing.*;
import BreezySwing.*;
public class Gui extends GBFrame {
	IntegerField input = addIntegerField (0, 1, 2, 1, 1);
	JButton enter = addButton("Add to Sequence", 1, 2, 1, 1);
	JButton reset = addButton("Reset", 2, 3, 1, 1);
	JButton output = addButton("Longest Sequence", 2, 2, 1, 1);
	JButton viewCurrentSequence = addButton ("View Current Sequence", 2, 1, 1, 1);
	int [] array = new int [26];
	int index = 0;
	int inputCounter = 0;
	Sequence calculator = new Sequence();
	JLabel counter = addLabel ("Number " + (inputCounter+1) + "/25:", 1, 1, 1, 1); //displays number of inputs
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == enter) {
			if (input.getText().isBlank()) { //error checks for empty input
				messageBox("Please input a number");
			}
			else if (input.isValidNumber()) {
				if (inputCounter == 25) { //limits inputs to 25
					messageBox("You cannot input any more numbers");
				}
				else {
					array[index] = input.getNumber(); //enters input into array
					index++;
					inputCounter++;
					input.setText("");
					input.grabFocus();
					if (inputCounter == 25) { //tells when array is full
						counter.setText ("Sequence Filled");
					}
					else { //displays number of inputs
						counter.setText ("Number " + (inputCounter+1) + "/25");
					}
				}
			}
			else { //error checks for non-numbers
				messageBox("Invalid input");
			}
		}
		if (buttonObj == reset) { //resets all variables
			for (int i = 0; i < array.length; i++) {
				int [] reset = new int [13];
				array[i] = 0;
				inputCounter = 0;
				index = 0;
				calculator.setLongestSequenceLength(0);
				calculator.setSequenceLengthCounter(1);
				calculator.setMultipleCounter(0);
				calculator.setMultiplePositions(reset);
				
				counter.setText ("Number " + (inputCounter+1) + "/25");
			}
		}
		if (buttonObj == viewCurrentSequence) { //displays current sequence
			String currentSequence = "";
			for (int i = 0; i < inputCounter; i++) {
				currentSequence += array[i] + " ";
			}
			messageBox(currentSequence);
		}
		if (buttonObj == output) { //displays longest non-decreasing sequence
		int answer = calculator.getSequenceLength(array, inputCounter);
		String answer2 = calculator.getLongestSequence(array);
			if (calculator.getMultipleCounter() == 0) {
				messageBox("There are no non-decreasing sequences");
			}
			else {
				messageBox("Length of longest sequence: " + answer + "   Longest sequence: " + answer2);
			}
		}
	}
	//outputs GUI
	public static void main(String[] args) {
		JFrame frm = new Gui();
		frm.setTitle("Longest Non-Decreasing Sequence");
		frm.setSize(600, 300);
		frm.setVisible(true);
	}
}
