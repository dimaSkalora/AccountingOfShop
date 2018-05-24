call mvn -B -s settings.xml -DskipTests=true clean package
call java -DDATABASE_URL="postgres://user:password@localhost:5432/accounting_of_shop" -jar target/dependency/webapp-runner.jar target/*.war