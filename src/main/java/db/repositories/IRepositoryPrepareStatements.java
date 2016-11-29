/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.repositories;

import db.classes.IHaveId;
import java.sql.SQLException;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public interface IRepositoryPrepareStatements<TEntity extends IHaveId> {

    public void insertPrepare(TEntity entity) throws SQLException;

    public void updatePrepare(TEntity entity)  throws SQLException;

    public void deletePrepare(TEntity entity)  throws SQLException;

    public void getPrepare(TEntity entity)  throws SQLException;


}
