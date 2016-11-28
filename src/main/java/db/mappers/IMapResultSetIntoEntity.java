/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.mappers;

import db.classes.IHaveId;
import java.sql.ResultSet;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public interface IMapResultSetIntoEntity<TEntity extends IHaveId> {
    
    public TEntity map(ResultSet rs);
    
}
