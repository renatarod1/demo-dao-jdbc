package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department insert ===");
		Department department = new Department(null, "Home");
		departmentDao.insert(department);
		System.out.println(department);
		
		System.out.println("\\n=== TEST 2: department findById ===");
		Department newDepartment = departmentDao.findById(3);
		System.out.println(newDepartment);
		
		System.out.println("\n=== TEST 3: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 5: department update ===");
		department = departmentDao.findById(9);
		department.setName("Sports");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}
