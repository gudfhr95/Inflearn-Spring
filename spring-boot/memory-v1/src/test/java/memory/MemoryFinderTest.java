package memory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MemoryFinderTest {

  @Test
  void get() {
    MemoryFinder memoryFinder = new MemoryFinder();
    Memory memory = memoryFinder.get();
    assertThat(memory).isNotNull();
  }
}