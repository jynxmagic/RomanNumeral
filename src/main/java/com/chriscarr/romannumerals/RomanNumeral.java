package com.chriscarr.romannumerals;

import com.chriscarr.romannumerals.exception.IntegerOutOfBoundsException;

public class RomanNumeral implements RomanNumeralInterface {
	

	int minRange;

	int maxRange;
	
	private final String[][] numerals = {
			{"", "M", "MM", "MMM"},
			{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
			{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
			{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}
	};
	
	/**
	 * @param minRange
	 * @param maxRange
	 */
	RomanNumeral(int minRange, int maxRange)
	{
		this.minRange = minRange;
		this.maxRange = maxRange;
	}

	/**
	 * 
	 * @param number between 1 & 3999
	 * @return String of Roman Numerals
	 */
	public String generate(int number)
	{
		if(number > maxRange || number < minRange)
		{
			// throw exception if the given value is outside of range.
			// exception is thrown with try/catch so as to not change the provided interface, 
			// in case other team members are working with this interface
			try 
			{
				throw new IntegerOutOfBoundsException(number);
			}
			catch (IntegerOutOfBoundsException e) 
			{
				e.printStackTrace();
			} 
			return null;
		}
	    return this.convertToRoman(number);
	}
	
	/**
	 * @param Integer arabic
	 * @return String
	 */
	private String convertToRoman(int arabic)
	{
		int remainder = arabic;
		
		String romanNumeral = "";
		
		int j = 1000;
		
		for(int i = 0; i < numerals.length; i++)
		{
			romanNumeral += numerals[i][(int)Math.floor(remainder/j)];
			remainder %= j;
			j /= 10;
		}
		
		return romanNumeral;
	}

}