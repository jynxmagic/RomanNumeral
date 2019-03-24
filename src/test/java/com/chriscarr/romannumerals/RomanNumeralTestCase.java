package com.chriscarr.romannumerals;

import java.io.FileReader;
import java.io.Reader;

import org.apache.commons.csv.*;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class RomanNumeralTestCase extends TestCase {
	
	private CSVParser roman_numerals_csv;

	@Before
	public void setUp() throws Exception {
		Reader file = new FileReader("src/test/java/com/chriscarr/romannumerals/roman_numerals_test_data.csv");
		this.roman_numerals_csv = CSVFormat.EXCEL.withHeader().parse(file);
	}

	@Test
	public void testGenerate() {
		
		RomanNumeral rn = new RomanNumeral(1, 3999);
		
		
		//first make sure our target range is correct
		assertEquals("-1", rn.generate(4000));
		assertEquals("-1", rn.generate(-400));
		assertEquals("-1", rn.generate(0));
		
		
		//then ensure that all values are correct to the testing data supplied
		for(CSVRecord record : this.roman_numerals_csv)
		{
			System.out.println(record.getRecordNumber());
			//params: msg, expected, actual
			assertEquals(record.get("number") + " is " + record.get("roman_numeral") + " in roman numerals.",
							record.get("roman_numeral"), 
					      	rn.generate(Integer.parseInt(record.get("number"))));
		}
	}

}