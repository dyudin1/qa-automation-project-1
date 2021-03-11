package ru.dyudin.homework.countries;

public enum Country {
    RU("Russia", true),
    CA("Canada", false),
    UK("United Kingdom", true);

    private final String enName;
    private final boolean isOpen;

    String getEnName() {
        return enName;
    }

    boolean getIsOpen() {
        return isOpen;
    }

    Country(final String enName, final boolean isOpen) {
        this.enName = enName;
        this.isOpen = isOpen;
    }

    @Override
    public String toString() {
        return "Country " + enName
                + "(" + this.name() + ")";
    }

    static Country getByName(final String countryName) throws NoSuchCountryException {

        for (Country i : Country.values()) {
            if (countryName.equalsIgnoreCase(i.enName)) {
                return i;
            }
        }
        throw new NoSuchCountryException("Country " + countryName + " not found");
    }

    static class NoSuchCountryException extends Exception {
        protected NoSuchCountryException(final String e) {
            super(e);
        }
    }
}