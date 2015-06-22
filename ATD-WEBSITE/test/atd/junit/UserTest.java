package atd.junit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import atd.domein.Privilege;
import atd.domein.User;

public class UserTest {

	@Test
	public void UserTest() {
		User Testuser = new User(0, null, null, null);
		
		String naam = "test";
		Testuser.setNaam(naam);
		assertNotNull(naam);
		assertEquals(naam, Testuser.getNaam());
		
		String username = "testusername";
		Testuser.setUsername(username);
		assertNotNull(username);
		assertEquals(username, Testuser.getUsername());
		
		int id = Testuser.getId();
		assertNotNull(id);
		assertEquals(id, Testuser.getId());
		
		Privilege priv = Privilege.KLANT;
		Testuser.setPriv(priv);
		assertNotNull(priv);
		assertEquals(priv, Testuser.getPriv());
	}
	public void UserTest2(){
		User Testuser = new User(1, "test", "testusername", null);
		
		Privilege priv = Privilege.ADMIN;
		Testuser.setPriv(priv);
		assertNotNull(priv);
		assertEquals(priv, Testuser.getPriv());
	}
	public void UserTest3(){
		User Testuser = new User(1, "test", "testusername", null);
		
		Privilege priv = Privilege.MONTEUR;
		Testuser.setPriv(priv);
		assertNotNull(priv);
		assertEquals(priv, Testuser.getPriv());
	}

}
