package Book_5_7_2;

import java.util.Collection;
import java.util.HashSet;

public class RaceResultsService {
    private Collection<Client> clients = new HashSet<Client>();
    private Collection<Subscribers> subscribers=new HashSet<Subscribers>();
    private Logger logger;

    public RaceResultsService(Logger logger) {
        this.logger = logger;
    }

    public void addSubscriber(Client client, SubscriptionCategory category) {
        boolean isSubs=false;
        for(Subscribers s : subscribers)
        {
            if(s.getSubscriptionCategory().equals(category) && client.equals(s.getClient()))
            {
                isSubs=true;
                break;
            }
        }
        if (!isSubs)
        {
            subscribers.add(new Subscribers(client,category));
        }
    }

    public void send(Message message) {
        logger.log(message.getDate(), message.getMessage());
        subscribers.stream()
                .filter(s -> s.getSubscriptionCategory() == message.getSubscriptionCategory())
                .forEach(s -> s.getClient().receive(message));
    }

    public void removeSubscriber(Client client, SubscriptionCategory category) {

        boolean isSubscribed=false;
        for(Subscribers s : subscribers)
        {
            if(s.getSubscriptionCategory().equals(category) && client.equals(s.getClient()))
            {
                isSubscribed=true;
                subscribers.remove(s);
                break;
            }
        }

    }
}
