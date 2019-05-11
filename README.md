# optiim-selenium

# Parameters

-Dbrowser.type=chrome
-Dtake.a.video=true


# --> Serial Test Execute 

mvn clean install site -Dbrowser.type=chrome -Dtake.a.video=true -P "Serial"


# --> Parallel Test Execute 

mvn clean install site -Dbrowser.type=chrome -Dtake.a.video=true -P "Parallel" -Dfork.count=2

# --> Network Test Execute 

mvn clean install site -Dbrowser.type=chrome -Dtake.a.video=true -P "Network"

