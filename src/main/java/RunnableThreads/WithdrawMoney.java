package RunnableThreads;

import Accounts.CustomerAcc;
import org.apache.log4j.Logger;

public class WithdrawMoney implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(DepositMoney.class.getName());

    Double amount;
    CustomerAcc customerAcc;
    final Object lock1;
    final Object lock2;

    public WithdrawMoney(CustomerAcc customerAcc, Double amount, Object Lock1, Object Lock2) {
        this.amount = amount;
        this.customerAcc = customerAcc;
        lock1 = Lock1;
        lock2 = Lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            LOGGER.info("Holding delivery lock1");
            try {
                //Delivery vehicle traveling the distance of the route
                Thread.sleep(100L * (long)Math.floor(amount + 0.5d));
                synchronized (lock2) {
                    LOGGER.info("Waiting for the money");
                    customerAcc.subtractBalance(amount);
                    LOGGER.info(amount + " has been withdraw");
                }
            } catch (InterruptedException e) {
                LOGGER.info("Error, money not removed.");
            }
        }
    }
}