install:
	./gradlew installDist
run-dist:
	./build/install/app/bin/app $(ARGS)

clean:
	./gradlew clean

build:
	./gradlew build

test:
	./gradlew test

lint-main:
	./gradlew checkstyleMain

lint-test:
	./gradlew checkstyleTest

.PHONY: build