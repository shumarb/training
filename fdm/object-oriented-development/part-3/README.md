# FXConvert

## Overview
This is an implementation of a currency conversion system involving 148 currencies, where the value of each currency's rate is in relation to 1 US Dollar (USD).

The system operates on these files:
+ **Currency.java**, which represents **Currency** objects based on information deserialized from the **fx_rates.json** file.
+ **User.java**, which represents **User** objects based on information deserialized from the **users.json** file.
+ **Runner.java**, which facilitates the transactions from the **transactions.txt** file.
 
The following are the datasets that the sytem relies on. These datasets are stored in the **src/main/resources** folder: 
+ **fx_rates.json**, which contains information on the currencies. 
+ **users.json**, which contains one or more **User** profiles. Each profile comprises of a **name** and a **wallet**. A **wallet** is a map of a currency's **name** to the **value** of the currency that the **user** has. 
(Example: A user named Ali has two currencies in his wallet: 25USD, and 14MYR. Hence, this information will be stored in the wallet as *USD: 25*, *MYR: 14*).
+ **transactions.txt**, which contains a set of transactions for the system to process. Every line in this file follows this format: *USERNAME* *FROMCURRENCY* *TOCURRENCY* *AMOUNT*

The following explains how the system processes each transaction:
1. Check if the *USER* exists.
2. Check if the *FROMCURRENCY* AND *TOCURRENCY* are both unique to one another and exists in the aforementioned 148 currencies.
3. Checks if the *USER* has the *FROMCURRENCY* in his/her wallet.
4. Checks that the amount of the *FROMCURRENCY* to be converted is less than or equal to the amount of the *FROMCURRENCY* in his/her wallet.
5. If the transaction satisfies all checks in **Steps 1 to 4**, the system executes the transaction updates the *USER*'s wallet accordingly. Otherwise, the system skips the transaction.
6. The console displays the logging messages for each transaction.
For every valid transaction, the console displays a message that the transaction was successful and the amount of the *FROMCURRENCY* that is converted to the *TOCURRENCY*.
For every skipped transaction, the console displays a message that the transaction was skipped and the reason the transaction was skipped.
7. The logging messages of each transaction is stored in a log file called **logging.log**, which is located in the **src/main/resources** folder. This logger file is created only after running the **Runner.java** file.

## Instructions
1. If your local machine has not been configured with the `Eclipse IDE`, follow the installation instructions [here](https://github.com/shumarb/training/blob/main/fdm/software-to-install/EclipseIDEInstallation.md).
2. If your local machine has not been configured with `Java 17`, follow the installation instructions [here](https://github.com/shumarb/training/blob/main/fdm/software-to-install/Java17Installation.md).
3. Download the [zip folder](https://github.com/shumarb/projects/blob/main/projects/fxconvert/fxconvert.zip) of the project to your local machine.
2. Unzip the zip file. The unzipped folder is called `fxconvert`.
3. Open the `Eclipse IDE`.
4. Select `File`.
5. Select `Import`.
6. Select `Maven`.
7. Select `Existing Maven Project`.
8. At `Root Directory`, select `Browse`.
9. Select the unzipped file. 
10. Select `Finish`. You will see the `fxconvert` Maven project in the `Package Explorer`.
11. Select the `>` icon of the `fxconvert` Maven project.
12. Select the `>` icon of the `src/main/java` folder.
13. Select the `>` icon of the `main` package.
14. Right-click `Runner.java`.
15. Select `Run As`.
16. Select `1. Java Application`.
17. Logging information will be displayed for the outcome of running the `transactions.txt` file in the `src/main/resources` folder.
18. Refresh `src/main/java`.
19. Select `users.json`. Users of valid transactions will have their wallets updated.
20. Refresh the `src/main/resources` folder.
21. Select `logging.log` to see the logging messages.
