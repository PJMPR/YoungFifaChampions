/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.repositories;

import db.classes.IHaveId;
import java.util.List;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public interface IRepository<TEntity extends IHaveId> {
    
    public TEntity get(Integer id);
    public List<TEntity> getAll();
    public void delete(Integer id);
    public void update(TEntity entity);
    public void insert(TEntity entity);
    public String tableName();
    
}
