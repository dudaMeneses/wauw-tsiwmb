run:
	docker-compose up -d --force-recreate
	docker run --net="host" -it -e SPRING_PROFILES_ACTIVE=docker wauw-tsiwmb:0.0.1-SNAPSHOT

build:
	mvn clean spring-boot:build-image -DskipTests
