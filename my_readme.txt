== Start spark in  Scala shell:
spark-shell
sh ./bin/spark-shell

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

