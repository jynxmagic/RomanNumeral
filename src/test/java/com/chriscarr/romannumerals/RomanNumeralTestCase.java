package com.chriscarr.romannumerals;

import java.io.FileReader;
import java.io.Reader;

import org.apache.commons.csv.*;
import org.junit.Before;
import org.junit.Test;

import com.chriscarr.romannumerals.exception.IntegerOutOfBoundsException;

import junit.framework.TestCase;

public class RomanNumeralTestCase extends TestCase {
	
	private CSVParser roman_numerals_csv;
	private RomanNumeral rn;

	@Before
	public void setUp() throws Exception {
		Reader file = new FileReader("src/test/java/com/chriscarr/romannumerals/roman_numerals_test_data.csv");
		this.roman_numerals_csv = CSVFormat.EXCEL.withHeader().parse(file);
		this.rn = new RomanNumeral(1, 3999);
	}

	@Test
	public void testGenerate()
	{
		//first make sure our target range is correct
		this.testOutOfBounds();
		
		//second, test that all correct input values match correct output values
		this.testArabicToRomanConversion();
	}
	
	@Test(expected = IntegerOutOfBoundsException.class)
	public void testOutOfBounds()
	{
		assertEquals(null, rn.generate(4000));
		assertEquals(null, rn.generate(-400));
		assertEquals(null, rn.generate(0));
	}
	
	@Test
	public void testArabicToRomanConversion()
	{
		//iterate over csv and ensure arabic values 1-3999 return the coresponding roman value
		for(CSVRecord record : this.roman_numerals_csv)
		{
			//params: msg, expected, actual
			assertEquals(record.get("number") + " is " + record.get("roman_numeral") + " in roman numerals.",
							record.get("roman_numeral"), 
					      	rn.generate(Integer.parseInt(record.get("number"))));
		}
	}

}