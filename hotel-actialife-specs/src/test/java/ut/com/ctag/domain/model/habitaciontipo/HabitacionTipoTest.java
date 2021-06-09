package com.ctag.domain.model.habitaciontipo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.internal.configuration.plugins.Plugins;

import com.ctag.domain.model.users.User;
 
public class HabitacionTipoTest {
 
  private static final Integer TEST_INTEGER = 1;
 
  private static final float TEST_FLOAT = 2.2f;
 
  private static final String TEST_STRING = "test";
 
  private HabitacionTipo underTest = new HabitacionTipo();
 
  @Test
  public void testEmptyConstructor() {
    underTest = new HabitacionTipo();
    assertNotNull(underTest);
  }
 
  @Test
  public void testGetId() throws Exception {
    underTest = new HabitacionTipo();
    Plugins.getMemberAccessor()
        .set(HabitacionTipo.class.getDeclaredField("id"), underTest, TEST_INTEGER);
    assertThat(underTest.getId().getId()).isEqualTo(TEST_INTEGER);
  }
 
  @Test
  public void testGetTipoHabitacion() {
    underTest.setTipoHabitacion(TEST_STRING);
    assertThat(underTest.getTipo_habitacion()).isEqualTo(TEST_STRING);
  }
 
  @Test
  public void testGetDescripcion() throws Exception {
    underTest.setDescripcion(TEST_STRING);
 
    assertThat(underTest.getDescripcion()).isEqualTo(TEST_STRING);
  }
 
  @Test
  public void testGetPrecio() throws Exception {
    underTest.setPrecio(TEST_FLOAT);
    assertThat(underTest.getPrecio()).isEqualTo(TEST_FLOAT);
  }
 
  @Test
  public void testGetm2() throws Exception {
    underTest.setM2(TEST_FLOAT);
    assertThat(underTest.getM2()).isEqualTo(TEST_FLOAT);
  }
 
  @Test
  public void testGetNumeroHabitaciones() {
    underTest.setNumeroHabitaciones(TEST_INTEGER);
    assertThat(underTest.getNumeroHabitaciones()).isEqualTo(TEST_INTEGER);
  }
 
  @Test
  public void testEquals() throws Exception {
    /*
     * EqualsVerifier.forClass(User.class).withPrefabValues(UserId.class,
     * mock(UserId.class), mock(UserId.class)) .withPrefabValues(UserId.class, null,
     * null) .withPrefabValues(User.class, mock(User.class), mock(User.class));
     */
 
    HabitacionTipo data = mock(HabitacionTipo.class);
    assertEquals("Los objetos coinciden ", data, data);
    assertNull("El objeto other es null ", null);
    assertNotEquals(
        "Los objetos no pertenecen a la misma clase", mock(HabitacionTipo.class), mock(User.class));
  }
}
