# Expense Tracker CLI

### Solution for the [expense-tracker](https://roadmap.sh/projects/expense-tracker) project from [roadmap.sh](https://roadmap.sh).

## Project setup
### Open project
```
$ git clone <project url>
$ cd expense-tracker
```
### Run Jar Gradle task
```
$ ./gradlew jar
```

## How to use
### Create expense
```
java -jar expense-tracker-1.0-SNAPSHOT.jar add --description "Coffe" --amount 40
```
### Update expense
```
java -jar expense-tracker-1.0-SNAPSHOT.jar update --id <id> --description "Ticket" --amount 70
```
### List expenses
```
java -jar expense-tracker-1.0-SNAPSHOT.jar list
```
### Delete expense
```
java -jar expense-tracker-1.0-SNAPSHOT.jar delete --id <id>
```
### Expense summary
```
java -jar expense-tracker-1.0-SNAPSHOT.jar summary
```
### Expense summary by month
```
java -jar expense-tracker-1.0-SNAPSHOT.jar summary --month 9
```