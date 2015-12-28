package test;

import com.dropbox.core.DbxException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import service.Client;

/**
 * Created by Admin on 27.12.15.
 */
public class ClientTest {



    @Test
    public void ShouldNotBeEqual() throws DbxException {

        Client client1 = new Client();
        Client client2 = new Client();

        Assert.assertFalse(client1.equals(client2));
    }

    @Test
    public void ShouldBeNotNull() throws DbxException {

        Client cl1 = new Client();
        Assert.assertNotNull(cl1);
    }


    @Test(expected=DbxException.class)
    public void ShouldThrowException() throws DbxException {

        Client client = Mockito.mock(Client.class);
        Mockito.doThrow(new DbxException.BadResponse("Bad response")).when(client).setClient();
        client.setClient();
    }

    @Test(expected=DbxException.class)
    public void ShouldThrowDbxException() throws DbxException {

        Client client = Mockito.mock(Client.class);
        Mockito.doThrow(new DbxException.InvalidAccessToken("Invalid Acces Token")).when(client).setClient();
        client.setClient();
    }


}