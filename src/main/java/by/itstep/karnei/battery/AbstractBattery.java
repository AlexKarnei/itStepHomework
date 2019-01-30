package by.itstep.karnei.battery;

public class AbstractBattery implements Battery {
    private int charges;

    public AbstractBattery(int charges) {
        this.charges = charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

    protected int getCharges(){
        return charges;
    }

    public boolean getCharge(int charges) {
        if (charges>0 && this.charges>charges){
            this.charges-=charges;
            return true;
        }
        return false;
    }
}
