@db_read
Feature: Read_database_data
  Scenario: Read_hotel_reservations
    Given user connects to the database
#    column=Price    table name = tHOTELROOM
#    NOTE: column and table name must be accurate
#    SCHEMA has all information about the database. So we use SCHEMA to write the correct names
    And user gets "Price" from "tHOTELROOM" table

#    And user gets "Name" from "tHOTEL" table
#    And user gets "Price" from "HOTEL" table
#    And user gets "Notes" from "tHOTELROOMRESERVATION" table

    And user reads all rows in the "Price" column
#    And user reads all rows in the "Name" column
#    And user reads all rows in the "Notes" column

#    HOMEWORK:CREATE A NEW STEPDEFITION TO DO ASSERTION FOR THIS LINE
    And users gets the value in row 5 in "Price" column and verifies the value is "470.0000"

