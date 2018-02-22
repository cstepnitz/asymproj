package chris.businesscards.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testEqualsWithStrings() {
		assertTrue(Utils.equal(null, null));
		assertFalse(Utils.equal("hi", null));
		assertFalse(Utils.equal(null, "hi"));
		// two different but equal strings
		assertTrue(Utils.equal("hi", "hi"));
		
		String sameString = "hi";
		assertTrue(Utils.equal(sameString, sameString));
	}
	
	
	@Test
	public void testHashCodePrimeWithNull() {
		assertEquals(Utils.hashCodePrime(null), Utils.hashCodePrime(null));
	}
	
	@Test
	public void testHashCodePrimeWithStrings() {
		String s1 = "hi";
		String s2 = "hi";
		String sNotSame = "bye";
		assertEquals(s1, s2);		
		
		assertEquals(Utils.hashCodePrime(s1), Utils.hashCodePrime(s2));
		assertNotEquals(Utils.hashCodePrime(s1), Utils.hashCodePrime(sNotSame));
		
	}
	
	

}
