package chris.businesscards.contactInfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

public class ContactInfoImplTest {

	
	@Test
	public void testConstructorEqual() {
		ContactInfoImpl c1 = build(3);
		ContactInfoImpl c2 = build(3);
		assertEquals(c1, c2);
		assertEquals(c1.getEmailAddress(), c2.getEmailAddress());
		assertEquals(c1.getName(), c2.getName());
		assertEquals(c1.getPhoneNumber(), c2.getPhoneNumber());		
		assertEquals(c1.hashCode(), c2.hashCode());
	}
	

	@Test
	public void testConstructorNotEqualName() {
		ContactInfoImpl c1 = build(3);
		ContactInfoImpl c2 = new ContactInfoImpl(c1.getName() + "foo",  c1.getPhoneNumber(), c1.getEmailAddress());
		assertFalse(c1.equals(c2));
		assertEquals(c1.getEmailAddress(), c2.getEmailAddress());
		assertFalse(c1.getName().equals(c2.getName()));
		assertEquals(c1.getPhoneNumber(), c2.getPhoneNumber());		
		assertFalse(c1.hashCode() == c2.hashCode());
	}
	

	@Test
	public void testConstructorNotEqualEmail() {
		ContactInfoImpl c1 = build(3);
		ContactInfoImpl c2 = new ContactInfoImpl(c1.getName(), c1.getPhoneNumber(),  c1.getEmailAddress() + "foo");
		assertFalse(c1.equals(c2));
		assertEquals(c1.getName(), c2.getName());
		assertFalse(c1.getEmailAddress().equals(c2.getEmailAddress()));
		assertEquals(c1.getPhoneNumber(), c2.getPhoneNumber());		
		assertFalse(c1.hashCode() == c2.hashCode());
	}

	@Test
	public void testConstructorNotEqualPhone() {
		ContactInfoImpl c1 = build(3);
		ContactInfoImpl c2 = new ContactInfoImpl(c1.getName(), c1.getPhoneNumber() + "foo",  c1.getEmailAddress());
		assertFalse(c1.equals(c2));
		assertEquals(c1.getName(), c2.getName());
		assertFalse(c1.getPhoneNumber().equals(c2.getPhoneNumber()));
		assertEquals(c1.getEmailAddress(), c2.getEmailAddress());		
		assertFalse(c1.hashCode() == c2.hashCode());
	}
	

	@Test
	public void testConstructorNulls() {
		ContactInfoImpl c1 = build(3);
		ContactInfoImpl c2 = new ContactInfoImpl(null, null, null);
		assertFalse(c1.equals(c2));	
	}

	
	@Test
	public void testHashcodeNulls() {
		ContactInfoImpl c2 = new ContactInfoImpl(null, null, null);
		assertNotEquals(0, c2.hashCode());
	}

	@Test
	public void testEqualsNulls() {
		ContactInfoImpl c1 = build(3);
		assertFalse(c1.equals(null));	
	}
	
	public static ContactInfoImpl build(int i) {
		return  new ContactInfoImpl("name" + i,  "email@" + i + ".com", "phone" + i);				
	}
}
