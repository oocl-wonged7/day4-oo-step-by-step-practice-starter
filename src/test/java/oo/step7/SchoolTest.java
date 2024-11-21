package oo.step7;

import oo.School;
import oo.Student;
import oo.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SchoolTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void should_return_correct_output_when_there_are_two_teachers_and_two_students() {
        School school = new School();
        Teacher alice = new Teacher(1, "Alice", 30, school);
        Teacher Bob = new Teacher(2, "Bob", 40, school);
        Student Charlie = new Student(3, "Charlie", 18, school);
        Student David = new Student(4, "David", 19, school);

        school.startSchool();

        String expectedOutput = "My name is Alice. I am 30 years old. I am a teacher." +
                "My name is Bob. I am 40 years old. I am a teacher." +
                "My name is Charlie. I am 18 years old. I am a student." +
                "My name is David. I am 19 years old. I am a student.";
        assertThat(systemOut()).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_correct_output_when_there_are_two_teachers() {
        School school = new School();
        Teacher alice = new Teacher(1, "Alice", 30, school);
        Teacher Bob = new Teacher(2, "Bob", 40, school);

        school.startSchool();

        String expectedOutput = "My name is Alice. I am 30 years old. I am a teacher." +
                "My name is Bob. I am 40 years old. I am a teacher.";
        assertThat(systemOut()).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_correct_output_when_there_are_two_students() {
        School school = new School();
        Student Charlie = new Student(3, "Charlie", 18, school);
        Student David = new Student(4, "David", 19, school);

        school.startSchool();

        String expectedOutput = "My name is Charlie. I am 18 years old. I am a student." +
                "My name is David. I am 19 years old. I am a student.";
        assertThat(systemOut()).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_correct_output_when_there_are_no_student_or_teacher() {
        School school = new School();
        school.startSchool();

        String expectedOutput = "";
        assertThat(systemOut()).isEqualTo(expectedOutput);
    }
}
