package com.chriscarr.romannumerals;

import com.github.fracpete.romannumerals4j.RomanNumeralFormat;

public class RomanNumeral implements RomanNumeralInterface {
	
	RomanNumeralFormat converter; //library allows for public use with Creative commons license. See: https://github.com/fracpete/romannumerals4j/blob/master/LICENSE.txt
	int minRange;
	int maxRange;
	
	RomanNumeral(int minRange, int maxRange)
	{
		this.converter = new RomanNumeralFormat();
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
		String romanNumerals = null;
		
		if(number > maxRange || number < minRange) return "-1"; //-1 is used as a flag that an incorrect number was used
		
		try
		{
			romanNumerals = this.converter.format(number);
		}
		catch(Exception e)
		{
			System.out.println("Error occured whilst attempting to convert number.");
			e.printStackTrace();
		}
		
		return romanNumerals;
	}

}