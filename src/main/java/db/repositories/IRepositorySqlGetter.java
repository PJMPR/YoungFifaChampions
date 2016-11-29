/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.repositories;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public interface IRepositorySqlGetter {

    public String insertSql();

    public String updateSql();

    public String getAllSql();

    public String deleteSql();

    public String getSql();
    
    public String createTableSql();
    
    public String tableName();
}
