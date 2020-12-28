FROM maven:3-jdk-8 as builder
WORKDIR /projects
RUN mvn install
#COPY ecomm-products .

FROM java:8-alpine
WORKDIR /app
COPY --from=builder /project/target/ecomm-products-0.0.1-SNAPSHOT.jar ./ecomm-products.jar
#ENTRYPOINT ["/bin/sh", "-c"]
CMD java -jar ecomm-products.jar