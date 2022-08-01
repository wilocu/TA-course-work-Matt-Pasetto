package Actions;

public final class Action implements ActionType{

    private final int actionId;
    private final int originId;
    private final int desId;

    public Action(int actionId, int originId, int desId){
        this.actionId = actionId;
        this.originId = originId;
        this.desId = desId;
    }

    @Override
    public boolean approved() {
        //approve the action or don't approve it here
        return true;
    }

    @Override
    public int getActionId() {
        return actionId;
    }

    @Override
    public int getOriginAccId() {
        return originId;
    }

    @Override
    public int getDestinationAccId() {
        return desId;
    }
}
