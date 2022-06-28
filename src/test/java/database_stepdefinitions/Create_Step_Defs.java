package database_stepdefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtils;
public class Create_Step_Defs {
    @When("user creates a new hotel with a {string}")
    public void user_creates_a_new_hotel_with_a(String hotelData) {
//    QUERY FOR INSERTING HOTEL
        String query = "INSERT INTO tHOTEL (Code, Name, Address, Phone, Email, CreateDate, CreateUser) VALUES ("+hotelData+")";
//    RUNNING THE QUERY
        DBUtils.executeQuery(query);
    }
    @Then("verify the hotel is created successfully")
    public void verify_the_hotel_is_created_successfully() {
//        READ THE HOTEL TABLE AND NAME COLUMN
//        THEN CHECK IF NAME INCLUDES Test Hotel
//        getColumnData("QUERY","COLUMN NAME") -> returns the list of the Column data as List of Object
        Assert.assertTrue(DBUtils.getColumnData("SELECT Name FROM tHOTEL","Name").toString().contains("Test Hotel"));
/*        CONCLUSION:
We inserted a new hotel from the database usign JDBC
And verified the data is added on the UI
 */
    }
    @Then("close the connection")
    public void close_the_connection() {
       DBUtils.closeConnection();
    }

}