static int[][] shiftUp(int[][] numbers){
	if (numbers.length == 1) {
		return numbers;
	}
    int[] toBeMovedToBottom = numbers[0];
    for (int i=0; i<numbers.length-1; i++){
    	numbers[i] = numbers[i+1];
    }
    numbers[numbers.length-1] = toBeMovedToBottom;
    return numbers;
}

static int getLargestRectangle(int[][] rectangles) {
	int largest = 0;
	for (int i=0; i<rectangles.length; i++){
		int[] currRect = rectangles[i];
		int area = currRect[2] * currRect[3];
		if (area > largest) {
			largest = area;
		}
    }
	return largest;
}
