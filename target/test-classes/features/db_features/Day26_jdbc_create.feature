@db_create
Feature: Create_hotel_room
  Scenario: Creating_hotel_room_test
    Given user connects to the database
    When user creates a new hotel with a "data"
    Then verify the hotel is created successfully
    Then close the connection
