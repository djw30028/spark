== Start spark in  Scala shell:
spark-shell
sh ./bin/spark-shell


================================
===
Installing Spark Standalone to a Cluster
./sbin/start-master.sh
./sbin/stop-master.sh

http://localhost:8080/

/sbin/start-slave.sh spark://Michaels-MBP.hsd1.ga.comcast.net:7077
/sbin/stop-slave.sh

==========
sbt assembly

=========
== add git init
git init


==================================
== Delete generated files under project
find . -name target -type d -exec rm -rf {} \;


== Add local directory to remote
- Step 1: in https://github.com/djw30028/
   clic + sign on right top, ex create spark.git
- Step 2: git init
- Step 3: git add .
- Step 4: git commit -m 'First init'
- Step 5: git remote add origin https://github.com/djw30028/spark.git
- Step 6: git push -u origin master


==================================
== Start standalone cluster,
create and modify: /Users/michaelwang/myprogs/spark-2.0.0-bin-hadoop2.7/conf/spark-env.sh

== Start master and slave
./sbin/start-slave.sh spark://Michaels-MBP.hsd1.ga.comcast.net:7077
./sbin/start-master.sh
-- check with: http://localhost:8080/

/sbin/start-slave.sh spark://Michaels-MBP.hsd1.ga.comcast.net:7077
./sbin/stop-slave.sh

== Submit application:
sbt assembly
cd /Users/michaelwang/myprogs/spark-2.0.0-bin-hadoop2.7
./bin/spark-submit --class "SparkPi" --master local[4] /Users/michaelwang/project/mypractice/SparkTest/target/scala-2.11/SparkTest-assembly-1.0.jar
./bin/spark-submit --class "SparkPi" --master spark://Michaels-MBP.hsd1.ga.comcast.net:7077 /Users/michaelwang/project/mypractice/SparkTest/target/scala-2.11/SparkTest-assembly-1.0.jar

from http://localhost:8080/
Will see
Completed Applications

=================================
== Cluster Launch Scripts, need to update conf/spark-env.sh
./sbin/start-all.sh
./sbin/stop-all.sh

./bin/spark-class org.apache.spark.deploy.Client kill <master url> <driver ID>

=================================
== NetworkWordCount
Step 1: ./sbin/start-all.sh

To run this on your local machine, you need to first run a Netcat server
Step 2: `$ nc -lk 9999`

Step 3: ./bin/spark-submit --class "NetworkWordCount" --master spark://Michaels-MBP.hsd1.ga.comcast.net:7077 /Users/michaelwang/project/mypractice/SparkTest/target/scala-2.11/SparkTest-assembly-1.0.jar localhost 9999

==================================
== KafkaWordCount/KafkaWordCountProducer, working fine

Step 1: ./sbin/start-all.sh
zkserver start
kafka-server-start /usr/local/etc/kafka/server.properties

Step 2:
./bin/spark-submit --class "KafkaWordCountProducer" --master spark://Michaels-MBP.hsd1.ga.comcast.net:7077 /Users/michaelwang/project/mypractice/SparkTest/target/scala-2.11/SparkTest-assembly-1.0.jar localhost:9092 test 3 5
  where hadoop000:9092 producer host port
  test is topic
  3 message/sec
  5 word per message


Step 3:
./bin/spark-submit --class "KafkaWordCount" --master spark://Michaels-MBP.hsd1.ga.comcast.net:7077 /Users/michaelwang/project/mypractice/SparkTest/target/scala-2.11/SparkTest-assembly-1.0.jar localhost:2181 test-consumer-group test 1


http://m.blog.csdn.net/article/details?id=42741757
