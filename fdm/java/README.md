# BookZone

## Overview
BookZone is a platform serving librarians at the Singapore Book Collectors club in their book catalogue. Its key features include:

+ `Adding` a book to the catalogue.
+ `Deleting` a book from the catalogue.
+ `Displaying all books` in the catalogue.
+ `Displaying all Special books` in the catalogue.
+ `Editing` a book in the catalogue.
+ `Marking` a book as Special.
+ `Removing a book from Specials` and retaining it in the catalogue.

## Setup
1. Ensure your local machine is configured with `Git, Java, Eclipse IDE, MySQL, and MySQL Workbench`.
2. Download the [zip file](https://github.com/shumarb/projects/tree/main/projects/bookZone/bookZone.zip) of the project ot your local machine.
3. Unzip the zip file. You will see a folder called `bookZone`.
4. Open the `Eclipse IDE`.
5. Select `File`.
6. Select `Import`.
7. Select `Maven`
8. Select `Existing Maven Project`.
9. At `Root Directory`, select `Browse`.
10. Navigate to the folder of the unzipped `bookZone` project.
11. Select the folder in Step 9. You will see the `bookZone` project in the Package Explorer.
12. Change lines 6 & 7 of application.properties to the `username` and `password` of your `MySQL database`.
13. Create a `schema` in your `MySQL Workbench` called book_zone.

## Instructions
1. Select the `>` icon of the `bookZone` project.
2. Select the `>` icon of the `src/main/java/` folder.
3. Select the `>` icon of the `com.bookzone` package.
4. Right-click `BookZoneApplication.java`.
5. Select `Run As`.
6. Select `1. Java Application`.
7. Open a web browser.
8. Enter `localhost:9001`.
9. You will see the `Index page`.
10. `Register` a BookZone account via an email address that ends with `sgbookcollectors.com`.
11. `Log into` BookZone.
12. Use the BookZone portal to `add, edit, delete, or indicate a book as Special`.
