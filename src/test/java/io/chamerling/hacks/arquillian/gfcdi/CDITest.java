package io.chamerling.hacks.arquillian.gfcdi;

import io.chamerling.hacks.arquillian.gfcdi.rest.HelloResource;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Christophe Hamerling - chamerling@linagora.com
 */
@RunWith(Arquillian.class)
public class CDITest {

    @Deployment
    public static WebArchive deploy() {
        File[] libs = Maven.resolver()
            .loadPomFromFile("pom.xml")
            // for CDI in jersey service (not supported by default)
            .resolve("org.glassfish.jersey.containers.glassfish:jersey-gf-cdi").withoutTransitivity()
            .as(File.class);

        return ShrinkWrap.create(WebArchive.class).addAsLibraries(libs).addClasses(Application.class, HelloResource.class, CallInterceptor.class, ResourceInterceptorBinding.class, TestBean.class)
            .setWebXML("web.xml")
            .addAsWebInfResource("beans.xml", "beans.xml");

    }

    @Test
    @RunAsClient
    public void testCall(@ArquillianResource URL baseURL) throws IOException, URISyntaxException {
        System.out.println("Calling resource at " +baseURL);
        WebTarget target = ClientBuilder.newBuilder().newClient().target(new URL(baseURL, "rest/hello").toURI());
        Response out = target.request().get();

        String payload = out.readEntity(String.class);
        System.out.println(payload);
        assertEquals(200, out.getStatus());
        assertTrue(payload.startsWith("Hello"));
    }
}
