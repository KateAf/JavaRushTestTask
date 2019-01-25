package app.service;

import app.entity.CompPart;

import java.util.List;

public interface CompPartsService {
    //CRUD
    void createCompPart(CompPart compPart);
    void updateCompPart(CompPart compPart);
    void deleteCompPart(int id);

    //Sort
    List<CompPart> getCompParts();
    List<CompPart> getCompParts(String partDescription);
    CompPart getCompPart(int id);
    List<CompPart> getRequired(String isRequired);

    //Computers from components
    int computersAssembled();
}