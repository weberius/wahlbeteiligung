# wahlbeteiligung

Das Projekt wahlbeteiligung soll unterschiedliche Wahlbeteiligung in unterschiedlichen geographischen Strukturen veranschaulichen. Es fokussiert sich zunächst auf die Wahlergebnisse im Bereich der Stadt Köln zu den Landtagswahlen.

Das Projekt integriert die Informationen aus den Projekten [wahlergebnis](https://github.com/weberius/wahlergebnis) und [wahlgebiet](https://github.com/codeforcologne/wahlgebiet) und stellt die Zusammenhänge in einer Webanwendung dar. Die Darstellung erfolgt in der Art eines Choroplethen. Mit Klick auf eine Geographie werden zusätzlichen Informationen zur Verfügung gestellt. 

# Status

Die Applikation befindet sich in der Entwicklung

# Verwendete Technologien

- Java
- HTML/ CSS/ JavaScript

# Verwendete Tools

TODO 

- leaflet
- bootstrap
- geojson
- Gson
- ...

# REST Endpoints

## /isochrone/service/ping

Diese Schnittstelle wird verwendet um zu prüfen, ob der Service selbst erreichbar ist.

# User Interface

TODO

# Installation

Die Applikation ist eine Java-Webapplikation und setzt einen Tomcat voraus. Die Installation setzt eine Postgres/ Postgis Datenbank voraus. Die Datenstruktur dort muss bereits vorhanden sein. 

    git clone https://github.com/weberius/wahlbeteiligung.git
    cd wahlbeteiligung
    mvn clean install

# License

<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons Lizenzvertrag" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br />Dieses Werk ist lizenziert unter einer <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Namensnennung - Weitergabe unter gleichen Bedingungen 4.0 International Lizenz</a>.