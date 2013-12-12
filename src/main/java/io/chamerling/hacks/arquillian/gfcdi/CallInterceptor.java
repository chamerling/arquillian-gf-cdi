package io.chamerling.hacks.arquillian.gfcdi;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

/**
 * Interceptor implementation. Activated in beans.xml and called before the rest operation.
 *
 * @author Christophe Hamerling - christophe.hamerling@gmail.com
 */
@Interceptor
@ResourceInterceptorBinding
public class CallInterceptor implements Serializable {

    @Inject
    protected TestBean bean;

    @AroundInvoke
    public Object incerement(final InvocationContext ctx) throws Exception {
        System.out.println("Intercepted");
        if (bean != null) {
            bean.inc();
        } else {
            System.out.println("...");
        }
        return ctx.proceed();
    }
}
