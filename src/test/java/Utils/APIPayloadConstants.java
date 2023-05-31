package Utils;

import org.json.JSONObject;

public class APIPayloadConstants {
    // we will pss the boady in multiple formats , for this we created this class
    public static String createEmployeePayload() {
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Rania\",\n" +
                "  \"emp_lastname\": \"masoud\",\n" +
                "  \"emp_middle_name\": \"Nattlie\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"1970-01-01\",\n" +
                "  \"emp_status\": \"Confirmed\",\n" +
                "  \"emp_job_title\": \"Engineer\"\n" +
                "}";
        return createEmployeePayload;

    }
   /* public static String createEmployeePayloadJson(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Rania");
        obj.put("emp_lastname","masoud");
        obj.put("emp_middle_name","Nattlie");
        obj.put("emp_gender","F");
        obj.put("emp_birthday","1970-01-01");
        obj.put("emp_status","Confirmed");
        obj.put("emp_job_title","Engineer");
        return obj.toString();
    }*/

    // to make the code dynmic istead of the hard code date which is above
    public static String createEmployeePayloadDynamic
    (String emp_firstname, String emp_lastname,
     String emp_middle_name, String emp_gender, String emp_birthday,
     String emp_status, String emp_job_title) {

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);

        return obj.toString();
    }

    public static String updateEmployeePayloadJson() {
        JSONObject obj = new JSONObject();
        obj.put("employee_id","53345A");
        obj.put("emp_firstname", "Ronaa");
        obj.put("emp_lastname", "masd");
        obj.put("emp_middle_name", "Na");
        obj.put("emp_gender", "F");
        obj.put("emp_birthday", "2000-01-01");
        obj.put("emp_status", "Confirmed");
        obj.put("emp_job_title", "CIO");
        return obj.toString();

    }
}