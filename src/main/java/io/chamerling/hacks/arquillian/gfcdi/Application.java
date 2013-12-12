package io.chamerling.hacks.arquillian.gfcdi;

import io.chamerling.hacks.arquillian.gfcdi.rest.HelloResource;

import java.util.HashSet;
import java.util.Set;

/**
 * The JAXRS Application
 *
 * @author Christophe Hamerling - chamerling.github.io
 */
public class Application extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> result = new HashSet<>();
        result.add(HelloResource.class);
        return result;
    }
}
