package SearchBinaryTree;

public class Lamp implements Comparable<Lamp>{

    private String lampCode, lampType;
    private int lampWatts, amount;

    public Lamp(String lampCode, String lampType, int lampWatts, int amount) {
        if(lampCode.length() != 5 || lampType.length() >= 10){
            throw new RuntimeException("Invalid input");
        }
        this.lampCode = lampCode;
        this.lampType = lampType;
        this.lampWatts = lampWatts;
        this.amount = amount;
    }

    public Lamp(String lampCode) {
        if(lampCode.length() != 5)
            throw new RuntimeException("Invalid input");
        this.lampCode = lampCode;
    }


    public void printData(){
        System.out.println("LampCode: " + lampCode + " LampType: "
                + lampType + " LampWatts: " + lampWatts + " Amount: " + amount);
    }

    public void setLampType(String lampType) {
        if(lampType.length() >= 10){
            throw new RuntimeException("Invalid input");
        }
        this.lampType = lampType;
    }

    public void setLampWatts(int lampWatts) {
        this.lampWatts = lampWatts;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getLampCode() {
        return lampCode;
    }

    public String getLampType() {
        return lampType;
    }

    public int getLampWatts() {
        return lampWatts;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public int compareTo(Lamp o) {
        if(this.lampCode.compareTo(o.lampCode) > 0){
            return 1;
        } else if(this.lampCode.compareTo(o.lampCode) < 0){
            return -1;
        }
        return 0;
    }
}
