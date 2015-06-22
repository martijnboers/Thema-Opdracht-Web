package atd.junit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import atd.domein.Auto;
import atd.domein.Privilege;
import atd.domein.User;
import atd.domein.Klant;
public class UserTest {

	@Test
	public void UserTest() {
		Klant Testuser = new Klant(0, "test", "testusername", "1234AB", "testemail", null, Privilege.KLANT);
		
		String naam = "test";
		assertNotNull(naam);
		assertEquals(naam, Testuser.getNaam());
		
		String username = "testusername";
		assertNotNull(username);
		assertEquals(username, Testuser.getUsername());
		
		int id = Testuser.getId();
		assertNotNull(id);
		assertEquals(id, Testuser.getId());
		
		String postcode = "1234AB";
		Testuser.setPostcode(postcode);
		assertNotNull(postcode);
		assertEquals(postcode, Testuser.getPostcode());
		
		String email = "testemail";
		Testuser.setEmail(email);
		assertNotNull(email);
		assertEquals(email, Testuser.getEmail());
		
		Privilege priv = Privilege.KLANT;
		assertNotNull(priv);
		assertEquals(priv, Testuser.getPriv());
	}
	public void UserTest2(){
		User Testuser = new User(1, "test", "testusername", null, 0);
		
		Privilege priv = Privilege.ADMIN;
		assertNotNull(priv);
		assertEquals(priv, Testuser.getPriv());
	}
	public void UserTest3(){
		User Testuser = new User(1, "test", "testusername", null, 0);
		
		Privilege priv = Privilege.MONTEUR;
		assertNotNull(priv);
		assertEquals(priv, Testuser.getPriv());
	}

}
