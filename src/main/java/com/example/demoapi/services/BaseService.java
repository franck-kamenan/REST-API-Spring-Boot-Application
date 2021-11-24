package com.example.demoapi.services;

import java.util.List;

public interface BaseService<TDOT, TFORM, TID> {
    
    List<TDOT> getAll();
    TDOT getOneById(TID id);
    void insert(TFORM form);
    void delete(TID id);
    TDOT update(TFORM form, TID id);
}
