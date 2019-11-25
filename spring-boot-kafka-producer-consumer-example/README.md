#To sent message 
POST:http://localhost:8081/kafka/publish
	{
    	"message": "Hi ankit"
	}
#To get All message
GET:http://localhost:8081/kafka/getAll
#To delete All message
DELETE:http://localhost:8081/kafka/deleteAll



				#KAFKA Commands
#(1). Go to this folder
D:\Kafka\kafka_2.12-2.3.0

#(2). St java_home & Class Path
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_221
set CLASSPATH=C:\Program Files\Java\jdk1.8.0_221\lib,C:\Program Files\Java\jdk1.8.0_221\lib\tools.jar

#(3). Start ZooKeeper
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

#(4). Start Kafka
.\bin\windows\kafka-server-start.bat .\config\server.properties

#(5). Create topic with 1 partition and 1 replica
.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic hello

#(6). Create producer and send message to Topic
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic hello-topic --property "parse.key=true" --property "key.separator=:" 

#(7). Start consumer
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --from-beginning --topic hello --partition 0

create database ticket;
use ticket;