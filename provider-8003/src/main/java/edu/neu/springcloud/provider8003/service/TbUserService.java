package edu.neu.springcloud.provider8003.service;

import edu.neu.springcloud.provider8003.bean.TbUserEntity;
import edu.neu.springcloud.provider8003.dao.TbUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TbUserService {
    @Autowired
    private TbUserDAO tbUserDAO;

    private final String providerName = "Provider8003";

    public TbUserEntity findById(int id) throws Exception {
        Optional<TbUserEntity> o = tbUserDAO.findById(id);
        if (o.isPresent()) {
            TbUserEntity e = o.get();
            e.setSource(providerName);
            return e;
        } else throw new Exception(String.format("[%s]: The user id %d cannot be found.", providerName, id));
    }

    public List<TbUserEntity> findAll() throws Exception {
        List<TbUserEntity> res = tbUserDAO.findAll();
        if (res.isEmpty()) {
            throw new Exception(String.format("[%s]: Database is empty.", providerName));
        } else {
            for (TbUserEntity e : res) {
                e.setSource(providerName);
            }
            return res;
        }
    }

    public List<TbUserEntity> findAllByUsername(String username) throws Exception {
        List<TbUserEntity> res = tbUserDAO.findAllByUsername(username);
        if (res.isEmpty()) {
            throw new Exception(String.format("[%s]: The username %s doesn't exist.", providerName, username));
        } else {
            for (TbUserEntity e : res) {
                e.setSource(providerName);
            }
            return res;
        }
    }

    public String add(TbUserEntity e) throws Exception {
        if (tbUserDAO.existsById(e.getId())) {
            throw new Exception(String.format("[%s]: The user already exists.", providerName));
        } else {
            tbUserDAO.saveAndFlush(e);
            return "Add success.";
        }
    }

    public String delete(int id) throws Exception {
        if (tbUserDAO.existsById(id)) {
            tbUserDAO.deleteById(id);
            return "Delete success.";

        } else {
            throw new Exception(String.format("[%s]: The user doesn't exist.", providerName));
        }
    }

    public String modify(TbUserEntity e) throws Exception {
        if (tbUserDAO.existsById(e.getId())) {
            tbUserDAO.save(e);
            return "Modify success.";
        } else {
            throw new Exception("The user id doesn't exist in `" + providerName + "`.");
        }
    }
}
