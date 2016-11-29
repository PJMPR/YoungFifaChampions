/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.repositories;

import db.classes.IHaveId;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public interface IRepository<TEntity extends IHaveId> {

    public TEntity get(TEntity entity) throws SQLException;

    public List<TEntity> getAll();

    public void delete(TEntity entity) throws SQLException;

    public void update(TEntity entity)throws SQLException;

    public void insert(TEntity entity)throws SQLException;

    public void createTableIfnotExists() throws SQLException;

}
