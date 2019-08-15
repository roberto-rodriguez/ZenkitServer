package com.app.manager;

import com.app.dao.ClientDAO;
import com.app.dto.ClientDTO;
import com.app.model.Client;
import com.system.dao.AbstractBaseDAO;
import com.system.dto.request.Hash;
import com.system.manager.AbstractManager;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DevTool
 */
@Service
@Transactional
public class ClientManager extends AbstractManager<Client, ClientDTO> {

    @Autowired
    private ClientDAO clientDAO;

    @Override
    public AbstractBaseDAO dao() {
        return clientDAO;
    }

    @Override
    protected Client create(Hash data) throws Exception {
        Client client = new Client();
        client.setCreationDate(new Date());
        client.setActive(true);
        return client;
    }

    @Override
    protected void update(Client entity, Hash data) {
        entity.setName(data.getString("name"));

        if (data.containsKey("username")) {
            entity.setUsername(data.getString("username"));
        }

        if (data.containsKey("passw")) {
            entity.setPassw(data.getString("passw"));
        }

        if (data.containsKey("active")) {
            entity.setActive(data.getBoolean("active"));
        }

    }

    public ClientDTO login(Hash data) {
        return clientDAO.login(data.getString("username"), data.getString("password"));
    }
}
