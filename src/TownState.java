

import java.util.ArrayList;
import java.util.Objects;

public class TownState {
    private int Money = 100000;
    private int initialProsperity;
    private int initialFood;
    private int initialMaterials;
    private int initialEnergy;
    private int unitPriceFood;
    private int unitPriceMaterials;
    private int unitPriceEnergy;
    private int amountRequestFood;
    private int delayRequestFood;
    private int amountRequestMaterials;
    private int delayRequestMaterials;
    private int amountRequestEnergy;
    private int delayRequestEnergy;
    private int priceBUILD1;
    private int foodUseBUILD1;
    private int materialsUseBUILD1;
    private int energyUseBUILD1;
    private int prosperityBUILD1;
    private int priceBUILD2;
    private int foodUseBUILD2;
    private int materialsUseBUILD2;
    private int energyUseBUILD2;
    private int prosperityBUILD2;
    private int prosperity;
    private int Food;
    private int Materials;
    private int Energy;
    public boolean Request = false;
    public String RequestAmount;
    public String RequestType;
    public int delay;


    public TownState(
            int initialProsperity,
            int initialFood,
            int initialMaterials,
            int initialEnergy,
            int unitPriceFood,
            int unitPriceMaterials,
            int unitPriceEnergy,
            int amountRequestFood,
            int delayRequestFood,
            int amountRequestMaterials,
            int delayRequestMaterials,
            int amountRequestEnergy,
            int delayRequestEnergy,
            int priceBUILD1,
            int foodUseBUILD1,
            int materialsUseBUILD1,
            int energyUseBUILD1,
            int prosperityBUILD1,
            int priceBUILD2,
            int foodUseBUILD2,
            int materialsUseBUILD2,
            int energyUseBUILD2,
            int prosperityBUILD2
    ) {
    	
        this.initialProsperity = initialProsperity;
        this.initialFood = initialFood;
        this.initialMaterials = initialMaterials;
        this.initialEnergy = initialEnergy;
        this.unitPriceFood = unitPriceFood;
        this.unitPriceMaterials = unitPriceMaterials;
        this.unitPriceEnergy = unitPriceEnergy;
        this.amountRequestFood = amountRequestFood;
        this.delayRequestFood = delayRequestFood;
        this.amountRequestMaterials = amountRequestMaterials;
        this.delayRequestMaterials = delayRequestMaterials;
        this.amountRequestEnergy = amountRequestEnergy;
        this.delayRequestEnergy = delayRequestEnergy;
        this.priceBUILD1 = priceBUILD1;
        this.foodUseBUILD1 = foodUseBUILD1;
        this.materialsUseBUILD1 = materialsUseBUILD1;
        this.energyUseBUILD1 = energyUseBUILD1;
        this.prosperityBUILD1 = prosperityBUILD1;
        this.priceBUILD2 = priceBUILD2;
        this.foodUseBUILD2 = foodUseBUILD2;
        this.materialsUseBUILD2 = materialsUseBUILD2;
        this.energyUseBUILD2 = energyUseBUILD2;
        this.prosperityBUILD2 = prosperityBUILD2;
        prosperity = initialProsperity;
        Food = initialFood;
        Materials = initialMaterials;
        Energy = initialEnergy;
        RequestAmount = "";
        RequestType = "";
    }
    
    public TownState(TownState other) {
        this.initialProsperity = other.initialProsperity;
        this.initialFood = other.initialFood;
        this.initialMaterials = other.initialMaterials;
        this.initialEnergy = other.initialEnergy;
        this.unitPriceFood = other.unitPriceFood;
        this.unitPriceMaterials = other.unitPriceMaterials;
        this.unitPriceEnergy = other.unitPriceEnergy;
        this.amountRequestFood = other.amountRequestFood;
        this.delayRequestFood = other.delayRequestFood;
        this.amountRequestMaterials = other.amountRequestMaterials;
        this.delayRequestMaterials = other.delayRequestMaterials;
        this.amountRequestEnergy = other.amountRequestEnergy;
        this.delayRequestEnergy = other.delayRequestEnergy;
        this.priceBUILD1 = other.priceBUILD1;
        this.foodUseBUILD1 = other.foodUseBUILD1;
        this.materialsUseBUILD1 = other.materialsUseBUILD1;
        this.energyUseBUILD1 = other.energyUseBUILD1;
        this.prosperityBUILD1 = other.prosperityBUILD1;
        this.priceBUILD2 = other.priceBUILD2;
        this.foodUseBUILD2 = other.foodUseBUILD2;
        this.materialsUseBUILD2 = other.materialsUseBUILD2;
        this.energyUseBUILD2 = other.energyUseBUILD2;
        this.prosperityBUILD2 = other.prosperityBUILD2;
        this.prosperity = other.prosperity;
        this.Food = other.Food;
        this.Materials = other.Materials;
        this.Energy = other.Energy;
        this.Money = other.Money;
        this.Request = other.Request;
        this.RequestAmount = other.RequestAmount;
        this.RequestType = other.RequestType;
        this.delay = other.delay;
    }

