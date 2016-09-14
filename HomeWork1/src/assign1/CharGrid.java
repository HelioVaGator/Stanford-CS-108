// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

package assign1;

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {

		int height = grid.length;
		int width = grid[0].length;

		int minX = width;
		int minY = height;
		int maxX = 0;
		int maxY = 0;

		//flag to check if ch present
		boolean chFound = false;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if(grid[i][j] == ch) {
					minX = i<minX?i:minX;
					minY = j<minY?j:minY;

					maxX = i>maxX?i:maxX;
					maxY = j>maxY?j:maxY;
					chFound = true;
				}

			}
		}

		if(chFound) {
			return (maxX-minX+1) * (maxY-minY+1);
		} else {
			System.out.println("Character: " + ch + " not found in grid");
			return 0;
		}
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {

		int height = grid.length;
		int width = grid[0].length;

		int plusCount = 0;

		if(height < 3 || width < 3) {
			System.out.println("Dimension of grid is short to form plus");
			return 0;
		}


		//x:j width, y:i height
		for (int i = 1; i < (height-1); i++) {
			for (int j = 1; j < (width-1); j++) {
				System.out.println("x:" + j + ",y:" + i);
				if(isPlus(i, j, height, width)) {
					plusCount++;
				}
			}
		}

		return plusCount;
	}

	private boolean isPlus(int y, int x, int height, int width) {
		int rightEnd = 0;
		int leftEnd = 0;
		int upEnd = 0;
		int bottomEnd = 0;

		if(isPlusSeed(x, y)) {
			//find end of right arm
			for (int i = x+1; i < width; i++) {
				if(grid[y][x] == grid[y][i]) {
					rightEnd = i;
				} else {
					//break if continuity breaks
					break;
				}
			}

			//find end of left arm
			for (int i = x-1; i >= 0; i--) {
				if(grid[y][x] == grid[y][i]) {
					leftEnd = i;
				} else {
					//break if continuity breaks
					break;
				}
			}

			//find end of bottom arm
			for (int i = y+1; i < height; i++) {
				if(grid[y][x] == grid[i][x]) {
					bottomEnd = i;
				} else {
					//break if continuity breaks
					break;
				}
			}

			//find end of up arm
			for (int i = y-1; i >= 0; i--) {
				if(grid[y][x] == grid[i][x]) {
					upEnd = i;
				} else {
					//break if continuity breaks
					break;
				}
			}


				if ((rightEnd - x == x - leftEnd) &&
						(bottomEnd - y == y - upEnd) &&
						(rightEnd - x == bottomEnd -y)) {
					return true;
				} else {
					return false;
				}

		} else {
			System.out.println("Not a plus seed");
			return false;
		}
	}


	/**
	 * a b a
	 * b b b     this pattern can be considered as seed for b
	 * c b f
	 * @param x x coordinate of seed
	 * @param y y coordinate of seed
     * @return true/false
     */
	private boolean isPlusSeed(int x, int y) {
		//System.out.println(x + "," + y);
		if(grid[y][x] == grid[y-1][x] &&
				grid[y][x] == grid[y][x-1] &&
				grid[y][x] == grid[y+1][x] &&
				grid[y][x] == grid[y][x+1]) {
			return true;
		} else {
			return false;
		}
	}


}
