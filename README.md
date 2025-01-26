# Expense Tracker CLI

### Solution for the [expense-tracker](https://roadmap.sh/projects/expense-tracker) project from [roadmap.sh](https://roadmap.sh).

## Project setup
### Open project
```
$ git clone git@github.com:StanaSimec/expense-tracker-cli.git
$ cd expense-tracker-cli
```
## Build project
### Compile files
```
javac -cp "build/libs/*" -d ./build ./src/tracker/*.java
```
## Create jar file
### Go to build directory
```
cd build
```
### Create jar
```
jar cmf manifest.txt Tracker.jar tracker/*.class
```
## How to use
### Create expense
```
java -jar Tracker.jar add --description "Coffe" --amount 40
```
### Update expense
```
java -jar Tracker.jar update --id <id> --description "Ticket" --amount 70
```
### List expenses
```
java -jar Tracker.jar list
```
### Delete expense
```
java -jar Tracker.jar delete --id <id>
```
### Expense summary
```
java -jar Tracker.jar summary
```
### Expense summary by month
```
java -jar Tracker.jar summary --month 9
```
