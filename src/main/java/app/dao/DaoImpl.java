package app.dao;

import app.entity.CompPart;
import app.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DaoImpl implements Dao {
    String queryPartDescription = "SELECT t.* FROM parts t WHERE t.description like '%" ;
    String queryIsRequired = "SELECT t.* FROM parts t WHERE t.required = " ;

    private final AppRepository Repository;

    //List<CompPart> partList = new ArrayList<>();

    @Autowired
    public DaoImpl(AppRepository Repository) {

        this.Repository = Repository;

    }

    @Override
    public List<CompPart> getCompParts() {
        //return partList;
        return Repository.uploadAll();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CompPart> getCompParts(String partDescription) {
        String query = queryPartDescription + partDescription + "%'" ;
        List<Object[]> partObjects = Repository.uploadAll(query);

        List<CompPart> parts = new ArrayList<>();
        createListFromObjectArray(partObjects, parts);
        return parts;
    }

    @Override
    public CompPart getCompPart(int id) {

        return Repository.uploadOnId(id, CompPart.class);
    }


    @Override
    public void createCompPart(CompPart compPart) {
        Repository.create(compPart);
    }

    @Override
    public void updateCompPart(CompPart compPart) {
        Repository.update(compPart);
    }

    @Override
    public void deleteCompPart(int id) {
        CompPart comPart = new CompPart();
        comPart.setId(id);
        Repository.delete(comPart);	}



    @SuppressWarnings("unchecked")
    @Override
    public List<CompPart> getRequired(String isRequired) {
        if (isRequired.isEmpty()) return getCompParts();
        else {
            String query = queryIsRequired + isRequired;
            List<Object[]> partObjects = Repository.uploadAll(query);

            List<CompPart> parts = new ArrayList<>();
            createListFromObjectArray(partObjects, parts);
            return parts;
        }
    }

    @Override
    public int computersAssembled() {
        List<CompPart> required = getRequired("true");
        TreeSet<Integer> set = new TreeSet<>();
        for (CompPart part : required) {
            set.add(part.getQuantity());
        }
        if (set.isEmpty()) return 0;
        return set.first();
    }


    private void CreateListFromList(List<CompPart> compParts, List<CompPart> parts) {
        parts.addAll(compParts);
    }

    public static void createListFromObjectArray(List<Object[]> compPartObjects, List<CompPart> compParts) {

        for (Object[] compPartObject : compPartObjects) {
            CompPart compPart = new CompPart();

            int id = (int) compPartObject[0];
            String description = (String) compPartObject[1];
            boolean required = (boolean) compPartObject[2];
            int amount = (int) compPartObject[3];

            compPart.setId(id);
            compPart.setDescription(description);
            compPart.setRequired(required);
            compPart.setQuantity(amount);
            compParts.add(compPart);
        }
    }
}
