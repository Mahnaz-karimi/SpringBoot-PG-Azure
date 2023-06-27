# SpringBoot-PG-Azure
Deplyed on Microsoft Azure 

#### Kafka in Docker
docker-compose up
docker-compose -f docker-compose.yml up
#### Docker runs on the background
> docker-compose -f docker-compose.yml up -d

#### Display a list of running Docker images
> docker ps
> docker ps -a

## Stop docker
> docker-compose down

#### Running docker
> docker exec -it kafka /bin/sh

> cd /opt/
> cd kafka
> cd bin
> 
#### Create topic in Kafka
> ./bin/kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic selftuts

#### Display a list of topics:
> ./bin/kafka-topics.sh --list --zookeeper zookeeper:2181


https://www.youtube.com/watch?v=NNjgt_8w9V4&t=239s

https://www-youtube-com.translate.goog/watch?v=WnlX7w4lHvM&_x_tr_sl=fa&_x_tr_tl=en&_x_tr_hl=da&_x_tr_pto=wapp
