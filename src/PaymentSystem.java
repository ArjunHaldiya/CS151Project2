public class PaymentSystem {

    public double processPayment(double amount) {
        if (!validatePayment(amount)) {

            System.out.println("Invalid payment amount.");
            return 0;
        }

        System.out.println("Payment of $" + amount + " processed.");

        return amount;
    }

    public boolean validatePayment(double amount) {
        return amount > 0;
    }

    public void printReceipt(double amount) {
        if (amount > 0) {
            System.out.println("Receipt: Paid $" + amount);
        } else {
            System.out.println("No valid payment made.");
        }
    }

    public boolean refundPayment(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid refund amount.");
            return false;

        }

        System.out.println("Refunded $" + amount);

        return true;
    }

    public void displayPaymentStatus(boolean paid) {
        if (paid) {

            System.out.println("Payment completed successfully.");
        } else {
            System.out.println("Payment pending.");
            
        }
    }
}