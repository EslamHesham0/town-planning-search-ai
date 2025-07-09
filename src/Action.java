public class Action {
    private TownState town;
    private boolean RequestActive = false;

    public Action(TownState town) {
        this.town = town;
    }


    public void consumeResources() {

        town.setFood(town.getFood() - 1);
        town.setMaterials(town.getMaterials()-1);
        town.setEnergy(town.getEnergy() - 1);
        int Price = town.getUnitPriceFood() + town.getUnitPriceEnergy() + town.getUnitPriceMaterials();
        town.setMoney(town.getMoney() - Price);
    }

    public void RequestFood(){
        if(RequestActive == false)
        {
            int money = town.getMoney();
            int FoodPrice = town.getUnitPriceFood() + town.getUnitPriceEnergy() + town.getUnitPriceMaterials();
            int Food = town.getFood();
            if(money>FoodPrice && Food<50)
            {
                town.RequestAmount = String.valueOf(town.getAmountRequestFood());
                town.RequestType = "Food";
                RequestActive = true;
                town.Request = true;
                town.delay = town.getDelayRequestFood();
                consumeResources();
            }
        }
    }

    public void RequestEnergy(){
        
        if(RequestActive == false)
        {
            int money = town.getMoney();
            int energy = town.getEnergy();
            int energyPrice=town.getUnitPriceFood() + town.getUnitPriceEnergy() + town.getUnitPriceMaterials();
            if(money >= energyPrice && energy <= 50)
            {
                RequestActive=true;
                town.Request = true;
                town.RequestAmount = String.valueOf(town.getAmountRequestEnergy());
                town.RequestType = "Energy";
                town.delay=town.getDelayRequestEnergy();
                consumeResources();
            }
        }
    }

    public void RequestMaterials(){
        
        if(RequestActive == false)
        {
            int money = town.getMoney();
            int energy = town.getMaterials();
            int materialsPrice=town.getUnitPriceFood() + town.getUnitPriceEnergy() + town.getUnitPriceMaterials();
            if(money >= materialsPrice && energy <= 50)
            {
                RequestActive=true;
                town.Request = true;
                town.RequestAmount = String.valueOf(town.getAmountRequestMaterials());
                town.RequestType = "Materials";
                town.delay=town.getDelayRequestEnergy();
                consumeResources();
            }
        }
    }

    public void WAIT()
    {
    	consumeResources();
        if(town.Request)
        {
        town.delay--;
        if(town.delay == 0)
        {
        	town.Request = false;
        	RequestActive = false;
            if(town.RequestType == ("Food"))
            {
                town.setFood(town.getFood() + Integer.parseInt(town.RequestAmount));
            }
            else if(town.RequestType == ("Energy"))
            {
                town.setEnergy(town.getEnergy() + Integer.parseInt(town.RequestAmount));
            }
            else if(town.RequestType == ("Materials"))
            {
                town.setMaterials(town.getMaterials() + Integer.parseInt(town.RequestAmount));
            }
            town.RequestType = "";
        }
        }
    }

    public void BUILD1() {
            
        int food = town.getFoodUseBUILD1();
        int materials = town.getMaterialsUseBUILD1();
        int energy = town.getEnergyUseBUILD1();
        int price = town.getPriceBUILD1();
        int prosperity = town.getProsperityBUILD1();
           
        if (food <= town.getFood() && materials <= town.getMaterials() 
        && energy <= town.getEnergy() && price <= town.getMoney()) 
        {    
            town.setFood(town.getFood() - food);
            town.setMaterials(town.getMaterials() - materials);
            town.setEnergy(town.getEnergy() - energy);
            town.setMoney(town.getMoney() - (price + (town.getUnitPriceFood() * food) + (town.getUnitPriceMaterials() * materials) + (town.getUnitPriceEnergy() * energy)));
            town.setProsperity(town.getProsperity() + prosperity);
        }

        if(town.Request)
        {
        town.delay--;
        if(town.delay == 0)
        {
        	town.Request = false;
        	RequestActive = false;
            if(town.RequestType == ("Food"))
            {
                town.setFood(town.getFood() + Integer.parseInt(town.RequestAmount));
            }
            else if(town.RequestType == ("Energy"))
            {
                town.setEnergy(town.getEnergy() + Integer.parseInt(town.RequestAmount));
            }
            else if(town.RequestType == ("Materials"))
            {
                town.setMaterials(town.getMaterials() + Integer.parseInt(town.RequestAmount));
            }
        }
        }
    }

    public void BUILD2() {
            
        int food = town.getFoodUseBUILD2();
        int materials = town.getMaterialsUseBUILD2();
        int energy = town.getEnergyUseBUILD2();
        int price = town.getPriceBUILD2();
        int prosperity = town.getProsperityBUILD2();
           
        if (food <= town.getFood() && materials <= town.getMaterials() 
        && energy <= town.getEnergy() && price <= town.getMoney()) 
        {    
            town.setFood(town.getFood() - food);
            town.setMaterials(town.getMaterials() - materials);
            town.setEnergy(town.getEnergy() - energy);
            town.setMoney(town.getMoney() - (price + (town.getUnitPriceFood() * food) + (town.getUnitPriceMaterials() * materials) + (town.getUnitPriceEnergy() * energy)));
            town.setProsperity(town.getProsperity() + prosperity);
        }
        
        if(town.Request)
        {
        town.delay--;
        if(town.delay == 0)
        {
        	town.Request = false;
        	RequestActive = false;
            if(town.RequestType == ("Food"))
            {
                town.setFood(town.getFood() + Integer.parseInt(town.RequestAmount));
            }
            else if(town.RequestType == ("Energy"))
            {
                town.setEnergy(town.getEnergy() + Integer.parseInt(town.RequestAmount));
            }
            else if(town.RequestType == ("Materials"))
            {
                town.setMaterials(town.getMaterials() + Integer.parseInt(town.RequestAmount));
            }
        }
        }
    }

    public boolean isValidAction(String actionType) {
        if(town.getMoney() == 0 || town.getFood() == 0 || town.getEnergy() == 0 || town.getMaterials() == 0)
        {
            return false;
        }
        if (actionType.equals("RequestFood")) {
            int money = town.getMoney();
           	int priceOfAction = town.getUnitPriceEnergy() + town.getUnitPriceFood() + town.getUnitPriceMaterials();
            int FoodPrice = town.getUnitPriceFood() * town.getAmountRequestFood() + priceOfAction;
            int Food = town.getFood();
            if(money>= priceOfAction && Food<50 && town.Request == false)
            {
                return true;
            }
            return false;
        } else if (actionType.equals("RequestEnergy")) {
            int money = town.getMoney();
            int energy = town.getEnergy();
            int priceOfAction = town.getUnitPriceEnergy() + town.getUnitPriceFood() + town.getUnitPriceMaterials();
            int energyPrice=town.getUnitPriceEnergy() * town.getAmountRequestEnergy();
            if(money >= priceOfAction && energy <= 50 && town.Request == false)
            {
                return true;
            }
            return false;
        } 
        else if (actionType.equals("RequestMaterials")){
            int money = town.getMoney();
            int energy = town.getMaterials();
            int priceOfAction = town.getUnitPriceEnergy() + town.getUnitPriceFood() + town.getUnitPriceMaterials();
            int materialsPrice=town.getUnitPriceMaterials() * town.getAmountRequestMaterials();
            if(money >= priceOfAction && energy <= 50 && town.Request == false){
                return true;
            }
            return false;
        }
        else if(actionType.equals("BUILD1")){
            int food = town.getFoodUseBUILD1();
            int materials = town.getMaterialsUseBUILD1();
            int energy = town.getEnergyUseBUILD1();
            int price = town.getPriceBUILD1();
            price +=(town.getUnitPriceFood() * food) + (town.getUnitPriceMaterials() * materials) + (town.getUnitPriceEnergy() * energy);
            if (food <= town.getFood() && materials <= town.getMaterials() 
            && energy <= town.getEnergy() && price <= town.getMoney()) 
            {
                return true;
            }
            return false;
        }
        else if(actionType.equals("BUILD2")){
            int food = town.getFoodUseBUILD2();
            int materials = town.getMaterialsUseBUILD2();
            int energy = town.getEnergyUseBUILD2();
            int price = town.getPriceBUILD2();
            price +=(town.getUnitPriceFood() * food) + (town.getUnitPriceMaterials() * materials) + (town.getUnitPriceEnergy() * energy);
            if (food <= town.getFood() && materials <= town.getMaterials() 
            && energy <= town.getEnergy() && price <= town.getMoney()) 
            {
                return true;
            }
            return false;
        }
        else if (actionType.equals("WAIT")) {
        	
        	int money = town.getMoney();
        	int priceOfAction = town.getUnitPriceEnergy() + town.getUnitPriceFood() + town.getUnitPriceMaterials();
        	
            if(town.getFood()>=1 && town.getEnergy()>=1 && town.getMaterials()>=1 && priceOfAction <= money)
            {
            	return true;
            }
            return false;
        }

        return false;
    }
    
    public int getActionPrice(String actionType)
    {
        switch (actionType) {
        case "RequestFood":
        	return town.getUnitPriceFood() * town.getAmountRequestFood() + town.getUnitPriceFood() + town.getUnitPriceEnergy() + town.getUnitPriceMaterials();
        case "RequestMaterials":
        	return town.getUnitPriceMaterials() * town.getAmountRequestMaterials() + town.getUnitPriceFood() + town.getUnitPriceEnergy() + town.getUnitPriceMaterials();
        case "RequestEnergy":
        	return town.getUnitPriceEnergy() * town.getAmountRequestEnergy() + town.getUnitPriceFood() + town.getUnitPriceEnergy() + town.getUnitPriceMaterials();
        case "WAIT":
        	return town.getUnitPriceFood() + town.getUnitPriceEnergy() + town.getUnitPriceMaterials();
        case "BUILD1":
        	int price = town.getPriceBUILD1();
            int food = town.getFoodUseBUILD1();
            int materials = town.getMaterialsUseBUILD1();
            int energy = town.getEnergyUseBUILD1();
        	return (price + (town.getUnitPriceFood() * food) + (town.getUnitPriceMaterials() * materials) + (town.getUnitPriceEnergy() * energy));
        case "BUILD2":
        	int price2 = town.getPriceBUILD2();
            int food2 = town.getFoodUseBUILD2();
            int materials2 = town.getMaterialsUseBUILD2();
            int energy2 = town.getEnergyUseBUILD2();
        	return (price2 + (town.getUnitPriceFood() * food2) + (town.getUnitPriceMaterials() * materials2) + (town.getUnitPriceEnergy() * energy2));  
        }
        return 0;
    }
    
    
}