package ru.dyudin.homework.countries;

class NoSuchCountryException extends Exception {
    protected NoSuchCountryException(final String e) {
        super(e);
    }
}
