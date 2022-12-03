package jpasample.domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import jpasample.persistence.IPersistenceObject;

@Entity
public class Student implements IPersistenceObject<String> {

    @Id
    private String studentCode;
    private String name;

    public Student(String studentCode, String name) {
        this.studentCode = studentCode;
        this.name = name;
    }

    public Student() {
    }

    @Override
    public String getKey() {
        return studentCode;
    }

    @Override
    public Object getClone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }
}
