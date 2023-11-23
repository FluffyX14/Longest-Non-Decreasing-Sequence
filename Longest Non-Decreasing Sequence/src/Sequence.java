public class Sequence {
	int longestSequenceLength = 0;
	int sequenceLengthCounter = 1;
	int multipleCounter = 0; //tracks number of longest sequences
	int [] multiplePositions = new int [13];
	
	//setters to reset
	public void setLongestSequenceLength(int longestSequenceLength) {
		this.longestSequenceLength = longestSequenceLength;
	}
	public void setSequenceLengthCounter(int sequenceLengthCounter) {
		this.sequenceLengthCounter = sequenceLengthCounter;
	}
	public void setMultipleCounter(int multipleCounter) {
		this.multipleCounter = multipleCounter;
	}
	public int getMultipleCounter() {
		return multipleCounter;
	}
	public void setMultiplePositions (int [] multiplePositions) {
		for (int i = 1; i < 12; i++) {
			multiplePositions [i] = 0;
		}
	}
	public int getSequenceLength(int [] array, int inputSize) {
		//resets all variables
		longestSequenceLength = 0;
		sequenceLengthCounter = 1;
		multipleCounter = 0;
		for (int i = 0; i < inputSize; i++) {
			multiplePositions[i] = 0;
		}
		
		for (int i = 1; i <= inputSize; i++) {
			if (array [i] >= array [i-1]) {
				sequenceLengthCounter++;
			}
			else {
				System.out.println(longestSequenceLength);
				if (sequenceLengthCounter > longestSequenceLength) { //if sequence > current longest sequence
					longestSequenceLength = sequenceLengthCounter;
					multiplePositions [multipleCounter] = i - sequenceLengthCounter; //marks first index of sequence
					if (multipleCounter == 0) {
						multipleCounter++;
					}
				}
				else if (sequenceLengthCounter == longestSequenceLength) { //if sequence = current longest sequence
					multiplePositions [multipleCounter] = i - sequenceLengthCounter; //marks first index of sequence
					multipleCounter++;
				}
				sequenceLengthCounter = 1;
			}
			
		}
		return longestSequenceLength;
	}
	public String getLongestSequence(int [] array) {
		String longestSequence = "";
		if (multipleCounter > 1) { //if there are multiple longest sequences
			for (int i = 0; i < multipleCounter; i++) {
				for (int j = 0; j < longestSequenceLength; j++) {
					longestSequence += (array[multiplePositions[i] + j] + " ");
				}
				longestSequence += "   ";
			}
		}
		else { //if there is only one longest sequence
			for (int i = 0; i < longestSequenceLength; i++) {
				longestSequence += (array[multiplePositions[multipleCounter] + i] + " ");
			}
		}
		return longestSequence;
	}
}
