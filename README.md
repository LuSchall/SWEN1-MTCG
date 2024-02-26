Design:
Der Server/die Applikation sind so programmiert, dass sie Zustandslos sind.
Das bedeutet es müssen zwischen zwei Anfrage keine Informationen Zwischengespeichert werden um diese zu erfüllen.
Außerdem gibt es grob drei Schichten:

Die HTTP/WEB Schicht: 
Zu ihr gehören die Controller Klassen und das "server" package mit der Soket implementierung selbst.
Sie regeln und verteilen die eintreffenden HTTP-Requests - leiten wenn nötig Daten weiter und erstellen und versenden die HTTP-Responses.

Die Service Klassen:
In ihnen findet die "Logik" des Servers  statt, sie bearbeiten die Informationen die sie vom Controller erhalten und leiten diese an die Repository Klassen weiter.
Eine ausnahme ist der SessionService - er speichert die Informationen direkt bei sich im Memory und ist damit nur teilweise persistent(alles auser aktive Tokes/Sessions).

Die Daten - Schicht und Repository Klassen:
Die Repository Klassen haben die alleinige Aufgabe die Daten in der Datenbank zu verwalten.
Wenn aus der Service schicht abfragen kommen oder Daten gespeichert werden müssen so passiert dies stehts über die jeweiligen Repository Classen.

Lessons Learned:
Ich habe mich lange vor der Abgabe gefürchtet da sie unschaffbar wirkte.
Inzwischen bin ich jetzt endlich auf einem Stand, dass ich sagen würde ich könnte mit genügend zeit die volle und auch weit erweiterte funktionalität des Spiels programmieren.
Außerdem ist mir die Trennung der oben genannten Schichten Anfangs nicht so leicht gefallen, was später etwas zu Schwierigkeiten geführt hat.
 
Unit Testing:
TBA

Unique feature:
es gibt das "element" die Eigenschaft Godlike: 
Wenn sie Kämpft und eine Karte besiegt die weniger als 50% ihres Schadens hat ascended sie zu einem Gott und reist alle gegner auf dem Schlachtfeld mit sich in eine andere Welt.
All diese Karten werden komplett vom spiel entfernt und der spieler der die Karte ausgespielt hat gewinnt dadurch.
Außerdem eine Karten Beschreibung.

Zeitaufwand: ca. 61 Stunden exklusive 15 Stunden die ich gebraucht habe um postreSQL im Projekt ein zu binden 
- als es im Unterricht gemacht wurde war ich krank und ich habe die Anleitung im online Kurs übersehen. Mit der Anleitung hatte ich es fast geschaft und ein kollege,
der sich gut auskennt gab mir noch den letzten hinweis der mich dann erlöst hat und es zum laufen brachte.
