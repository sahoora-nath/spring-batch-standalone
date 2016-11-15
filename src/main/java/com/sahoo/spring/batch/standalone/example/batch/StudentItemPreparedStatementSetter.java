package com.sahoo.spring.batch.standalone.example.batch;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import com.sahoo.spring.batch.standalone.example.model.Student;

public class StudentItemPreparedStatementSetter implements ItemPreparedStatementSetter<Student> {

	@Override
	public void setValues(Student student, PreparedStatement ps) throws SQLException {
		ps.setString(1, student.getStudentName());
        ps.setDate(2, new java.sql.Date(student.getDob().toDate().getTime()));
        ps.setDouble(3, student.getPercentage());
	}
}
