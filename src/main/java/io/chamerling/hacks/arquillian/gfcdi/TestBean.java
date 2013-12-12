package io.chamerling.hacks.arquillian.gfcdi;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Christophe Hamerling - christophe.hamerling@gmail.com
 */
@SessionScoped
public class TestBean implements Serializable {

    AtomicLong called;

    public TestBean() {
        called = new AtomicLong(0);
    }

    public void inc() {
        System.out.println("Test bean ++");
        long calls = called.incrementAndGet();
        System.out.println(calls);
    }

    public long getCalled() {
        return called.get();
    }
}
