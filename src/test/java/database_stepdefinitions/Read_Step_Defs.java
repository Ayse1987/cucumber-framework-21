package database_stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;
import utilities.Driver;

import java.sql.*;

public class Read_Step_Defs {


    @Given("user connects to the database")
    public void user_connects_to_the_database() {
//        Call teh appropriate method form DBUtils to connect to the database
        DBUtils.createConnection();
    }
    @Given("user gets {string} from {string} table")
    public void user_gets_from_table(String column, String table) {

//        String query = "Select Price from tHOTELROOM"; //Price= column, tHOTELROOM=table  name
        String query=   "Select "+column+" from "+table;


//        RUN THAT QUERY USING executeQuery from DBUtils
        DBUtils.executeQuery(query);

//        NOW DRIVER IS ON THE PRICE COLUMN ON HOTEL TABLE
    }

    @Given("user reads all rows in the {string} column")
    public void user_reads_all_rows_in_the_column(String column) throws SQLException {
//      We will use Result set to do actions
//        resultSet.next() -> takes us to the next row
//        resultSet -> DBUtils.getResultset()
        DBUtils.getResultset().absolute(3);//Takes me to 4th row
        //Getting the data from the CURRENT POSITION
        Object thirdColumnObject=DBUtils.getResultset().getObject(column);//Getting 4th column data on "Price" column
        System.out.println("THIRD : "+thirdColumnObject);

//        Go to the next row
        DBUtils.getResultset().next();
        Object next1=DBUtils.getResultset().getObject(column);//Getting 4th column data on "Price" column
        System.out.println("FOURTH : "+next1);//425

        DBUtils.getResultset().next();
        Object next2=DBUtils.getResultset().getObject(column);//Getting 4th column data on "Price" column
        System.out.println("FIFTH : "+next2);//425

        DBUtils.getResultset().next();//on the 3rd row
        Object next3=DBUtils.getResultset().getObject(column);//Getting 4th column data on "Price" column
        System.out.println("SIXTH : "+next3);//425

        DBUtils.getResultset().absolute(4);//Takes me to 4th row
        //Getting the data from the CURRENT POSITION
        Object fourthColumnObject=DBUtils.getResultset().getObject(column);//Getting 4th column data on "Price" column
        System.out.println("FOURTH : "+fourthColumnObject);//425

        //PRINT ALL ROWS
        while( DBUtils.getResultset().next()){// DBUtils.getResultset().next() TRUE IF NEXT EXIST
            Object data=DBUtils.getResultset().getObject(column);
            System.out.println(data);
        }

        //GO TO LAST COLUMN USING last() method. first() takes to teh first column
        DBUtils.getResultset().last();
//        I can get data as string using getString method
        String lastData=DBUtils.getResultset().getString(column);
        System.out.println("LAST DATA : "+lastData);

    }
    @Given("users gets the value in row {int} in {string} column and verifies the value is {string}")
    public void users_gets_the_value_in_row_in_column_and_verifies_the_value_is(Integer rowNum, String column, String value) throws SQLException {
       DBUtils.getResultset().absolute(rowNum);
       Object  data=DBUtils.getResultset().getObject(column);
       String expectedData=value;
       String actual=data.toString();


        Assert.assertEquals(expectedData,actual);
    }

}

