package pl.edu.icm.cermine.metadata.affiliations.parsing;

import static org.junit.Assert.*;

import org.jdom.output.XMLOutputter;
import org.junit.Test;

import pl.edu.icm.cermine.exception.AnalysisException;
import pl.edu.icm.cermine.exception.TransformationException;

public class AffiliationParserTest {

	@Test
	public void testParseString() throws AnalysisException, TransformationException {
		AffiliationParser parser = new AffiliationParser();
		XMLOutputter outputter = new XMLOutputter();
		String input = "Department of Dinozauring, Dino Institute, Tyranosaurus Route 35, Boston, MA, USA";
		String expected = "<aff>" +
				"<institution>Department of Dinozauring, Dino Institute</institution>" +
				", " +
				"<addr-line>Tyranosaurus Route 35, Boston, MA</addr-line>" +
				", " +
				"<country>USA</country>" +
				"</aff>";
		String actual = outputter.outputString(parser.parseString(input));
		assertEquals(expected, actual);
	}

	@Test
	public void testParseStringWithAuthor() throws AnalysisException, TransformationException {
		AffiliationParser parser = new AffiliationParser(
				"common-words-affiliations-with-author.txt",
				"acrf-affiliations-with-author.ser.gz");
		XMLOutputter outputter = new XMLOutputter();
		String input = "Andrew McDino and Elizabeth Pterodactyl, Department of Dinozauring, Dino Institute, Tyranosaurus Route 35, Boston, MA, USA";
		String expected = "<aff>" +
				"<author>Andrew McDino and Elizabeth Pterodactyl</author>" +
				", " +
				"<institution>Department of Dinozauring, Dino Institute</institution>" +
				", " +
				"<addr-line>Tyranosaurus Route 35, Boston, MA</addr-line>" +
				", " +
				"<country>USA</country>" +
				"</aff>";
		String actual = outputter.outputString(parser.parseString(input));
		assertEquals(expected, actual);
	}

}
