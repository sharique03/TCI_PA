package Book_5_7_2;

public class Subscribers {
    private Client client;
    private SubscriptionCategory subscriptionCategory;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public SubscriptionCategory getSubscriptionCategory() {
        return subscriptionCategory;
    }

    public void setSubscriptionCategory(SubscriptionCategory subscriptionCategory) {
        this.subscriptionCategory = subscriptionCategory;
    }

    public Subscribers(Client client, SubscriptionCategory subscriptionCategory) {
        this.client = client;
        this.subscriptionCategory = subscriptionCategory;
    }
}
