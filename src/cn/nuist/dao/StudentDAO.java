package cn.nuist.dao;

import cn.nuist.model.Student;
import cn.nuist.model.User;

import java.util.List;


public interface StudentDAO {

	/**
	 * Add one student to database
	 * @param studentName name of student
	 * @param id studentID of student
	 * @param major major of student
	 * @return if success
	 * @throws Exception
	 */
	boolean addStudent(String id, String studentName, String major) throws Exception;

	/**
	 * Update one student to database
	 * @param id of student
	 * @param studentName of student
	 * @param major of student
	 * @return if success
	 * @throws Exception
	 */
	boolean updateStudent(String id, String studentName, String major) throws Exception;

	/**
	 * Find students from database
	 * @param id part name of student
	 * @param studentName of student
	 * @return Students within conditions
	 * @throws Exception
	 */
	List<Student> findAllStudents(String id, String studentName) throws Exception;

	/**
	 * Delete students from database
	 * @param ids all ids of records
	 * @return if success
	 * @throws Exception
	 */
    boolean deleteStudents(List<String> ids) throws Exception;
}
