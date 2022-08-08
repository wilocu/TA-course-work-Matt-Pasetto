package Actions;

public interface IActionType {

    boolean approved();

    int getActionId();

    int getOriginAccId();

    int getDestinationAccId();

}
