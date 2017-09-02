FROM hypriot/rpi-java
EXPOSE 8080
VOLUME /tmp 
ADD /target/freezer-0.0.1-SNAPSHOT.jar freezer.jar

ENV JAVA_OPTS="" 
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /freezer.jar" ]

