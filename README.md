# Wauw! The Startup is way much better!

This project was created to show how to adopt `AOT`, `CDS` and `virtual threads` in a Spring Boot application in order to improve its startup.

The application is pretty simple, connecting to a `db (postgres)`, a `cache (redis)` and subscribing a `pubsub (GCP)` to receive messages. Spring-boot applications try
to connect with all these components prior to be considered healthy, which can validate our startup time improvements.

## Important links

- [CDS Smoke Run Info](https://github.com/spring-projects/spring-lifecycle-smoke-tests/blob/main/README.adoc#training-run-configuration)
- [AOT](https://docs.spring.io/spring-boot/maven-plugin/aot.html)
- [CDS](https://docs.spring.io/spring-boot/how-to/class-data-sharing.html)
- [GraalVM](https://docs.spring.io/spring-boot/reference/packaging/native-image/index.html)