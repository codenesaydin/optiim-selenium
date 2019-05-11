# optiim-selenium

# Used Technology

-> Selenium (3.4.0) : Selenium automates browsers.
-> BrowserMob Proxy (2.1.1) : A free utility to help web developers watch and manipulate network traffic from their AJAX applications.
-> JUnit (4.12) : JUnit is an open source framework designed for the purpose of writing and running tests in the Java programming language. 
-> Monte-screen-recorder (0.7.7) : The Monte Media Library is a Java library for processing media data.
-> slf4j : The Simple Logging Facade for Java (SLF4J) serves as a simple facade or abstraction for various logging frameworks, such as java.util.logging, logback and log4j.
-> Extent Report (2.41.2) : Class is used to generate an HTML report on the user-specified path.
  
# Parameters

-Dbrowser.type=chrome
-Dtake.a.video=true

# --> Serial Test Execute 

mvn clean install site -Dbrowser.type=chrome -Dtake.a.video=true -P "Serial"


# --> Parallel Test Execute 

mvn clean install site -Dbrowser.type=chrome -Dtake.a.video=true -P "Parallel" -Dfork.count=2

# --> Network Test Execute 

mvn clean install site -Dbrowser.type=chrome -Dtake.a.video=true -P "Network"

