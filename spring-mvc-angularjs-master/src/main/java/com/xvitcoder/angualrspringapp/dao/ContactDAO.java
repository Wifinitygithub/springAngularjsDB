package com.xvitcoder.angualrspringapp.dao;

import java.util.List;

import com.xvitcoder.angualrspringapp.beans.Train;


public interface ContactDAO {
     
    public void saveOrUpdate(Train contact);
     
    public void delete(int contactId);
     
    public Train get(int contactId);
     
    public List<Train> list();
}
