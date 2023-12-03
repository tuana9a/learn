#! /bin/bash
REMOTE_ADDRESS=tuannm@10.5.0.249
REMOTE_PORT=2395

JAR=./target/learn-spark-0.0.1.jar
SUBMIT_SH=submit.sh
CONFIG=config.properties

LIBS=./target/libs/

if [ "$1" == "job" ]; then
  echo scp -P $REMOTE_PORT \
  $SUBMIT_SH $JAR $CONFIG \
  $REMOTE_ADDRESS:/home/tuannm/learn-spark/

  scp -P $REMOTE_PORT \
  $SUBMIT_SH $JAR $CONFIG \
  $REMOTE_ADDRESS:/home/tuannm/learn-spark/

elif [ "$1" == "libs" ]; then
  echo scp -r -P $REMOTE_PORT \
  "$LIBS" \
  $REMOTE_ADDRESS:/home/tuannm/learn-spark/

  scp -r -P $REMOTE_PORT \
  "$LIBS" \
  $REMOTE_ADDRESS:/home/tuannm/learn-spark/

else
  echo missing first argument
fi