    public void GetTownStatus(){
        System.out.println("Money: " + Money + "\nProsperity: " + prosperity + "\nFood: " + Food + "\nMaterials: " + Materials + "\nEnergy: " + Energy);
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TownState townState = (TownState) o;
        return Objects.equals(getStateString(), townState.getStateString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStateString());
    }

    private String getStateString() {
        // Concatenate relevant fields to create a string representation of the state
        return initialProsperity + "-" + initialFood + "-" + initialMaterials + "-" +
               initialEnergy + "-" + unitPriceFood + "-" + unitPriceMaterials + "-" +
               unitPriceEnergy + "-" + amountRequestFood + "-" + delayRequestFood + "-" +
               amountRequestMaterials + "-" + delayRequestMaterials + "-" + amountRequestEnergy + "-" +
               delayRequestEnergy + "-" + priceBUILD1 + "-" + foodUseBUILD1 + "-" + materialsUseBUILD1 + "-" +
               energyUseBUILD1 + "-" + prosperityBUILD1 + "-" + priceBUILD2 + "-" + foodUseBUILD2 + "-" +
               materialsUseBUILD2 + "-" + energyUseBUILD2 + "-" + prosperityBUILD2 + "-" + prosperity + "-" +
               Food + "-" + Materials + "-" + Energy + "-" + Request + "-" + RequestAmount + "-" + RequestType + "-" + delay;
    }
    
    public int getUnitPriceFood() {
        return unitPriceFood;
    }


    public int getUnitPriceMaterials() {
        return unitPriceMaterials;
    }


    public int getUnitPriceEnergy() {
        return unitPriceEnergy;
    }


    public int getAmountRequestFood() {
        return amountRequestFood;
    }


    public int getDelayRequestFood() {
        return delayRequestFood;
    }


    public int getAmountRequestMaterials() {
        return amountRequestMaterials;
    }


    public int getDelayRequestMaterials() {
        return delayRequestMaterials;
    }


    public int getAmountRequestEnergy() {
        return amountRequestEnergy;
    }


    public int getDelayRequestEnergy() {
        return delayRequestEnergy;
    }


    public int getPriceBUILD1() {
        return priceBUILD1;
    }


    public int getFoodUseBUILD1() {
        return foodUseBUILD1;
    }


    public int getMaterialsUseBUILD1() {
        return materialsUseBUILD1;
    }


    public int getEnergyUseBUILD1() {
        return energyUseBUILD1;
    }


    public int getProsperityBUILD1() {
        return prosperityBUILD1;
    }


    public int getPriceBUILD2() {
        return priceBUILD2;
    }


    public int getFoodUseBUILD2() {
        return foodUseBUILD2;
    }


    public int getMaterialsUseBUILD2() {
        return materialsUseBUILD2;
    }


    public int getEnergyUseBUILD2() {
        return energyUseBUILD2;
    }


    public int getProsperityBUILD2() {
        return prosperityBUILD2;
    }
        
    public int getMoney() {
        return Money;
    }


    public int getInitialProsperity() {
        return initialProsperity;
    }


    public int getInitialFood() {
        return initialFood;
    }


    public int getInitialMaterials() {
        return initialMaterials;
    }


    public int getInitialEnergy() {
        return initialEnergy;
    }

    
    public void setMoney(int money) {
        Money = money;
    }


    public void setInitialProsperity(int initialProsperity) {
        this.initialProsperity = initialProsperity;
    }


    public void setInitialFood(int initialFood) {
        this.initialFood = initialFood;
    }


    public void setInitialMaterials(int initialMaterials) {
        this.initialMaterials = initialMaterials;
    }


    public void setInitialEnergy(int initialEnergy) {
        this.initialEnergy = initialEnergy;
    }


    public void setUnitPriceFood(int unitPriceFood) {
        this.unitPriceFood = unitPriceFood;
    }


    public void setUnitPriceMaterials(int unitPriceMaterials) {
        this.unitPriceMaterials = unitPriceMaterials;
    }


    public void setUnitPriceEnergy(int unitPriceEnergy) {
        this.unitPriceEnergy = unitPriceEnergy;
    }


    public void setAmountRequestFood(int amountRequestFood) {
        this.amountRequestFood = amountRequestFood;
    }


    public void setDelayRequestFood(int delayRequestFood) {
        this.delayRequestFood = delayRequestFood;
    }


    public void setAmountRequestMaterials(int amountRequestMaterials) {
        this.amountRequestMaterials = amountRequestMaterials;
    }


    public void setDelayRequestMaterials(int delayRequestMaterials) {
        this.delayRequestMaterials = delayRequestMaterials;
    }


    public void setAmountRequestEnergy(int amountRequestEnergy) {
        this.amountRequestEnergy = amountRequestEnergy;
    }


    public void setDelayRequestEnergy(int delayRequestEnergy) {
        this.delayRequestEnergy = delayRequestEnergy;
    }


    public void setPriceBUILD1(int priceBUILD1) {
        this.priceBUILD1 = priceBUILD1;
    }


