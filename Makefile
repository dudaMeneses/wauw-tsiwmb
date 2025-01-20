run:
	docker-compose up -d --force-recreate
	docker run --net="host" -it wauw-tsiwmb:0.0.1-SNAPSHOT

build:
	mvn spring-boot:build-image -DskipTests
