# my-quarkus-app

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/my-quarkus-app-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- Azure Functions HTTP ([guide](https://quarkus.io/guides/azure-functions-http)): Write Microsoft Azure functions
- JDBC Driver - H2 ([guide](https://quarkus.io/guides/datasource)): Connect to the H2 database via JDBC
- Funqy HTTP Binding ([guide](https://quarkus.io/guides/funqy-http)): HTTP Binding for Quarkus Funqy framework

## Provided Code

### Funqy HTTP

Start your Funqy functions using HTTP

[Related guide section...](https://quarkus.io/guides/funqy-http#get-query-parameter-mapping)


### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

[Related Hibernate with Panache section...](https://quarkus.io/guides/hibernate-orm-panache)

# quarkus-2

10148  mvn clean package
10149  mvn quarkus:run
10150  mvn quarkus:run -DenableDebug
10151* history
10152* curl -d '"Dan"' -X POST localhost:8080/api/greeting
10153* curl -d '"Dan"' -X POST localhost:8081/api/greeting
10154  mvn quarkus:deploy
10155* curl -d '"Dan"' -X POST https://toms-account-function.azurewebsites.net//api/greeting
10156* curl -d '"Dan"' -X POST https://toms-account-function.azurewebsites.net/api/greeting


### Set up
Used this:
https://piotrminkowski.com/2024/01/31/serverless-on-azure-function-with-quarkus/

in conjunction with all this stuff:
```bash
10139  az account show
10140  az group create -l eastus -n quarkus-serverless
10141  az storage account create -n pminkowsserverless \\n     -g quarkus-serverless \\n     -l eastus \\n     --sku Standard_LRS
10142  az storage account create -n tomsserverless \\n     -g quarkus-serverless \\n     -l eastus \\n     --sku Standard_LRS
10143  az functionapp create -n pminkows-account-function \\n     -c eastus \\n     --os-type Linux \\n     --functions-version 4 \\n     -g quarkus-serverless \\n     --runtime java \\n     --runtime-version 17.0 \\n     -s tomsserverless
10144  az functionapp create -n toms-account-function \\n     -c eastus \\n     --os-type Linux \\n     --functions-version 4 \\n     -g quarkus-serverless \\n     --runtime java \\n     --runtime-version 17.0 \\n     -s tomsserverless
10145  ls
10146  quarkus create app com.example:my-quarkus-app \\n    --extension=funqy-http,azure-functions-http,hibernate-orm-panache,jdbc-h2\n
10147  cd my-quarkus-app
10148* mvn clean package
10149* mvn quarkus:run
10150* mvn quarkus:run -DenableDebug
10151* history
10152* curl -d '"Dan"' -X POST localhost:8080/api/greeting
10153* curl -d '"Dan"' -X POST localhost:8081/api/greeting
10154* mvn quarkus:deploy
10155* curl -d '"Dan"' -X POST https://toms-account-function.azurewebsites.net//api/greeting
10156* curl -d '"Dan"' -X POST https://toms-account-function.azurewebsites.net/api/greeting
```
