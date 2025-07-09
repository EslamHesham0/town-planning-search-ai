

public class LLAPSearch extends GenericSearch<TownState, Action> {

    public LLAPSearch() {
        super();

    }

    public static String solve(String initalState,String strategy, boolean visualize){
    	
    	TownState town = TownState.fromString(initalState);

        if (strategy.equals("BF")) 
            return LLAPSearch.breadthFirstSearch(town, visualize);
        
        if (strategy.equals("DF"))
            return LLAPSearch.depthFirstSearch(town, visualize);
        
        if(strategy.equals("ID"))
        	return iterativeDeepeningSearch(town,visualize);
        
        if(strategy.equals("UC"))
        	return LLAPSearch.UCSSearch(town, visualize);
        
        if(strategy.equals("GR1"))
        	return LLAPSearch.GR1Search(town, visualize);
        
        if(strategy.equals("GR2"))
        	return LLAPSearch.GR2Search(town, visualize);
        
        if(strategy.equals("AS1"))
        	return LLAPSearch.AS1Search(town, visualize);
        
        if(strategy.equals("AS2"))
        	return LLAPSearch.AS2Search(town, visualize);
        
        return "NOSOLUTION";
        
        
        
    }
    
    public static void main(String[] args) {
    	String x = solve("29;" +
                "14,9,26;" +
                "650,400,710;" +
                "20,2;29,2;38,1;" +
                "8255,8,7,9,36;" +
                "30670,12,12,11,36;","BF",true);
		System.out.println(x);
	}
    // Implement necessary methods, including the solve method.
}