MVNW := mvn
DC_DIR := $(CURDIR)
DOCKERHUB_USERNAME := andresmromero7
DOCKER_IMAGE_VERSION := v1
INFRASTRUCTURE_PATH := docker-compose

USER_CONTEXT := user-context

.PHONY: f

f: format
t: test
i: install
db: docker-build
s: setup
is: infrastructure-start

setup: f t i db is

format:
	$(MVNW) spotless:apply

test:
	$(MVNW) test

install:
	$(MVNW) clean install -DskipTests

docker-build:
	cd $(USER_CONTEXT) && docker build . -t $(DOCKERHUB_USERNAME)/$(USER_CONTEXT):$(DOCKER_IMAGE_VERSION)

infrastructure-start:
	cd $(INFRASTRUCTURE_PATH) && docker-compose up -d