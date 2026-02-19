package pt.isel.pc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class RecordTests {
    record Id(int id) {}

    class Idc {
        public final int id;
        public Idc(int id) { this.id = id; }
    }

    @Test
    public void checkEqualityByValue() {
        Id id1 = new Id(2);
        Id id2 = new Id(2);

        assertEquals(id1,id2);
        assertNotSame(id1, id2);
        Idc id3 = new Idc(2);
        Idc id4 = new Idc(2);

        assertEquals(id3,id4);
        assertNotSame(id3,id4);
    }
}
