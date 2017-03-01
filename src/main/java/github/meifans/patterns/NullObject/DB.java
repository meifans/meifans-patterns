package github.meifans.patterns.NullObject;

/**
 * Created by Meifans on 16/12/15.
 */
public class DB {


    public static Employee getEmployee(String name) {
        //find employee by name
        //not find ,then
        return Employee.NULL;
    }

}

