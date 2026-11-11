public class Sponsor {
    private String brandName;
    private double fundingAmount;

    public Sponsor(String brandName, double fundingAmount) {
        this.brandName = brandName;
        this.fundingAmount = fundingAmount;
    }
    public String getBrandName() { return brandName; }
    public double getFundingAmount() { return fundingAmount; }
}