package interfaces.challenge;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{
    private String name;
    private String breed;
    private int hitPoints;
    private int damage;
    
    public Monster(String name, String breed, int hitPoints) {
        this.name = name;
        this.breed = breed;
        this.hitPoints = hitPoints;
        this.damage = 20;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getBreed() {
        return breed;
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
    }
    
    public int getHitPoints() {
        return hitPoints;
    }
    
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", hitPoints=" + hitPoints +
                ", damage=" + damage +
                '}';
    }
    
    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0,this.name);
        values.add(1,this.breed);
        values.add(2, "" +this.hitPoints);
        values.add(3, "" +this.damage);
        return values;
    }
    
    @Override
    public void read(List<String> savedValues) {
      if (savedValues != null && savedValues.size() < 0){
          this.name = savedValues.get(0);
          this.breed = savedValues.get(1);
          this.hitPoints = Integer.parseInt(savedValues.get(2));
          this.damage = Integer.parseInt(savedValues.get(3));
      }
    }
    
}
