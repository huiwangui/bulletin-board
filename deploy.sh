#!/usr/bin/env bash

killTomcat(){
 pid=`ps -ef|grep tomcat|grep java|awk '{print $2}'`
 echo "tomcat Id list :$pid"
 if [ "$pid" = "" ]
 then
   echo "no tomcat pid alive"
 else
   kill -9 $pid
   fi
}

cd $PROJ_PATH/bullentin-board
mvn clean install

killTomcat

rm -rf $TOMCAT_APP_PATH/webapps/ROOT
rm -f $TOMCAT_APP_PATH/webapps/ROOT.war
rm -f $TOMCAT_APP_PATH/webapps/bullentin-board.war

cp $PROJ_PATH/bullentin-board/target/bulletin-board-0.0.1-SNAPSHOT.jar $TOMCAT_APP_PATH/webapps/

cd $TOMCAT_APP_PATH/webapps/
mv bulletin-board-0.0.1-SNAPSHOT.jar ROOT.jar

cd $TOMCAT_APP_PATH/
