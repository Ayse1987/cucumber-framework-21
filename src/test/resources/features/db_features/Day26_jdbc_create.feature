@db_create
Feature: Create_hotel_room
  Scenario: Creating_hotel_room_test
    Given user connects to the database
    When user creates a new hotel with a "'2000','Test Hotel','Test Address','9999999','test@testemail.com','2021-06-29 19:40:47.597',4"
    Then verify the hotel is created successfully
    Then close the connection
