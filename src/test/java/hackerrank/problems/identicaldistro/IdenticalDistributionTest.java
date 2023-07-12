package hackerrank.problems.identicaldistro;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IdenticalDistributionTest {

    @Test
    void example1() {
        List<Integer> input = List.of(3, 8, 7, 6, 4);
        int result = IdenticalDistribution.cardPackets(input);
        assertEquals(2, result);
    }

    @Test
    void example2() {
        List<Integer> input = List.of(3, 9, 7, 6, 5, 2);
        int result = IdenticalDistribution.cardPackets(input);
        assertEquals(4, result);
    }
}