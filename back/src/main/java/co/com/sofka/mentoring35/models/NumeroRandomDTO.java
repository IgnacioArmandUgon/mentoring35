package co.com.sofka.mentoring35.models;

public class NumeroRandomDTO {

    private Integer initialNumber;

    private Integer finalNumber;

    private Integer amount;

    private int[] numbersList;

    public Integer getFinalNumber() {
        return finalNumber;
    }

    public Integer getInitialNumber() {
        return initialNumber;
    }

    public int[] getNumbersList() {
        return numbersList;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setFinalNumber(Integer finalNumber) {
        this.finalNumber = finalNumber;
    }

    public void setInitialNumber(Integer initialNumber) {
        this.initialNumber = initialNumber;
    }

    public void setNumbersList(int[] numbersList) {
        this.numbersList = numbersList;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
