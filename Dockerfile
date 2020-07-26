FROM ubuntu:18.04

# Declare environment variables
ENV OPENCAGE_API_KEY="UNSET"
ENV OPENWEATHERMAP_API_KEY="UNSET"
ENV GHOST_API_KEY="UNSET"

# Install dependencies
RUN apt-get update && apt-get install -y bash git openjdk-8-jdk

# Clone repository and enter directory
RUN git clone https://github.com/simpleauthority/pundasyon.git /app
WORKDIR /app

# Build jar
RUN ./gradlew clean build

# Expose port
EXPOSE 7000

# Run application
CMD /bin/sh -c "OPENCAGE_API_KEY=$OPENCAGE_API_KEY OPENWEATHERMAP_API_KEY=$OPENWEATHERMAP_API_KEY GHOST_API_KEY=$GHOST_API_KEY java -Xms256M -Xmx256M -jar build/libs/pundasyon.jar"
