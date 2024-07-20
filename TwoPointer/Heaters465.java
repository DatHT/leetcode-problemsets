package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Heaters465 {
    public int findRadius(int[] houses, int[] heaters) {
        if (houses.length == heaters.length) {
            boolean isDiff = false;
            for (int i = 0; i < houses.length; i++) {
                if (houses[i] != heaters[i]) {
                    isDiff = true;
                }
            }
            if (!isDiff) return 0;
        }
        Set<Integer> set = Arrays.stream(heaters).boxed().collect(Collectors.toSet());
        Set<Integer> remaining = new HashSet<>();
        Set<Integer> bag = new HashSet<>();
        int result = 0;
        for (int i = 0; i < houses.length; i++) {
            if (set.contains(houses[i])) {
                bag.add(houses[i]);
                if (i > 0) {
                    bag.add(houses[i - 1]);
                    result = Math.max(result, Math.abs(houses[i - 1] - houses[i]));
                } else if (i < houses.length - 1) {
                    bag.add(houses[i + 1]);
                    result = Math.max(result, Math.abs(houses[i + 1] - houses[i]));
                }
            } else {
                if (!bag.contains(houses[i])) {
                    remaining.add(houses[i]);
                }
            }
        }
        if (remaining.size() == 0) return result;
        for (int house : remaining) {
            int min = Integer.MAX_VALUE;
            for (int heater : heaters) {
                min = Math.min(min, Math.abs(house - heater));
            }
            result = Math.max(result, min);
        }
        return result;
    }
}
