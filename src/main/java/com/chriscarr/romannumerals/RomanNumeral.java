package com.chriscarr.romannumerals;

import com.frequal.romannumerals.Converter;

public class RomanNumeral implements RomanNumeralInterface {
	
	Converter converter; //library allows for public use with GNU license. See: http://frequal.com/RomanNumerals/index.html
	int minRange;
	int maxRange;
	
	RomanNumeral(int minRange, int maxRange)
	{
		this.converter = new Converter();
		this.minRange = minRange;
		this.maxRange = maxRange;
	}

	public String generate(int number) 
	{
		String romanNumerals = null;
		
		if(number > maxRange || number < minRange) return "-1"; //-1 is used as a flag that an incorrect number was used
		
		try
		{
			romanNumerals = this.converter.toRomanNumerals(number);
		}
		catch(Exception e)
		{
			System.out.println("Error occured whilst attempting to convert number.");
			e.printStackTrace();
		}
		
		return romanNumerals;
	}

}
