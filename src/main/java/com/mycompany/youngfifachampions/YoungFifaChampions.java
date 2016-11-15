/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.youngfifachampions;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class YoungFifaChampions {

    /**
     * Application Log object.
     */
    public static Logger LOG;

    /**
     * Input parameters object
     */
    public static Params PARAMS;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            //Params initialization
            if (args.length > 0) {
                PARAMS = new Params(args[0]);
            } else {
                PARAMS = new Params(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Initialize Logger
        LOG = new Logger(PARAMS.LOG_FILE_PATH, PARAMS.IS_FILE_APPEND,PARAMS.VERBOSE_MODE);
        
        LOG.addLog("Main", Logger.LogType.DEBUG, "Stworzony logger");
        LOG.addLog(null, YoungFifaChampions.class, Logger.LogType.WARRNING, null, "Test error");

    }

}
