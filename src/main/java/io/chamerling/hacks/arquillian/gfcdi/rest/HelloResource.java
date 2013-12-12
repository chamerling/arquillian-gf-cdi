package io.chamerling.hacks.arquillian.gfcdi.rest;

import io.chamerling.hacks.arquillian.gfcdi.ResourceInterceptorBinding;
import io.chamerling.hacks.arquillian.gfcdi.TestBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * YOLO!
 *
 * @author Christophe Hamerling - christophe.hamerling@gmail.com
 */
@RequestScoped
@Path("/hello")
@ResourceInterceptorBinding
public class HelloResource {

    /**
     * Bean is injected with the help of the glassfish CDI module. If not present, the injection fails.
     */
    @Inject
    private TestBean bean;

    /**
     *
     * @return
     */
    @GET
    public Response hello() {
        if (bean == null) {
            return Response.serverError().entity("Bean has not been injected").build();
        }
        System.out.println("Hello called " + bean.getCalled());
        return Response.ok("Hello " + bean.getCalled()).build();
    }




}
