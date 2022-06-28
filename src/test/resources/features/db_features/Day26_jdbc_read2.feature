@db_read_2
Feature: Read_database_data
#  HOW TO PRINT NAME COLUMN
#  Assert 6 room name is Twin room
  Scenario: Read_hotel_reservations
    Given user connects to the database
    And user gets "Name" from "tHOTELROOM" table
    And user reads all rows in the "Name" column
    And users gets the value in row 6 in "Name" column and verifies the value is "Twin room"

#    Read the Names from Hotel table
#    and assert that 5th price is NEWw HOTEL
  Scenario: Read_hotel_reservations
    Given user connects to the database
    And user gets "Name" from "tHOTEL" table
    And user reads all rows in the "Name" column
    And users gets the value in row 5 in "Name" column and verifies the value is "NEWw HOTEL"