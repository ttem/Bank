package com.ttem.model.bank;

import com.ttem.model.account.Client;
import com.ttem.model.exception.account.client.ClientDuplicateException;
import com.ttem.model.exception.account.client.ClientException;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final String name;
    private final List<Client> clientDataBase;

    public Bank(final String name) {
        this.name = name;
        this.clientDataBase = getClientListFromDataBase();
    }

    public boolean addNewClient(final Client newClient) throws ClientException {
        if (newClient.isValid() && isNewClient(newClient)){
            return addClientToDataBase(newClient);
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public List<Client> getClientDataBase() {
        return this.clientDataBase;
    }

    private boolean isNewClient(final Client newClient) throws ClientDuplicateException {
        for (Client existingClient : this.getClientDataBase()) {
            if (existingClient == newClient){
                throw new ClientDuplicateException(newClient.toString() + " this client already exists");
            }
        }
        return true;
    }

    private boolean addClientToDataBase(final Client newClient) {
        return this.clientDataBase.add(newClient);
    }

    private List<Client> getClientListFromDataBase() {
        return new ArrayList<>();
    }
}
