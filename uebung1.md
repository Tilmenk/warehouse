# Übung 1

## Projekt Einrichtung

1. Erstellen Sie ein Repository Ihrer Organisation und klonen Sie es.
2. Erstellen Sie ein Maven-Projekt mit  [https://start.spring.io/](https://start.spring.io/). In dem Maven-Projekt
   sollte Java 17 als Version in der  `pom.xml`  eingestellt werden. Darüber hinaus sollten Sie  `J-Unit`
   und `Spring Web` als Abhängigkeiten hinzufügen. Weitere Abhängigkeiten können sie später hinzufügen.
3. Im Pull-Request sollen sich nur die nötigen Änderungen befinden. Sie können eine  `.gitignore`  erstellen um Dateien
   zu definieren, welche nicht hochgeladen werden.
4. Erstellen Sie einen Pull-Request. In dem Pull-Request werden nur Änderungen an der Einrichtung des Projekts
   vorgenommen.

## Erster Service

1. Erstellen Sie eine CSV-Datei mit 10 Hardwarekomponenten Ihrer Wahl. Fügen Sie die CSV-Datei in das Hauptverzeichnis
   des Repositorys hinzu. Die Datei sollte beim Starten des Dienstes geladen werden.
2. Implementieren sie die folgende GET-Endpunkte:
   ```
   GET http://localhost:8080/components
   Accept: application/json
   ```
   &
   ```
   GET http://localhost:8080/components/{COMPONENT_ID}
   Accept: application/json
   ```
   Falls die HTTP-Anfrage vom Client korrekt gestellt wurde und erfolgreich von Ihrem Service bearbeitet wurde, liefert
   Ihr Service eine Liste aller Produkte/ein einzelnes Produkt in JSON-Format zurück.
3. Ihr Dienst sollte inkorrekten Client-Requests entsprechend RFC 2616, Section 10.04
   behandeln:  [https://tools.ietf.org/html/rfc2616#section-10.4](https://tools.ietf.org/html/rfc2616#section-10.4).

## Postman

1. Erstellen Sie einen Postman Workspace für Ihr Team und laden Sie Ihre Mitglieder ein
2. Erstellen sie eine neue Collection für den Warehouse. Fügen sie Test für ihren Dienst hinzu. Überlegen sie sich,
   welche möglichen fehlerhaften Anfragen möglich sind. Dokumentieren sie die verschiedenen Fälle im Pull-Request. Sie
   können dafür z.B. die CURL Befehle kopieren und im Pull-Request hinzufügen.Finden sie alle sinnvollen fehlerhaften
   Anfragen/Fällen gefunden haben.

## Swagger

1. Integrieren sie Swagger und OpenAPI in ihre Anwendung.

## Tutorials & co.

- https://spring.io/guides/gs/rest-service/
- https://git-scm.com/doc
- https://www.baeldung.com/spring-rest-openapi-documentation
- 