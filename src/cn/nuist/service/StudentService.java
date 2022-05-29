package cn.nuist.service;

import cn.nuist.util.Message;

import java.util.List;

public interface StudentService {
    /**
     * Add student operation
     *
     * @param id    of student
     * @param name  of student
     * @param major of Student
     * @return message of add operation
     */
    Message addStudent(String id, String name, String major);

    /**
     * Update data of student
     *
     * @param id    of student
     * @param name  of student
     * @param major of Student
     * @return message of modify operation
     */
    Message update(String id, String name, String major);

    /**
     * Query students
     *
     * @param id of user
     * @return message of query operation
     */
    Message query(String id, String studentName);

    /**
     * Delete students
     * @param ids all ids of students to be deleted
     * @return message of query operation
     */
    Message deleteAll(List<String> ids);


}