    public void setFoodUseBUILD1(int foodUseBUILD1) {
        this.foodUseBUILD1 = foodUseBUILD1;
    }


    public void setMaterialsUseBUILD1(int materialsUseBUILD1) {
        this.materialsUseBUILD1 = materialsUseBUILD1;
    }


    public void setEnergyUseBUILD1(int energyUseBUILD1) {
        this.energyUseBUILD1 = energyUseBUILD1;
    }


    public void setProsperityBUILD1(int prosperityBUILD1) {
        this.prosperityBUILD1 = prosperityBUILD1;
    }


    public void setPriceBUILD2(int priceBUILD2) {
        this.priceBUILD2 = priceBUILD2;
    }


    public void setFoodUseBUILD2(int foodUseBUILD2) {
        this.foodUseBUILD2 = foodUseBUILD2;
    }


    public void setMaterialsUseBUILD2(int materialsUseBUILD2) {
        this.materialsUseBUILD2 = materialsUseBUILD2;
    }


    public void setEnergyUseBUILD2(int energyUseBUILD2) {
        this.energyUseBUILD2 = energyUseBUILD2;
    }


    public void setProsperityBUILD2(int prosperityBUILD2) {
        this.prosperityBUILD2 = prosperityBUILD2;
    }


    public int getProsperity() {
        return prosperity;
    }


    public void setProsperity(int prosperity) {
        this.prosperity = Math.min(prosperity, 100);;
    }


    public int getFood() {
        return Food;
    }


    public void setFood(int food) {
        this.Food = Math.min(food, 50);
    }


    public int getMaterials() {
        return Materials;
    }


    public void setMaterials(int materials) {
        Materials = Math.min(materials, 50);;
    }


    public int getEnergy() {
        return Energy;
    }


    public void setEnergy(int energy) {
        Energy = Math.min(energy, 50);;
    }


    public static TownState fromString(String input) {
        String[] values = input.split(";");

        //initial state values
        int initialProsperity = Integer.parseInt(values[0]);
        String[] resourceValues = values[1].split(",");
        int initialFood = Integer.parseInt(resourceValues[0]);
        int initialMaterials = Integer.parseInt(resourceValues[1]);
        int initialEnergy = Integer.parseInt(resourceValues[2]);
        
        //unit price values
        String[] unitPriceValues = values[2].split(",");
        int unitPriceFood = Integer.parseInt(unitPriceValues[0]);
        int unitPriceMaterials = Integer.parseInt(unitPriceValues[1]);
        int unitPriceEnergy = Integer.parseInt(unitPriceValues[2]);
        
        //delivery request values
        String[] amountDelayRequestValuesFood = values[3].split(",");
        int amountRequestFood = Integer.parseInt(amountDelayRequestValuesFood[0]);
        int delayRequestFood = Integer.parseInt(amountDelayRequestValuesFood[1]);
        
        String[] amountDelayRequestValuesMaterials = values[4].split(",");
        int amountRequestMaterials = Integer.parseInt(amountDelayRequestValuesMaterials[0]);
        int delayRequestMaterials = Integer.parseInt(amountDelayRequestValuesMaterials[1]);
        
        String[] amountDelayRequestValuesEnergy = values[5].split(",");
        int amountRequestEnergy = Integer.parseInt(amountDelayRequestValuesEnergy[0]);
        int delayRequestEnergy = Integer.parseInt(amountDelayRequestValuesEnergy[1]);
        
        //build1 values
        String[] build1Values = values[6].split(",");
        int priceBUILD1 = Integer.parseInt(build1Values[0]);
        int foodUseBUILD1 = Integer.parseInt(build1Values[1]);
        int materialsUseBUILD1 = Integer.parseInt(build1Values[2]);
        int energyUseBUILD1 = Integer.parseInt(build1Values[3]);
        int prosperityBUILD1 = Integer.parseInt(build1Values[4]);
        
        //build2 values
        String[] build2Values = values[7].split(",");
        int priceBUILD2 = Integer.parseInt(build2Values[0]);
        int foodUseBUILD2 = Integer.parseInt(build2Values[1]);
        int materialsUseBUILD2 = Integer.parseInt(build2Values[2]);
        int energyUseBUILD2 = Integer.parseInt(build2Values[3]);
        int prosperityBUILD2 = Integer.parseInt(build2Values[4]);
        

        return new TownState(
            initialProsperity,
            initialFood,
            initialMaterials,
            initialEnergy,
            unitPriceFood,
            unitPriceMaterials,
            unitPriceEnergy,
            amountRequestFood,
            delayRequestFood,
            amountRequestMaterials,
            delayRequestMaterials,
            amountRequestEnergy,
            delayRequestEnergy,
            priceBUILD1,
            foodUseBUILD1,
            materialsUseBUILD1,
            energyUseBUILD1,
            prosperityBUILD1,
            priceBUILD2,
            foodUseBUILD2,
            materialsUseBUILD2,
            energyUseBUILD2,
            prosperityBUILD2
        );
    }
}
