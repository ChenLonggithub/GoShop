package jgsu.clong.service.impl;

import jgsu.clong.mapper.LogMapper;
import jgsu.clong.service.LogService;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class LogServieImpl implements LogService {

    @Autowired
    LogMapper logMapper;

    @Override
    public void insertLog(String text, String id) {
        Map<Object,Object> map = new HashMap<Object,Object>();
        map.put("id",id);
        map.put("text",text);
        logMapper.insert(map);
    }
}
