public class iPhone {
    private final String model;
    private final Integer yearOfIssue;

    public iPhone(String model, Integer yearOfIssue) {
        this.model = model;
        this.yearOfIssue = yearOfIssue;
    }

    public String getModel() {
        return model;
    }

    public Integer getYearOfIssue() {
        return yearOfIssue;
    }

    @Override
    public String toString() {
        return  model + ": " +
                "год выпуска - " + yearOfIssue;
    }
}
