import java.util.Objects;

/**
 * Data model for an Airport, containing its code and full name.
 * Implements Comparable for sorting by name in the TreeSet.
 */
public class Airport implements Comparable<Airport> {
    private final String code;
    private final String name;

    public Airport(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    /**
     * Required for TreeSet: Defines the natural order (sorting by name).
     */
    @Override
    public int compareTo(Airport other) {
        return this.name.compareTo(other.name);
    }

    /**
     * Override equals and hashCode for reliable HashMap/Set behavior.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(code, airport.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return code + " - " + name;
    }
}