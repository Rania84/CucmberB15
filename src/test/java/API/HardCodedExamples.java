package API;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {
     String baseURI =RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
     String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODQ5NzE0NDcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTAxNDY0NywidXNlcklkIjoiNTM0MSJ9.eYt5QDlh9uw7YZbacraItvh7f95tqA4JzxZUCwOAq2Y";
     static String employee_id ;
     @Test
     public void bgetcreatedEmployee(){
         RequestSpecification preparedRequest = given().header("Content-Type","application/json").
                 header("Authorization",token).queryParam("employee_id",employee_id);

         // hitting the endpoint
         Response response = preparedRequest.when().get ("/getOneEmployee.php");
         response.prettyPrint();
         //verfiy the sesponse
         response.then().assertThat().statusCode(200);
         String tempEmpId = response.jsonPath().getString("employee.employee_id");

         //we have 2 emp id, one is global and second is local
         Assert.assertEquals(employee_id, tempEmpId);
     }
     @Test
     public void acreateEmployee() {
         // prepare the request
         RequestSpecification preparedReguest = given().header("Content-Type", "application/json").
                 header("Authorization", token).body("{\n" +
                         "  \"emp_firstname\": \"Rania\",\n" +
                         "  \"emp_lastname\": \"masoud\",\n" +
                         "  \"emp_middle_name\": \"Nattlie\",\n" +
                         "  \"emp_gender\": \"F\",\n" +
                         "  \"emp_birthday\": \"1970-01-01\",\n" +
                         "  \"emp_status\": \"Confirmed\",\n" +
                         "  \"emp_job_title\": \" Engineer\"\n" +
                         "}");
         // hitting the endpoint
         Response response = preparedReguest.when().post("/createEmployee.php");
         //it will print the output in the console
         response.prettyPrint();

         // verifying the assertions
         response.then().assertThat().statusCode(201);
         //we are capturing employee id from the response
         employee_id = response.jsonPath().getString("Employee.employee_id");
         System.out.println(employee_id);


         //we are capturing employee id from the response
         employee_id = response.jsonPath().getString("Employee.employee_id");
         System.out.println(employee_id);



         //todo verifying the firstname in the response body
         response.then().assertThat().body("Employee.emp_firstname", equalTo("Rania"));
         System.out.println("My test case is passed");
         response.then().assertThat().body("Employee.emp_lastname", equalTo("masoud"));

         //verify the response headers
         response.then().assertThat().header("Content-Type","application/json");
         System.out.println("My test case is passed");
     }
     @Test
     public  void cupdateEmployee(){
         RequestSpecification preparedRequest =given().header("Content-Type", "application/json"). header("Authorization", token).body( "{\n" +
                 "  \"employee_id\": \""+employee_id+"\",\n" +
                 "  \"emp_firstname\": \"Dodo\",\n" +
                 "  \"emp_lastname\": \"Leoring\",\n" +
                 "  \"emp_middle_name\": \"leo\",\n" +
                 "  \"emp_gender\": \"F\",\n" +
                 "  \"emp_birthday\": \"2023-05-20\",\n" +
                 "  \"emp_status\": \"probation\",\n" +
                 "  \"emp_job_title\": \"CFO\"\n" +
                 "}");
         Response response = preparedRequest.when().put("/updateEmployee.php");
         response.then().assertThat().statusCode(200);
         //for verification
         response.then().assertThat().body("Message", equalTo("Employee record Updated"));
     }

    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                queryParam("employee_id",employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        //if you want to verify the body of the response.
        //you can do that using hamcrest matchers

    }
     }




