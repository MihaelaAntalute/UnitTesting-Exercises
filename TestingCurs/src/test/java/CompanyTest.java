import company.Company;
import company.Department;
import company.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompanyTest {


    @Test
    void testAddDepartment_ShouldReturnTrue(){
        //given
        Department[] departments = new Department[100];
        Company company = new Company("asdf",213123,departments,0);
        Employee[] employees = new Employee[100];
        Department addedDepartment = new Department("dep1",employees,0);
        //when
        boolean result = company.addDepartment(addedDepartment);
        //then
        assertTrue(result);
        assertEquals(1,company.getNumberOfDepartaments());
    }

    @Test
    void testFindDepartmentByName_ShouldReturnDepartmentName(){
        //given
        Department department1 = new Department("dep1",new Employee[30],0);
        Department department2 = new Department("dep2",new Employee[30],0);
        Department[] departments = new Department[]{department1,department2};
        Company company = new Company("asdf",213123,departments,0);
        //when
        Department result = company.findDepartmentByName("dep1");
        //then
        assertEquals(department1,result);
    }

    @Test
    void testFindDepartmentByName_ShouldReturnEmptyDepartment(){
        //given
        Department department1 = new Department("dep1",new Employee[30],0);
        Department department2 = new Department("dep2",new Employee[30],0);
        Department[] departments = new Department[]{department1,department2};
        Company company = new Company("asdf",213123,departments,0);
        //when
        Department result = company.findDepartmentByName("dep3");
        //then
        assertEquals(new Department("",new Employee[0],0),result);
    }


}
