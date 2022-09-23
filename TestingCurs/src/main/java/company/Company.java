package company;

import java.util.Arrays;

public class Company {
    private String name;
    private int yearFounded;
    private Department[] departments;
    private int numberOfDepartments;

    public Company(String name, int yearFounded, Department[] departments, int numberOfDepartments) {
        this.name = name;
        this.yearFounded = yearFounded;
        this.departments = departments;
        this.numberOfDepartments = numberOfDepartments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public Department[] getDepartaments() {
        return departments;
    }

    public void setDepartaments(Department[] departaments) {
        this.departments = departaments;
    }

    public int getNumberOfDepartaments() {
        return numberOfDepartments;
    }

    public void setNumberOfDepartaments(int numberOfDepartaments) {
        this.numberOfDepartments = numberOfDepartaments;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", yearFounded=" + yearFounded +
                ", departments=" + Arrays.toString(departments) +
                ", numberOfDepartments=" + numberOfDepartments +
                '}';
    }

    //10. scrie o metoda care printeaza toate departamentele din companie
    public void printAllDepartments() {
        for (int i = 0; i < departments.length; i++) {
            System.out.println(departments[i]);
        }


    }

    public Department findDepartmentByName(String departmentName) {
        for (int i = 0; i < departments.length; i++) {
            if (departmentName.equals(departments[i].getDepartmentName())) {
                return departments[i];
            }
        }
        return new Department("", new Employee[0], 0);
    }

    //11. scrie o metoda care printeaza toti angajatii dintr-un anumit departament din companie

    public void printAllEmployeesByDepartment(String departmentName) {
        Department foundDepartment = findDepartmentByName(departmentName);
        for (int i = 0; i < foundDepartment.getEmployees().length; i++) {
            System.out.println(foundDepartment.getEmployees()[i]);
        }
    }


    //12. scrie o metoda care printeaza cati angajati are un anumit departament din companie

    public void printNumberOfEmployeesByDepartment(String departmentName) {
        Department foundDepartment = findDepartmentByName(departmentName);
        foundDepartment.printNumberOfEmployees();
    }


    //14. scrie o metoda care printeaza toate strazile adreselor angajatilor dintr-un anumit departament din companie
    public void allEmployeesStreetBYDepartment(String departmentName) {
        Department foundedDepartment = findDepartmentByName(departmentName);
        for (int i = 0; i < foundedDepartment.getEmployees().length; i++) {
            System.out.println(foundedDepartment.getEmployees()[i].getAddress().getStreet());
        }
    }
    //15. scrie o metoda care printeaza strada adresei unui anumit angajat din companie

    public String printStreetByEmployeeName(String employeeName) {
//             for (int i = 0; i < departments.length; i++) {
//            for (int j = 0; j < departments[i].getEmployees().length; j++) {
//                if (employeeName.equals(departments[i].getEmployees()[j].getFirstName())) {
//                    System.out.println(departments[i].getEmployees()[j].getAddress().getStreet()
//                    );
//                }
//            }
//        }
//        return "";
        for (int i = 0; i < departments.length; i++) {
            Employee foundedEmployee = departments[i].findEmployeesByName(employeeName);
            if (!"".equals(foundedEmployee.getFirstName())) {
                return foundedEmployee.getAddress().getStreet();
            }
        }
        return "";
    }

    //17. scrie o metoda care cauta un angajat (dupa nume) intr-un anumit departament din companie si ii afiseaza numele, daca il gaseste

    public Employee searchEmployeeByNameAndDepartment(String employeeName, String departmentName) {
//        for (int i = 0; i <departments.length ; i++) {
//            if(departmentName.equals(departments[i].getDepartmentName())){
//                Department foundDepartment = departments[i];
//                for (int j = 0; j < foundDepartment.getEmployees().length; j++) {
//                    if(employeeName.equals(foundDepartment.getEmployees()[j].getFirstName())){
//                        Employee foundEmployee = foundDepartment.getEmployees()[j];
//                        return foundEmployee;
//                    }
//                }
//            }
//
//        }
        Department foundDepartment = findDepartmentByName(departmentName);
        Employee foundEmployee = foundDepartment.findEmployeesByName(employeeName);
        if (!"".equals(foundEmployee.getFirstName())) {
            return foundEmployee;
        }
        return new Employee("", "", 0, new Address("", "", 0));
    }


    //18. scrie o metoda care printeaza toti angajatii din toate departamentele din companie


    public void printAllEmployeesFromCompany() {
        for (int i = 0; i < departments.length; i++) {
            Department currentDepartment = departments[i];
            for (int j = 0; j < currentDepartment.getEmployees().length; j++) {
                System.out.println(currentDepartment.getEmployees()[j]);
            }
        }
    }

    //19. scrie o metoda care printeaza numarul total de angajati din toate departamentele din companie
    public int printTotalNumberOfEmployee() {
        int totalNumbersOfEmployees = 0;
        for (int i = 0; i < departments.length; i++) {
            totalNumbersOfEmployees += departments[i].getNumberOfEmployeesDepartment();
        }
        return totalNumbersOfEmployees;
    }


    //20. scrie o metoda care cauta un angajat in toate departamentele din companie si ii afiseaza numele, daca il gaseste

    public String findEmployeeByNameFromCompany(String employeeName) {
        for (int i = 0; i < departments.length; i++) {
            Department currentDepartment = departments[i];
//            for (int j = 0; j < currentDepartment.getEmployees().length; j++) {
//                if(employeeName.equals(currentDepartment.getEmployees()[j].getFirstName())){
//                    return currentDepartment.getEmployees()[j].getFirstName();
//                }
//            }
            Employee foundEmployee = currentDepartment.findEmployeesByName(employeeName);
            if (!"".equals(foundEmployee.getFirstName())) {
                return foundEmployee.getFirstName();
            }
        }
        return "";
    }

    //21. scrie o metoda care printeaza numele angajatului cu cel mai mare salariu dintr-un anumit departament

    public String findEmployeeWithBigestSalaryFromDepartment(String departmentName) {
        Employee maxEmployeeSalary1 = new Employee("", "", 0, new Address("", "", 0));
        Department foundDepartment = findDepartmentByName(departmentName);
        for (int i = 0; i < foundDepartment.getEmployees().length; i++) {
            Employee foundEmployee = foundDepartment.getEmployees()[i];
            if (maxEmployeeSalary1.getSalary() < foundDepartment.getEmployees()[i].getSalary()) {
                maxEmployeeSalary1 = foundDepartment.getEmployees()[i];
            }
        }
        return maxEmployeeSalary1.getFirstName();
    }

    //22. scrie o metoda care printeaza numele angajatului cu cel mai mare salariu din companie
    public String findEmployeeWithBigestSalary() {
        Employee maxEmployeeSalary = new Employee("", "", 0, new Address("", "", 0));
        for (int i = 0; i < departments.length; i++) {
            Employee[] employee = departments[i].getEmployees();
            for (int j = 0; j < employee.length; j++) {
                if (maxEmployeeSalary.getSalary() < employee[j].getSalary()) {
                    maxEmployeeSalary = employee[j];
                }
            }
        }
        return maxEmployeeSalary.getFirstName();
    }

    //23. scrie o metoda care printeaza numele angajatului cu cel mai mic salariu din companie

    public String findEmployeeWithMinSalary() {
        Employee minEmployeeSalary = new Employee("", "", 0, new Address("", "", 0));
        for (int i = 0; i < departments.length; i++) {
            Employee[] employee = departments[i].getEmployees();
            for (int j = 0; j < employee.length; j++) {
                if (minEmployeeSalary.getSalary() > departments[i].getEmployees()[j].getSalary()) {
                    minEmployeeSalary = departments[i].getEmployees()[j];
                }
            }
        }
        return minEmployeeSalary.getFirstName();
    }

    //24. scrie o metoda care printeaza numele angajatului cu cel mai mic salariu dintr-un anumit departament;
   //de verificat;
    public String findEmployeeWithMinSalaryFromDepartment(String departmentName) {
        Employee minEmployeeSalary = new Employee("","",0, new Address("", "", 0));
        Department foundDepartment = findDepartmentByName(departmentName);
        for (int i = 0; i < foundDepartment.getEmployees().length; i++) {
            Employee foundEmployee = foundDepartment.getEmployees()[i];
            if (minEmployeeSalary.getSalary() > foundEmployee.getSalary()) {
                minEmployeeSalary = foundEmployee;
            }
        }
        return minEmployeeSalary.getFirstName();
    }



    public boolean addDepartment(Department department){
        departments[numberOfDepartments] = department;
        numberOfDepartments++;
        return true;
    }
}
