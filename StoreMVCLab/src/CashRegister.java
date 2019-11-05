import javafx.beans.property.*;
public class CashRegister implements ProductObserver {
    private DoubleProperty cash = new SimpleDoubleProperty();

    public CashRegister() {
        cash.set(0.0);
    }

    public void add(double money) {
        setCash(getCash() + money);
    }
    public final double getCash(){
        return cash.get();
    }

    private final void setCash(double value){
        cash.set(value);
    }

    public ReadOnlyDoubleProperty cashProperty(){
        return cash;
    }

    @Override
    public void handleSale(double amount) {
        add(amount);
    }
}
