package fr.unilim.iut.firstdoublure;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock; 
import static org.mockito.Mockito.when;
import org.junit.Test;

public class UserServiceImplTest {
	@Test
	public void should_create_user_with_hashed_password() {
    
			HashProvider hashprovider=mock(HashProvider.class);
			when(hashprovider.hash("secret")).thenReturn("???");
			
    		UserService userService = new UserServiceImpl(hashprovider);
     	
    		User user = userService.createUser("Bob", "secret");

     		assertEquals(user.firstName(), "Bob"); 
     		assertEquals(user.hashedPassword(), "???"); 
	}
}
