# Currency Conversion System

## Overview
This is an implementation of a currency conversion system involving 148 currencies, where the value of each currency's rate is in relation to 1 US Dollar (USD).

The system operates based on these three files:
+ **Currency.java**, which represents **Currency** objects based on information derived from deserialising the **fx_rates.json** file.
+ **User.java**, which represents **User** objects based on information derived from deserialising the **users.json** file.
+ **Runner.java**, which demonstrates how the **Currency** and **User** objects interact with one another.
 
The dataset relies on these datasets, which are stored in the **src/main/resources** folder: 
+ **fx_rates.json**, which contains information on the currencies. Every **Currency** object is a JSON object where the *name* is the three-lettered currency (example: the Euro currency is denoted as *eur*), and the aforementioned **Currency** object.
+ **users.json**, which contains a map of **User** profiles. Every **User** object has a **name** and a **wallet**. A **wallet** is a map of a **Currency** to the value of the **Currency** (Example: A user named Ali has two currencies in his wallet: 25USD, and 14MYR. Hence, this information will be stored in the wallet as *USD: 25*, *MYR: 14*).
+ **transactions.txt**, which contains a set of transactions for the system to process. Every line in this file follows this format: *USERNAME* *FROMCURRENCY* *TOCURRENCY* *AMOUNT*

The Currency Conversion System works as follows:
1. Check if the *USER* exists.
2. Check if the *FROMCURRENCY* AND *TOCURRENCY* are both unique to one another and exists in the aforementioned 148 currencies.
3. Checks if the *USER* has the *FROMCURRENCY* in his/her wallet, and that the amount of the *FROMCURRENCY* to be converted is less than or equal to the amount of the *FROMCURRENCY* in his/her wallet.

If all three checks are met, proceed with the transaction and the *USER*'s wallet will be updated accordingly. Otherwise, skip the transaction.

For all transactions, a message will be displayed in the console and logged in the logger file. 
For every successful transaction, a message is displayed in the console showing that the transaction was successful, followed by showing the amount of the *FROMCURRENCY* that is converted to the *TOCURRENCY*.
For every unsuccessful transaction, a message is displayed in the console showing that the transaction was unsuccessful, followed by the reason for the unsuccessful transaction.

The message of every transaction will be stored in a logger called **logging.log**. This file is located in the *src/main/logs* folder.

## Instructions
1. If your local machine has not been configured with the `Eclipse IDE`, follow the installation instructions [here](https://github.com/shumarb/training/blob/main/fdm/software-to-install/EclipseIDEInstallation.md).
2. If your local machine has not been configured with `Java 17`, follow the installation instructions [here](https://github.com/shumarb/training/blob/main/fdm/software-to-install/Java17Installation.md).
3. Download the [zip folder](https://github.com/shumarb/training/blob/main/fdm/object-oriented-development/part-1/sheikhumar_hangman.zip) of the project to your local machine
4. Unzip the zip file. The unzipped folder is called `ood3`
5. Open the `Eclipse IDE`.
6. Select `File`.
7. Select `Import`.
8. Select `Maven`
9. Select `Existing Maven Project`.
9. At `Root Directory`, select `Browse`.
10. Select the unzipped file. 
11. Select `Finish`. You will see the `ood3` Maven project in the `Package Explorer`
12. Select the `>` icon of the `ood3` Maven project
13. Select the `>` icon of the `src/main/java` folder
14. Select the `>` icon of the `com.fdmgroup.ood3assessment.main` package
15. Right-click `Runner.java`
16. Select `Run As`
17. Select `1. Java Application`
18. Logging information will be displayed for the outcome of running the `transactions.txt` file in the `src/main/resources` folder.
