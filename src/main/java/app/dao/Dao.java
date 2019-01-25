package app.dao;


import app.entity.CompPart;

import java.util.List;

public interface Dao  {
    //CRUD
    void createCompPart(CompPart compPart);
    void updateCompPart(CompPart compPart);
    void deleteCompPart(int id);
    CompPart getCompPart(int id);

    //Sort
    List<CompPart> getCompParts();
    List<CompPart> getCompParts(String partDescription);
    List<CompPart> getRequired(String isRequired);

    //Computers from components
    int computersAssembled();
}