package company;

public class Main {
    public static void main(String[] args) {
        Address  address1 = new Address("Cluj-Napoca","Republicii",43);
        Address  address2 = new Address("Cluj-Napoca","Frunzisului",33);
        Address  address3 = new Address("Cluj-Napoca","Observatorului",50);
        Address  address4 = new Address("Cluj-Napoca","Eroilor",72);
        Address  address5 = new Address("Cluj-Napoca","Primaverii",25);
        Address  address6 = new Address("Cluj-Napoca","Fagului",3);
        Employee employee1 = new Employee("Andrei","Popescu",7500,address1);
        Employee employee2 = new Employee("Ana","Sandu",8500,address2);
        Employee employee3 = new Employee("Mihai","Farcas",9500,address3);
        Employee employee4 = new Employee("Mihaela","Ionescu",10500,address4);
        Employee employee5 = new Employee("Eugen","Borza",11500,address5);
        Employee employee6 = new Employee("Alina","Suciu",12500,address6);
        Employee[] salesEmployees = new Employee[]{employee1, employee2, employee3};
        Employee[] techEmployees = new Employee[]{employee4, employee5, employee6};
        Department salesDepartment = new Department("vanzari",salesEmployees,3);
        Department techDepartment = new Department("tehnologie",techEmployees,3);
        Department[] companyDepartments = new Department[]{salesDepartment,techDepartment};
        Company company = new Company("JustCodeIT", 2021, companyDepartments, 2);
        employee1.printNameEmployee();
        employee2.printEmployeeStreet();
        employee3.printEmployeeAddress();
        salesDepartment.printNumberOfEmployees();
        salesDepartment.printAllEmployees();
        salesDepartment.printAllEmployeesStreets();
        System.out.println(salesDepartment.findEmployeesByName("Ana"));
        System.out.println(salesDepartment.findEmployeesAddressByName("dtt"));
        System.out.println(salesDepartment.findEmployeeAddressByStreet("Republicii"));
        company.printAllDepartments();
       // company.findDepartmentByName("tehnologie");
        company.printAllEmployeesByDepartment("vanzari");
        company.printNumberOfEmployeesByDepartment("vanzari");
        company.allEmployeesStreetBYDepartment("tehnologie");
        System.out.println(company.printStreetByEmployeeName("Andrei"));
        System.out.println(company.searchEmployeeByNameAndDepartment("Andrei","vanzari"));
        company.printAllEmployeesFromCompany();
        System.out.println(company.printTotalNumberOfEmployee());
        System.out.println(company.findEmployeeByNameFromCompany("Ana"));
        System.out.println("Angajatul cu slaariul maxim din company");
        System.out.println(company.findEmployeeWithBigestSalary());
        System.out.println("Angajatul cu salariul maxim din department");
        System.out.println(company.findEmployeeWithBigestSalaryFromDepartment("vanzari"));
        System.out.println("Angajatul cu salariul minim din company");
        System.out.println(company.findEmployeeWithMinSalary());
        System.out.println("Angajatul cu salariul minim din department");
        System.out.println(company.findEmployeeWithMinSalaryFromDepartment("vanzari"));
    }
}
