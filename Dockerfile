#
# Build stage
#
FROM maven:3.6.3-openjdk-17 AS build
# COPY src /home/app/src
# COPY pom.xml /home/app
# RUN mvn -f /home/app/pom.xml clean package -DskipTests
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD pom.xml $HOME
RUN mvn verify --fail-never
ADD . $HOME
RUN mvn -f $HOME/pom.xml clean package -DskipTests

#
# Package stage
#
FROM openjdk:17
COPY --from=build /usr/app/target/warehouse-0.0.1.jar /usr/local/lib/warehouse.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/warehouse.jar"]