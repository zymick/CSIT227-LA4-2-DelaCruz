package Management_Exc;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param manager the manager to give the salary
     * @param employee the employee to receive the raise
     * @param salary the salary increase to be given
     * @throws ClassCastException when manager or employee is not a manager or employee
     * @throws IllegalArgumentException when salary is invalid
     * @throws NoSuchElementException when given manager or employee does not exist in the list of persons
     */

    public static void giveRaise(List<Person> persons, String manager, String employee, double salary)  {
        if (salary < 0) {
            throw new IllegalArgumentException("Raise must be non-negative");
        }
        Manager mngr= null;
        Employee empl = null;

        for (Person person : persons) {
            if (person.getName().equals(manager)) {
                if(person instanceof Manager) {
                    mngr = (Manager) person;
                } else {
                    throw new ClassCastException(manager + " is not a manager");
                }
            } else if (person.getName().equals(employee)) {
                if(person instanceof Employee) {
                    empl = (Employee) person;}
                else {
                    throw new ClassCastException(employee + " is not an employee");
                }
            }
        }
        if (mngr == null) {
            throw new NoSuchElementException(manager + " does not exist");
        }
        if (empl == null) {
            throw new NoSuchElementException(employee + " does not exist");
        }

        mngr.giveRaise(empl, salary);
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param developer the developer to be assigned
     * @param manager the manager assigned to the dev
     * @throws ClassCastException when manager or developer is not a manager or employee
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException when developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) {
        Developer dev = null;
        Manager mngr = null;

        for (Person person : persons) {
            if (person.getName().equals(developer)) {
                if(person instanceof Developer) {
                    dev = (Developer) person;
                } else {
                    throw new ClassCastException(developer + " is not a developer");
                }
            }
            if (person.getName().equals(manager)) {
                if(person instanceof Manager) {
                    mngr = (Manager) person;
                }else{
                    throw new ClassCastException(manager + " is not a manager");
                }
            }
        }
        if (dev == null) {
            throw new NoSuchElementException(developer + " does not exist");
        }
        if (mngr == null) {
            throw new NoSuchElementException(manager + " does not exist");
        }

        dev.setProjectManager(mngr);

    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param customer the customer to speak to the employee
     * @param employee the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws ClassCastException when given customer or employee is not what they are
     * @throws NoSuchElementException when given customer or employee is not in the list of persons
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) {
        Customer cstmr = null;
        Employee emp = null;

        for (Person person : persons) {
            if (person.getName().equals(customer)) {
                if (person instanceof Customer) {
                    cstmr = (Customer) person;
                } else {
                    throw new ClassCastException(customer + " is not a customer");
                }
            }
            if (person.getName().equals(employee)) {
                if (person instanceof Employee) {
                    emp = (Employee) person;
                } else {
                    throw new ClassCastException(employee + " is not an employee");
                }
            }
        }

        if (cstmr == null) {
            throw new NoSuchElementException(customer + " does not exist");
        }
        if (emp == null) {
            throw new NoSuchElementException(employee + " does not exist");
        }

        return cstmr.speak(emp);
    }
}
