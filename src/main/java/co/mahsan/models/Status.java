package co.mahsan.models;

public enum Status {
    BANNED("Banned"),
    BORROWED("Borrowed"),
    EXIST("Exist");

    private final String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return getDisplayName();
    }
}
