# WeatherChecker App

## Beschreibung
Die WeatherChecker-App ist eine Konsolenanwendung, die aktuelle Wetterdaten einer Stadt anzeigt.  
Die Applikation verwendet das Konzept der **Delegation**, um die Logik klar zu trennen:

- **Main-Klasse (`WeatherApp`)**: startet die Anwendung und verwaltet den Ablauf.
- **UserInputHandler**: liest Benutzereingaben (z. B. Stadtname) und validiert sie.
- **WeatherService**: ruft eine externe Wetter-API (z. B. OpenWeatherMap) auf.
- **WeatherLogic**: verarbeitet die Daten und bereitet sie zur Ausgabe vor.
- **Custom Exception (`InvalidCityException`)**: wird ausgelöst, wenn der Benutzer eine ungültige Eingabe macht.

## Ziele
- Anwendung des Delegationsprinzips (Trennung von Input, Logik, Service).
- Fehlerbehandlung durch eigene Exception-Klassen.
- Nutzung einer externen API zur Datenbeschaffung.

## Beispielhafter Ablauf
1. Der Benutzer gibt eine Stadt ein.
2. Der `UserInputHandler` überprüft die Eingabe.
3. Der `WeatherService` ruft die Daten von der API ab.
4. Die `WeatherLogic` bereitet die Daten auf und gibt sie aus.

## Beispielausgabe
