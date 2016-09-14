//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.
package assign1;

import java.awt.event.HierarchyEvent;

public class TetrisGrid {


	private boolean grid[][];
	private int height;
	private int width;
	
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
		height = grid[0].length;
		width = grid.length;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {

		for (int i = 0; i < height; i++) {
			while(isRowFull(i)) {
				shiftRowDown(i);
			}
		}


	}

	private void shiftRowDown(int filledHeight) {

		//System.out.println(height + ", wd:" + width);
		for (int i = filledHeight; i < height-1; i++) {
			for (int j = 0; j < width; j++) {
				grid[j][i] = grid[j][i+1];
			}
		}

		//fill the top row with false
		for (int j = 0; j < width; j++) {
			grid[j][height-1] = false;
		}

	}

	private boolean isRowFull(int heightToCheck) {

		//check if row has true
		if(!grid[0][heightToCheck]) {
			return false;
		} else {
			//check if all element of row is true
			for (int i = 0; i < width-1; i++) {
				if(grid[i][heightToCheck] != grid[i+1][heightToCheck]) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid;
	}

	public void printGrid() {
		for (int i = height-1; i >= 0; i--) {
			for (int j = 0; j < width; j++) {
				System.out.printf("%-8s",grid[j][i] + ", ");
			}

			System.out.println();
		}
	}
}
