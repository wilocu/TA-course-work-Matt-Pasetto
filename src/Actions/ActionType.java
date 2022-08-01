package Actions;

public interface ActionType {

    boolean approved();

    int getActionId();

    int getOriginAccId();

    int getDestinationAccId();

}
