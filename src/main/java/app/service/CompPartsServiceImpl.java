package app.service;



import app.dao.Dao;
import app.entity.CompPart;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompPartsServiceImpl implements CompPartsService {
    @Autowired
    private  Dao dao;

    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    public CompPartsServiceImpl() {

    }


    @Override
    public void createCompPart(CompPart compPart) {
        dao.createCompPart(compPart);
    }

    @Override
    public void updateCompPart(CompPart compPart) {
        dao.updateCompPart(compPart);
    }

    @Override
    public void deleteCompPart(int id) {
        dao.deleteCompPart(id);
    }

    @Override
    public List<CompPart> getCompParts() {
        return dao.getCompParts();
    }

    @Override
    public List<CompPart> getCompParts(String partName) {
        return dao.getCompParts(partName);
    }

    @Override
    public CompPart getCompPart(int id) {
        return dao.getCompPart(id);
    }

    @Override
    public List<CompPart> getRequired(String isRequired) {
        return dao.getRequired(isRequired);
    }

    @Override
    public int computersAssembled() {
        return dao.computersAssembled();
    }


}