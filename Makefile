JFLAGS = -g
JC = javac
START = java src.app.Program ./scenario.txt
START2 = java src.app.Program ./scenario2.txt
DEL = rm -rf simulation.txt
S = ./src/
a = app/
c = classes/
e = exceptions/
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
CLASSES = $S$aProgram.java $S$cAircraft.java $S$cAircraftFactory.java $S$cBaloon.java $S$cCoordinates.java \
	$S$cFlyable.java $S$cHelicopter.java $S$cJetPlane.java $S$cTower.java $S$cWeatherProvider.java $S$cWeatherTower.java \
	$S$eEmptyFileException.java $S$eInputOutputException.java $S$eWrongNumberOfArguments.java

all: classes

classes: $(CLASSES:.java=.class)

start: 
	$(START)
start2:
	$(START2)
del:
	$(DEL)
clean:
	$(RM) $S$a*.class
	$(RM) $S$c*.class
	$(RM) $S$e*.class

re: clean classes
