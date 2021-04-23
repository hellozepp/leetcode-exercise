package leetcodeAll.leetcode;

/**
 * 6. ZigZag Conversion
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P A H N A P L S I I G Y I R And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * @author Watcher
 *
 */
public class ZigZagConversion {

	/**
	 * 找规律
	 * 
	 * @param s
	 * @param nRows
	 * @return
	 */
	public String convert(String s, int nRows) {
		if (s == null || s.length() == 0 || nRows <= 0)
			return "";
		if (nRows == 1)
			return s;

		StringBuilder res = new StringBuilder();
		int size = 2 * nRows - 2;
		for (int i = 0; i < nRows; i++) {
			for (int j = i; j < s.length(); j += size) {
				res.append(s.charAt(j));
				if (i != 0 && i != nRows - 1) { // except the first row and the
												// last row
					int temp = j + size - 2 * i;
					if (temp < s.length())
						res.append(s.charAt(temp));
				}
			}
		}
		return res.toString();
	}
}
