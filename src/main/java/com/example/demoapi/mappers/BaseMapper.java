package com.example.demoapi.mappers;

public interface BaseMapper<TDTO, TFORM, TENTITY> {
    
    public TENTITY formToEntity(TFORM form);
    public TDTO toDto(TENTITY entity);
    public TENTITY dtoToEntity(TDTO dto);
}
