package io.chamerling.hacks.arquillian.gfcdi;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

/**
 * The custom interceptor annotation. Put it on resources to intercept incoming calls.
 *
 * @author Christophe Hamerling - christophe.hamerling@gmail.com
 */
@Inherited
@InterceptorBinding
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ResourceInterceptorBinding {
}
