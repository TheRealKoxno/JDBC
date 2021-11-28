package miptjava;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class TaskBTest {
    private TaskB b;
    public TaskBTest() {
        b = new TaskB();
    }
    @Test
    public void missionOne() throws SQLException {
        b.missionOne();
    }

    @Test
    public void missionTwo() throws SQLException {
        b.missionTwo();
    }

    @Test
    public void missionThree() throws SQLException {
        b.missionThree();
    }

    @Test
    public void missionFour() throws SQLException {
        b.missionFour();
    }
}