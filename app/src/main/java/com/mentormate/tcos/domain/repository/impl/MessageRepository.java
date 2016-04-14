package com.mentormate.tcos.domain.repository.impl;

import com.mentormate.tcos.domain.model.impl.MessageModel;
import com.mentormate.tcos.domain.repository.Repository;

/**
 * Created by krasimir.karamazov on 4/13/2016.
 */
public class MessageRepository implements Repository<MessageModel> {


    @Override
    public boolean insert(MessageModel model) {
        return false;
    }

    @Override
    public boolean update(MessageModel model) {
        return false;
    }

    @Override
    public MessageModel get(long id) {
        String msg = "Welcome, motherfucker!";

        // simulate some network/database lag
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new MessageModel(msg);
    }

    @Override
    public boolean delete(MessageModel model) {
        return false;
    }
}
