

class NodeH 
{
     TownState state;
     String action;
     int astar1;
     int astar2;
     int greedy1;
     int greedy2;
     int pathCost;
     int depth;
     NodeH parent;

    public NodeH(TownState state, String action, NodeH parent) {
    	if(parent == null)
    		depth=0;
    	else
    		depth = parent.depth + 1;
        this.state = state;
        this.action = action;
        this.parent = parent;
        this.pathCost = pathCost(this);
        this.astar1 = ((100 - state.getProsperity())/Integer.max(state.getProsperityBUILD1(),state.getProsperityBUILD2()))*(Integer.min(state.getPriceBUILD1(), state.getPriceBUILD2()))+ this.pathCost;
        this.astar2 = (100 - state.getProsperity())/((state.getProsperityBUILD1()+state.getProsperityBUILD2())/2)*((state.getPriceBUILD1()+state.getPriceBUILD2())/2) + this.pathCost;
        this.greedy1 = ((100 - state.getProsperity())/Integer.max(state.getProsperityBUILD1(),state.getProsperityBUILD2()))*(Integer.min(state.getPriceBUILD1(), state.getPriceBUILD2()));
        this.greedy2 = (100 - state.getProsperity())/((state.getProsperityBUILD1()+state.getProsperityBUILD2())/2)*((state.getPriceBUILD1()+state.getPriceBUILD2())/2);
    }
    
    public int pathCost(NodeH t)
    {
    	NodeH current = t;
    	int pC = 0;
    	while(current.parent!=null)
    	{
    		Action j = new Action(current.state);
    		pC+=j.getActionPrice(current.action);
    		current = current.parent;
    	}
    	return pC;
    }

    public TownState getState() {
        return state;
    }

    public String getAction() {
        return action;
    }

    public NodeH getParent() {
        return parent;
    }

	public int getAstar1() {
		return astar1;
	}

	public int getAstar2() {
		return astar2;
	}

	public int getGreedy1() {
		return greedy1;
	}

	public int getGreedy2() {
		return greedy2;
	}

	public int getPathCost() {
		return pathCost;
	}

    
}