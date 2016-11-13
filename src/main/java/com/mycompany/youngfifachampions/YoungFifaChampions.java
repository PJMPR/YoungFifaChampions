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

            if (args.length > 0) {
                PARAMS = new Params(args[0]);
            } else {
                PARAMS = new Params(null);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
//        System.err.println(PARAMS.VERBOSE_MODE);
//        System.err.println(PARAMS.PARAM_1);
//        System.err.println(PARAMS.PARAM_2);
//        System.err.println(PARAMS.PARAM_3);
        System.err.println(PARAMS.getParameterValueByName("ANONYMOUS_PARAM").getClass());
        System.err.println(PARAMS.getParameterValueByName("ANONYMOUS_PARAM2"));
        //LOG = new Logger();

    }

}
