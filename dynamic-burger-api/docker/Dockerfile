FROM java:8

ARG artifact

ADD ${artifact} /opt/${artifact}

RUN printf "#!/bin/sh\njava -jar /opt/dynamic-burger-0.0.1-SNAPSHOT.jar" >> run.sh \
 && chmod +x run.sh /opt/dynamic-burger-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["./run.sh", ""]
