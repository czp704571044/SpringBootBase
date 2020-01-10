package com.czp.demo.Service;

import com.czp.demo.Mapper.BjUserMapper;
import com.czp.demo.Model.BjUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BjUserService {
    @Autowired(required = false)
    private BjUserMapper bjUserMapper;
    @Cacheable(value="users")
    public List<BjUser> selectPeople(){
        return bjUserMapper.selectPeople();
    }
}
