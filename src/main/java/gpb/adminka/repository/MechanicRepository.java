package gpb.adminka.repository;

import gpb.adminka.model.Mechanic;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MechanicRepository {
    private HashMap<Integer, Mechanic> mechanics;

    public MechanicRepository() {
        this.mechanics = new HashMap<>();
    }

    public MechanicRepository(HashMap<Integer, Mechanic> mechanics) {
        this.mechanics = mechanics;
    }

    public HashMap<Integer, Mechanic> getMechanics() {
        return mechanics;
    }

    public void setMechanics(HashMap<Integer, Mechanic> mechanics) {
        this.mechanics.putAll(mechanics);
    }

    public Mechanic getMechanic(int id) {
        return mechanics.get(id);
    }

    public void setMechanic(Mechanic mechanic) {
        mechanics.put(mechanic.getId(), mechanic);
    }
}
