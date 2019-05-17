package edu.mum.converter;

import javax.swing.text.html.HTML.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import edu.mum.domain.Group;
import edu.mum.service.GroupService;

public class IdToGroupConverter implements Converter<String, Group> {

    @Autowired
    GroupService groupService;

    public Group convert(String id) {     
        return groupService.findGroupById(Long.parseLong(id));
    }
}
