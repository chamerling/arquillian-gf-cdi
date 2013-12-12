# arquillian-gf-cdi

Getting started with Arquillian, Glassfish, Interceptors and CDI. Because it killed my night...

## About

- How to test using Arquillian and embedded Glassfish
- How to javax.inject.Inject bean using CDI in a Jersey2 JAXRS 2 resource
- How to intercept calls using javax.interceptor.Interceptor
- How to test from the client side

## WTF

- CDI and JAXRS: Will not work on Glassfish without the gf-cdi module (not embedded in the distribution)
- Interceptors and beans.xml: Looks like all of this fails if they are not packaged in the same JAR (at least with Arquillian)

## TODO

Arquillian version++, got some issues with injection:

- http://stackoverflow.com/questions/17806480/arquillian-fails-to-inject-dependencies-after-the-first-test-class
- https://community.jboss.org/message/830718)

## License

MIT