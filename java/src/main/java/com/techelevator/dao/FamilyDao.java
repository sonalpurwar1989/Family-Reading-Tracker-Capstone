package com.techelevator.dao;

import com.techelevator.model.Family;
import java.util.List;
public interface FamilyDao {

    void addFamily(Family family);

    List<Family> getAllFamilies();

    Family getFamilyById(Integer familyId);

    void updateFamily(Family family);

    void deleteFamily(Integer familyId);

    List <Family> getAllFamiliesWithQueryForRowSet();




}
