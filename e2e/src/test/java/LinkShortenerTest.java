import com.javainuse.TestBase;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LinkShortenerTest extends TestBase {

    @Test
    public void testShortenLink() throws IOException {
        // Given
        //String name = RandomStringUtils.randomAlphabetic( 8 );
        String rawUrl = "?rawUrl=http://nxp.com";

        // When
        StatusLine statusLine = getRequest(SHORT_LINK + rawUrl).getStatusLine();

        // Then
        Assert.assertTrue(statusLine.getStatusCode() == HttpStatus.SC_OK);
    }
}
