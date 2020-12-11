package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdTest
{
  Id id = new Id();
  Id id1 = new Id();
  Id id2 = new Id();

  @Test void getId()
  {
    assertEquals(1, id.getId());
    assertEquals(2,id1.getId());
    assertEquals(3,id2.getId());
  }
}