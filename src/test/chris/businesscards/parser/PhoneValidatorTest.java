package chris.businesscards.parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PhoneValidatorTest {

	PhoneValidator impl = new PhoneValidator();
	
	@Test
	public void testPhoneNumberFormatMatches() {
		assertTrue("717-222-2222", impl.isValid("717-222-2222"));
		assertTrue("(717)222-2222", impl.isValid("(717)222-2222"));
		assertTrue("(717) 222-2222", impl.isValid("(717) 222-2222"));
		assertTrue("(717) 222 - 2222", impl.isValid("(717) 222 - 2222"));
		assertTrue("717.222.2222", impl.isValid("717.222.2222"));
		assertTrue("717 . 222 . 2222", impl.isValid("717 . 222 . 2222"));
		assertTrue("7172222222", impl.isValid("7172222222"));
		assertTrue("Phone: 410-555-1234", impl.isValid("Phone: 410-555-1234"));
		assertTrue("Tel: +1 (703) 555-1259", impl.isValid("Tel: +1 (703) 555-1259"));
		assertTrue("PHONE: 717-222-2222", impl.isValid("PHONE: 717-222-2222"));
		assertTrue("Tel: (717)222-2222", impl.isValid("Tel: (717)222-2222"));
		assertTrue("TELEPHONE: (717) 222-2222", impl.isValid("TELEPHONE: (717) 222-2222"));
		assertTrue("Call (717) 222 - 2222", impl.isValid("Call (717) 222 - 2222"));
		assertTrue("P: 717.222.2222", impl.isValid("P: 717.222.2222"));
		
		
		assertFalse("null", impl.isValid(null));
		assertFalse("Fax: 410-555-4321", impl.isValid("Fax: 410-555-4321"));
		assertFalse("Fax: +1 (703) 555-1200", impl.isValid("Fax: +1 (703) 555-1200"));
		assertFalse("fax: 717.222.2222", impl.isValid("fax: 717.222.2222"));
		assertFalse("FAX: 717.222.2222", impl.isValid("FAX: 717.222.2222"));
		assertFalse("f: 717.222.2222", impl.isValid("f: 717.222.2222"));
	}
	
}
