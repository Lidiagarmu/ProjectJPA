package org.example.main;

import org.example.entity.Employee;
import org.example.util.UtilEntity;

import jakarta.persistence.EntityManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager em = UtilEntity.getEntityManager();
        List<Employee> employees = em.createQuery("SELECT e from Employee e", Employee.class).getResultList();
        System.out.println("--------LISTAR TODOS LOS EMPLEADOS----------");
        employees.forEach(System.out::println);

        System.out.println("------BUSCAR UN EMPLEADO---------");
        int employeeId = 3;
        Employee employee = em.find(Employee.class, employeeId);
        System.out.println("Empleado encontrado " + employee);

/*
        System.out.println("------CREAR EMPLEADO------");
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("Pedro");
        newEmployee.setMaSurname("Martín");
        newEmployee.setPaSurname("Gil");
        newEmployee.setEmail("pedro@example.com");
        newEmployee.setSalary((float)30000);

        em.getTransaction().begin(); //para iniciar la transaccion
        em.persist(newEmployee); //para guardar la transaccion
        em.getTransaction().commit(); //para confirmar la transaccion

        System.out.println("Nuevo empleado creado: " + newEmployee);

*/
        /*
        System.out.println("--------ACTUALIZAR EMPLEADO-----");
        int employeeToUpdateId = 2;
        Employee employeeToUpdate = em.find(Employee.class, employeeToUpdateId);
        System.out.println("Empleado a modificar " + employeeToUpdate);
        System.out.println("---------------------");

        employeeToUpdate.setFirstName("Juan");
        employeeToUpdate.setPaSurname("Perez");
        employeeToUpdate.setSalary((float)50000);

        em.getTransaction().begin();
        em.merge(employeeToUpdate); //combina los cambios de una entidad
        em.getTransaction().commit();

        System.out.println("Empleado actualizado " + employeeToUpdate);

         */

        System.out.println("-------ELIMINAR EMPLEADO-----");
        int employeeToDeleteId = 1;
        Employee employeeToDelete = em.find(Employee.class, employeeToDeleteId);
        System.out.println("Empleado a eliminar: " + employeeToDelete);

        em.getTransaction().begin();
        em.remove(employeeToDelete); //para eliminar empleado
        em.getTransaction().commit();
        em.close(); //para cerrar recursos


    }
}