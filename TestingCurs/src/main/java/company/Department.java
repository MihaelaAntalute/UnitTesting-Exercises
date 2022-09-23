package company;

import java.util.Arrays;
import java.util.Objects;

public class Department {
    private String departmentName;
    private Employee[] employees;
    private int numberOfEmployeesDepartment;

    public Department(String departmentName, Employee[] employees, int numberOfEmployeesDepartment) {
        this.departmentName = departmentName;
        this.employees = employees;
        this.numberOfEmployeesDepartment = numberOfEmployeesDepartment;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public int getNumberOfEmployeesDepartment() {
        return numberOfEmployeesDepartment;
    }

    public void setNumberOfEmployeesDepartment(int numberOfEmployeesDepartment) {
        this.numberOfEmployeesDepartment = numberOfEmployeesDepartment;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", employees=" + Arrays.toString(employees) +
                ", numberOfEmployeesDepartment=" + numberOfEmployeesDepartment +
                '}';
    }

    //4. scrie un program care afiseaza numarul de angajati din departament
    public void printNumberOfEmployees() {
        System.out.println(this.numberOfEmployeesDepartment);
    }

    //5. scrie o metoda care printeaza toti angajatii din departament
    public void printAllEmployees() {
        for (int i = 0; i < employees.length; i++) {
            //System.out.println(employees[i].getFirstName()+ " " +employees[i].getLastName());
            employees[i].printNameEmployee();
        }
    }

    //6. scrie o metoda care printeaza toate strazile adreselor angajatilor din departament
    public void printAllEmployeesStreets() {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getAddress().getStreet());
            //employees[i].printEmployeeStreet();

        }
    }

    //7. scrie o metoda care cauta un anumit angajat dupa nume in departament, si ii afiseaza numele daca il gaseste
    public Employee findEmployeesByName(String name) {
        for (int i = 0; i < employees.length; i++) {
            if (name.equals(employees[i].getFirstName())) {
                return employees[i];
            }
        }
        return new Employee("","",0,new Address("",
                "",0));
    }

    //8. scrie o metoda care printeaza adresa unui anumit angajat din departament
    public Address findEmployeesAddressByName(String name){
        Employee foundEmployee = this.findEmployeesByName(name);
        if("".equals(foundEmployee.getFirstName())){
            return new Address("","",0);
        }
        return foundEmployee.getAddress();

//        for (int i = 0; i < employees.length; i++) {
//            if(name.equals(employees[i].getFirstName())){
//               return employees[i].getAddress();
//            }
//        }
//        return new Address("","",0);
    }

    //9. scrie o metoda care cauta o adresa (dupa strada) in lista de angajati a departamentului, si ii afiseaza strada daca o gaseste

    public Address findEmployeeAddressByStreet(String street){
        for (int i = 0; i < employees.length; i++) {
            if(street.equals(employees[i].getAddress().getStreet())){
                return employees[i].getAddress();
            }
        }
        return new Address("","",0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return numberOfEmployeesDepartment == that.numberOfEmployeesDepartment && departmentName.equals(that.departmentName) && Arrays.equals(employees, that.employees);
    }


}

