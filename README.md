# SpringBoot-PG-Azure
Deplyed on Microsoft Azure 

#### Docker and docker-compose

- touch docker-compose.yml
- docker --version
- docker-compose --version


#### Kafka And Zookeeper in Docker
- docker-compose up
- docker-compose -f docker-compose.yml up

#### Docker runs on the background
- docker-compose -f docker-compose.yml up -d

#### Display a list of running Docker images
- docker ps
- docker ps -a

## Stop docker
- docker-compose down

#### To go inside the Kafka container for start a shell (/bin/sh)
- docker exec -it kafka /bin/sh
- cd /opt/kafka

###### To create topic in Kafka
- ./bin/kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic <topic-name> 

###### To display a list of topics:
- ./bin/kafka-topics.sh --list --zookeeper zookeeper:2181
