MVNW := mvn
DC_DIR := $(CURDIR)
DOCKERHUB_USERNAME := andresmromero7
DOCKER_IMAGE_VERSION := v1
INFRASTRUCTURE_PATH := docker-compose

USER_CONTEXT := user-context
CONFIGURATION_SERVER := configuration-server
DISCOVERY_SERVER := discovery-server
GATEWAY_SERVER := gateway

.PHONY: f

f: format
t: test
i: install
db: docker-build
s: setup
is: infrastructure-start
c: clean

setup: c f t i db is

clean:
	$(MVNW) clean

format:
	$(MVNW) spotless:apply

test:
	$(MVNW) test

install:
	$(MVNW) clean install -DskipTests

docker-build:
	cd $(USER_CONTEXT) && docker build . -t $(DOCKERHUB_USERNAME)/$(USER_CONTEXT):$(DOCKER_IMAGE_VERSION)
	cd $(CONFIGURATION_SERVER) && docker build . -t $(DOCKERHUB_USERNAME)/$(CONFIGURATION_SERVER):$(DOCKER_IMAGE_VERSION)
	cd $(DISCOVERY_SERVER) && docker build . -t $(DOCKERHUB_USERNAME)/$(DISCOVERY_SERVER):$(DOCKER_IMAGE_VERSION)
	cd $(GATEWAY_SERVER) && docker build . -t $(DOCKERHUB_USERNAME)/$(GATEWAY_SERVER):$(DOCKER_IMAGE_VERSION)

infrastructure-start:
	cd $(INFRASTRUCTURE_PATH) && docker-compose up -d